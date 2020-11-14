package com.javapandeng.controller;

import com.javapandeng.base.BaseController;
import com.javapandeng.po.ItemCategory;
import com.javapandeng.service.ItemCategoryService;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hangzhi1063
 * @date 2020/11/3 14:44
 */
@Controller
@RequestMapping("/itemCategory")
public class ItemCategoryController extends BaseController {
    @Autowired
    ItemCategoryService itemCategoryService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model, ItemCategory itemCategory) {
        String sql = "select * from item_category where isDelete = 0 and pid is null order by id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj", itemCategory);
        return "itemCategory/itemCategory";

    }

    @RequestMapping("/toAddCateGory")
    public String ToaddCateGory() {
        return "itemCategory/add";
    }

    //新增一级类目
    @RequestMapping("/add")
    public String add(ItemCategory itemCategory) {
        itemCategory.setIsDelete(0);
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/findBySql";
    }

    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        ItemCategory category = itemCategoryService.load(id);
        model.addAttribute("category", category);
        return "itemCategory/update";
    }

    @RequestMapping("/exUpdate")
    public String exUpdate(ItemCategory itemCategory) {
        System.out.println("进入更新类目");
        System.out.println(itemCategory);
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        //将其下级也删除
        String sql = "update item_category set isDelete= 1 where pid=" + id;
        itemCategoryService.updateBysql(sql);
        return "redirect:/itemCategory/findBySql.action";
    }

    @RequestMapping("/findBySql2")
    public String findBySql2(ItemCategory itemCategory, Model model) {
        String sql = "select * from item_category where isDelete = 0 and pid= " + itemCategory.getPid() + " order by id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("pid", itemCategory.getPid());
        return "itemCategory/itemCategory2";
    }

    @RequestMapping("/toAdd2")
    public String toAdd2(Integer pid, Model model) {
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setIsDelete(0);
        itemCategory.setId(pid);
        ItemCategory byEntity = itemCategoryService.getByEntity(itemCategory);
        model.addAttribute("pid", pid);
        model.addAttribute("name", byEntity.getName());
        return "itemCategory/add2";
    }

    @RequestMapping("/exAdd2")
    public String exAdd2(ItemCategory itemCategory) {
        itemCategory.setIsDelete(0);
        itemCategoryService.insert(itemCategory);
        System.out.println(itemCategory.getPid());
        String result ="redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
        return result;
    }

    @RequestMapping("/update2")
    public String update2(Integer id, Model model) {
        ItemCategory category = itemCategoryService.load(id);
        model.addAttribute("category", category);
        return "itemCategory/update2";
    }

    @RequestMapping("/exUpdate2")
    public String exUpdate2(ItemCategory itemCategory) {
        System.out.println("进入更新类目");
        System.out.println(itemCategory);
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
    }

    @RequestMapping("/delete2")
    public String delete2(Integer id) {
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        //将其下级也删除

        return "redirect:/itemCategory/findBySql2.action?pid="+load.getPid();
    }
}
