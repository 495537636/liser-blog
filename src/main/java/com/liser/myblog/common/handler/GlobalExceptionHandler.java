package com.liser.myblog.common.handler;

import com.liser.myblog.common.exception.BusinessException;
import com.liser.myblog.common.wrap.WrapMapper;
import com.liser.myblog.common.wrap.Wrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.liser.myblog.common.enums.StatusEnum.*;

/**
 * @description: 全局异常处理
 * @author: LiMG
 * @create: 2020-03-26 21:22:00
 **/
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
	 * 处理自定义的业务异常
	 * @param e
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
	public Wrapper bizExceptionHandler(Exception e) {
    	// 业务异常
    	if (e instanceof BusinessException) {
    		return WrapMapper.businessError(e);
		}
		// 参数丢失
		if (e instanceof MissingServletRequestParameterException) {
			return WrapMapper.wrap(PARAM_MISS.getCode(), PARAM_MISS.getMessage(), e.getMessage());
		}
		// 参数转换异常
		if (e instanceof HttpMessageNotReadableException) {
    		return WrapMapper.wrap(PARAM_ERROR.getCode(), PARAM_ERROR.getMessage(), e.getMessage());
		}
		// 请求方式错误异常
		if (e instanceof HttpRequestMethodNotSupportedException) {
    		return WrapMapper.wrap(METHOD_ERROR.getCode(), METHOD_ERROR.getMessage(), e.getMessage());
		}
    	log.error("发生异常！原因是：{}", e.getMessage(), e);
    	return WrapMapper.wrap(ERROR.getCode(), ERROR.getMessage());
    }

}
