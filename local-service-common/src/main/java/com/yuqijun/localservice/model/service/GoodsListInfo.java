package com.yuqijun.localservice.model.service;

import com.yuqijun.localservice.model.dao.LsGoods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsListInfo implements Serializable {

    /* 一类商品列表 */
    private List<LsGoods> goodsList;

    /* 商品分类 */
    private String  title;
}
