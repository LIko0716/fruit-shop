package com.javapandeng.controller;

import com.alibaba.fastjson.JSONObject;
import com.javapandeng.base.BaseController;
import com.javapandeng.po.Item;
import com.javapandeng.po.ItemCategory;
import com.javapandeng.po.Manage;
import com.javapandeng.po.User;
import com.javapandeng.service.ItemCategoryService;
import com.javapandeng.service.ItemService;
import com.javapandeng.service.ManageService;
import com.javapandeng.service.UserService;
import com.javapandeng.utils.Const;
import com.javapandeng.vo.ItemCategoryDto;
import com.javapandeng.vo.ResError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/11/3 9:42
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @Autowired
    private ManageService manageService;
    @Autowired
    private ItemCategoryService itemCategoryService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String mLogin() {
        return "/login/mLogin";
    }

    @RequestMapping("toLogin")
    public String toLogin(Manage manage, HttpServletRequest request) {
        System.out.println("进入登录请求");
        Manage entity = manageService.getByEntity(manage);

        if (entity == null) {
            return "redirect:/login/mLogout";
        }
        request.getSession().setAttribute(Const.MANAGE, entity.getRealName());
        return "/login/mIndex";
    }

    @RequestMapping("mLogout")
    public String mLoginOut(HttpServletRequest request) {
        request.getSession().setAttribute(Const.MANAGE, null);
        return "redirect:/login/login";
    }

    @RequestMapping("/uIndex")
    public String uIndex(Model model, Item item, HttpServletRequest request) {
        //查询一级类目 以及他下面的二级类目
        String sql1 = "select * from item_category where isDelete =0 and pid is null";
        List<ItemCategory> itemCategories = itemCategoryService.listBySqlReturnEntity(sql1);
        List<ItemCategoryDto> lbs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(itemCategories)) {
            for (ItemCategory itemCategorie : itemCategories) {
                ItemCategoryDto itemCategoryDto = new ItemCategoryDto();
                itemCategoryDto.setFather(itemCategorie);
                String sql2 = "select * from item_category where isDelete =0 and pid =" + itemCategorie.getId();
                List<ItemCategory> children = itemCategoryService.listBySqlReturnEntity(sql2);
                itemCategoryDto.setChildren(children);
                lbs.add(itemCategoryDto);
            }
        }
        model.addAttribute("lbs", lbs);
        //给前端传输热销商品和折扣商品
        String sql3 = "select * from item where isDelete =0 and zk is not null order by zk desc limit 0,10";
        List<Item> zks = itemService.listBySqlReturnEntity(sql3);
        String sql4 = "select * from item  where isDelete =0 order by id desc limit 0,10";
        List<Item> rxs = itemService.listBySqlReturnEntity(sql4);
        model.addAttribute("zks", zks);
        model.addAttribute("rxs", rxs);
        return "login/uIndex";
    }

    @RequestMapping("/res")
    public String res() {

        return "login/res";
    }

    @RequestMapping("toRes")
    public String toRes(User user, Model model) {
        boolean flag = false;
        ResError re = new ResError();
        if (user.getUserName() == null || "".equals(user.getUserName())) {
            re.setError1("请输入用户名");
            flag = true;
        } else {
            String sql = "select * from user where userName = '" + user.getUserName() + "'";
            User user2 = userService.getBySqlReturnEntity(sql);
            if (user2 != null) {
                re.setError3("用户名已存在");
                flag = true;
            }

        }
        if (user.getPassWord() == null || "".equals(user.getPassWord())) {
            re.setError2("请输入密码");
            flag = true;

        }
        if (!flag) {
            userService.insert(user);
            return "login/uLogin";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("re", re);
            return "login/res";
        }
    }

    @RequestMapping("/uLogin")
    public String uLogin() {
        return "login/uLogin";
    }

    @RequestMapping("/utoLogin")
    public String utoLogin(User u, HttpServletRequest request) {
        User user = userService.getByEntity(u);
        if (user == null) {
            return "login/res";
        }
        HttpSession session = request.getSession();
        session.setAttribute(Const.USERNAME, user.getUserName());
        session.setAttribute("role", 2);
        session.setAttribute(Const.USERID, user.getId());
        return "redirect:/login/uIndex";
    }

    @RequestMapping("/uLogout")
    public String uLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/login/uIndex";
    }

    @RequestMapping("/pass")
    public String pass(Model model, HttpSession session) {
        Object obj = session.getAttribute(Const.USERID);
        if (obj == null) {
            return "login/uLogin";
        }

        Integer userId = Integer.valueOf(obj.toString());
        User user = userService.load(userId);
        model.addAttribute(user);
        return "login/pass";
    }

    @RequestMapping("/upass")
    @ResponseBody
    public String upass(String password,HttpSession session){
        JSONObject js = new JSONObject();
        Object obj = session.getAttribute(Const.USERID);

        if (obj==null){
            js.put(Const.RES,0);
            return js.toJSONString();
        }
        Integer userId= Integer.valueOf(obj.toString());
        User user = userService.load(userId);
        user.setPassWord(password);
        userService.updateById(user);
        js.put(Const.RES,1);
        return js.toJSONString();
    }
}
