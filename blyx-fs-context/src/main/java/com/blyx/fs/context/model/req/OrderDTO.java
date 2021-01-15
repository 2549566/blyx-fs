package com.blyx.fs.context.model.req;


import com.blyx.fs.common.model.BaseMO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
@Data
public class OrderDTO extends BaseMO implements Serializable {

    private static final long serialVersionUID = -7648318580971446484L;


    /**
     * 用户手机号
     *
     * */

    private String userMobile;
    /**
     * 订单省份编码
     *
     * */
    private Integer orderProvinceCode;

    /**
     * 订单城市编码
     *
     * */
    private Integer orderCityCode;
    /**
     * 订单地区编码
     *
     * */
    private Integer orderAreaCode;
    /**
     * 订单详细地址
     *
     * */
    private String orderAddressDetail;

    /**
     * 客户的订单描述
     *
     * */
    private String context;
    /**
     * 修补区域
     *
     * */
    private String repairRegion;

}
