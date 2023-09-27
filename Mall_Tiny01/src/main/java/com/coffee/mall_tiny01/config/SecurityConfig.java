package com.coffee.mall_tiny01.config;

import com.coffee.mall_tiny01.common.RestAuthenticationEntryPoint;
import com.coffee.mall_tiny01.common.RestfulAccessDeniedHandler;
import com.coffee.mall_tiny01.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


/*
* SecurityConfig的配置
* */

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf() // 此处使用的jwt, 此处就不需要csrf了
                .disable()
                .sessionManagement() // 基于token, 故此也不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对网站静态资源的无授权访问
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**")
                .permitAll()
                .antMatchers("/admin/login", "/admin/register") // 对登录和注册允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS) // 跨域请求会进行一次options请求
                .permitAll()
                //.antMatchers("/**") //测试式全部运行访问
                //.permitAll()
                .anyRequest() // 除上面外的所有请求全部都需要鉴权认证
                .authenticated();
        // 禁止缓存
        http.headers().cacheControl();
        // 添加JWT filter
        // http.addFilterBefore()

    }


    // @Bean
//    public
}
