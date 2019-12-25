package com.common.exception;

import com.common.enums.BaseResultCodeEnum;

/**
 *
 *
 * @author LIU Kunpeng  WeChat:13758206010
 * @version $Id: IllegalArgumentException.java, v 0.1 2018年5月25日 下午3:05:45 LIU Kunpeng Exp $
 */
public class BaseIllegalArgumentException extends BaseRuntimeException{

    /** serialVersionUID */
    private static final long serialVersionUID = 3688633731480353586L;

    public BaseIllegalArgumentException(String message) {
        super(BaseResultCodeEnum.ILLEGAL_ARGUMENT, message);
    }

    public BaseIllegalArgumentException(String message, Throwable cause) {
        super(BaseResultCodeEnum.ILLEGAL_ARGUMENT, message, cause);
    }
}