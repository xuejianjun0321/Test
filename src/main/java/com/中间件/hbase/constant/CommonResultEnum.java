package com.中间件.hbase.constant;


import java.util.Formatter;

/**
 * 通用枚举类，只放公共部分
 *
 * @date: 2018/12/27 5:06 PM
 */
public enum CommonResultEnum implements IResultEnum {
    SUCCESS(0, "成功"),
    PARTIAL_FAILURE(1, "部分失败"),
    UNAUTH(401, "登录超时"),
    PARAM_WRONG(100000, "参数错误"),
    SERVER_TEMPLATE_ERR(100010, "内部服务错误"),
    RPC_INVOKE_ERR(100011, "内部服务错误");

    private int code;

    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public String format(String... content) {

        Formatter e = null;

        try {
            e = new Formatter();
            return e.format(this.msg, content).toString();
        } finally {
            if (null != e) {
                e.close();
            }
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    CommonResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
