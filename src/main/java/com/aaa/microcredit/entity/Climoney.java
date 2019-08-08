package com.aaa.microcredit.entity;

import lombok.Data;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * fileName:Climoney
 * description:
 * author:雷建林
 * ceeateTime:2019/8/6 20:36
 */
@Data
public class Climoney {
    private Integer cId;
    private Integer userId;
    private Integer cMoneyType;
    private Integer cChangeMoney;
    private Date cChangeTime;
    private Integer cAvailMoney;
    private String cDescribes;
}
