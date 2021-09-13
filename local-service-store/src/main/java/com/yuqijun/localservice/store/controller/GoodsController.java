package com.yuqijun.localservice.store.controller;

import com.yuqijun.localservice.apiPrameterValidata.StoreGoodsListValidate;
import com.yuqijun.localservice.model.BaseController;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.query.GoodsQuery;
import com.yuqijun.localservice.store.service.impl.LsGoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/goods")
public class GoodsController extends BaseController {

    @Autowired
    private LsGoodsServiceImpl lsGoodsService;

    @PostMapping("/storeGoodsList")
    public ResponseResult storeGoodsList(@RequestBody @Validated(StoreGoodsListValidate.class) GoodsQuery query){
        return Success(lsGoodsService.getIndexPageData(query.getStoreId()));
    }

}
