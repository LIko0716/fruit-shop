package com.javapandeng.controller;

import com.javapandeng.base.BaseController;
import com.javapandeng.po.News;
import com.javapandeng.service.NewsService;
import com.javapandeng.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author hangzhi1063
 * @date 2020/11/5 19:41
 */
@Controller
@RequestMapping("/news")
public class NewsController  extends BaseController {

    @Autowired
   private NewsService newsService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model, News news){
        String sql ="select * from news ";
        if (!isEmpty(news.getName())){
            sql += " where name like '%"+news.getName()+"%'";
        }
        sql+=" order by id desc";

        Pager<News> pagers = newsService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",news);
        return "news/news";
    }

    @RequestMapping("/add")
    public String add(){
        return "news/add";
    }

    @RequestMapping("/exAdd")
    public String exAdd(News news){
        news.setAddTime(new Date());
        newsService.insert(news);
        return "redirect:/news/findBySql.action";
    }

    @RequestMapping("/update")
    public String update(Model model,Integer id){
        News byId = newsService.getById(id);
        model.addAttribute("news",byId);
        return "news/update";

    }

    @RequestMapping("/exUpdate")
    public String exUpdate(News news){
        newsService.updateById(news);
        return "redirect:/news/findBySql.action";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        newsService.deleteById(id);
        return "redirect:/news/findBySql.action";
    }
    @RequestMapping("/list")
    public String list(Model model){

        String sql ="select * from news order by id desc";
        Pager<News> pagers = newsService.findBySqlReturnEntity(sql);
        model.addAttribute("pagers",pagers);
        return "news/list";
    }

    @RequestMapping("/view")
    public String view(Integer id,Model model){
        News news = newsService.load(id);
        model.addAttribute("news",news);
        return "news/view";
    }
}
