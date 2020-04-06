package com.liser.myblog.common.util;

import cn.hutool.core.util.StrUtil;
import com.liser.myblog.common.exception.BusinessException;

import static com.liser.myblog.common.enums.StatusEnum.BUSINESS_ERROR;

/**
 * @description: 数据校验工具
 * @author: LiMG
 * @create: 2020-03-26 21:05:18
 **/
public class ValidateUtil {

    /**
     * 校验条件是否为空，如果符合则抛出参数缺失异常
     * @param value
     * @param message
     * @throws BusinessException
     */
    public static void paramRequired(Object value, String message)
            throws BusinessException {
        if (value == null) {
            throw new BusinessException(BUSINESS_ERROR.getCode(), message);
        } else {
            if (value instanceof String
                    && StrUtil.isBlank(String.valueOf(value))) {
                throw new BusinessException(BUSINESS_ERROR.getCode(), message);
            }
        }
    }

    /**
     * 校验条件是否符合，如果符合则抛出参数错误异常
     * @param checked
     * @param message
     * @throws BusinessException
     */
    public static void paramValidate(boolean checked, String message) throws BusinessException {
        if (checked) {
            throw new BusinessException(BUSINESS_ERROR.getCode(), message);
        }
    }

    /**
     * 校验条件是否符合，如果符合则抛出业务异常
     * @param checked
     * @param message
     * @throws BusinessException
     */
    public static void businessValidate(boolean checked, String message) throws BusinessException {
        if (checked) {
            throw new BusinessException(BUSINESS_ERROR.getCode(), message);
        }
    }

}

