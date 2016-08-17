package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/7/27.
 */
public class ResultNormalDto {
    private String name;
    private Integer value;

    public ResultNormalDto(String name, Integer value) {
        this.name = name; this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
