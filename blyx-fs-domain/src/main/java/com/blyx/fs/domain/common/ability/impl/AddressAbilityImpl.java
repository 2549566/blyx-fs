package com.blyx.fs.domain.common.ability.impl;

import com.alibaba.fastjson.JSON;
import com.blyx.fs.common.base.RedisConstant;
import com.blyx.fs.common.utils.RedisUtil;
import com.blyx.fs.domain.common.ability.AddressAbility;
import com.blyx.fs.domain.common.model.AddressMO;
import com.blyx.fs.domain.common.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/16
 */
@Slf4j
@Service
public class AddressAbilityImpl implements AddressAbility {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AddressRepository addressRepository;


    @Override
    public AddressMO findAddressByCode(Integer addressCode) {

        log.info("AddressAbilityImpl.findAddressByCode:addressCode={}",addressCode);

        if(addressCode==null){
            return null;
        }

        String redisKey= RedisConstant.REDIS_ADDRESS_PREFIX+addressCode;

        String redisValue=redisUtil.get(redisKey);

        if(StringUtils.isNotBlank(redisValue)){
            AddressMO addressMO= JSON.parseObject(redisValue,AddressMO.class);
            return addressMO;
        }

        AddressMO addressMO= addressRepository.getAddressByCode(addressCode);

        redisUtil.set(redisKey,JSON.toJSONString(addressMO));

        return addressMO;
    }
}
