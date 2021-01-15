package com.blyx.fs.common.enums;


import java.util.Objects;

/**
 * 异常枚举类
 *
 * */
public enum AddressCodeEnum {


    BJ(1,"BJ","北京")


    ;




    private int id;
    private String code;
    private String desc;

    AddressCodeEnum(int id,String code, String desc) {
        this.id=id;
        this.code = code;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static String getCodeById(Integer code){
        if(null == code){
            return "";
        }
        for(AddressCodeEnum node:values()){
            if(Objects.equals(node.getId(),code)){
                return node.getCode();
            }
        }
        return "";
    }
}
