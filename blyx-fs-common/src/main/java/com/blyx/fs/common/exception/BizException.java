package com.blyx.fs.common.exception;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {
    private Integer code;
    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }
    public BizException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
