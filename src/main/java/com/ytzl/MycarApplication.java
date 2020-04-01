package com.ytzl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.ytzl.dao")
@ServletComponentScan(basePackages = "com.ytzl.config")
public class MycarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycarApplication.class, args);
    }

}
