package com.blyx.fs.domain.address.repository;

import com.blyx.fs.domain.address.model.AddressDTO;
import com.blyx.fs.domain.common.model.AddressMO;

import java.util.List;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/16
 */
public interface AddressRepository {

    /**
     * @desc 根据地址编码，获取地址信息
     * @return AddressMO
     *
     * */
    AddressMO getAddressByCode(Integer addressCode);

    List<AddressDTO> querySonAddressList(Integer addressCode);
}
