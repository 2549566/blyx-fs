package com.blyx.fs.web.controller.address;

import com.blyx.fs.common.enums.AddressLevelEnum;
import com.blyx.fs.common.enums.BizCodeEnum;
import com.blyx.fs.common.exception.BizException;
import com.blyx.fs.common.model.ResultModel;
import com.blyx.fs.domain.address.ability.AddressAbility;
import com.blyx.fs.domain.address.model.AddressDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/23
 */
@Slf4j
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    @Autowired
    private AddressAbility addressAbility;

    /**
     * @desc 根据地址ID、级别，获取子地址列表
     * @param addressCode 地址ID
     * @return
     * */
    @PostMapping("/queryAddressList")
    public ResultModel<List<AddressDTO>> queryAddressList(Integer addressCode){

        if(addressCode==null){
            throw new BizException(BizCodeEnum.ADDRESS_REST_QUERYADDRESSLIST_PARAM_EMPTY.getCode(),BizCodeEnum.ADDRESS_REST_QUERYADDRESSLIST_PARAM_EMPTY.getMsg());
        }

        log.info("AddressController.queryAddressList:addressCode={}",addressCode);


        List<AddressDTO> addressDTOList=addressAbility.queryAddressList(addressCode);

        return ResultModel.setSuccessData(addressDTOList);
    }
}
