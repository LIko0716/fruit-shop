package com.javapandeng.service.impl;

import com.javapandeng.base.BaseDao;
import com.javapandeng.base.BaseServiceImpl;
import com.javapandeng.mapper.CommentMapper;
import com.javapandeng.po.Comment;
import com.javapandeng.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hangzhi1063
 * @date 2020/11/14 18:16
 */
@Service
public class CommentServiceImpl  extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public BaseDao<Comment> getBaseDao() {
        return commentMapper ;
    }
}