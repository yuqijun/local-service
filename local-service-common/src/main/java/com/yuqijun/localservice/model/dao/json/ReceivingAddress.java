package com.yuqijun.localservice.model.dao.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/*
* 用户信息收货地址字段实体类
* */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceivingAddress implements Serializable {

    /* 客户唯一编号 */
    @NotBlank(message = "客户编号不能为空")
    private String createUserId;

    /* 地址 */
    @NotBlank(message = "客户收货地址不能为空")
    private String address;

    /* 客户姓名 */
    @NotBlank(message = "客户姓名不能为空")
    private String userName;

    /* 客户联系电话 */
    @NotBlank(message = "客户联系电话不能为空")
    private String phone;
}
