package com.blyx.fs.infrastructrue.mapper;

import com.blyx.fs.infrastructrue.entity.WorkerEntity;
import org.springframework.stereotype.Repository;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/25
 */
@Repository
public interface WorkerMapper {


    WorkerEntity selectWorkerInfo(WorkerEntity paramWorkerEntity);

    void insertWorker(WorkerEntity paramWorkerEntity);
}
