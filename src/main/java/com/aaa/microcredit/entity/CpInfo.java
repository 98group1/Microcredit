package com.aaa.microcredit.entity;

public class CpInfo {
    //公司id
    private Integer cpId;
    //登录的用户名
    private String userName;
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


    //法人Id
    private Integer lawId;
    //法人代表
    private String lawPerson;
    //法人性别
    private String lawSex;
    //法人年龄
    private Integer lawAge;
    //法人电话
    private String lawTel;
    //法人证件
    private String lawZj;
    //法人住址
    private String houseAddress;
    //法人学历
    private String education;
    //法人身份证正面
    private String lawSfzz;
    //法人身份证反面
    private String lawSfzf;

    private Integer status;

    public Integer getLawId() {
        return lawId;
    }

    public void setLawId(Integer lawId) {
        this.lawId = lawId;
    }

    public String getLawPerson() {
        return lawPerson;
    }

    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson;
    }

    public String getLawSex() {
        return lawSex;
    }

    public void setLawSex(String lawSex) {
        this.lawSex = lawSex;
    }

    public Integer getLawAge() {
        return lawAge;
    }

    public void setLawAge(Integer lawAge) {
        this.lawAge = lawAge;
    }

    public String getLawTel() {
        return lawTel;
    }

    public void setLawTel(String lawTel) {
        this.lawTel = lawTel;
    }

    public String getLawZj() {
        return lawZj;
    }

    public void setLawZj(String lawZj) {
        this.lawZj = lawZj;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLawSfzz() {
        return lawSfzz;
    }

    public void setLawSfzz(String lawSfzz) {
        this.lawSfzz = lawSfzz;
    }

    public String getLawSfzf() {
        return lawSfzf;
    }

    public void setLawSfzf(String lawSfzf) {
        this.lawSfzf = lawSfzf;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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