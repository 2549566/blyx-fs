package com.blyx.fs.web.controller.order;

import com.blyx.fs.common.model.BlyxResult;
import com.blyx.fs.common.utils.ParamCheckUtil;
import com.blyx.fs.common.utils.RedisUtil;
import com.blyx.fs.context.activity.order.OrderActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    private RedisUtil redisUtil;

    @Autowired
    private OrderActivity orderActivity;


    @GetMapping("/submitOrderFS")
    public BlyxResult<Boolean> getCheckCode(HttpServletRequest request, String mobile){
        //校验手机号
//        ParamCheckUtil.checkMobileNumber(mobile);

        redisUtil.setEx("quyangtest","31232131",20000);

        String testStr=redisUtil.get("quyangtest");

        System.out.println(testStr);

        //校验IP，防止网络攻击 todo

        String orderCode=orderActivity.createOrderFS();

        return BlyxResult.setSuccessData(true);
    }

}
