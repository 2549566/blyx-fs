package com.blyx.fs.common.enums;


/**
 * 异常枚举类
 *
 * */
public enum WorkerAuthEnum {


    IS_NOT_AUTH(false,"未认证"),
    IS_AUTH(true,"已认证"),
    ;




    private Boolean isAuth;
    private String desc;

    WorkerAuthEnum(Boolean isAuth, String desc) {
        this.isAuth = isAuth;
        this.desc = desc;
    }

    public Boolean getAuth() {
        return isAuth;
    }

    public void setAuth(Boolean auth) {
        isAuth = auth;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
