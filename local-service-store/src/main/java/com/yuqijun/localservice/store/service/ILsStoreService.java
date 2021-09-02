package com.yuqijun.localservice.store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuqijun.localservice.model.dao.LsStore;

import java.util.List;

public interface ILsStoreService extends IService<LsStore> {

    /* 首页获取所有商店 logo地址、店铺编号、店铺名、店铺评分、店铺月销量、店铺描述 */
    public List<LsStore> getIndexPageData();
}
