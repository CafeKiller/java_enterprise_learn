package com.coffee.mall_tiny01.controller;


import com.coffee.mall_tiny01.common.api.CommonPage;
import com.coffee.mall_tiny01.common.api.CommonResult;
import com.coffee.mall_tiny01.mbg.model.PmsBrand;
import com.coffee.mall_tiny01.service.PmsBrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌管理Controller
 * */
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    /* 日志对象 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);


    /**
     * 请求所有品牌信息
     * */
    @ApiOperation("获取所有品牌信息")
    @GetMapping("/listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }

    /**
     * 创建一个品牌信息
     * */
    @ApiOperation("添加品牌")
    @PostMapping("/create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
       CommonResult commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("create success:{}", pmsBrand);
        }else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("create failed:{}", pmsBrand);
        }
        return commonResult;
    }

    /**
     * 更新一个品牌信息
     * @param id 品牌id
     * @param pmsBrandDto 品牌更新信息
     * */
    @ApiOperation("更新指定id品牌信息")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1){
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
        }else {
            commonResult = CommonResult.failed("更新Brand失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    /**
     * 删除一个品牌信息
     * @param id 品牌id
     * */
    @ApiOperation("删除指定id品牌信息")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") long id){
        int result = brandService.deleteBrand(id);
        if (result == 1){
            LOGGER.debug("deleteBrand success : id={}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("deleteBrand failed : id={}",id);
            return CommonResult.failed("删除失败");
        }
    }

    /**
     * 分页获取品牌信息
     * @param pageNum 请求元素的起始位置 默认从1开始
     * @param pageSize 请求的单页元素数量 默认单页取3位元素
     * */
    @ApiOperation("分页查询品牌列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    /**
     * 根据id获取单个品牌的信息
     * */
    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id){
        return CommonResult.success(brandService.getBrand(id));
    }

}
