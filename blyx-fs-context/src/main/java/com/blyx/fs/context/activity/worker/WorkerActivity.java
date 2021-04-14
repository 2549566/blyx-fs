package com.blyx.fs.context.activity.worker;

import com.blyx.fs.domain.worker.model.WorkerMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/14
 */
public interface WorkerActivity {

    /**
     * @desc 根据手机号获取
     * @param mobile 手机号
     * @return WorkerMO 工人信息
     * */
    WorkerMO getWorkerInfoByMobile(String mobile);

    Boolean perfectWorkerInfo(WorkerMO workerMO);
}
