package com.yuqijun.localservice.store.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuqijun.localservice.model.dao.LsOrder;
import com.yuqijun.localservice.store.dao.LsOrderMapper;
import com.yuqijun.localservice.store.service.ILsOrderService;
import org.springframework.stereotype.Service;

@Service
public class LsOrderServiceImpl extends ServiceImpl<LsOrderMapper, LsOrder> implements ILsOrderService {
}
