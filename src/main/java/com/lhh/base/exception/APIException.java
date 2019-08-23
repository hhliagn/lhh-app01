package com.lhh.base.exception;

import com.lhh.base.enums.base.IErrorEnum;

public class APIException extends FrameworkException {
    public APIException(IErrorEnum errorEnum) {
        super(errorEnum);
    }

    public String toString() {
        return "APIException{errorEnum=" + super.errorEnum + '}';
    }
}
