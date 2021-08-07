package com.yuqijun.socket.controller;

import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.socket.service.LsUserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/api/index")
public class LoginController extends ResponseResult {

    @Resource
    private LsUserService userService;

    @ApiOperation(value = "用户登录验证，如果通过则将其ip端口注册至服务端")
    @PostMapping("/login")
    public Object login(@RequestBody LsUser user){
        return userService.login(user);
    }

    @ApiModelProperty(value = "用户注册")
    @PostMapping("/register")
    public Object register(@RequestBody LsUser user){
        /* 密码加密 */
        String encryption = user.getLoginPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setLoginPassword( bCryptPasswordEncoder.encode(user.getLoginPassword()));
        return userService.register(user)?Success():Fail();
    }

    public static void main (String [] args){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String p = "123";
        String encryption = bCryptPasswordEncoder.encode(p);

        boolean p1 = bCryptPasswordEncoder.matches(encryption,p);
        log.info("加密后的字符串："+encryption);
        log.info("对比："+p1);


    }
}
