package com.yuqijun.localservice.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/* 商品查询实体类 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsQuery {

    @NotBlank(message = "商店编号不能为空")
    private  String storeId;

}
