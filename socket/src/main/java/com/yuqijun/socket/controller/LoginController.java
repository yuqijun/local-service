package com.yuqijun.socket.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

//    @Value("${timeout}")
//    private String timeout;

    @ApiOperation(value = "用户登录验证，如果通过则将其ip端口注册至服务端")
    @PostMapping("/login")
    public Object login(){

        /* 根据账号查询数据库，解密对比密码 */

        /* 监听 */
        return null;
    }

//    @Bean
//    private  void main(){
//        log.info("apollo超时配置："+timeout);
//    }
}
