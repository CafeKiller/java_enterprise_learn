package com.cafe.killer.cafe_mall.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单超时取消并解锁库存的定时器
 * @author Coffee_Killer
 * */
@Component
public class OrderTimeOutCancelTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    private void cancelTimeOutOrder() {
        LOGGER.info("取消订单, 并根据 sku 编号释放解锁库存");
    }

}
