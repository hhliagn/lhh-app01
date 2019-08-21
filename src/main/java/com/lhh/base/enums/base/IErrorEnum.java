package com.lhh.base.enums.base;

public interface IErrorEnum<T extends Enum<T>> extends ICodeEnum<T,Integer> {
    String getReason();
    Integer getCode();
    String getMessage();
    default T codeOf(){
        return null;
    }
}
