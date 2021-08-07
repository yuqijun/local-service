package com.yuqijun.socket.controller;

import com.yuqijun.localservice.apiPrameterValidata.LoginValidate;
import com.yuqijun.localservice.apiPrameterValidata.RegisterValidate;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.socket.service.LsUserService;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/api/index")
public class LoginController extends ResponseResult<Object> {

    @Resource
    private LsUserService userService;

//    @ApiOperation(value = "用户登录验证，如果通过则将其ip端口注册至服务端")
    @PostMapping("/login")
    public Object login(@RequestBody @Validated(LoginValidate.class) LsUser user){
        return userService.login(user);
    }

//    @ApiModelProperty(value = "用户注册")
    @PostMapping("/register")
    public Object register(@RequestBody @Validated(RegisterValidate.class) LsUser user){
        /* 密码加密 */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setLoginPassword( bCryptPasswordEncoder.encode(user.getLoginPassword()));
        return userService.register(user)?Success():Fail();
    }

}
