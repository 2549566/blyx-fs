package com.blyx.fs.domain.worker.repository;


import com.blyx.fs.domain.order.model.OrderMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
public interface OrderRepository {

    /**
     * @desc 保存订单（只新增）
     * @param orderMO 订单对象
     * @return Integer 返回创建成功条数
     *
     * */
    Integer saveOrder(OrderMO orderMO);
}
