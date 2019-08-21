package com.lhh.base.aware;

public abstract class AbstractOperator implements IOperatorAware{

    private Long operatorId;
    private String OperatorName;
    private String OperationId;

    @Override
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    @Override
    public String getOperationId() {
        return OperationId;
    }

    public void setOperationId(String operationId) {
        OperationId = operationId;
    }
}
