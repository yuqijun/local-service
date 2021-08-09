package com.yuqijun.localservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import com.yuqijun.localservice.apiPrameterValidata.LoginValidate;
import com.yuqijun.localservice.apiPrameterValidata.RegisterValidate;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
//@ApiModel(value = "LsUser",description = "用户模型")
@TableName(value = "tb_user")
public class LsUser {

//    @ApiModelProperty(name = "id",value = "用户编号")
    private String id;

//    @ApiModelProperty(name = "loginAccount",value = "登陆账号")
    @NotBlank(message = "账号不能为空",groups = {LoginValidate.class})
    @NotBlank(message = "账号不能为空",groups = {RegisterValidate.class})
    private String loginAccount;

//    @ApiModelProperty(name = "loginPassword",value = "登陆密码")
    @NotBlank(message = "密码不能为空",groups = {LoginValidate.class})
    @NotBlank(message = "密码不能为空",groups = {RegisterValidate.class})
    private String loginPassword ;

}
