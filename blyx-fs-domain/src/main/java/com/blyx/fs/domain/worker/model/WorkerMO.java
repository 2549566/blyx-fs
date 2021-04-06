package com.blyx.fs.domain.worker.model;

import com.blyx.fs.common.model.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/4/6
 */
@Data
public class WorkerMO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -370238068549552024L;

    /**
     * 主键
     *
     * */
    private Long id;
    /**
     * 用户pin
     *
     * */
    private String pin;
    /**
     * 工人类型
     * 0:普通防水工人 10：系统管理员
     * */
    private Integer type;
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
     * 信用等级
     *
     * */
    private Integer creditLevel;
    /**
     * 用户评分
     *
     * */
    private Integer score;
    /**
     * 用户名
     *
     * */
    private String userName;
    /**
     * 身份证姓名
     *
     * */
    private String realName;
    /**
     * 推进人pin
     *
     * */
    private String referencesPin;
    /**
     * 头像路径
     *
     * */
    private String imageHeader;
    /**
     * 登陆密码
     *
     * */
    private String password;
    /**
     * 省份编码
     *
     * */
    private Integer addressProvinceCode;
    /**
     * 市区编码
     *
     * */
    private Integer addressCityCode;
    /**
     * 地区编码
     *
     * */
    private Integer addressAreaCode;

    private String addressProvinceName;

    private String addressCityName;

    private String addressAreaName;
    /**
     * 详细地址
     *
     * */
    private String addressDetail;
    /**
     * 详细地址
     *
     * */
    private String locateInfo;
    /**
     * 是否已认证：0：未认证，1：已认证
     *
     * */
    private Boolean isAuth;
    /**
     * 是否接受订单：1:接单，0：不接单
     *
     * */
    private Boolean isAcceptOrder;
}
