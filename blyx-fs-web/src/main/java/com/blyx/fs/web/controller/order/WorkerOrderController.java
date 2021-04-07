package com.blyx.fs.web.controller.order;

import com.alibaba.fastjson.JSON;
import com.blyx.fs.common.base.PageVO;
import com.blyx.fs.common.model.ResultModel;
import com.blyx.fs.context.activity.order.OrderActivity;
import com.blyx.fs.domain.order.model.OrderMO;
import com.blyx.fs.domain.order.model.WorkerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/7
 */
@Slf4j
@RestController
@RequestMapping("/workerOrder")
public class WorkerOrderController {

    @Autowired
    private OrderActivity orderActivity;

    @PostMapping("/queryOrderList")
    public ResultModel<PageVO<List<OrderMO>>> queryOrderList(@RequestBody PageVO<WorkerDTO> page){

        log.info("WorkerOrderController.queryOrderList:page={}", JSON.toJSONString(page));

        PageVO<List<OrderMO>> result= orderActivity.queryOrderListPage(page);

        return ResultModel.setSuccessData(result);
    }
}
