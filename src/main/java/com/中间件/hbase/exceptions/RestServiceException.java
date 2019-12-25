package com.中间件.hbase.exceptions;


import com.中间件.hbase.constant.CommonResultEnum;
import com.中间件.hbase.constant.IResultEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ description:
 * @ date: 2018/7/12 19:47
 * @ modified:
 **/
@Getter
@Setter
public class RestServiceException extends RuntimeException {

    private static final long serialVersionUID = -8373310686430610622L;
    protected int code;
    protected String message;

    public RestServiceException(String message) {
        super(message);
        this.code = CommonResultEnum.SERVER_TEMPLATE_ERR.getCode();
        this.message = CommonResultEnum.SERVER_TEMPLATE_ERR.getMsg();
        this.message = message;
    }

    public RestServiceException(int errorCode, String message) {
        super(message);
        this.message = CommonResultEnum.SERVER_TEMPLATE_ERR.getMsg();
        this.code = errorCode;
        this.message = message;
    }

    public RestServiceException(IResultEnum iResultEnum) {
        this(iResultEnum.getCode(), iResultEnum.getMsg());
    }

    public RestServiceException(IResultEnum iResultEnum, String message) {
        this(iResultEnum.getCode(), message);
    }

    public RestServiceException(Throwable cause) {
        super(cause);
        this.code = CommonResultEnum.SERVER_TEMPLATE_ERR.getCode();
        this.message = CommonResultEnum.SERVER_TEMPLATE_ERR.getMsg();
    }

    public RestServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code = CommonResultEnum.SERVER_TEMPLATE_ERR.getCode();
        this.message = CommonResultEnum.SERVER_TEMPLATE_ERR.getMsg();
        this.message = message;
    }

    public RestServiceException(int errorCode, String message, Throwable cause) {
        this(message, cause);
        this.code = errorCode;
        this.message = message;
    }

    public RestServiceException(IResultEnum iResultEnum, Throwable cause) {
        this(iResultEnum.getCode(), iResultEnum.getMsg(), cause);
    }

    public RestServiceException(IResultEnum iResultEnum, String message, Throwable cause) {
        this(iResultEnum.getCode(), message, cause);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public RestServiceException formatter(Object... args) {
        if (!StringUtils.isEmpty(this.message)) {
            for(int i = 0; i < args.length; ++i) {
                this.message = String.format(this.message, args);
            }
        }

        return this;
    }

    public static long getSerialversionuid() {
        return -8373310686430610622L;
    }

    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
