package com.cafe.killer.cafe_mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


/**
 * MyBatis 配置类
 * @author Coffee_Killer
 * */

@Configuration
@MapperScan({"com.cafe.killer.cafe_mall.mbg.mapper","com.cafe.killer.cafe_mall.dao"})
public class MyBatisConfig {

}
