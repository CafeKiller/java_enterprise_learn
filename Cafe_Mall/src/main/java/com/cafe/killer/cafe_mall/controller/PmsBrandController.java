package com.cafe.killer.cafe_mall.controller;


import com.cafe.killer.cafe_mall.common.api.CommonPage;
import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.mbg.model.PmsBrand;
import com.cafe.killer.cafe_mall.service.PmsBrandService;
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
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

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


    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = service.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(service.getBrand(id));
    }

}
