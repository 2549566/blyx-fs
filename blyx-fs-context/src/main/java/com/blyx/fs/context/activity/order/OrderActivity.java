package com.blyx.fs.context.activity.order;

import com.blyx.fs.context.model.req.OrderDTO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
public interface OrderActivity {

    /**
     * @desc 创建FS订单
     * @param orderDTO 订单入参
     *
     * @return orderCode 订单编码
     * */
    String createOrderFS(OrderDTO orderDTO);
}
