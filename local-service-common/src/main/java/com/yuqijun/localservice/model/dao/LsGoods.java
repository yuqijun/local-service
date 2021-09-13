package com.yuqijun.localservice.model.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LsGoods implements Serializable{

    private Integer purchaseQuantity;

    private String storeId;

    private String goodsId;

    private String goodsName;

    private String goodsDescription;

    private BigDecimal goodsPrice;

    /* 商品月销 */
    private Integer goodsSalesVolume;

    /* 商品库存 */
    private Integer goodsNumber;

    /* 商品展示图片地址 */
    private String goodsAvatar;

    /* 商品创建时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    /* 商品更新时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    /* 商品所属组 */
    private String title;

    /* 备注 */
    private String remark;
}
