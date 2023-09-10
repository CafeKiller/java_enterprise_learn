package com.coffee.mall_tiny01.config;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2文档配置
 * */
@Configurable
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 选择在当前模块下的controller包生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.coffee.mall_tiny01.controller"))

                /* 为有@Api注解的Controller生成API文档 */
                //.apis(RequestHandlerSelectors.withClassAnnotation((Api.class)))

                /* 为有@ApiOperation注解的方法生成API文档 */
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))

                // 为包下所有的方法生成API文档
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger API文档")
                .description("cafe_mall_tiny")
                .contact("Coffee_Killer")
                .version("1.0.0")
                .build();
    }

}
