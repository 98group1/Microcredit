package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.HkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
@Service

public class HkSeriviceImpl implements HkService {
    @Autowired
    private HkDao hkDao;
    @Override
    @Transactional
    public Integer hkcz(Map map) {
        //修改明细表里的贷款状态
        Integer result1 = hkDao.updateLoanmx(map);
        System.out.println(map.get("c_changetime"));
        Integer zPeriobs = (Integer) map.get("zPeriobs");
        Integer bePeriods = (Integer) map.get("bePeriods");
        Integer loanId = (Integer) map.get("loanId");
        Integer applyId = (Integer) map.get("ApplyId");
        //向流水表里添加还款的记录
        Integer result3 = hkDao.insertMoney(map);
        Integer result4 = hkDao.updateLoanHK(map);
        Integer result5 = hkDao.insertPTMoney(map);
        if(result1==1&&bePeriods.equals(zPeriobs)){
            //修改贷款表里的贷款状态
            Integer result2 = hkDao.updateLoan(loanId);
            //修改申请表里的贷款状态
            Integer result6 = hkDao.updateApply(applyId);
            Integer result=result1+result2+result6;
            System.out.println(result);
            return result;
        }
        return result1+result3+result4+result5;
    }

    /**
     * 查询出某用户最新的可用余额
     * @return
     */
    @Override
    public Map selectAvailMoney(Integer userId) {
        Map map = hkDao.selectAvailMoney(userId);
        return map;
    }

    /**
     * 向流水表里录入数据
     * @param map
     * @return
     */
    @Override
    public Integer insertMoney(Map map) {
        return hkDao.insertMoney(map);
    }

    @Override
    public Map selectPTAvailMoney() {
        return hkDao.selectPTAvailMoney();
    }
}
