package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.CliMoneyMapper;
import com.aaa.microcredit.entity.Climoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:CliMoneyServiceImpl
 * description:
 * author:雷建林
 * ceeateTime:2019/8/6 20:45
 */
@Service
public class CliMoneyServiceImpl implements CliMoneyService {
    @Autowired
    private CliMoneyMapper moneyMapper;
    @Override
    public List<Map> query(Map map) {
        List<Map> maps = moneyMapper.query(map);
        return maps;
    }

    @Override
    public int queryPageCount(Map map) {
        return moneyMapper.queryPageCount(map);
    }
}
