package com.cafe.killer.cafe_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// FIX: 修复 Mybatis 无法正确扫描问题
//@MapperScan({"com.cafe.killer.cafe_mall.mbg.mapper","com.cafe.killer.cafe_mall.dao"})
// FIX: 修复 SwaggerUI 启动失败问题
@EnableSwagger2
public class CafeMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeMallApplication.class, args);
    }

}
