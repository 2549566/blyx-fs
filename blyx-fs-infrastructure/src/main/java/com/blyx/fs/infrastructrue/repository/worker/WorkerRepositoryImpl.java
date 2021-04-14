package com.blyx.fs.infrastructrue.repository.worker;

import com.blyx.fs.domain.worker.model.WorkerMO;
import com.blyx.fs.domain.worker.repository.WorkerRepository;
import com.blyx.fs.infrastructrue.entity.WorkerEntity;
import com.blyx.fs.infrastructrue.mapper.WorkerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/6
 */
@Service
public class WorkerRepositoryImpl implements WorkerRepository {


    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public WorkerMO findWorkerInfo(WorkerMO workerMO) {

        WorkerEntity paramWorkerEntity=new WorkerEntity();
        BeanUtils.copyProperties(workerMO,paramWorkerEntity);

        WorkerEntity workerEntity= workerMapper.selectWorkerInfo(paramWorkerEntity);

        if(workerEntity==null){
            return null;
        }
        WorkerMO resultMO=new WorkerMO();
        BeanUtils.copyProperties(workerEntity,resultMO);

        return resultMO;
    }

    @Override
    public void saveWorkerInfo(WorkerMO workerMO) {
        WorkerEntity paramWorkerEntity=new WorkerEntity();
        BeanUtils.copyProperties(workerMO,paramWorkerEntity);
        workerMapper.insertWorker(paramWorkerEntity);
    }

    @Override
    public Boolean updateWorkerInfoByMobile(WorkerMO workerMO) {
        WorkerEntity paramWorkerEntity=new WorkerEntity();
        BeanUtils.copyProperties(workerMO,paramWorkerEntity);
        Integer count=workerMapper.updateWorkerInfoByMobile(workerMO);
        return count>0;
    }
}
