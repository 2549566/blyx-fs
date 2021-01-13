package com.blyx.fs.web.interceptor;

import com.blyx.fs.common.enums.SystemExceptionEnum;
import com.blyx.fs.common.exception.BusinessException;
import com.blyx.fs.common.model.BlyxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author quyang5
 * @description
 * @date 15:53 2020/12/14
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public <T> BlyxResult<T> handlerBusinessException(BusinessException e){
        log.error("GlobalException.BusinessException:"+e.getMessage(),e.getCode());
        return BlyxResult.setFailure(e.getCode(),e.getMessage());
    }

    @ExceptionHandler
    public <T> BlyxResult<T> handlerException(Exception e){
        log.error("GlobalException.Exception:"+e);
        return BlyxResult.setFailure(SystemExceptionEnum.SYSTEM_ERROR.getCode(),SystemExceptionEnum.SYSTEM_ERROR.getDesc());
    }


}
