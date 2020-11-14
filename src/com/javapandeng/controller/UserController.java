package com.javapandeng.controller;

import com.javapandeng.base.BaseController;
import com.javapandeng.po.User;
import com.javapandeng.service.UserService;
import com.javapandeng.utils.Const;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author hangzhi1063
 * @date 2020/11/4 9:38
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("findBySql")
    public String findBySql(Model model,User user){
        String sql = "select * from user where 1=1 ";
        if (!isEmpty(user.getUserName())){
            sql += " and userName like '%"+user.getUserName()+"%'";
        }

        sql +=" order by id";
        Pager<User> pagers = userService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("name",user.getUserName());
        return "user/user";
    }

        @RequestMapping("/view")
        public String view(Model model , HttpSession session){
            Object obj = session.getAttribute(Const.USERID);
            if (obj==null){
                return "redirect:/login/uLogin";
            }
            User user=userService.getById(Integer.valueOf(obj.toString()));
            model.addAttribute("viewUser",user);
            return "user/view";
        }

        @RequestMapping("/exUpdate")
        public String exUpdate(User user,HttpSession session){
            user.setId(Integer.valueOf(session.getAttribute(Const.USERID).toString()));
            userService.updateById(user);
            return "redirect:/user/view";
        }
}
