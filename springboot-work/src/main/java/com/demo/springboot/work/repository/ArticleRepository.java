package com.demo.springboot.work.repository;

import com.demo.springboot.work.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {

}
