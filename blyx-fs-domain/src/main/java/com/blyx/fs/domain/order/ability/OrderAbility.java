package com.blyx.fs.domain.order.ability;


import com.blyx.fs.domain.order.model.OrderMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
public interface OrderAbility {


    /**
     * @desc 生成OrderCode
     * @param orderProvinceCode 防水区域
     * @param bizType 业务类型
     * @return String
     *
     * */
    String genOrderCode(Integer orderProvinceCode,String bizType);

    /**
     * @desc 创建一个订单
     * @param orderMO 订单入参（字段不全）
     * @return 订单编码
     *
     * */
    String createOneOrder(OrderMO orderMO);
}
