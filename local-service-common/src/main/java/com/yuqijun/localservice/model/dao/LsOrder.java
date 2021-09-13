package com.yuqijun.localservice.model.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuqijun.localservice.apiPrameterValidata.AddOrder;
import com.yuqijun.localservice.model.dao.json.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(autoResultMap = true,value = "tb_order")
public class LsOrder implements Serializable {

    /* 订单编号（唯一的，雪花算法或其他方法生成的唯一编号） */
    private String orderNo;

    /* 创建订单的用户编号 */
    @NotBlank(message = "用户编号不能为空",groups = {AddOrder.class})
    private String createUserId;

    /* 订单商品列表 */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Goods> goodsList;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    /* 送达时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime arriveTime;

    /* 商店名称 */
    @NotBlank(message = "商店名称不能为空",groups = {AddOrder.class})
    private String storeName;

    /* 商店联系电话 */
    @NotBlank(message = "商店联系电话不能为空",groups = {AddOrder.class})
    private String storeTelephone;

    /* 订单状态 1. 用户下单 、 2. 商户接单 、 3. 商户出餐骑手接单（开始派送） 4. 订单完成 */
    private Integer orderStatus;

    /* 订单金额 */
    private BigDecimal orderPrice;

    /* 订单商品总数量 */
    @NotNull(message = "订单商品总数量不能为空",groups = {AddOrder.class})
    private Integer goodsNumber;

    /* 订单收货地址 */
    @NotBlank(message = "订单收货地址不能为空",groups = {AddOrder.class})
    private String receivingAddress;

    /* 订单支付方式 1. 线上支付  、 2. 线下支付 */
    @NotNull(message = "支付方式不能为空",groups = {AddOrder.class})
    private Integer paymentMethod;

    /* 餐具信息 */
    @NotBlank(message = "餐具信息不能为空",groups = {AddOrder.class})
    private String tablewareNumber;

    /* 优惠卷金额 */
    private BigDecimal coupon = new BigDecimal(0);

    /* 客户下单备注信息 */
    private String remark;

    /* 打包费 */
    private BigDecimal packageFee = new BigDecimal(0);

    /* 配送费 */
    private BigDecimal distributionFee = new BigDecimal(0);

}
