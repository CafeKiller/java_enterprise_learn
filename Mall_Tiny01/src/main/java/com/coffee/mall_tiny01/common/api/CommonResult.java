package com.coffee.mall_tiny01.common.api;

public class CommonResult<T> {

    private long code;
    private String message;
    private T data;

    protected CommonResult(){ }
    protected CommonResult(long code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 响应成功, 并返回结果
     * @param data 获取的数据
     * */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }

}
