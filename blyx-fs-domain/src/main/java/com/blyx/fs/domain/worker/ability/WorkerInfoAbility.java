package com.blyx.fs.domain.worker.ability;

import com.blyx.fs.domain.worker.model.WorkerMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/6
 */
public interface WorkerInfoAbility {

    /**
     * @desc 查询工人信息
     * @param mobile 查询工人信息入参-手机号
     * @return WorkerMO
     *
     * */
    WorkerMO getWorkerInfo(String mobile);

    /**
     * @desc 工人注册
     * @param mobile 查询工人信息入参-手机号
     * @return WorkerMO
     *
     * */
    WorkerMO registerWorkerFrist(String mobile);
}
