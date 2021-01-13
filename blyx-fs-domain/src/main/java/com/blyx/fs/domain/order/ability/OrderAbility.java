package com.blyx.fs.domain.order.ability;


import com.blyx.fs.domain.order.model.OrderMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
public interface OrderAbility {

    Integer createOneOrder(OrderMO orderMO);
}
