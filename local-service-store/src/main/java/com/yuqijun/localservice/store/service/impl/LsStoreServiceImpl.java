package com.yuqijun.localservice.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqijun.localservice.model.dao.LsStore;
import com.yuqijun.localservice.store.dao.LsStoreMapper;
import com.yuqijun.localservice.store.service.ILsStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LsStoreServiceImpl extends ServiceImpl<LsStoreMapper, LsStore> implements ILsStoreService {

    @Autowired
    private LsStoreMapper lsStoreMapper;

    @Override
    public List<LsStore> getIndexPageData() {
        return lsStoreMapper.getIndexPageData();
    }
}
