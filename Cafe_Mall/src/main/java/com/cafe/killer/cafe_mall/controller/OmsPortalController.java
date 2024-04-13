package com.cafe.killer.cafe_mall.controller;

import com.cafe.killer.cafe_mall.dto.OrderParam;
import com.cafe.killer.cafe_mall.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 订单管理 Controller
 * */
@Api(tags = "OmsPortalController", description = "订单管理")
@Controller
@RequestMapping("/order")
public class OmsPortalController {

    @Autowired
    private OmsPortalOrderService portalOrderService;


    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    @ResponseBody
    public Object generateOrder(@RequestParam OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }

}
