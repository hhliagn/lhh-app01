package com.lhh.base.model;

import com.lhh.base.aware.IOperatorAware;
import com.lhh.base.enums.EnumDeleted;

import java.util.Date;

public abstract class BaseDTO extends BaseSpecFields {

    public void setOperator(Long userId, String operator, String operationId, boolean created){
        Date now = new Date();
        if (created){
            this.setCreateUserId(userId);
            this.setCreateUserName(operator);
            this.setDeleted(EnumDeleted.NORMAL);
            this.setVersion(0);
            this.setCreateTime(now);
            if (this.getDisplayOrder() == null){
                this.setDisplayOrder(0);
            }
        }

        this.setUpdateTime(now);
        this.setUpdateUserId(userId);
        this.setUpdateUserName(operator);
        this.setRid(operationId);
    }

    public void setOperator(IOperatorAware operator, boolean created){
        this.setOperator(operator.getOperatorId(), operator.getOperatorName(), operator.getOperationId(), created);
    }
}
