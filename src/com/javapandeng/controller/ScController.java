package com.javapandeng.controller;

import com.javapandeng.po.Item;
import com.javapandeng.po.Sc;
import com.javapandeng.service.ItemService;
import com.javapandeng.service.ScService;
import com.javapandeng.utils.Const;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author hangzhi1063
 * @date 2020/11/8 10:31
 */
@Controller
@RequestMapping("/sc")
public class ScController {

    @Autowired
    private ScService scService;

    @Autowired
    private ItemService itemService;
    
    @RequestMapping("/exAdd")
    public String exAdd(Sc sc, HttpSession session){
        Object o = session.getAttribute(Const.USERID);
        if (o==null){
            return "redirect:/login/uLogin";
        }
        sc.setUserId((Integer)o);
        scService.insert(sc);

        Item item = itemService.getById(sc.getItemId());
        item.setScNum(item.getScNum()+1);
        itemService.updateById(item);

        return "redirect:/sc/findBySql";
    }

    @RequestMapping("findBySql")
    public String findBySql(Model model,HttpSession session){
        Object obj =session.getAttribute(Const.USERID);
        if (obj ==null){
            return "login/uLogin";
        }
        Integer userId = Integer.valueOf(obj.toString());
        String sql = "select * from sc where user_id = " + userId + " order by id desc";
        Pager<Sc> pagers = scService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers",pagers);
        return "sc/my";
        }

        @RequestMapping("/delete")
    public String delete(Integer id){
        scService.deleteById(id);
        return "redirect:/sc/findBySql";
    }
}
