package com.yuqijun.localservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "LsUser",description = "用户模型")
public class LsUser {

    @ApiModelProperty(name = "loginAccount",value = "登陆账号")
    private String loginAccount;

    @ApiModelProperty(name = "loginPassword",value = "登陆密码")
    private String loginPassword ;

    @ApiModelProperty(name = "ip",value = "用户当前ip")
    private String ip;

    @ApiModelProperty(name = "port",value ="用户当前端口号" )
    private String port;
}
