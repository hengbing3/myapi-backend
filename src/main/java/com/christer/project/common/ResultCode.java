package com.christer.project.common;

/**
 * @author Christer
 * @version 1.0
 * @date 2023-09-04 21:27
 * Description:
 */
public enum ResultCode {
    /**
     * api状态码
     */
    SUCCESS(200, "ok"),
    FAILED(9999, "操作失败"),
    TOKEN_FAILED(401, "token失效"),
    FILE_UPLOAD_ERROR(40001,"文件上传失败！"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    NONE(99999, "无"),
    INTERFACE_ADD_ERROR(1000, "接口信息新增失败！"),
    INTERFACE_EDIT_ERROR(1001, "接口信息编辑失败！"),
    PARAMS_VALIDATE_ERROR(40001, "参数校验失败！"),
    PARAMS_ERROR(40000, "请求参数错误！"),
    ALIPAY_CONFIG_ERROR(60000, "支付宝支付配置创建失败！"),
    ;

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private ResultCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }
}

