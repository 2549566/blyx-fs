package com.blyx.fs.domain.order.ability.impl;


import com.blyx.fs.common.enums.BizTypeEnum;
import com.blyx.fs.common.enums.OrderStatusEnum;
import com.blyx.fs.common.utils.GenOrderUtil;
import com.blyx.fs.domain.address.ability.AddressAbility;
import com.blyx.fs.domain.common.model.AddressMO;
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
    @Autowired
    private AddressAbility addressAbility;

    @Override
    public String genOrderCode(Integer orderProvinceCode,String bizType) {

        return GenOrderUtil.genOrderCode(orderProvinceCode,bizType);
    }

    @Override
    public String createOneOrder(OrderMO orderMO) {

        orderMO.setOrderCode(genOrderCode(orderMO.getOrderProvinceCode(), BizTypeEnum.FS.getCode()));

        orderMO.setType(BizTypeEnum.FS.getType());

        AddressMO province=addressAbility.findAddressByCode(orderMO.getOrderProvinceCode());

        if(province!=null){
            orderMO.setOrderProvinceName(province.getCityName());
        }

        AddressMO city=addressAbility.findAddressByCode(orderMO.getOrderCityCode());

        if(city!=null){
            orderMO.setOrderCityName(city.getCityName());
        }

        AddressMO area=addressAbility.findAddressByCode(orderMO.getOrderAreaCode());

        if(area!=null){
            orderMO.setOrderAreaName(area.getCityName());
        }

        orderMO.setStatus(OrderStatusEnum.INIT.getStatus());

        if(orderMO.getSumAmount()!=null){
            Integer workAmount=(int)(0.9 * orderMO.getSumAmount());
            Integer serviceFee=orderMO.getSumAmount()-workAmount;
            orderMO.setWorkerAmount(workAmount);
            orderMO.setServiceFee(serviceFee);
        }

        orderRepository.saveOrder(orderMO);

        return orderMO.getOrderCode();
    }
}
