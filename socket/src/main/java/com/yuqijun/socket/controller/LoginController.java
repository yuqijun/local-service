package com.yuqijun.socket.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @ApiOperation(value = "用户登录验证，如果通过则将其ip端口注册至服务端")
    @PostMapping("/login")
    public Object login(){

        /* 根据账号查询数据库，解密对比密码 */

        /* 监听 */
        return null;
    }
}
