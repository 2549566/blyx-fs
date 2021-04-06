package com.blyx.fs.context.activity.other;

/**
 * @author quyang5
 * @description
 * @date 15:53 2021/2/24
 */
public interface CheckCodeActivity {

    /**
     * @desc 校验二维码是否过期
     * @param mobile 手机号
     * @param code 二维码
     * @return Boolean
     *
     * */
    Boolean checkCodeOver(String mobile, String code);

    /**
     * @desc 生成二维码
     * @param mobile 手机号
     * @return String
     *
     * */
    String genCheckCode(String mobile);
}
