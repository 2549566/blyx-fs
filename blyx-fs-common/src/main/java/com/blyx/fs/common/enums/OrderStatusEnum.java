package com.blyx.fs.common.enums;

/**
 * 正则表达式枚举
 *
 * */
public enum OrderStatusEnum {

    INIT(1, "初始化");
    private Integer status;
    private String desc;

    OrderStatusEnum(Integer status, String desc) {
        this.status=status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
