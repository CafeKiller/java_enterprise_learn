package com.coffee.mall_tiny01.controller;


import com.coffee.mall_tiny01.common.api.CommonResult;
import com.coffee.mall_tiny01.mbg.model.PmsBrand;
import com.coffee.mall_tiny01.service.PmsBrandService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @GetMapping("/listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }

    /**
     * 创建一个品牌信息
     * */
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

}
