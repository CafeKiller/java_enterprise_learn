package com.cafe.killer.cafe_mall.controller;

import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.dto.UmsAdminLoginParam;
import com.cafe.killer.cafe_mall.mbg.model.UmsAdmin;
import com.cafe.killer.cafe_mall.mbg.model.UmsPermission;
import com.cafe.killer.cafe_mall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 后台用户管理 Controller
 * @author Coffee_Killer
 * */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
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
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam, BindingResult result){
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) CommonResult.failed();
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation("登录并返回 token")
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam,
                              BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) return CommonResult.validateFailed("用户名或密码错误");
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户的所有权限(包括 +- 权限)")
    @GetMapping("/permission/{adminId}")
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermission(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

}
