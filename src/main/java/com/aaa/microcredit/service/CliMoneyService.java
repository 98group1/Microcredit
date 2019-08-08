package com.aaa.microcredit.service;

import com.aaa.microcredit.entity.Climoney;

import java.util.List;
import java.util.Map;

/**
 * fileName:CliMoneyService
 * description:
 * author:雷建林
 * ceeateTime:2019/8/6 20:44
 */
public interface CliMoneyService {
    List<Map> query(Map map);

    int queryPageCount(Map map);
}
