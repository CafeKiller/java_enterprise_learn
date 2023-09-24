package com.coffee.mall_tiny01.controller;

import com.coffee.mall_tiny01.common.api.CommonResult;
import com.coffee.mall_tiny01.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
* 会员登录注册管理Controller
* */

@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RestController("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }

}
