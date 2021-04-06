package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum CreditLevelEnum {


    LEVEL_0(0,"无信用"),
    LEVEL_1(1,"无太大信用"),
    LEVEL_8(8,"信用一般"),
    LEVEL_9(9,"信用良好"),
    LEVEL_10(10,"信用特别好"),
    ;




    private int code;
    private String desc;

    CreditLevelEnum(int code, String desc) {
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
