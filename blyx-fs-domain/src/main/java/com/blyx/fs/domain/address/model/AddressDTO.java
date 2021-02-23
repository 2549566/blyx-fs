package com.blyx.fs.domain.address.model;


import lombok.Data;

import java.io.Serializable;

/**
 * 地址
 *
 * */
@Data
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = -3601015773257244340L;
    /**
     * id
     *
     * */
    private Integer id;
    /**
     * 父ID
     *
     * */
    private String pid;
    /**
     * 城市名
     *
     * */
    private String cityName;
    /**
     * 地址类型
     *
     * */
    private Integer type;
}
