package com.cafe.killer.cafe_mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;


/**
 * MyBatis 配置类
 * @author Coffee_Killer
 * */

@Configurable
@MapperScan("com.cafe.killer.cafe_mall.mbg.mapper")
public class MyBatisConfig {

}
