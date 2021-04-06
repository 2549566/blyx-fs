package com.blyx.fs.web.controller.worker;

import com.blyx.fs.common.model.ResultModel;
import com.blyx.fs.common.utils.ParamCheckUtil;
import com.blyx.fs.common.utils.RedisUtil;
import com.blyx.fs.context.activity.other.CheckCodeActivity;
import com.blyx.fs.context.activity.worker.WorkerLoginActivity;
import com.blyx.fs.domain.worker.model.WorkerMO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/7
 */
@Slf4j
@RestController
@RequestMapping("/workerLogin")
public class LoginController {


    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private CheckCodeActivity checkCodeActivity;

    @Autowired
    private WorkerLoginActivity workerLoginActivity;




    @PostMapping("/getCheckCode")
    public ResultModel<String> getCheckCode(String mobile){
        //校验手机号
        ParamCheckUtil.checkMobileNumber(mobile);

        //校验IP，防止网络攻击 todo

        String checkCode=checkCodeActivity.genCheckCode(mobile);

        return ResultModel.setSuccessData(checkCode);
    }

    /**
     * 注册，第一次登陆
     *
     * */
    @PostMapping(value = "/login")
    public ResultModel<WorkerMO> login(String mobile, String code){
        //校验手机号
        ParamCheckUtil.checkMobileNumber(mobile);
        //校验二维码
        ParamCheckUtil.checkCode(code);
        //校验验证码过期
        checkCodeActivity.checkCodeOver(mobile,code);

        WorkerMO workerMO= workerLoginActivity.getWorkerInfoByMobile(mobile);

        if(workerMO==null){
            workerMO=workerLoginActivity.registerWorkerFrist(mobile);
        }


        return ResultModel.setSuccessData(workerMO);
    }


}
