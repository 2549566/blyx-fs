package com.blyx.fs.infrastructrue.repository.order;


import com.blyx.fs.domain.order.model.OrderMO;
import com.blyx.fs.domain.worker.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
@Slf4j
@Service
public class OrderRepositoryImpl implements OrderRepository {


    @Override
    public Integer saveOrder(OrderMO orderMO) {
        return null;
    }
}
