package com.aaa.microcredit.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Apply {
    //贷款id
    private Integer applyId;
    //用户id
    private Integer userId;
    //还款方式
    private Integer repaymentId;
    //还款类型
    private Integer repaymentType;
    //贷款类型
    private Integer loanType;
    //担保人姓名
    private String bondsmanName;
    //担保人年龄
    private int bondsmanAge;
    //担保人性别
    private String bondsmanSex;
    //担保人电话
    private String bondsmanTel;
    //担保人身份证号
    private String bondsmanZj;
    //担保人身份证正面照片url
    private String bondsmanSfzz;
    //担保人身份证反面照片url
    private String bondsmanSfzf;
    //担保人家庭住址
    private String bondsmanAdd;
    //担保人年收入（单位：万元）
    private String income;
    //贷款状态   1未审核2审核中（一审通过二审还没开始期间）
    // 3审核通过（一审、二审都通过） 4审核不通过，即驳回（一审二审其中一个不通过就不通过）
    // 5贷款金额已到账6 待还款 7 已还款 8还款结束 9逾期
    private Integer loanStatus;
    //贷款金额
    private Double loanMoney;
    //贷款期限
    private String loanDeadline;
    //贷款时间
    private Date loanTime;
    //一审人
    private String firstCareful;
   //一身时间
    private Date firstTime;
    //二审人
    private String twoCareful;

    //二审时间
    private Date twoTime;
    //驳回理由
    private String reason;
    //借款描述
    private String describes;

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

    public Integer getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Integer repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }



    public String getBondsmanName() {
        return bondsmanName;
    }

    public void setBondsmanName(String bondsmanName) {
        this.bondsmanName = bondsmanName;
    }

    public int getBondsmanAge() {
        return bondsmanAge;
    }

    public void setBondsmanAge(int bondsmanAge) {
        this.bondsmanAge = bondsmanAge;
    }

    public String getBondsmanSex() {
        return bondsmanSex;
    }

    public void setBondsmanSex(String bondsmanSex) {
        this.bondsmanSex = bondsmanSex;
    }

    public String getBondsmanTel() {
        return bondsmanTel;
    }

    public void setBondsmanTel(String bondsmanTel) {
        this.bondsmanTel = bondsmanTel;
    }

    public String getBondsmanZj() {
        return bondsmanZj;
    }

    public void setBondsmanZj(String bondsmanZj) {
        this.bondsmanZj = bondsmanZj;
    }

    public String getBondsmanSfzz() {
        return bondsmanSfzz;
    }

    public void setBondsmanSfzz(String bondsmanSfzz) {
        this.bondsmanSfzz = bondsmanSfzz;
    }

    public String getBondsmanSfzf() {
        return bondsmanSfzf;
    }

    public void setBondsmanSfzf(String bondsmanSfzf) {
        this.bondsmanSfzf = bondsmanSfzf;
    }

    public String getBondsmanAdd() {
        return bondsmanAdd;
    }

    public void setBondsmanAdd(String bondsmanAdd) {
        this.bondsmanAdd = bondsmanAdd;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getLoanDeadline() {
        return loanDeadline;
    }

    public void setLoanDeadline(String loanDeadline) {
        this.loanDeadline = loanDeadline;
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
        this.firstCareful = firstCareful;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public String getTwoCareful() {
        return twoCareful;
    }

    public void setTwoCareful(String twoCareful) {
        this.twoCareful = twoCareful;
    }

    public Date getTwoTime() {
        return twoTime;
    }

    public void setTwoTime(Date twoTime) {
        this.twoTime = twoTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyId=" + applyId +
                ", userId=" + userId +
                ", repaymentId=" + repaymentId +
                ", repaymentType=" + repaymentType +
                ", loanType=" + loanType +
                ", bondsmanName='" + bondsmanName + '\'' +
                ", bondsmanAge=" + bondsmanAge +
                ", bondsmanSex='" + bondsmanSex + '\'' +
                ", bondsmanTel='" + bondsmanTel + '\'' +
                ", bondsmanZj='" + bondsmanZj + '\'' +
                ", bondsmanSfzz='" + bondsmanSfzz + '\'' +
                ", bondsmanSfzf='" + bondsmanSfzf + '\'' +
                ", bondsmanAdd='" + bondsmanAdd + '\'' +
                ", income='" + income + '\'' +
                ", loanStatus=" + loanStatus +
                ", loanMoney=" + loanMoney +
                ", loanDeadline='" + loanDeadline + '\'' +
                ", loanTime=" + loanTime +
                ", firstCareful='" + firstCareful + '\'' +
                ", twoCareful='" + twoCareful + '\'' +
                ", reason='" + reason + '\'' +
                ", describes='" + describes + '\'' +
                '}';
    }
}