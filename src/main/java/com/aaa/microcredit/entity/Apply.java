package com.aaa.microcredit.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Apply {
    private Integer applyId;

    private Integer userId;

    private Integer loanType;

    private BigDecimal loanMoney;

    private Integer loanDeadline;

    private Integer repaymentType;

    private Integer repaymentId;

    private String bondsmanName;

    private Integer bondsmanAge;

    private String bondsmanSex;

    private String bondsmanTel;

    private String bondsmanZj;

    private String bondsmanSfzz;

    private String bondsmanSfzf;

    private String bondsmanAdd;

    private String income;

    private String describes;

    private Integer loanStatus;

    private Date loanTime;

    private String firstCareful;

    private String twoCareful;

    private String reason;

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public Integer getLoanDeadline() {
        return loanDeadline;
    }

    public void setLoanDeadline(Integer loanDeadline) {
        this.loanDeadline = loanDeadline;
    }

    public Integer getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(Integer repaymentType) {
        this.repaymentType = repaymentType;
    }

    public Integer getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Integer repaymentId) {
        this.repaymentId = repaymentId;
    }

    public String getBondsmanName() {
        return bondsmanName;
    }

    public void setBondsmanName(String bondsmanName) {
        this.bondsmanName = bondsmanName == null ? null : bondsmanName.trim();
    }

    public Integer getBondsmanAge() {
        return bondsmanAge;
    }

    public void setBondsmanAge(Integer bondsmanAge) {
        this.bondsmanAge = bondsmanAge;
    }

    public String getBondsmanSex() {
        return bondsmanSex;
    }

    public void setBondsmanSex(String bondsmanSex) {
        this.bondsmanSex = bondsmanSex == null ? null : bondsmanSex.trim();
    }

    public String getBondsmanTel() {
        return bondsmanTel;
    }

    public void setBondsmanTel(String bondsmanTel) {
        this.bondsmanTel = bondsmanTel == null ? null : bondsmanTel.trim();
    }

    public String getBondsmanZj() {
        return bondsmanZj;
    }

    public void setBondsmanZj(String bondsmanZj) {
        this.bondsmanZj = bondsmanZj == null ? null : bondsmanZj.trim();
    }

    public String getBondsmanSfzz() {
        return bondsmanSfzz;
    }

    public void setBondsmanSfzz(String bondsmanSfzz) {
        this.bondsmanSfzz = bondsmanSfzz == null ? null : bondsmanSfzz.trim();
    }

    public String getBondsmanSfzf() {
        return bondsmanSfzf;
    }

    public void setBondsmanSfzf(String bondsmanSfzf) {
        this.bondsmanSfzf = bondsmanSfzf == null ? null : bondsmanSfzf.trim();
    }

    public String getBondsmanAdd() {
        return bondsmanAdd;
    }

    public void setBondsmanAdd(String bondsmanAdd) {
        this.bondsmanAdd = bondsmanAdd == null ? null : bondsmanAdd.trim();
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income == null ? null : income.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public String getFirstCareful() {
        return firstCareful;
    }

    public void setFirstCareful(String firstCareful) {
        this.firstCareful = firstCareful == null ? null : firstCareful.trim();
    }

    public String getTwoCareful() {
        return twoCareful;
    }

    public void setTwoCareful(String twoCareful) {
        this.twoCareful = twoCareful == null ? null : twoCareful.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}