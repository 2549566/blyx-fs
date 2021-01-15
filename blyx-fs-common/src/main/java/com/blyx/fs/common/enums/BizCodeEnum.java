package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum BizCodeEnum {


    /**
     * worker异常 10000开头
     *
     * */
    WORKER_LOGIN_TOKEN_IS_NOT_EXISTS(100001,"用户未登陆"),



    /**
     * order异常 20000开头
     *
     * */
    ORDER_USER_SUBMIT_NULL(200001,"提交的订单为空"),
    ORDER_NOT_IN_SERVER_REGION(200002,"订单不在服务区"),





    ;




    private int code;
    private String desc;

    BizCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
