package com.blyx.fs.domain.common.ability;

import com.blyx.fs.domain.common.model.AddressMO;

/**
 * @author quyang5
 * @description 地址对外提供能力点
 * @date 15:53 2021/1/16
 */
public interface AddressAbility {

    /**
     * @desc 获取地址信息
     * @param addressCode
     * @return AddressMO
     *
     * */
    AddressMO findAddressByCode(Integer addressCode);
}
