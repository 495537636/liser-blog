package com.liser.myblog.common.exception;

/**
 * <p>Description 业务异常信息类 </p>
 * <p>Company: http://www.uinnova.cn </p>
 * @author LiMG
 * @Date 2018/4/2 13:58
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8688369791233850346L;

    private String code;
    private String message;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

