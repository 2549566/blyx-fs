package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum WorkerAuthEnum {


    IS_NOT_AUTH(-1,"未认证"),
    IS_AUTHING(0,"认证中"),
    IS_AUTH(1,"已认证"),
    ;

    private Integer code;
    private String desc;

    WorkerAuthEnum(Integer code, String desc) {
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
