package com.yuqijun.localservice.consumer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuqijun.localservice.model.LsMessage;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ILsMessageMapper extends BaseMapper<LsMessage> {
}
