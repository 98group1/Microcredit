package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.ClientMoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 孟浩阳
 * @Date: 2019/8/6 19:44
 */
@Service

public class ClientMoneyServiceImpl implements ClientMoneyService {
    @Autowired
    private ClientMoneyMapper clientMoneyMapper;

    /**
     * 通过用户id查询流水表中用户的最新记录,并将新的数据录入
     * @param map
     * @param UserId
     * @return
     */

    @Override
    @Transactional
    public Integer selectUserId( Map map,Integer UserId) {
        Map map1=clientMoneyMapper.selectUserId(UserId);
        BigDecimal availMoney = (BigDecimal) map1.get("availMoney");
        Integer loanMoney= (Integer) map.get("Loan_money");
        BigDecimal lM=new BigDecimal(loanMoney.toString());
        System.out.println(availMoney.add(lM));
        Map mapinsert=new HashMap();
        mapinsert.put("userId",map.get("user_id"));
        mapinsert.put("moneyType",2);//资金变动类型   2代表放款
        mapinsert.put("changeMoney",map.get("Loan_money")); //变动金额  相当于客户的贷款金额
        mapinsert.put("changeTime",map.get("loan_time"));
        mapinsert.put("availMoney",availMoney.add(lM));
        mapinsert.put("describes","放款");
        System.out.println(mapinsert.toString()+"0000000000");
        Integer insert = clientMoneyMapper.insert(mapinsert);
        if(insert>0){
            //查询平台表中最新的数据
            Map map2 = clientMoneyMapper.selectPingtai();
            BigDecimal availMoneyPingtai = (BigDecimal) map2.get("availMoney");//得到平台流水表中可用余额
            int r=availMoneyPingtai.compareTo(BigDecimal.ZERO); //和0，ZERO比较
                if(r>0) { //大于
            Map mappingtai=new HashMap();
            mappingtai.put("loanId",map.get("l_id"));
            mappingtai.put("moneyType",2);//资金变动类型   2代表放款
            mappingtai.put("changeMoney",map.get("Loan_money")); //变动金额  相当于客户的贷款金额
            mappingtai.put("changeTime",map.get("loan_time"));
            mappingtai.put("describes","放款");
            mappingtai.put("availMoney",availMoneyPingtai. subtract(lM));
            System.out.println(mappingtai.toString()+"NNNNNNNNNNNNNNNNNNNNNNNNN");
            clientMoneyMapper.insertPingtai(mappingtai);
            Map newMap=new HashMap();
            newMap.put("user_id",map.get("user_id"));
            newMap.put("n_type",mappingtai.get("moneyType"));
            newMap.put("n_content",mappingtai.get("describes"));
            newMap.put("n_status",1);
            newMap.put("n_time",mappingtai.get("changeTime"));
            Integer resultNew=clientMoneyMapper.insertNews(newMap);
            if(resultNew>0){
                return 1;
            }
        }
        }

        return 0;
    }



    @Override
    public Integer insertNews(Map map) {
        return clientMoneyMapper.insertNews(map);
    }






    @Override
    public Map selectApply() {
        return clientMoneyMapper.selectApply();
    }
}
