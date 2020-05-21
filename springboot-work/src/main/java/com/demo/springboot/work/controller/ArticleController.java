package com.demo.springboot.work.controller;

import com.demo.springboot.work.pojo.Article;
import com.demo.springboot.work.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @Cacheable(value = "article", unless = "#result==null")
    @GetMapping("/{id}")
    public @ResponseBody
    Article findById(@PathVariable Integer id) {
        return articleService.findById(id);
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Article> all = articleService.findAll();
        model.addAttribute("list", all);
        return "index";
    }

    @RequestMapping("/page")
    public String getPage(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize) {
        Page<Article> page = articleService.getPage(pageNum, pageSize);
        System.out.println("总页数： " + page.getTotalPages());
        System.out.println("当前页： " + pageNum);
        page.getContent().stream().forEach(System.out::println);
        model.addAttribute("page", page);
        return "index";
    }

}
