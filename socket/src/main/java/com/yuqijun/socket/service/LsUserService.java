package com.yuqijun.socket.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqijun.localservice.model.LsUser;
import com.yuqijun.localservice.model.ResponseResult;

public interface LsUserService extends IService<LsUser> {

    /* 新用户注册 */
    boolean register(LsUser user);

    /* 用户登录 */

    ResponseResult<Object> login(LsUser  user);
}
