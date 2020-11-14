package com.javapandeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.Message;
import com.javapandeng.service.MessageService;
import com.javapandeng.utils.Const;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author hangzhi1063
 * @date 2020/11/6 8:46
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model, Message message) {
        String sql = "select * from message ";

        if (!isEmpty(message.getName())) {
            sql += " where name like '%" + message.getName() + "%'";


        }

        sql += "order by id desc";

        Pager<Message> pagers = messageService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj", message);
        return "message/message";
    }

    @RequestMapping("add")
    public String add(HttpSession session) {

        return "message/add";
    }

    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(Message message) {
        messageService.insert(message);
        JSONObject js =new JSONObject();
        js.put("message","添加成功");
        return js.toString();
    }
}
