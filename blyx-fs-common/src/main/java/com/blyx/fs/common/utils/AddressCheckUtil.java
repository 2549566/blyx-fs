package com.blyx.fs.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quyang5
 * @description 服务地域校验，只校验省份
 * @date 15:53 2021/1/15
 */
public class AddressCheckUtil {

    /**
     * 服务区域列表
     *
     * */
    public static final List<Integer> serverRegionList=new ArrayList<>();

    static{
        //2:北京
        serverRegionList.add(2);
    }


    /**
     * @desc 校验服务区域
     * @param orderProvinceCode 订单省份
     *
     * @return boolean 是否成功
     *
     * */
    public static boolean checkServerRegion(Integer orderProvinceCode){
        if(serverRegionList.contains(orderProvinceCode)){
            return true;
        }
        return false;
    }
}
