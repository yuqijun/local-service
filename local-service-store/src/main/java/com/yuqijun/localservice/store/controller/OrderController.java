package com.yuqijun.localservice.store.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.client.utils.JSONUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.rabbitmq.tools.json.JSONUtil;
import com.yuqijun.localservice.apiPrameterValidata.AddOrder;
import com.yuqijun.localservice.model.BaseController;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.model.dao.LsOrder;
import com.yuqijun.localservice.model.dao.json.Goods;
import com.yuqijun.localservice.store.service.impl.LsOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController {


    @Autowired
    private LsOrderServiceImpl orderService;

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
}
