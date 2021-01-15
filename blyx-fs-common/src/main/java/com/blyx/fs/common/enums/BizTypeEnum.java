package com.blyx.fs.common.enums;

/**
 * 正则表达式枚举
 *
 * */
public enum BizTypeEnum {

    FS("001","防水");
    private String code;
    private String desc;

    BizTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
