package com.yuqijun.localservice.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqijun.localservice.model.dao.LsStore;
import com.yuqijun.localservice.store.dao.LsStoreMapper;
import com.yuqijun.localservice.store.service.ILsStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class LsStoreServiceImpl extends ServiceImpl<LsStoreMapper, LsStore> implements ILsStoreService {

    @Autowired
    private LsStoreMapper lsStoreMapper;

    @Override
    public List<LsStore> getIndexPageData() {
        List<LsStore> indexPageData = lsStoreMapper.getIndexPageData();
        log.info("所有店铺信息:{}", JSON.toJSONString(indexPageData));
        return indexPageData;
    }
}
