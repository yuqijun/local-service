package com.yuqijun.localservice.consumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqijun.localservice.consumer.dao.ILsMessageMapper;
import com.yuqijun.localservice.model.LsMessage;
import org.springframework.stereotype.Service;
import com.yuqijun.localservice.consumer.service.ILsMessageService;


@Service
public class LsMessageServiceImpl extends ServiceImpl<ILsMessageMapper, LsMessage> implements ILsMessageService {
}
