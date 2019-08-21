package com.lhh.base.enums.http;

import com.lhh.base.enums.base.IErrorEnum;

public interface IError400Enum<T extends Enum<T>> extends IErrorEnum<T> {
    @Override
    default String getReason(){
        return "[Bad Request] - 请求参数不合法";
    }

    @Override
    default Integer getCode(){
        return 400;
    }
}
