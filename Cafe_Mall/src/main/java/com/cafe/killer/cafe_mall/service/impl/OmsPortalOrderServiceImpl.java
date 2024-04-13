package com.cafe.killer.cafe_mall.service.impl;

import com.cafe.killer.cafe_mall.common.api.CommonResult;
import com.cafe.killer.cafe_mall.component.CancelOrderSender;
import com.cafe.killer.cafe_mall.dto.OrderParam;
import com.cafe.killer.cafe_mall.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前台订单管理 service
 * @author Coffee_Killer
 * */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // TODO 执行一系列下单操作
        LOGGER.info("process generateOrder");
        // 下单完成后开启一个延迟消息, 用于当用户没有付款时取消订单 (orderId 应该在下单时生成)
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void clearOrder(Long orderId) {
        // TODO 执行一系列取消订单操作
        LOGGER.info("process cancelOrder orderId:{}", orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        // 获取订单超时时间, 假设为30分钟
        long delayTimes = 30 * 1000;
        // 发起延迟消息
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
