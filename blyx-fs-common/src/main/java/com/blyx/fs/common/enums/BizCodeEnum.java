package com.blyx.fs.common.enums;


/**
 * 正则表达式枚举
 *
 * */
public enum BizCodeEnum {

    WORKER_LOGIN_TOKEN_IS_NOT_EXISTS(100001,"用户未登陆");

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
