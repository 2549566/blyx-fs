package com.blyx.fs.infrastructrue.mapper;

import com.blyx.fs.infrastructrue.entity.AddressEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @description 权限配置类
 * @author: quyang5
 * @date: 2020/9/7 19:33
 */
@Repository
public interface AddressMapper {

    /**
     * 获取配置枚举
     *
     * */
    List<AddressEntity>  selectAddress();
}
