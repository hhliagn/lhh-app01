package com.lhh.base.enums.http;

import com.lhh.base.enums.base.IErrorEnum;

public interface IError401Enum<T extends Enum<T>> extends IErrorEnum<T> {
    @Override
    default String getReason(){
        return "401错误";
    }

    @Override
    default Integer getCode(){
        return 401;
    }
}
