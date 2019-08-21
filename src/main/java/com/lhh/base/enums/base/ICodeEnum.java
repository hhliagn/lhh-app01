package com.lhh.base.enums.base;

public interface ICodeEnum<T extends Enum<T>,C> {
    C getCode();
    T codeOf();
}
