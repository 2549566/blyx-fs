package com.blyx.fs.context.activity.order;

import com.blyx.fs.common.base.PageVO;
import com.blyx.fs.context.model.req.OrderDTO;
import com.blyx.fs.domain.order.model.OrderMO;
import com.blyx.fs.domain.order.model.WorkerDTO;

import java.util.List;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
public interface OrderActivity {

    /**
     * @desc 创建FS订单
     * @param orderDTO 订单入参
     *
     * @return orderCode 订单编码
     * */
    String createOrderFS(OrderDTO orderDTO);

    PageVO<List<OrderMO>> queryOrderListPage(PageVO<WorkerDTO> page);
}
