package com.yuqijun.localservice.socket.controller;



import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yuqijun.localservice.apiPrameterValidata.LoginValidate;
import com.yuqijun.localservice.apiPrameterValidata.RegisterValidate;
import com.yuqijun.localservice.model.BaseController;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.socket.es.KylinMQMonitorLogsMapper;
import com.yuqijun.localservice.socket.model.KylinMQMonitorLogs;
import com.yuqijun.localservice.socket.service.impl.LsUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@RestController
@RequestMapping(value = "/api/index")
public class LoginController extends BaseController {

    @Resource
    private LsUserServiceImpl userService;

    @Autowired
    private KylinMQMonitorLogsMapper mapper;

    @Autowired
    private ConnectionFactory connectionFactory;


//    @ApiOperation(value = "用户登录验证，如果通过则将其ip端口注册至服务端")
    @PostMapping("/login")
    public Object login(@RequestBody @Validated(LoginValidate.class) LsUser user){
        ResponseResult login = userService.login(user);
        log.info("登陆返回信息 ："+Success(userService));

        return Success(userService.login(user));
    }

//    @ApiModelProperty(value = "用户注册")
    @PostMapping("/register")
    public Object register(@RequestBody @Validated(RegisterValidate.class) LsUser user){
        /* 密码加密 */
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword( bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.register(user)?Success():Fail();
    }

    @GetMapping(value = "/test")
    public ModelAndView test(HttpServletRequest req) {
        // UserEntity userEntity = getCurrentUser(req);

        ModelAndView mv = new ModelAndView();
        LsUser user = new LsUser();
        user.setLoginName("yuqijun");
        user.setPassword("yuqijun");
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

    @PostMapping(value = "/savelog")
    public Object saveLog(){
        KylinMQMonitorLogs logs = new KylinMQMonitorLogs();
        logs.setCost(13213131l);
        logs.setAppId("天象");
        logs.setCreateTime(System.currentTimeMillis());
        logs.setId(IdWorker.getIdStr());
        logs.setQueueName("max_queue");

        KylinMQMonitorLogs save = mapper.save(logs);
//        log.info("save 返回值 ："+ JSONUtils.toJSONString(save));
        return  save;





    }


}
