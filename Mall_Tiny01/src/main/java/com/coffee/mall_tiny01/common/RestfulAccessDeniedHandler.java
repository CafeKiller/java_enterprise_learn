package com.coffee.mall_tiny01.common;

import cn.hutool.json.JSONUtil;
import com.coffee.mall_tiny01.common.api.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.coyote.http11.Constants.a;

public class RestfulAccessDeniedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException authException) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(CommonResult.unauthorized(authException.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}