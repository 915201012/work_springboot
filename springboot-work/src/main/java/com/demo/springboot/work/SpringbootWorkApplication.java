package com.demo.springboot.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.demo.springboot.work.mapper")
@EnableCaching
public class SpringbootWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWorkApplication.class, args);
    }

}
