package com.yuqijun.localservice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "LsUser",description = "用户模型")
@TableName(value = "tb_user")
public class LsUser {

    @ApiModelProperty(name = "id",value = "用户编号")
    private String id;

    @ApiModelProperty(name = "loginAccount",value = "登陆账号")
    private String loginAccount;

    @ApiModelProperty(name = "loginPassword",value = "登陆密码")
    private String loginPassword ;

}
