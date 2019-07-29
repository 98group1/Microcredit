package com.aaa.microcredit.entity;

public class CpInfo {
    //公司id
    private Integer cpId;
    //登录的用户名
    private String username;
    //公司名称
    private String cpName;
    //公司机构代码号
    private String cpCode;
    //公司地址
    private String cpAddress;
    //公司营业执照图片原始名称
    private String licenseName;
    //公司营业执照图片地址
    private String licenseUrl;
    //公司电话
    private String cpTel;
    //公司账户1
    private String cpAccount1;
    //公司账户2
    private String cpAccount2;
    //公司邮箱
    private String cpEmail;

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName == null ? null : cpName.trim();
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode == null ? null : cpCode.trim();
    }

    public String getCpAddress() {
        return cpAddress;
    }

    public void setCpAddress(String cpAddress) {
        this.cpAddress = cpAddress == null ? null : cpAddress.trim();
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName == null ? null : licenseName.trim();
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl == null ? null : licenseUrl.trim();
    }

    public String getCpTel() {
        return cpTel;
    }

    public void setCpTel(String cpTel) {
        this.cpTel = cpTel == null ? null : cpTel.trim();
    }

    public String getCpAccount1() {
        return cpAccount1;
    }

    public void setCpAccount1(String cpAccount1) {
        this.cpAccount1 = cpAccount1 == null ? null : cpAccount1.trim();
    }

    public String getCpAccount2() {
        return cpAccount2;
    }

    public void setCpAccount2(String cpAccount2) {
        this.cpAccount2 = cpAccount2 == null ? null : cpAccount2.trim();
    }

    public String getCpEmail() {
        return cpEmail;
    }

    public void setCpEmail(String cpEmail) {
        this.cpEmail = cpEmail == null ? null : cpEmail.trim();
    }
}