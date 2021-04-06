package com.blyx.fs.context.activity.worker;

import com.blyx.fs.domain.worker.model.WorkerMO;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/7
 */
public interface WorkerLoginActivity {

    /**
     * @desc 根据手机号获取工人信息
     * @param mobile 手机号
     * @return WorkerMO
     *
     *
     * */
    WorkerMO getWorkerInfoByMobile(String mobile);

    /**
     * @desc 工人注册
     * @param mobile 手机号
     * @return WorkerMO
     *
     * */
    WorkerMO registerWorkerFrist(String mobile);
}
