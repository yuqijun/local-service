package model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LsUser",description = "用户模型")
public class LsUser {

    @ApiModelProperty(name = "loginAccount",value = "登陆账号")
    private String loginAccount;

    @ApiModelProperty(name = "loginPassword",value = "登陆密码")
    private String loginPassword ;
}
