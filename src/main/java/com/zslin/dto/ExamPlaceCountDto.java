package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/7/27.
 */
public class ExamPlaceCountDto {
    private String cityDivision;

    private String type;

    private String carType;

    private Integer amount;

    public String getCityDivision() {
        return cityDivision;
    }

    public void setCityDivision(String cityDivision) {
        this.cityDivision = cityDivision;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
