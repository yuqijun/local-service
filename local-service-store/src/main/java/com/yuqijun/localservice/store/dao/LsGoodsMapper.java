package com.yuqijun.localservice.store.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuqijun.localservice.model.dao.LsGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LsGoodsMapper extends BaseMapper<LsGoods> {

    /* 进入某个商店时展示的所有商品部分信息 */
    public List<LsGoods> getIndexPageData(@Param("storeId") String storeId);
}
