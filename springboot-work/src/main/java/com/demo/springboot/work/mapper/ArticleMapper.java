package com.demo.springboot.work.mapper;

import com.demo.springboot.work.pojo.Article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ArticleMapper {

    @Select("SELECT * FROM t_article WHERE ID = #{id}")
    Article findById(Integer id);

    List<Article> findAll();

    List<Article> findPage(Map<String, Object> param);
}
