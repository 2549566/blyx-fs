package com.blyx.fs.domain.order.ability.impl;


import com.blyx.fs.domain.order.ability.OrderAbility;
import com.blyx.fs.domain.order.model.OrderMO;
import com.blyx.fs.domain.worker.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
@Slf4j
@Service
public class OrderAbilityImpl implements OrderAbility {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Integer createOneOrder(OrderMO orderMO) {

        return orderRepository.saveOrder(orderMO);
    }
}
