package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/7/29.
 */
public class StudentCountDto {

    /** 数量 */
    private Integer amount;

    /** 类型，如：男、女、挂科、通过、未考 */
    private String type;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
