package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/8/2.
 */
public class TestRecordDto {
    private Integer schoolId;

    private String schoolName;

    private String steps;

    /** 是否通过，1通过，0不及格 */
    private Integer flag;

    /** 市级行政区划 */
    private String cityDivision;

    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getCityDivision() {
        return cityDivision;
    }

    public void setCityDivision(String cityDivision) {
        this.cityDivision = cityDivision;
    }

    @Override
    public String toString() {
        return "TestRecordDto{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", steps='" + steps + '\'' +
                ", flag=" + flag +
                ", cityDivision='" + cityDivision + '\'' +
                ", amount=" + amount +
                '}';
    }
}
