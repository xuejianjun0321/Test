package com.中间件.hbase.exceptions;

import com.中间件.hbase.constant.IResultEnum;

/**
 * hbase 操作异常类
 */
public class HbaseException extends RestServiceException {

    public HbaseException(String message) {
        super(message);
    }

    public HbaseException(IResultEnum iResultEnum, Throwable cause) {
        super(iResultEnum,cause);
    }

    public HbaseException(IResultEnum iResultEnum){
        super(iResultEnum);
    }

}
