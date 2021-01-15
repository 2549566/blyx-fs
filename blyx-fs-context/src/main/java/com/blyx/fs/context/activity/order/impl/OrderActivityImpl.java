package com.blyx.fs.context.activity.order.impl;


import com.blyx.fs.context.activity.order.OrderActivity;
import com.blyx.fs.context.model.req.OrderDTO;
import com.blyx.fs.domain.order.ability.OrderAbility;
import com.blyx.fs.domain.order.model.OrderMO;
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
public class OrderActivityImpl implements OrderActivity {


    @Autowired
    private OrderAbility orderAbility;

    @Override
    public String createOrderFS(OrderDTO orderDTO) {

        OrderMO orderParam=new OrderMO();

        orderParam.setUserMobile(orderDTO.getUserMobile());
        orderParam.setOrderProvinceCode(orderDTO.getOrderProvinceCode());
        orderParam.setOrderCityCode(orderDTO.getOrderCityCode());
        orderParam.setOrderAreaCode(orderDTO.getOrderAreaCode());
        orderParam.setOrderAddressDetail(orderDTO.getOrderAddressDetail());
        orderParam.setContext(orderDTO.getContext());
        orderParam.setRepairRegion(orderDTO.getRepairRegion());

        return orderAbility.createOneOrder(orderParam);
    }
}
