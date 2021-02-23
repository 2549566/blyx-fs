package com.blyx.fs.common.enums;


import java.util.Objects;

/**
 * 地址级别枚举
 *
 * */
public enum AddressLevelEnum {

    ZH(0,"国家级"),
    PROVINCE(1,"省级"),
    AREA(2,"地级"),
    CITY(3,"市级");

    private int level;
    private String desc;

    AddressLevelEnum(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static AddressLevelEnum getAddressLevelEnum(int level) {
        for(AddressLevelEnum addressLevelEnum : values()) {
            if(Objects.equals(level,addressLevelEnum.getLevel())) {
                return addressLevelEnum;
            }
        }
        return null;
    }

}
