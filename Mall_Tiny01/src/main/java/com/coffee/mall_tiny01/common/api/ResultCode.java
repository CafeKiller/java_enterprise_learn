package com.coffee.mall_tiny01.common.api;

/*
* API响应码
* */
public enum ResultCode implements IErrorCode{
    SUCCESS(20000, "操作成功"),
    FAILED(50000,"操作失败"),
    VALIDATE_FAILED(400001, "参数检验失败"),
    UNAUTHORIZED(40002,"未登录 或 Token已过期"),
    FORBIDDEN(40003,"没有相关权限")
    ;

    private long code;
    private String message;

    private ResultCode(long code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
