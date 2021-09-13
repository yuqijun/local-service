package com.yuqijun.localservice.model.dao.json;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/* 订单实体类中的 goodsList字段类型 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {

    /* 商品数量 */
    private Integer purchaseQuantity;

    /* 商品所属商店ID */
    private String storeId;

    /* 商品ID */
    private String goodsId;

    /* 商品名称 */
    private String goodsName;

    /* 商品单价 */
    private BigDecimal goodsPrice;

    /* 商品总价 */
    private BigDecimal goodsTotalPrice;

    /* 商品展示图片地址 */
    private String goodsAvatar;

}
