package com.javapandeng.controller;

import com.javapandeng.base.BaseController;
import com.javapandeng.po.Item;
import com.javapandeng.po.ItemCategory;
import com.javapandeng.service.ItemCategoryService;
import com.javapandeng.service.ItemService;
import com.javapandeng.utils.Pager;
import com.javapandeng.utils.SystemContext;
import com.javapandeng.utils.UUIDUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/11/4 10:53
 */
@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model, Item item) {
        String sql = "select * from item where isDelete = 0 ";
        if (!isEmpty(item.getName())) {
            sql += " and name like '%" + item.getName() + "%'";
        }
        sql += " order by id desc";
        Pager<Item> pagers = itemService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj", item);
        return "item/item";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        String sql = "select * from item_category where isDelete = 0 and pid is not null order by id";
        List<ItemCategory> itemCategories = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("itemCategories", itemCategories);
        return "item/add";
    }

    @RequestMapping("/exAdd")
    public String exAdd(Item item, @RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        itemCommon(item, files, request);
        item.setGmNum(0);
        item.setIsDelete(0);
        item.setScNum(0);
        itemService.insert(item);
        return "redirect:/item/findBySql.action";
    }

    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        //返回一个二级列表对象 返回当前id对象
        Item item = itemService.load(id);
        String sql = "select * from item_category where isDelete = 0 and pid is not null order by id";
        List<ItemCategory> itemCategories = itemCategoryService.listBySqlReturnEntity(sql);
        model.addAttribute("item", item);
        model.addAttribute("obj", itemCategories);
        return "item/update";
    }


    @RequestMapping("/exUpdate")
    public String exUpdate(Item item, @RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        itemCommon(item, files, request);
        itemService.updateById(item);
        return "redirect:/item/findBySql.action";
    }

    /**
     * 新增和更新的公共方法
     */

    private void itemCommon(Item item, @RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        if (files.length > 0) {
            for (int s = 0; s < files.length; s++) {
                String n = UUIDUtils.create();
                String path = SystemContext.getRealPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename();
                File newFile = new File(path);
                //通过CommonsMultipartFile的方法直接写文件
                files[s].transferTo(newFile);
                if (s == 0) {
                    item.setUrl1(request.getContextPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 1) {
                    item.setUrl2(request.getContextPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 2) {
                    item.setUrl3(request.getContextPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 3) {
                    item.setUrl4(request.getContextPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
                if (s == 4) {
                    item.setUrl5(request.getContextPath() + "\\resource\\ueditor\\upload\\" + n + files[s].getOriginalFilename());
                }
            }
        }
        ItemCategory byId = itemCategoryService.getById(item.getCategory_id_two());
        item.setCategory_id_one(byId.getPid());
    }

    @RequestMapping("/delete")
    public String delete(Item item) {
        Item load = itemService.load(item);
        load.setIsDelete(1);
        itemService.updateById(load);
        return "redirect:/item/findBySql.action";
    }

    @RequestMapping("/shopList")
    public String showList(Item item,Model model) {
        //根据条件查出商品
        String sql = "select * from item where isDelete = 0 ";
        if (item.getCategory_id_two() != null) {
            sql += " and category_id_two = " + item.getCategory_id_two();
        }
        if (!isEmpty(item.getName())) {
            sql += " and name like '%" + item.getName() + "%'";
        }

        if (isEmpty(item.getPrice())){
            sql +=" order by (price+0) desc";
        }else if (isEmpty(item.getGmNum())){
            sql +=" order by gmNum desc";

        }else {
            sql +=" order by id desc";

        }
        Pager<Item> pagers = itemService.findBySqlReturnEntity(sql);
        model.addAttribute("obj",item);
        model.addAttribute("pagers",pagers);
        //model.addAttribute("condition",condition);
        return "item/shopList";
    }

    @RequestMapping("/view")
    public String view(Item id,Model model){
        Item obj = itemService.load(id);
        model.addAttribute("obj",obj);

        return "item/view";
    }

}
