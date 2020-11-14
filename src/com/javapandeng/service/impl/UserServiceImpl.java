package com.javapandeng.service.impl;

import com.javapandeng.base.BaseDao;
import com.javapandeng.base.BaseServiceImpl;
import com.javapandeng.mapper.UserMapper;
import com.javapandeng.po.User;
import com.javapandeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hangzhi1063
 * @date 2020/11/4 9:37
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public BaseDao<User> getBaseDao() {
        return userMapper;
    }
}
