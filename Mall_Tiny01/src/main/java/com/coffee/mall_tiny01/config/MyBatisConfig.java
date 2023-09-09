package com.coffee.mall_tiny01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@MapperScan("com.coffee.mall_tiny01.mbg.mapper")
public class MyBatisConfig {
}
