package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/7/27.
 */
public class SchoolDto {
    //驾校id
    private Integer id;
    //驾校名称
    private String schoolName;
    //驾校代码
    private String schoolCode;
    //联系地址
    private String address;
    //联系人
    private String contactName;
    //联系电话
    private String contactPhone;
    //可考车型
    private String carType;
    //行政区划
    private String cityDivision;
    //行政区划（县级）
    private String division;
    public String getDivision() {
        return division;
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
