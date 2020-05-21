package com.demo.springboot.work.test;

import com.demo.springboot.work.mapper.ArticleMapper;
import com.demo.springboot.work.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void test1() {
        Article byId = articleMapper.findById(1);
        System.out.println(byId);
    }

    @Test
    public void test2() {
        List<Article> all = articleMapper.findAll();
        all.stream().forEach(System.out::println);
    }

}
