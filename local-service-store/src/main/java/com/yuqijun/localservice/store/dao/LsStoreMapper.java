package com.yuqijun.localservice.store.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuqijun.localservice.model.dao.LsStore;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface LsStoreMapper extends BaseMapper<LsStore> {

    /* 获取App 店铺首页数据 */
    public List<LsStore> getIndexPageData();
}
