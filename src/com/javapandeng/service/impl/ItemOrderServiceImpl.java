package com.javapandeng.service.impl;

import com.javapandeng.base.BaseDao;
import com.javapandeng.base.BaseServiceImpl;
import com.javapandeng.mapper.ItemOrderMapper;
import com.javapandeng.po.ItemOrder;
import com.javapandeng.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hangzhi1063
 * @date 2020/11/5 14:04
 */
@Service
public class ItemOrderServiceImpl  extends BaseServiceImpl<ItemOrder> implements ItemOrderService {
    @Autowired
    private ItemOrderMapper itemOrderMapper;
    @Override
    public BaseDao<ItemOrder> getBaseDao() {
        return itemOrderMapper;
    }
}
