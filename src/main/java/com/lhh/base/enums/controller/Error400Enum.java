package com.lhh.base.enums.controller;

import com.lhh.base.enums.http.IError400Enum;

public enum Error400Enum implements IError400Enum<Error400Enum> {

    PHONE_NUMBER_ERROR(40001,"手机号错误")
    ;

    Integer code;
    String message;

    Error400Enum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
