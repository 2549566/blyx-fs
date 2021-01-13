package com.blyx.fs.infrastructrue.mapper;


import com.blyx.fs.infrastructrue.entity.OrderEntity;
import org.springframework.stereotype.Repository;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/13
 */
@Repository
public interface OrderMapper {

    /**
     * @desc 插入一条订单
     *
     * @param orderEntity 订单实体类
     * @return Integer 返回创建成功条数
     *
     * */
    Integer insertOne(OrderEntity orderEntity);
}
