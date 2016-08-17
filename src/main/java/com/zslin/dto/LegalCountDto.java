package com.zslin.dto;

/**
 * Created by zsl-pc on 2016/8/2.
 */
public class LegalCountDto {
    /** 查询车辆数量 */
    private Integer carAmount = 0;
    /** 违章车辆数量 */
    private Integer legalCarAmount = 0;
    /** 违章车辆号牌 */
    private String legalCars = "";
    /** 违章条数 */
    private Integer legalAmount = 0;
    /** 共计罚金 */
    private Double moneyAmount = 0.0;
    /** 共计扣分 */
    private Integer scoreAmount = 0;
    public Integer getCarAmount() {
        return carAmount;
    }
    public void setCarAmount(Integer carAmount) {
        this.carAmount = carAmount;
    }
    public Integer getLegalCarAmount() {
        return legalCarAmount;
    }
    public void setLegalCarAmount(Integer legalCarAmount) {
        this.legalCarAmount = legalCarAmount;
    }
    public String getLegalCars() {
        return legalCars;
    }
    public void setLegalCars(String legalCars) {
        this.legalCars = legalCars;
    }
    public Integer getLegalAmount() {
        return legalAmount;
    }
    public void setLegalAmount(Integer legalAmount) {
        this.legalAmount = legalAmount;
    }
    public Double getMoneyAmount() {
        return moneyAmount;
    }
    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
    public Integer getScoreAmount() {
        return scoreAmount;
    }
    public void setScoreAmount(Integer scoreAmount) {
        this.scoreAmount = scoreAmount;
    }

    @Override
    public String toString() {
        return "LegalCountDto{" +
                "carAmount=" + carAmount +
                ", legalCarAmount=" + legalCarAmount +
                ", legalCars='" + legalCars + '\'' +
                ", legalAmount=" + legalAmount +
                ", moneyAmount=" + moneyAmount +
                ", scoreAmount=" + scoreAmount +
                '}';
    }
}
