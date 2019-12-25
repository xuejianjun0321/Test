package com.common.exception;

/*
 *    Copyright the original author.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import com.alibaba.csp.ahas.shaded.com.taobao.diamond.utils.StringUtils;
import com.common.enums.BaseResultCodeEnum;
import com.common.enums.EnumBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * 运行时异常基类
 *
 * @author LIU Kunpeng  WeChat:13758206010
 * @version $Id: BaseRuntimeException.java, v 0.1 2017年10月12日 下午8:29:34 LIU Kunpeng Exp $
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class BaseRuntimeException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = -8373310686430610622L;

    /** 异常码 */
    protected String          code             = BaseResultCodeEnum.SYSTEM_ERROR.getCode();

    /** 异常摘要信息 */
    protected String          digestMessage    = BaseResultCodeEnum.SYSTEM_ERROR.message();

    /** 异常具体信息 */
    protected String          message          = BaseResultCodeEnum.SYSTEM_ERROR.message();

    /**
     * 构造器。
     *
     * @param detailMessage
     *            异常信息
     */
    public BaseRuntimeException(String detailMessage) {
        this.message = detailMessage;
    }

    /**
     * 构造器。
     *
     * @param errorCode
     *            异常码
     * @param detailMessage
     *            异常信息
     */
    public BaseRuntimeException(String errorCode, String detailMessage) {
        this.code = errorCode;
        this.message = detailMessage;
    }

    /**
     * 构造器。
     *
     * @param errorCode
     *            异常码
     * @param digestMessage
     *            异常信息
     */
    public BaseRuntimeException(String errorCode, String digestMessage, String detailMessage) {
        this.code = errorCode;
        this.digestMessage = digestMessage;
        this.message = detailMessage;
    }

    /**
     * 构造器。
     *
     * @param baseEnum
     *           异常结果枚举
     */
    public BaseRuntimeException(EnumBase baseEnum) {
        this(baseEnum.name(), baseEnum.message());
    }

    /**
     * 构造器。
     *
     * @param baseEnum
     *           异常结果枚举
     * @param detailMessage
     *           异常信息
     */
    public BaseRuntimeException(EnumBase baseEnum, String detailMessage) {
        this(baseEnum.name(), detailMessage);
    }

    /**
     * 构造器。
     *
     * @param baseEnum
     *           异常结果枚举
     * @param digestMessage
     *           异常信息
     * @param detailMessage
     *           异常具体信息
     */
    public BaseRuntimeException(EnumBase baseEnum, String digestMessage, String detailMessage) {
        this.code = baseEnum.name();
        this.digestMessage = digestMessage;
        this.message = detailMessage;
    }

    /**
     * 构造器。
     *
     * @param cause
     *            原因
     */
    public BaseRuntimeException(Throwable cause) {
        super(cause);

    }

    /**
     * 构造器。
     *
     * @param detailMessage
     *            异常信息
     * @param cause
     *            原因
     */
    public BaseRuntimeException(String detailMessage, Throwable cause) {
        super(cause);
        this.message = detailMessage;
    }

    /**
     * 构造器。
     *
     * @param errorCode
     *            异常码
     * @param detailMessage
     *            异常信息
     * @param cause
     *            原因
     */
    public BaseRuntimeException(String errorCode, String detailMessage, Throwable cause) {
        this(errorCode, null, detailMessage, cause);
    }

    /**
     * 构造器
     *
     * @param errorCode
     *            异常码
     * @param digestMessage
     *            异常信息
     * @param detailMessage
     *            异常具体信息
     * @param cause
     *            原因
     */
    public BaseRuntimeException(String errorCode, String digestMessage, String detailMessage,
                                Throwable cause) {
        super(cause);
        this.digestMessage = digestMessage;
        this.message = detailMessage;
        this.code = errorCode;
    }

    /**
     * 构造函数
     *
     * @param baseEnum
     *          异常结果集枚举
     * @param cause
     *          异常
     */
    public BaseRuntimeException(EnumBase baseEnum, Throwable cause) {
        this(baseEnum.name(), baseEnum.message(), cause);
    }

    /**
     * 构造函数
     *
     * @param baseEnum
     * @param detailMessage
     * @param cause
     */
    public BaseRuntimeException(EnumBase baseEnum, String detailMessage, Throwable cause) {
        this(baseEnum.name(), detailMessage, cause);
    }

    /**
     * 构造函数
     *
     * @param baseEnum
     * @param digestMessage
     * @param detailMessage
     * @param cause
     */
    public BaseRuntimeException(EnumBase baseEnum, String digestMessage, String detailMessage,
                                Throwable cause) {
        this(baseEnum.name(), digestMessage, detailMessage, cause);
    }

    /**
     * @see java.lang.Throwable#toString()
     */
    @Override
    public String toString() {
        StringBuilder exceptionInfo = new StringBuilder(getClass().getName());
        exceptionInfo.append("[").append("code=").append(getCode()).append(",digestMessage=")
                .append(getDigestMessage()).append(",message=").append(getMessage()).append("]");
        return exceptionInfo.toString();
    }

    /**
     * 异常信息参数格式化
     * <br>
     * <a style='color:red;font-weight:800;'>此方法不建议使用，若发现此方法请当即删除。替代功能参照{@link java.text.DateFormat}</a>
     *
     * @param args    message中有需要传入的变量"s%,d%"之类的
     *                eg：message:"this is a example!  %s",args:"ok"
     *                消息
     */
    @Deprecated
    public BaseRuntimeException formatter(Object... args) {
        if (!StringUtils.isEmpty(message)) {
            for (int i = 0; i < args.length; i++) {
                message = String.format(this.message, args);
            }
        }
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getDigestMessage() {
        return digestMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BaseRuntimeException code(String code) {
        this.code = code;
        return this;
    }

    public BaseRuntimeException digestMessage(String digestMessage) {
        this.digestMessage = digestMessage;
        return this;
    }

    public BaseRuntimeException message(String message) {
        this.message = message;
        return this;
    }
}
