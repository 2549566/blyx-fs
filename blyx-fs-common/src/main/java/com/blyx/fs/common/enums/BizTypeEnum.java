package com.blyx.fs.common.enums;

/**
 * 正则表达式枚举
 *
 * */
public enum BizTypeEnum {

    FS(1,"001","防水");
    private Integer type;
    private String code;
    private String desc;

    BizTypeEnum(Integer type,String code, String desc) {
        this.type=type;
        this.code = code;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
