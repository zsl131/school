package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/7/25.
 */
public class DivisionDto {
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "code:"+code+",name:"+name;
    }
}
