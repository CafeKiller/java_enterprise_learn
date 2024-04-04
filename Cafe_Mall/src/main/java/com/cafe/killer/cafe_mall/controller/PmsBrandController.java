package com.cafe.killer.cafe_mall.controller;


import com.cafe.killer.cafe_mall.common.api.CommonPage;
import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.mbg.model.PmsBrand;
import com.cafe.killer.cafe_mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理 Controller
 * @author Coffee_Killer
 * */
@Api(tags = "PmsBrandController", description = "品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("添加品牌")
    @PostMapping("/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult = null;

        int cont = service.createBrand(pmsBrand);
        if (cont == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("creatBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("创建操作失败");
            LOGGER.debug("creatBrand failed:{}", pmsBrand);
        }

        return commonResult;
    }

    @ApiOperation("通过ID更新指定品牌")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand, BindingResult result) {
        CommonResult commonResult = null;

        int cont = service.updateBrand(id, pmsBrand);
        if (cont == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("更新操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("通过ID删除指定品牌")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int cont = service.deleteBrand(id);
        if (cont == 1) {
            LOGGER.debug("deleteBrand success: id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed: id={}", id);
            return CommonResult.failed("删除操作失败");
        }
    }

    @ApiOperation("分页查询品牌")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                        @ApiParam("页码") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3")
                                                        @ApiParam("每页数量") Integer pageSize) {
        List<PmsBrand> brandList = service.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定ID的品牌信息")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(service.getBrand(id));
    }

    @ApiOperation("获取所有品牌列表")
    @GetMapping("/all")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(service.listAllBrand());
    }

}
