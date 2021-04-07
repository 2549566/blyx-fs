package com.blyx.fs.domain.order.repository;


import com.blyx.fs.domain.order.model.OrderMO;

import java.util.List;

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

    /**
     * @desc 查询订单信息
     * @param limit 页大小
     * @param offset 偏移量
     * @return List<OrderMO>
     *
     * */
    List<OrderMO> queryOrderListPage(Integer limit, Integer offset);
}
