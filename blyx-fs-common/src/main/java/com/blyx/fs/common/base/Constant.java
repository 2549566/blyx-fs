package com.blyx.fs.common.base;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/24
 */
public class Constant {

    //生成手机验证码
    public static String MOBILE_GEN_CODE ="mobile_check_code_";
    //限制手机号的key
    public static String CHECK_MOBILE="check_mobile_";;
    //手机号限制时间
    public static int CHECK_MOBILE_OVER_TIME =60*24;
    //手机号每日限制次数
    public static int CHECK_MOBILE_TIMES_EVERYDAY=10;
    //ip限制时间
    public static int CHECK_IP_OVER_TIME=60*24;
    //ip每日可调用的次数
    public static int CHECK_IP_TIMES=5;
    //手机验证码过期时间
    public static int MOBILE_CHECK_CODE_OVER_TIME=100000;
}
