package com.lhh.pack1.post.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lhh.base.utils.CommUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

public class PageEntity implements Serializable {

    @JsonIgnore
    private Integer offset;
    @JsonIgnore
    private Integer limit;
    private Integer count;
    private List list;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        if (!CommUtils.isNull(offset)){
            offset = offset * this.limit;
        }
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
