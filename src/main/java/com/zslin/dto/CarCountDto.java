package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/8/2.
 */
public class CarCountDto {

    /** 驾校Id */
    private Integer schoolId;

    /** 驾校名称 */
    private String schoolName;

    /** 驾校代码 */
    private String schoolCode;

    /** 车型 */
    private String carType;

    /** 数量 */
    private Integer amount;

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

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
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

    @Override
    public String toString() {
        return "CarCountDto{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", schoolCode='" + schoolCode + '\'' +
                ", carType='" + carType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
