package com.cafe.killer.cafe_mall.service;


import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理 service
 * @author Coffee_Killer
 * */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     * */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);



    /**
     * 取消单个超时订单
     * */
    @Transactional
    void clearOrder(Long orderId);

}
