package com.blyx.fs.domain.order.model;


import com.blyx.fs.common.model.BaseMO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/12
 */
@Data
public class OrderMO extends BaseMO implements Serializable {
    private static final long serialVersionUID = -668131878334418738L;

    /**
     * 主键ID
     *
     * */
    private Long id;

    /**
     * 订单编码
     *
     * */
    private String orderCode;
    /**
     * 订单类型
     * 1：防水
     *
     * */
    private Integer type;
    /**
     * 用户姓名
     *
     * */
    private String userName;

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
     * 订单省份名称
     *
     * */
    private String orderProvinceName;
    /**
     * 订单城市名称
     *
     * */
    private String orderCityName;
    /**
     * 订单地区名称
     *
     * */
    private String orderAreaName;
    /**
     * 订单详细地址
     *
     * */
    private String orderAddressDetail;
    /**
     * 订单状态
     *
     * */
    private Integer status;
    /**
     * 工人编码
     *
     * */
    private String workerPin;
    /**
     * 总金额
     *
     * */
    private Integer sumAmount;
    /**
     * 工人分配金额
     *
     * */
    private Integer workerAmount;
    /**
     * 手续费
     *
     * */
    private Integer serviceCharge;
    /**
     * 客户的订单描述
     *
     * */
    private String context;
    /**
     * 工人的订单备注
     *
     * */
    private String workerMark;
    /**
     * 修补区域
     *
     * */
    private String repairRegion;
    /**
     * 开始时间
     *
     * */
    private Date startTime;
    /**
     * 结束时间
     *
     * */
    private Date endTime;
    /**
     * 该订单评分
     *
     * */
    private Integer score;
    /**
     * 用户评价
     *
     * */
    private String userEvaluation;
    /**
     * 订单异常描述
     *
     * */
    private String errorMsg;
    /**
     * 订单异常编码
     *
     * */
    private Integer errorCode;

}
