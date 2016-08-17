package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/7/26.
 */
public class SchoolCountDto {
    private String cityDivision;

    private String carType;

    private Integer amount;

    private String division;

    private Integer amount2;

    public Integer getAmount2() {
        return amount2;
    }

    public String getDivision() {
        return division;
    }

    public void setAmount2(Integer amount2) {
        this.amount2 = amount2;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCityDivision() {
        return cityDivision;
    }

    public void setCityDivision(String cityDivision) {
        this.cityDivision = cityDivision;
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
