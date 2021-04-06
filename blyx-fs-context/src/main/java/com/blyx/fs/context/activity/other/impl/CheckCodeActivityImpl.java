package com.blyx.fs.context.activity.other.impl;

import com.blyx.fs.context.activity.other.CheckCodeActivity;
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
public class CheckCodeActivityImpl implements CheckCodeActivity {



    @Autowired
    private CheckCodeAbility checkCodeAbility;

    @Override
    public Boolean checkCodeOver(String mobile, String code) {
        return checkCodeAbility.checkCodeOver(mobile,code);
    }

    @Override
    public String genCheckCode(String mobile) {
        return checkCodeAbility.genCheckCode(mobile);
    }
}
