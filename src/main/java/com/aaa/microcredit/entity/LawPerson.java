package com.aaa.microcredit.entity;

import lombok.Data;

@Data
public class LawPerson {
    private Integer lawId;

    private String username;

    private String lawPerson;

    private String lawSex;

    private Integer lawAge;

    private String lawTel;

    private String lawZj;

    private String houseAddress;

    private String education;

    private String lawSfzz;

    private String lawSfzf;

    private Integer status;

    public Integer getLawId() {
        return lawId;
    }

    public void setLawId(Integer lawId) {
        this.lawId = lawId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLawPerson() {
        return lawPerson;
    }

    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson == null ? null : lawPerson.trim();
    }

    public String getLawSex() {
        return lawSex;
    }

    public void setLawSex(String lawSex) {
        this.lawSex = lawSex == null ? null : lawSex.trim();
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
        this.lawTel = lawTel == null ? null : lawTel.trim();
    }

    public String getLawZj() {
        return lawZj;
    }

    public void setLawZj(String lawZj) {
        this.lawZj = lawZj == null ? null : lawZj.trim();
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getLawSfzz() {
        return lawSfzz;
    }

    public void setLawSfzz(String lawSfzz) {
        this.lawSfzz = lawSfzz == null ? null : lawSfzz.trim();
    }

    public String getLawSfzf() {
        return lawSfzf;
    }

    public void setLawSfzf(String lawSfzf) {
        this.lawSfzf = lawSfzf == null ? null : lawSfzf.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}