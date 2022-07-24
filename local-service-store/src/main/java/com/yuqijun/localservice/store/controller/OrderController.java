package com.yuqijun.localservice.store.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.utils.JSONUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.rabbitmq.tools.json.JSONUtil;
import com.yuqijun.localservice.apiPrameterValidata.AddOrder;
import com.yuqijun.localservice.model.BaseController;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.model.dao.LsGoods;
import com.yuqijun.localservice.model.dao.LsOrder;
import com.yuqijun.localservice.model.dao.json.Goods;
import com.yuqijun.localservice.store.service.impl.LsOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController {

    public final static String GOOD_ID= "good_id_";

    @Autowired
    private LsOrderServiceImpl orderService;

    @Autowired
    private RedisTemplate redisTemplate;
    /*
    * 新增订单
    *  */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody @Validated(AddOrder.class) LsOrder order){

        log.info("新增订单"+ JSON.toJSONString(order));

        /* 缺少支付流程
        *
        *  计算完订单金额，和订单商品总数量后调用支付接口支付成功以后再落库DB注意异常
        *  */

        order.setOrderNo(IdWorker.getIdStr());
        order.setCreateTime(LocalDateTime.now());
        order.setOrderStatus(0);

        BigDecimal orderPrice = new BigDecimal(0);
        Integer orderGoodsNumber = 0 ;
        for(Goods goods:order.getGoodsList()){
            goods.setGoodsTotalPrice(goods.getGoodsPrice().multiply(new BigDecimal(goods.getPurchaseQuantity())));

            orderPrice.add(goods.getGoodsTotalPrice());
            orderGoodsNumber = orderGoodsNumber+goods.getPurchaseQuantity();
        }

        order.setOrderPrice(orderPrice);
        order.setGoodsNumber(orderGoodsNumber);
        return orderService.save(order)?Success("下单成功"):Fail("下单失败");
    }


    /*
    * 使用lua 尝试解决超卖问题
    * */
    @PostMapping("/buy")
    public ResponseResult buy(@RequestBody  LsOrder order){



        //执行lua脚本
        /*
        * lua 脚本内容。根据(商品id)判断商品数量是否大于(用户购买的数量)
        * 如果数量足够那么将(商品id,购买的商品数量，用户id打到rabbitmq 队列同步数据库)
        * */
        //key1 商品id ， avg2购买的商品数量 ， avg3 用户id

        String script2  ="return redis.call('GET',KEYS[1]);";


        String script3 = "local key1 = KEYS[1]; local argv1int = ARGV[1]; local argv2 = ARGV[2]" +
                "local currentNumberInt= tonumber(redis.call('get',key1));" +
                "local  diff = currentNumberInt - argv1int;" +
                "if(diff < 0) then return 0; end;" +
                "redis.call('set',key1,diff) return 1;";
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Boolean.class);
        redisScript.setScriptText(script3);

        //script,List<key> , Object...
        List<Object> keys = new ArrayList<>();
        keys.add(GOOD_ID.concat(order.getGoodsList().get(0).getGoodsId()).toString());
        long startTime = System.currentTimeMillis();


        Object execute = redisTemplate.execute(redisScript, keys,order.getGoodsList().get(0).getPurchaseQuantity(),order.getCreateUserId());
        log.info("下单返回结果:{}",execute);
        log.info("耗时：{}",System.currentTimeMillis()-startTime);

        return null;
    }


    /*
    * 提前把抢购商品存到redis
    * */
    @PostMapping("/preheat")
    public ResponseResult preheat(@RequestBody LsGoods goods){
        redisTemplate.opsForValue().set(GOOD_ID.concat(goods.getGoodsId()),goods.getGoodsNumber());
        return Success();
    }

    public static void main(String [] args){
        File file = new File("src/main/resources/redisScript.lua");
        log.info("fdsadfasdfasfsadfasf:{}",file.getAbsoluteFile());

        ResourceScriptSource resourceScriptSource = new ResourceScriptSource(new ClassPathResource("redisScript.lua"));
        resourceScriptSource.getResource();
        log.info("dsafasdfasdfa");
    }

}
