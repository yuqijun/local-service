package com.yuqijun.localservice.consumer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuqijun.localservice.model6.LsMessage;
import org.apache.ibatis.annotations.Mapper;
import com.yuqijun.localservice.consumer.dao.ILsMessageMapper;

@Mapper
public interface ILsMessageMapper extends BaseMapper<LsMessage> {
}
