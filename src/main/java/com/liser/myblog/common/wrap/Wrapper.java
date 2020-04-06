package com.liser.myblog.common.wrap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>Description 返回对象封装类 </p>
 * <p>Company: http://www.uinnova.cn/ </p>
 * @author LiMG
 * @create 2018/3/28 11:02
 */
@ApiModel(value = "返回对象")
public class Wrapper<T> implements Serializable {

    private static final long serialVersionUID = -5286986781881970377L;

    @ApiModelProperty("返回状态码")
    private String code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回对象")
    private T result;

    public Wrapper() {
        this("200", "操作成功");
    }

    public Wrapper(String code, String message) {
        code(code).message(message);
    }

    public Wrapper(String code, String message, T result) {
        code(code).message(message).result(result);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Wrapper<T> code(String code) {
        setCode(code);
        return this;
    }

    public Wrapper<T> message(String message) {
        setMessage(message);
        return this;
    }

    public Wrapper<T> result(T result) {
        setResult(result);
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "200".equals(this.code);
    }

    @JsonIgnore
    public boolean isFail() {
        return !"200".equals(this.code);
    }

    @Override
    public String toString() {
        return "Wrapper{code=" + this.code + ", message='" + this.message + '\'' + ", result=" + this.result + '}';
    }

}
