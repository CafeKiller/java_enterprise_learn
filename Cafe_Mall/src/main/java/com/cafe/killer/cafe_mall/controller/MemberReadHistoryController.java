package com.cafe.killer.cafe_mall.controller;

import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.nosql.mongodb.document.MemberReadHistory;
import com.cafe.killer.cafe_mall.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员商品浏览记录管理 Controller
 * @author Coffee_Killer
 * */
@Controller
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @PostMapping("/create")
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("删除浏览记录")
    @PostMapping("/delete")
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        int count = memberReadHistoryService.delete(ids);
        if (count > 0) return CommonResult.success(count);
        return CommonResult.failed();
    }

    @ApiOperation("展示浏览记录")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<List<MemberReadHistory>> list(Long memberId){
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return CommonResult.success(memberReadHistoryList);
    }

}
