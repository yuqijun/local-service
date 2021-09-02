package com.yuqijun.localservice.socket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.socket.dao.LsUserMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuqijun.localservice.socket.service.LsUserService;

import java.time.LocalDateTime;

@Service
public class LsUserServiceImpl extends ServiceImpl<LsUserMapper,LsUser> implements LsUserService  {

    @Resource
    private LsUserMapper mapper;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean register(LsUser user) {
        /* 密码加密 */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String secret = bCryptPasswordEncoder.encode(user.getPassword());
        if(bCryptPasswordEncoder.matches(user.getPassword(),secret)){
            user.setPassword(secret);
            String id = IdWorker.getIdStr();
            user.setCreateUserId(id);
            user.setUpdateUserId(id);
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            return mapper.insert(user)>0;
        }
        return false;
    }

    @Override
    public LsUser login(LsUser user) {
        LambdaQueryWrapper<LsUser> query = new LambdaQueryWrapper<>();
        query.eq(LsUser::getLoginName,user.getLoginName());
        LsUser lander = mapper.selectOne(query);

        if(null == lander){
            return null;
        }

        /* 判断密码是否正确 */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String t1 = user.getPassword();
        String t2 = lander.getPassword();

        if(!bCryptPasswordEncoder.matches(t1,t2)){
            /*
            *  返回登陆结果信息
            *  将信息丢入RabbitMq队列，异步与服务端建立连接
            * */


            return null;
        }

        return lander;

    }


}
