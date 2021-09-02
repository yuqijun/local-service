package com.yuqijun.localservice.store.controller;

import com.yuqijun.localservice.model.BaseController;
import com.yuqijun.localservice.model.ResponseResult;
import com.yuqijun.localservice.store.service.impl.LsStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store/")
public class StoreController extends BaseController {

    @Autowired
    private LsStoreServiceImpl lsStoreService;

    /* App商店首页获取所有商店部分信息 */
    @PostMapping("/indexPageData")
    public ResponseResult getIndexPageData(){
        return Success(lsStoreService.getIndexPageData());
    }
}
