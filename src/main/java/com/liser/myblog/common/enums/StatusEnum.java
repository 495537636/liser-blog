package com.liser.myblog.common.enums;

/**
 * @description: 系统状态枚举类
 * @author: LiMG
 * @create: 2020-03-26 21:22:00
 **/
public enum StatusEnum {

    SUCCESS("200", "操作成功"),
    ERROR("500", "操作失败"),
    BUSINESS_ERROR("800", "业务异常"),
    NO_PERMISSION("1000", "没有权限"),
    NO_LOGIN("10000", "用户未登录"),
    PARAM_ERROR("701", "参数错误"),
    METHOD_ERROR("702", "请求类型错误"),
    PARAM_MISS("703", "参数缺失");

    StatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
