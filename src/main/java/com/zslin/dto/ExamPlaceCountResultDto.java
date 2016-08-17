package com.zslin.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zsl-pc on 2016/7/27.
 */
public class ExamPlaceCountResultDto {
    private List<String> cates;
    private List<ResultNormalDto> datas;

    public ExamPlaceCountResultDto() {
        this.cates = new ArrayList<String>();
        this.datas = new ArrayList<ResultNormalDto>();
    }

    public List<String> getCates() {
        return cates;
    }

    public void setCates(List<String> cates) {
        this.cates = cates;
    }

    public List<ResultNormalDto> getDatas() {
        return datas;
    }

    public void setDatas(List<ResultNormalDto> datas) {
        this.datas = datas;
    }
}
