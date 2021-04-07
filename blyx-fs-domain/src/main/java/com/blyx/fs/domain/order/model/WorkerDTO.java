package com.blyx.fs.domain.order.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/7
 */
@Data
public class WorkerDTO implements Serializable {
    private static final long serialVersionUID = -2894006893520330117L;

    /**
     * 用户pin
     *
     * */
    private String pin;

    /**
     * 手机号
     *
     * */
    private String mobile;

    /**
     * 身份证号
     *
     * */
    private String idCard;

    /**
     * 定位地址
     *
     * */
    private String locateInfo;

    /**
     * 经度
     *
     * */
    private Double longitude;

    /**
     * 纬度
     *
     * */
    private Double latitude;
}
