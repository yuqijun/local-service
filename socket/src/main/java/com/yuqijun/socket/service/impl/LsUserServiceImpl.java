package com.yuqijun.socket.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.socket.dao.LsUserMapper;
import com.yuqijun.socket.service.LsUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class LsUserServiceImpl extends ServiceImpl<LsUserMapper,LsUser> implements LsUserService  {

    @Resource
    private LsUserMapper mapper;



    @Override
    public boolean register(LsUser user) {
        /* 密码加密 */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setLoginPassword( bCryptPasswordEncoder.encode(user.getLoginPassword()));
        return mapper.insert(user)>0;
    }

    @Override
    public ResponseResult<Object> login(LsUser user) {
        LambdaQueryWrapper<LsUser> query = new LambdaQueryWrapper<>();
        query.eq(LsUser::getLoginAccount,user.getLoginAccount());
        LsUser lander = mapper.selectOne(query);

        /* 判断密码是否正确 */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(lander.getLoginPassword(),user.getLoginPassword())){
            /*
            *  返回登陆结果信息
            *  将信息丢入RabbitMq队列，异步与服务端建立连接
            * */
        }else{
            /*
            *  返回登陆结果信息
            * */
        }



        return null ;
    }


}
