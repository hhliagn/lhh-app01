package com.lhh.base.enums;

public enum EnumDeleted {

    NORMAL(0,"正常"),
    DELETED(1,"删除");

    private Integer code;
    private String label;

    EnumDeleted(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public EnumSurveyStatus codeOf(Integer code){
        EnumSurveyStatus[] values = EnumSurveyStatus.values();
        for (EnumSurveyStatus value : values) {
            if (value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }
}
