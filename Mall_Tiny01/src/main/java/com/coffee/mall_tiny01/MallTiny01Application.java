package com.coffee.mall_tiny01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.coffee.mall_tiny01.mbg.mapper")
public class MallTiny01Application {

    public static void main(String[] args) {
        SpringApplication.run(MallTiny01Application.class, args);
    }

}
