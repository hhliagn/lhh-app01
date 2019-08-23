package com.lhh.base.enums.http;

public enum  Enum401Error implements IError401Enum<Enum401Error> {

    SGW_SESSION_USER_NOT_FOUND(401001, "网关session用户未找到");

    Integer code;
    String message;

    Enum401Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
