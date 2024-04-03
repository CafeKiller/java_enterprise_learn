package com.cafe.killer.cafe_mall.controller;


import com.cafe.killer.cafe_mall.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
