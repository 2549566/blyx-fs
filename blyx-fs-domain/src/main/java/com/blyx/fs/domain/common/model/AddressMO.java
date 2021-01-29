package com.blyx.fs.domain.common.model;


import lombok.Data;

import java.io.Serializable;

/**
 * 地址
 *
 * */
@Data
public class AddressMO implements Serializable {

    private static final long serialVersionUID = 7733665049867984274L;
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
