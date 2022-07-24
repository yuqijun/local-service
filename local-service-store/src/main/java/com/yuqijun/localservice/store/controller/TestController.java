package com.yuqijun.localservice.store.controller;


import com.alibaba.fastjson.JSON;

import com.yuqijun.localservice.store.entity.EsMessageEntity;
import com.yuqijun.localservice.store.entity.EsMessageEntityQuery;
import com.yuqijun.localservice.store.service.impl.EsMessageRecordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j

@RestController
@RequestMapping("/api/msgrecord")
@Validated
public class TestController   {

    @Autowired
    @Qualifier(value = "esMessageRecordServiceImpl")
    private EsMessageRecordServiceImpl esMessageRecordService;



//    @PostMapping("/getEsSmsRecord")
//    public Object getSmsRecord(@RequestBody EsMessageEntityQuery query){
//        return esMessageRecordService.getRecord(query);
//    }


//    @PostMapping("/esSmsInsert")
//    public Object esSmsInsert(@RequestBody EsMessageEntity entity){
//        return  esMessageRecordService.insert(entity);
//    }

    @PostMapping("/hello")


    public Object hello(@RequestBody EsMessageEntity entity){
        return  "success";
    }
}