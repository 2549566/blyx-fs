package com.blyx.fs.common.base;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/16
 */
public class RedisConstant {


    /**
     * redis 过期时间
     *
     * */
    public static final Integer REDIS_TIMEOUT=60*24*10;

    /**
     * 地址在Redis中存储的前缀
     *
     * */
    public static final String REDIS_ADDRESS_PREFIX="redis_address_prefix_";
    public static final String REDIS_ADDRESS_SONLIST_PREFIX="redis_address_sonlist_prefix_";

}
