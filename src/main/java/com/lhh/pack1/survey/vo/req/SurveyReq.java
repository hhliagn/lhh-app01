package com.lhh.pack1.survey.vo.req;

import com.lhh.base.enums.EnumSurveyStatus;
import com.lhh.base.utils.BeanUtils;
import com.lhh.pack1.survey.dao.dto.SurveyDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SurveyReq implements Serializable {

    private Long surveyId;
    private String title;
    private boolean isUsed;
    private Integer submitLimit;
    private EnumSurveyStatus status;
    private String remark;
    private static final long serialVersionUID = 1L;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Integer getSubmitLimit() {
        return submitLimit;
    }

    public void setSubmitLimit(Integer submitLimit) {
        this.submitLimit = submitLimit;
    }

    public EnumSurveyStatus getStatus() {
        return status;
    }

    public void setStatus(EnumSurveyStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static SurveyDTO convertTo(SurveyReq req) {
        return req.convertTo();
    }

    public static List<SurveyDTO> convertTo(List<SurveyReq> reqs){
        List<SurveyDTO> result = new ArrayList<>();
        for (SurveyReq req : reqs) {
            result.add(req.convertTo());
        }
        return result;
    }

    public SurveyDTO convertTo(){
        return BeanUtils.copyProperties(this,SurveyDTO.class);
    }
}
