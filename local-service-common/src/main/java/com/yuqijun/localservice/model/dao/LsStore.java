package com.yuqijun.localservice.model.dao;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuqijun.localservice.model.dao.json.StoreContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/*
* 商店实体类
* */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(autoResultMap = true,value = "tb_store")
public class LsStore {

    private String storeId;

    private String createUserId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createDateTime;

    private String updateUserId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateDateTime;

    private String remark;

    private String description;

    /* 省 */
    private String province;


    /* 市 */
    private String city;

    /* 区域 */
    private String region;

    /* 县 */
    private String county;

    /* 乡 */
    private String country;

    /* 村 */
    private String village;

    private String address;

    private String telephone;

    /* 商店log头像地址 */
    private String logoAvatar;

    private String storeName;

    /* 商店类型 */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> storeTypeList;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> storeTypeNameList;

    /* 商店联系人列表 */

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<StoreContact> storeContactList;

    /* 用户真是姓名 */
    private String userName;

    /* 用户昵称 */
    private String nickName;

    /* 店铺法人联系电话 */
    private String phone;

    /* 店铺评分 */
    private String storeSource;

    /* 全店销量 */
    private Integer storeSalesVolume;

//    /* 满减 */
//    private

    /* 全店无门槛优惠卷 */
    private BigDecimal storeNoThresholdCoupon;

    /* 配送费 */
    private BigDecimal distributionFee;

}
