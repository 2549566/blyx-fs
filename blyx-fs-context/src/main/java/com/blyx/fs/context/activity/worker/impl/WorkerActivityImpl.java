package com.blyx.fs.context.activity.worker.impl;

import com.blyx.fs.context.activity.worker.WorkerActivity;
import com.blyx.fs.domain.worker.ability.WorkerInfoAbility;
import com.blyx.fs.domain.worker.model.WorkerMO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/14
 */
@Slf4j
@Service
public class WorkerActivityImpl implements WorkerActivity {


    @Autowired
    private WorkerInfoAbility workerInfoAbility;


    @Override
    public WorkerMO getWorkerInfoByMobile(String mobile) {

        log.info("WorkerLoginActivityImpl.findWorkerInfoByMobile:mobile={}",mobile);

        WorkerMO workerMO=workerInfoAbility.getWorkerInfo(mobile);

        return workerMO;
    }

    @Override
    public Boolean perfectWorkerInfo(WorkerMO workerMO) {
        return workerInfoAbility.editWorkerInfo(workerMO);
    }
}
