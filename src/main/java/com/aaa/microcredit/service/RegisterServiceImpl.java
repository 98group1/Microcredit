package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.ClientMoneyMapper;
import com.aaa.microcredit.dao.RegisterDao;
import com.aaa.microcredit.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fileName:RegisterServiceImpl
 * description:
 * author:雷建林
 * ceeateTime:2019/7/27 16:16
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao dao;

    @Autowired
    private ClientMoneyMapper clientMoneyMapper;
    @Override
    @Transactional
    public int addUser(Login login) {
        dao.addUser(login);
        Integer lid=login.getId();
        System.out.println(lid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Map map=new HashMap();
        map.put("userId",lid);
        map.put("moneyType",1);
        map.put("changeMoney",0);
        map.put("changeTime",df.format(date));//当前时间
        map.put("availMoney",0);
        map.put("describes","初始资金");
        System.out.println(map.toString());
        return clientMoneyMapper.insert(map);
    }

    /**
     * 登陆方法：根据名字进行查询密码
     */
    public List<Map> query1(String userName){
        return dao.query1(userName);
    }

    public String queryName(String userName){
        List<Map> map = dao.queryName(userName);
        if (map!=null&&map.size()>0){
            return "true";
        }
        return "false";
    }

    @Override
    public int changePwd(String passWord,Integer id) {

        return dao.changePwd(passWord,id);
    }

    @Override
    public int changePayCode(String paymentCode, Integer id) {
        return dao.changePayCode(paymentCode,id);
    }

    @Override
    public Map backLogin(String eName) {
        return dao.backLogin(eName);
    }
}
