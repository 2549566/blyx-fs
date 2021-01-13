package com.blyx.fs.common.utils;

import com.blyx.fs.common.enums.ParamEnum;
import com.blyx.fs.common.exception.BusinessException;
import org.springframework.util.StringUtils;

public class ParamCheckUtil {

	public static boolean checkMobileNumber(String mobile){
		if(StringUtils.isEmpty(mobile) ||  !mobile.matches( "[0-9]{1,}" )){
			throw new BusinessException(ParamEnum.PARAM_MOBILE_RULE.getCode(),ParamEnum.PARAM_MOBILE_RULE.getDesc());
		}
		return true;
	}

	public static boolean checkCode(String code){
		if(StringUtils.isEmpty(code) ||  !code.matches( "[0-9]{1,}" )){
			throw new BusinessException(ParamEnum.PARAM_CODE_RULE.getCode(),ParamEnum.PARAM_CODE_RULE.getDesc());
		}
		return true;
	}

	public static boolean checkSkuIds(String skuIds){
		if(StringUtils.isEmpty(skuIds) || !skuIds.matches("(\\d+\\,?)+")){
			throw new BusinessException(ParamEnum.PARAM_SKUIDS_ERROR.getCode(),ParamEnum.PARAM_SKUIDS_ERROR.getDesc());
		}
		return true;
	}

	public static boolean checkPageNum(Integer pageNum){
		if(null==pageNum ||pageNum<=0){
			throw new BusinessException(ParamEnum.PARAM_PAGE_ERROR.getCode(),ParamEnum.PARAM_PAGE_ERROR.getDesc());
		}
		return true;
	}

	public static boolean checkIp(String ip){
		String regex= "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		// 判断ip地址是否与正则表达式匹配
		if(StringUtils.isEmpty(ip) || !ip.matches(regex)){
			throw new BusinessException(ParamEnum.PARAM_IP_RULE.getCode(),ParamEnum.PARAM_IP_RULE.getDesc());
		}
		return true;
	}
}