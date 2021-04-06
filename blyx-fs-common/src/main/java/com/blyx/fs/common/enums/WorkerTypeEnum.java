package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum WorkerTypeEnum {


    WORKER_NORMAL(0,"普通工人"),
    ADMIN(10,"管理员"),

    ;




    private int code;
    private String desc;

    WorkerTypeEnum(int code, String desc) {
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
