package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.RegisterDao;
import com.aaa.microcredit.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public int addUser(Login login) {
        return dao.addUser(login);
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
    public Map backLogin(String eName) {
        return dao.backLogin(eName);
    }
}
