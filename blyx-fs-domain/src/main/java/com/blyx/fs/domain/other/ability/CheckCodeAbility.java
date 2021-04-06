package com.blyx.fs.domain.other.ability;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/24
 */
public interface CheckCodeAbility {

    /**
     * @desc 校验二维码是否过期
     * @param mobile 手机号
     * @param code 二维码
     * @return Boolean
     *
     * */
    Boolean checkCodeOver(String mobile, String code);

    String genCheckCode(String mobile);
}
