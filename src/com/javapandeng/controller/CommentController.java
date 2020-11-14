package com.javapandeng.controller;

import com.javapandeng.po.Comment;
import com.javapandeng.service.CommentService;
import com.javapandeng.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author hangzhi1063
 * @date 2020/11/14 18:15
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/exAdd")
    public String exAdd(Comment comment, HttpSession session){
        Object obj =session.getAttribute(Const.USERID);
        if (obj==null){
            return "login/uLogin";
        }

        Integer userId = Integer.valueOf(obj.toString());
        comment.setUserId(userId);
        comment.setAddTime(new Date());
        commentService.insert(comment);
        return "redirect:/itemOrder/my";
    }
}
