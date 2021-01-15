package com.blyx.fs.common.utils;

import com.blyx.fs.common.enums.AddressCodeEnum;
import org.apache.commons.lang3.StringUtils;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author quyang5
 * @description
 * @date 13:56 2020/9/29
 */
public class GenOrderUtil {

    public static AtomicLong nextId=new AtomicLong(0);
    private static Long maxIncreId = 10000L;


    public static String genOrderCode(Integer orderProvinceCode,String bizType){


        String prefix= AddressCodeEnum.getCodeById(orderProvinceCode);

        if(StringUtils.isBlank(prefix)){
            prefix="SYSTEM";
        }

        prefix+=bizType;
        getNextId();
        String nextIdStr=String.format("%05d",nextId.longValue());
        String dateStr=DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");
        String random=String.format("%04d",new Random().nextInt(9999));
        return prefix+dateStr+random+nextIdStr;
    }

    public static void getNextId(){
        nextId.compareAndSet(maxIncreId,0L);
        nextId.incrementAndGet();
    }


    public static void main(String[] args) {
        System.out.println(genOrderCode(1,"001"));
    }
}
