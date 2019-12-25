package com.架构设计.模板架构;

import com.中间件.hbase.constant.IResultEnum;

/**
 * Description: 返回码
 * <p></p>
 * @Author: shaoye
 * Date: 2019-08-16 11:51
 */
public enum ContractResultEnum implements IResultEnum {
    /**
     * 返回码
     */
    SUCCESS(0, "成功"),
    SYSTEM_EXCEPTION(70001000, "系统异常"),
    PARAM_ERROR(70001001, "参数有误"),
    PARAM_INCOMPLETE(70001002, "参数不完整"),
    FILE_UPLOAD_FAIL(70001003, "文件上传失败"),
    TEMPLATE_UPLOAD_FAIL(70001004, "模板上传失败"),
    PDF_CONVERT_FAIL(70001005, "PDF 转换失败"),
    FILE_TYPE_ERROR(70001006, "文件类型有误"),
    CONTRACT_NOT_EXISTS(70001007, "合同不存在"),
    CONTRACT_NEED_EDIT(70001008, "合同需要进行重新编辑"),
    SERVICE_ERROR(70001009, "内部服务错误"),
    CONTRACT_HAS_FREEZED(70001010, "合同已被冻结"),
    FILE_NAME_ERROR(70001011, "文件名解析异常"),
    CAN_NOT_UNFREEZE(70001012, "只有冻结中的合同才允许解冻"),
    CONTRACT_UNFREEZE_FAIL(70001013, "合同解冻失败"),
    CONTRACT_TERMINATION_FAIL(70001014, "合同终止失败"),
    CAN_NOT_TERMINATION(70001015, "只有冻结中的合同才允许作废"),
    START_FLOW_FAIL(70001016, "流程发起失败"),
    OPERATION_FAIL(70001017, "操作失败"),
    CUSTOMER_IS_NULL(70001018, "客户获取失败"),
    GID_IS_NULL(70001019, "客户GID不能为空"),
    CONTRACTID_IS_EMPTY(70001020, "合同ID不能为空"),
    CONTEXT_EXCEPTION(70001021, "上下文异常"),
    TEMPLATE_NOT_FIND(70001022, "合同模板不存在"),
    TEMPLATE_TYPE_ERROT(70001023, "合同模板类型错误"),
    RECEIVER_INCOMPLETE(70001024, "收件人信息不完整"),
    SIGN_FILE_NOT_EXSIT(70001024, "签署文件不存在");

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

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ContractResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}