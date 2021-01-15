package com.blyx.fs.web.controller.order;

import com.alibaba.fastjson.JSON;
import com.blyx.fs.common.enums.BizCodeEnum;
import com.blyx.fs.common.exception.BizException;
import com.blyx.fs.common.model.BlyxResult;
import com.blyx.fs.common.utils.AddressCheckUtil;
import com.blyx.fs.common.utils.ParamCheckUtil;
import com.blyx.fs.context.activity.order.OrderActivity;
import com.blyx.fs.context.model.req.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
@Slf4j
@RestController
@RequestMapping("/userOrder")
public class UserOrderController {


    @Autowired
    private OrderActivity orderActivity;


    @PostMapping("/submitOrderFS")
    public BlyxResult<Boolean> submitOrderFS(@RequestBody OrderDTO orderDTO){

        log.info("UserOrderController.submitOrderFS:orderDTO={}",JSON.toJSONString(orderDTO));

        checkSubmitOrderFS(orderDTO);

        //校验手机号
        ParamCheckUtil.checkMobileNumber(orderDTO.getUserMobile());

        String orderCode=orderActivity.createOrderFS(orderDTO);

        log.info("UserOrderController.submitOrderFS:result orderCode={}",orderCode);

        return BlyxResult.setSuccessData(true);
    }

    private Boolean checkSubmitOrderFS(OrderDTO orderDTO) {

        if(orderDTO==null){
            log.error("UserOrderController.submitOrderFS:orderDTO is null");
            throw new BizException(BizCodeEnum.ORDER_USER_SUBMIT_NULL.getCode(),BizCodeEnum.ORDER_USER_SUBMIT_NULL.getDesc());
        }

        if(!AddressCheckUtil.checkServerRegion(orderDTO.getOrderProvinceCode())){
            throw new BizException(BizCodeEnum.ORDER_NOT_IN_SERVER_REGION.getCode(),BizCodeEnum.ORDER_NOT_IN_SERVER_REGION.getDesc());
        }

        return true;
    }

}
