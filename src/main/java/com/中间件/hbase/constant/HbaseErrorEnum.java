package com.中间件.hbase.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  hbase 错误枚举
 */
@Getter
@AllArgsConstructor
public enum HbaseErrorEnum implements IResultEnum {

    /**
     *  服务异常500
     */
    DB_CONNECTION_ERROR(500, "数据库服务异常"),
    DATA_IS_NULL_ERROR(501,"数据不存在");

    private Integer code;

    private String message;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }
}
