package com.lhh.base.enums;

public enum EnumSurveyStatus {

    EFFCITIVE("EFFCITIVE","生效中"),
    TO_BE_EFFCITIVE("TO_BE_EFFCITIVE","待生效"),
    TERMINATED("TERMINATED","终止");

    private String code;
    private String label;

    EnumSurveyStatus(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public EnumSurveyStatus codeOf(String s) {
        return codeOf(s);
    }
}
