package com.yuqijun.localservice.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqijun.localservice.model.dao.LsGoods;
import com.yuqijun.localservice.model.service.GoodsListInfo;
import com.yuqijun.localservice.store.dao.LsGoodsMapper;
import com.yuqijun.localservice.store.service.ILsGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LsGoodsServiceImpl extends ServiceImpl<LsGoodsMapper, LsGoods> implements ILsGoodsService {

    @Autowired
    private LsGoodsMapper mapper;

    @Override
    public  List<GoodsListInfo> getIndexPageData(String storeId) {


        /* 得到所有商品，然后分类 */

        List<LsGoods> list = mapper.getIndexPageData(storeId);


        Map<String, List<LsGoods>> collect = list.stream().collect(Collectors.groupingBy(lsGoods -> lsGoods.getTitle(), Collectors.toList()));
        List<GoodsListInfo> goodsListInfos = new ArrayList<>();


        for(Map.Entry<String,List<LsGoods>> entry  : collect.entrySet()){
            GoodsListInfo goodsListInfo = new GoodsListInfo();
            goodsListInfo.setTitle(entry.getKey());
            goodsListInfo.setGoodsList(entry.getValue());
            goodsListInfos.add(goodsListInfo);
        }



        return goodsListInfos;
    }
}
