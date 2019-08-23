package com.lhh.pack1.post.base;

public class WebRespModel {

    public static final Integer OK = 1;
    public static final Integer ERROR = -1;

    Integer code;
    String message;
    Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public WebRespModel ok(String message, Object object){
        WebRespModel r = new WebRespModel();
        r.setCode(OK);
        r.setMessage(message);
        r.setData(object);
        return r;
    }

    public WebRespModel error(String message, Object object){
        WebRespModel r = new WebRespModel();
        r.setCode(ERROR);
        r.setMessage(message);
        r.setData(object);
        return r;
    }
}
