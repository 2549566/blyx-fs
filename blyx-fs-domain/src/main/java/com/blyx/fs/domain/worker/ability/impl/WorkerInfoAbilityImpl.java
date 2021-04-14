package com.blyx.fs.domain.worker.ability.impl;

import com.alibaba.fastjson.JSON;
import com.blyx.fs.common.base.RedisConstant;
import com.blyx.fs.common.enums.CreditLevelEnum;
import com.blyx.fs.common.enums.WorkerAcceptOrderEnum;
import com.blyx.fs.common.enums.WorkerAuthEnum;
import com.blyx.fs.common.enums.WorkerTypeEnum;
import com.blyx.fs.common.utils.RedisUtil;
import com.blyx.fs.common.utils.UniqueUtil;
import com.blyx.fs.domain.worker.ability.WorkerInfoAbility;
import com.blyx.fs.domain.worker.model.WorkerMO;
import com.blyx.fs.domain.worker.repository.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/6
 */
@Slf4j
@Service
public class WorkerInfoAbilityImpl implements WorkerInfoAbility {


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public WorkerMO getWorkerInfo(String mobile) {

        String workerStr=redisUtil.get(RedisConstant.REDIS_WORKER_PREFIX+mobile);

        if(StringUtils.isNotBlank(workerStr)){
            return JSON.parseObject(workerStr,WorkerMO.class);
        }

        WorkerMO param=new WorkerMO();
        param.setMobile(mobile);
        WorkerMO workerMO = workerRepository.findWorkerInfo(param);

        if(workerMO==null){
            return null;
        }

        redisUtil.setEx(RedisConstant.REDIS_WORKER_PREFIX+ mobile,JSON.toJSONString(workerMO),RedisConstant.REDIS_WORKER_TIMEOUT);

        return workerMO;
    }

    @Override
    public WorkerMO registerWorkerFrist(String mobile) {

        WorkerMO workerMO=new WorkerMO();

        workerMO.setMobile(mobile);
        workerMO.setPassword("88888888");
        workerMO.setPin(UniqueUtil.genPin(mobile));
        workerMO.setType(WorkerTypeEnum.WORKER_NORMAL.getCode());
        workerMO.setCreditLevel(CreditLevelEnum.LEVEL_9.getCode());
        workerMO.setAddressProvinceCode(2);
        workerMO.setAddressCityCode(52);
        workerMO.setAddressAreaCode(500);

        workerMO.setAddressProvinceName("北京市");
        workerMO.setAddressCityName("北京市");
        workerMO.setAddressAreaName("东城区");

        workerMO.setIsAuth(WorkerAuthEnum.IS_NOT_AUTH.getCode());

        workerMO.setIsAcceptOrder(WorkerAcceptOrderEnum.IS_ACCEPT.getCode());

        workerRepository.saveWorkerInfo(workerMO);

        return workerMO;
    }

    @Override
    public Boolean editWorkerInfo(WorkerMO workerMO) {
        return workerRepository.updateWorkerInfoByMobile(workerMO);
    }

}
