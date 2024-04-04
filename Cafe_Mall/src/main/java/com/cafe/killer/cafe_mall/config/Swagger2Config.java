package com.cafe.killer.cafe_mall.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2Api 文档配置类
 * @author Coffee_Killer
 * */
@Configurable
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包下的 controller 生成 API 文档
                .apis(RequestHandlerSelectors.basePackage("com.cafe.killer.cafe_mall.controller"))
                // 为有 @Api 注解的 controller 生成 API 文档
                // .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 为有 @ApiOperation 注解的方法生成 API 文档
                // .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerAPI 文档")
                .description("cafe_mall API document")
                .contact("cafe")
                .version("1.0")
                .build();
    }

}
