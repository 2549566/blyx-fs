package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum WorkerAcceptOrderEnum {


    IS_NOT_ACCEPT(0,"不接单"),
    IS_ACCEPT(1,"接单"),
    ;

    private Integer code;
    private String desc;

    WorkerAcceptOrderEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
