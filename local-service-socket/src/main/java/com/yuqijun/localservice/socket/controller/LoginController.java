package com.yuqijun.localservice.socket.controller;


import com.yuqijun.localservice.apiPrameterValidata.LoginValidate;
import com.yuqijun.localservice.apiPrameterValidata.RegisterValidate;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.socket.service.impl.LsUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/api/index")
public class LoginController extends ResponseResult {

    @Resource
    private LsUserServiceImpl userService;

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

    @GetMapping(value = "/test")
    public ModelAndView test(HttpServletRequest req) {
        // UserEntity userEntity = getCurrentUser(req);

        ModelAndView mv = new ModelAndView();
        LsUser user = new LsUser();
        user.setLoginAccount("yuqijun");
        user.setLoginPassword("yuqijun");
        mv.addObject("user",user);
        mv.setViewName("/user/show.html");
        return mv;
    }

    @GetMapping(value = "/client")
    public ModelAndView cleint(HttpServletRequest req){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/client.html");
        return mv;
    }


}
