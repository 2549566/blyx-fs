package com.blyx.fs.context.activity.worker.impl;

import com.blyx.fs.context.activity.worker.WorkerLoginActivity;
import com.blyx.fs.domain.worker.ability.WorkerInfoAbility;
import com.blyx.fs.domain.worker.model.WorkerMO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/7
 */
@Slf4j
@Service
public class WorkerLoginActivityImpl implements WorkerLoginActivity {

    @Autowired
    private WorkerInfoAbility workerInfoAbility;


    @Override
    public WorkerMO getWorkerInfoByMobile(String mobile) {

        log.info("WorkerLoginActivityImpl.findWorkerInfoByMobile:mobile={}",mobile);

        WorkerMO workerMO=workerInfoAbility.getWorkerInfo(mobile);

        return workerMO;
    }

    @Override
    public WorkerMO registerWorkerFrist(String mobile) {
        log.info("WorkerLoginActivityImpl.registerWorker:mobile={}",mobile);

        WorkerMO workerMO=workerInfoAbility.registerWorkerFrist(mobile);

        return workerMO;
    }
}
