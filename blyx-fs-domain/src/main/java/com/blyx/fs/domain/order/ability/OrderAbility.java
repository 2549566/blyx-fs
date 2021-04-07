package com.blyx.fs.domain.order.ability;


import com.blyx.fs.common.base.PageVO;
import com.blyx.fs.domain.order.model.OrderMO;
import com.blyx.fs.domain.order.model.WorkerDTO;

import java.util.List;

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


    /**
     * @desc 根据工人信息查询订单列表
     * @param page 工人信息+分页信息
     * @return List<OrderMO>
     *
     * */
    List<OrderMO> queryOrderListPage(PageVO<WorkerDTO> page);
}
