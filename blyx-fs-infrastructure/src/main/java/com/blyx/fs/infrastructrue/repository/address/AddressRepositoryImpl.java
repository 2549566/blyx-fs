package com.blyx.fs.infrastructrue.repository.address;

import com.blyx.fs.domain.common.model.AddressMO;
import com.blyx.fs.domain.common.repository.AddressRepository;
import com.blyx.fs.infrastructrue.entity.AddressEntity;
import com.blyx.fs.infrastructrue.mapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/1/16
 */
@Slf4j
@Service
public class AddressRepositoryImpl implements AddressRepository {


    @Autowired
    private AddressMapper addressMapper;

    @Override
    public AddressMO getAddressByCode(Integer addressCode) {
        AddressEntity addressEntity= addressMapper.selectAddressByCode(addressCode);
        AddressMO addressMO = new AddressMO();
        BeanUtils.copyProperties(addressEntity,addressMO);
        return addressMO;
    }
}
