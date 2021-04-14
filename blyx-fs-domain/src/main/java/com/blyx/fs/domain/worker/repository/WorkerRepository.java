package com.blyx.fs.domain.worker.repository;

import com.blyx.fs.domain.worker.model.WorkerMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/6
 */
public interface WorkerRepository {


    WorkerMO findWorkerInfo(WorkerMO workerMO);

    void saveWorkerInfo(WorkerMO workerMO);

    Boolean updateWorkerInfoByMobile(WorkerMO workerMO);
}
