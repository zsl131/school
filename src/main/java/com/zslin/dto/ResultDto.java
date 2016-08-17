package com.zslin.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsl-pc on 2016/7/26.
 */
public class ResultDto {
    private List<String> cates;
    private List<Integer> values;

    public ResultDto() {
        this.cates = new ArrayList<String>();
        this.values = new ArrayList<Integer>();
    }

    public List<Integer> getValues() {
        return values;
    }

    public List<String> getCates() {
        return cates;
    }

    public void setCates(List<String> cates) {
        this.cates = cates;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
