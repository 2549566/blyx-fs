package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum BizCodeEnum {


    /**
     * worker异常 100000开头
     *
     * */
    WORKER_LOGIN_TOKEN_IS_NOT_EXISTS(100001,"用户未登陆"),
    WORKER_PREFECT_WORKERINFO_NULL(100002,"用户信息不能为空"),
    WORKER_PREFECT_MOBILE_NULL(100003,"手机号不能为空"),
    WORKER_PREFECT_IDCARD_NULL(100004,"身份证不能为空"),
    WORKER_PREFECT_IDCARD_FORMAT(100005,"身份证格式错误"),
    WORKER_PREFECT_IDCARD_FACE_URL(100006,"未上传身份证人脸照片"),
    WORKER_PREFECT_IDCARD_NATIONAL_EMBLEM_URL(100007,"未上传身份证国徽照片"),



    /**
     * order异常 200000开头
     *
     * */
    ORDER_USER_SUBMIT_NULL(200001,"提交的订单为空"),
    ORDER_NOT_IN_SERVER_REGION(200002,"订单不在服务区"),



    /**
     * address异常 400000开头
     *
     * */
    ADDRESS_REST_QUERYADDRESSLIST_PARAM_EMPTY(400001,"REST：地址ID为空"),


    ;




    private int code;
    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
