package com.blyx.fs.common.enums;


/**
 * 正则表达式枚举
 *
 * */
public enum SystemExceptionEnum {

    SYSTEM_ERROR(-1,"系统错误");

    private int code;
    private String desc;

    SystemExceptionEnum(int code, String desc) {
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
