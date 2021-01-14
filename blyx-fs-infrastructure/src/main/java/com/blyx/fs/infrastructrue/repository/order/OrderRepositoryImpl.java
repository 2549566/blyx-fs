package com.blyx.fs.infrastructrue.repository.order;


import com.blyx.fs.domain.order.model.OrderMO;
import com.blyx.fs.domain.worker.repository.OrderRepository;
import com.blyx.fs.infrastructrue.entity.OrderEntity;
import com.blyx.fs.infrastructrue.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
@Slf4j
@Service
public class OrderRepositoryImpl implements OrderRepository {


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer saveOrder(OrderMO orderMO) {
        OrderEntity entity=new OrderEntity();
        BeanUtils.copyProperties(orderMO,entity);
        return orderMapper.insertOne(entity);
    }
}
