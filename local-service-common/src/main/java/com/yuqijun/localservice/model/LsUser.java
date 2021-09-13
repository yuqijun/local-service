package com.yuqijun.localservice.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuqijun.localservice.apiPrameterValidata.LoginValidate;
import com.yuqijun.localservice.apiPrameterValidata.RegisterValidate;
import com.yuqijun.localservice.model.dao.json.ReceivingAddress;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
//@ApiModel(value = "LsUser",description = "用户模型")
@TableName(autoResultMap = true,value = "tb_user")
public class LsUser {

//    @ApiModelProperty(name = "id",value = "用户编号")
    private String createUserId;

//    @ApiModelProperty(name = "loginAccount",value = "登陆账号")
    @NotBlank(message = "账号不能为空",groups = {LoginValidate.class})
    @NotBlank(message = "账号不能为空",groups = {RegisterValidate.class})
    private String loginName;

//    @ApiModelProperty(name = "loginPassword",value = "登陆密码")
    @NotBlank(message = "密码不能为空",groups = {LoginValidate.class})
    @NotBlank(message = "密码不能为空",groups = {RegisterValidate.class})
    private String password ;

    private String updateUserId;

    @NotBlank(message = "手机号不能为空",groups = RegisterValidate.class)
    private String phone;

    @NotBlank(message = "省 不能为空",groups = RegisterValidate.class)
    private String province;

    @NotBlank(message = "市 不能为空",groups = RegisterValidate.class)
    private String city;

    @NotBlank(message = "区 不能为空",groups = RegisterValidate.class)
    private String region;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;


    /* 客户收货地址列表 */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<ReceivingAddress> receivingAddress;
}
