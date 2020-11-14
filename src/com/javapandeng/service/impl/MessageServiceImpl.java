package com.javapandeng.service.impl;

import com.javapandeng.base.BaseDao;
import com.javapandeng.base.BaseService;
import com.javapandeng.base.BaseServiceImpl;
import com.javapandeng.mapper.MessageMapper;
import com.javapandeng.po.Message;
import com.javapandeng.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hangzhi1063
 * @date 2020/11/6 8:47
 */
@Service
public class MessageServiceImpl  extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public BaseDao<Message> getBaseDao() {
        return messageMapper;
    }
}
