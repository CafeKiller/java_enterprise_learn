package com.cafe.killer.cafe_mall.controller;

import com.cafe.killer.cafe_mall.common.api.CommonPage;
import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.nosql.elasticsearch.document.EsProduct;
import com.cafe.killer.cafe_mall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索商品管理 Controller
 * @author Coffee_Killer
 * */
@Api(tags = "EsProductController", description = "搜索商品管理")
@Controller
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private EsProductService esProductService;

    @ApiOperation("导入所有数据库中的商品到ES")
    @PostMapping("/importAll")
    @ResponseBody
    public CommonResult<Integer> importAll() {
        int count = esProductService.importAll();
        return  CommonResult.success(null);
    }

    @ApiOperation("根据 id 删除商品")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation("根据 id 批量删除商品")
    @PostMapping("/delete/batch")
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success(null);
    }


    @ApiOperation("根据 id 创建商品")
    @GetMapping("/create/{id}")
    @ResponseBody
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) return CommonResult.success(esProduct);
        return CommonResult.failed();
    }

    @ApiOperation("简单搜索")
    @GetMapping("/search/simple")
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> result = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(result));
    }

}
