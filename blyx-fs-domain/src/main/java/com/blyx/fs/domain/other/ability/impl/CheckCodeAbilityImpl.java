package com.blyx.fs.domain.other.ability.impl;

import com.blyx.fs.common.base.Constant;
import com.blyx.fs.common.enums.ParamEnum;
import com.blyx.fs.common.enums.SystemExceptionEnum;
import com.blyx.fs.common.exception.BizException;
import com.blyx.fs.common.exception.SystemException;
import com.blyx.fs.common.utils.ParamCheckUtil;
import com.blyx.fs.common.utils.RedisUtil;
import com.blyx.fs.domain.other.ability.CheckCodeAbility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/24
 */
@Slf4j
@Service
public class CheckCodeAbilityImpl implements CheckCodeAbility {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Boolean checkCodeOver(String mobile, String code) {

        if(!code.equals(redisUtil.get(Constant.MOBILE_GEN_CODE+mobile))){
            throw new BizException(ParamEnum.PARAM_CODE_OVER.getCode(),ParamEnum.PARAM_CODE_OVER.getDesc());
        }
        return true;
    }

    @Override
    public String genCheckCode(String mobile) {
        checkMobileTimes(mobile);

        Integer code =(int)((Math.random()*9+1)*1000);
        redisUtil.setEx(Constant.MOBILE_GEN_CODE+mobile,code.toString(),Constant.MOBILE_CHECK_CODE_OVER_TIME);

        return String.valueOf(code);
    }


    public boolean checkMobileTimes(String mobile){
        ParamCheckUtil.checkMobileNumber(mobile);
        if(null==redisUtil.get(Constant.CHECK_MOBILE+mobile)){
            redisUtil.setEx(Constant.CHECK_MOBILE+mobile,"",Constant.CHECK_MOBILE_OVER_TIME);
            return true;
        }
        if(Integer.parseInt(redisUtil.get(Constant.CHECK_MOBILE+mobile).toString())<Constant.CHECK_MOBILE_TIMES_EVERYDAY){
            Integer times=Integer.parseInt(redisUtil.get(Constant.CHECK_MOBILE+mobile))+1;
            redisUtil.setEx(Constant.CHECK_MOBILE+mobile,String.valueOf(times),Constant.CHECK_IP_OVER_TIME);
            return true;
        }
        throw new SystemException(SystemExceptionEnum.SYSTEM_MOBILE_SAFE.getCode(),SystemExceptionEnum.SYSTEM_MOBILE_SAFE.getDesc());
    }
}
