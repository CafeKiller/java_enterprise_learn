package com.cafe.killer.cafe_mall.common.api;

/**
 * 常用 API 操作码枚举
 * @author Coffee_Killer
 */
public enum ResultCode implements MyErrorCode {
    SUCCESS(2000, "操作成功"),
    FAILED(5000, "操作失败"),
    VALIDATE_FAILED(4004, "参数校验失败"),
    UNAUTHORIZED(4001, "未登录 / TOKEN过期"),
    FORBIDDEN(4003, "没有相关权限");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
