package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.ZhDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ZhServiceImpl implements ZhService {
    @Autowired
    private ZhDao zhDao;
    /**
     * 查询出某客户最新的可用余额
     * @return
     */
    @Override
    public Map selectAvailMoney(Integer userId) {
        return zhDao.selectAvailMoney(userId);
    }
    /**
     * 查询该用户的贷款的信息，将对应的值显示在账户上
     * @param userId //参数
     * @return
     */
    @Override
    public List<Map> selectLoan(Integer userId) {
        return zhDao.selectLoan(userId);
    }
}
