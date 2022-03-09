package com.yuqijun.localservice.authentication.controller;

import com.yuqijun.localservice.model.BaseController;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController extends BaseController {

    @PostMapping("/getToken")
    public ResponseResult getToken(@RequestBody LsUser user){
        //验证登录用户密码
        //获取用户信息
        //生成token
        return null;
    }

}
