package com.blyx.fs.infrastructrue.mapper;


import com.blyx.fs.infrastructrue.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<OrderEntity> queryOrderListPage(@Param("limit") Integer limit,@Param("offset") Integer offset);

    Integer queryOrderListCount();
}
