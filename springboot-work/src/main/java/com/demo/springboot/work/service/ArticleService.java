package com.demo.springboot.work.service;

import com.demo.springboot.work.mapper.ArticleMapper;
import com.demo.springboot.work.pojo.Article;
import com.demo.springboot.work.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleRepository articleRepository;


    public Article findById(Integer id) {
        return articleMapper.findById(id);
    }

    public List<Article> findAll() {
        return articleMapper.findAll();
    }

    public List<Article> findPage(Integer pageSize, Integer pageNum) {
        Map<String, Object> param = new HashMap<>();
        param.put("index", (pageNum - 1) * pageSize);
        param.put("pageSize", pageSize);
        return articleMapper.findPage(param);
    }

    public Page<Article> getPage(int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        return page;
    }
}
