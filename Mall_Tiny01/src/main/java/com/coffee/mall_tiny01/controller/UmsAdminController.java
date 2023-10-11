package com.coffee.mall_tiny01.controller;

import com.coffee.mall_tiny01.common.api.CommonResult;
import com.coffee.mall_tiny01.mbg.model.UmsAdmin;
import com.coffee.mall_tiny01.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 后台用户管理
 * */
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RestController("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result){
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin != null){
            CommonResult.failed();
        }
    }

}
