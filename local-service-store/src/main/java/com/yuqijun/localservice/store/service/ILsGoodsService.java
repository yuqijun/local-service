package com.yuqijun.localservice.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqijun.localservice.model.dao.LsGoods;
import com.yuqijun.localservice.model.service.GoodsListInfo;

import java.util.List;
import java.util.Map;

public interface ILsGoodsService extends IService<LsGoods> {

    /* 进入某个商店时展示的所有商品部分信息 */
//    public List<LsGoods> getIndexPageData(String storeId);
    public List<GoodsListInfo> getIndexPageData(String storeId);
}
