package com.blyx.fs.web.controller.worker;

import com.alibaba.fastjson.JSON;
import com.blyx.fs.common.enums.BizCodeEnum;
import com.blyx.fs.common.enums.WorkerAuthEnum;
import com.blyx.fs.common.exception.BizException;
import com.blyx.fs.common.model.ResultModel;
import com.blyx.fs.common.utils.ParamCheckUtil;
import com.blyx.fs.common.utils.ValidateIdCardUtil;
import com.blyx.fs.context.activity.worker.WorkerActivity;
import com.blyx.fs.domain.worker.model.WorkerMO;
import com.blyx.fs.web.controller.order.WorkerOrderController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/14
 */
@Slf4j
@RestController
@RequestMapping("/worker")
public class WorkerController {


    @Autowired
    private WorkerActivity workerActivity;

    @PostMapping("/getWorkerInfo")
    public ResultModel<WorkerMO> getCheckCode(String mobile){
        //校验手机号
        ParamCheckUtil.checkMobileNumber(mobile);

        WorkerMO workerMO=workerActivity.getWorkerInfoByMobile(mobile);

        return ResultModel.setSuccessData(workerMO);
    }

    @PostMapping("/perfectWorkerInfo")
    public ResultModel<Boolean> perfectWorkerInfo(@RequestBody WorkerMO workerMO){

        log.info("WorkerController.perfectWorkerInfo:workerMO={}", JSON.toJSONString(workerMO));

        if(workerMO==null){
            throw new BizException(BizCodeEnum.WORKER_PREFECT_WORKERINFO_NULL.getCode(),BizCodeEnum.WORKER_PREFECT_WORKERINFO_NULL.getMsg());
        }

        if(StringUtils.isBlank(workerMO.getMobile())){
            throw new BizException(BizCodeEnum.WORKER_PREFECT_MOBILE_NULL.getCode(),BizCodeEnum.WORKER_PREFECT_MOBILE_NULL.getMsg());
        }

        if(StringUtils.isBlank(workerMO.getIdCard())){
            throw new BizException(BizCodeEnum.WORKER_PREFECT_IDCARD_NULL.getCode(),BizCodeEnum.WORKER_PREFECT_IDCARD_NULL.getMsg());
        }

        if(!ValidateIdCardUtil.isIDCard(workerMO.getIdCard())){
            throw new BizException(BizCodeEnum.WORKER_PREFECT_IDCARD_FORMAT.getCode(),BizCodeEnum.WORKER_PREFECT_IDCARD_FORMAT.getMsg());
        }

        if(StringUtils.isBlank(workerMO.getIdcardFaceUrl())){
            throw new BizException(BizCodeEnum.WORKER_PREFECT_IDCARD_FACE_URL.getCode(),BizCodeEnum.WORKER_PREFECT_IDCARD_FACE_URL.getMsg());
        }

        if(StringUtils.isBlank(workerMO.getIdcardNationalEmblemUrl())){
            throw new BizException(BizCodeEnum.WORKER_PREFECT_IDCARD_NATIONAL_EMBLEM_URL.getCode(),BizCodeEnum.WORKER_PREFECT_IDCARD_NATIONAL_EMBLEM_URL.getMsg());
        }

        workerMO.setIsAuth(WorkerAuthEnum.IS_AUTH.getCode());

        workerActivity.perfectWorkerInfo(workerMO);

        return ResultModel.setSuccessData(true);
    }
}
