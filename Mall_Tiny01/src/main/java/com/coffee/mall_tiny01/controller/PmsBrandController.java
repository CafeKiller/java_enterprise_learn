package com.coffee.mall_tiny01.controller;


import com.coffee.mall_tiny01.service.PmsBrandService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService brandService;

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);


}
