package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.LoanMapper;
import com.aaa.microcredit.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public int deleteByPrimaryKey(Integer lId) {
        return 0;
    }

    @Override
    public int insert(Loan record) {
        return 0;
    }

    @Override
    public int insertSelective(Loan record) {
        return 0;
    }

    @Override
    public Loan selectByPrimaryKey(Integer lId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Loan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Loan record) {
        return 0;
    }

    @Override
    public List<Map> selectAll(Map map) {
        return loanMapper.selectAll(map);
    }

    @Override
    public List<Map> selectMxAll() {
        return loanMapper.selectMxAll();
    }

    @Override
    public Integer selectAllCount(Map map) {
        return loanMapper.selectAllCount(map);
    }

    /**
     * 拼接还款表和明细表
     * @return
     */
    @Override
    public List<Map> selectMxPjAll(Map map) {
        //先查询出贷款表
        List<Map> listloan = loanMapper.selectAll(map);
        //判断不为空
        if (listloan!=null&&listloan.size()>0){
            //遍历
            for (Map maploan : listloan) {
                //查询出明细表
                List<Map> listmx = loanMapper.selectMxAll();
                //创建新的数组，用与拼接
                List listpj=new ArrayList();
                //判断并遍历
                if (listmx!=null&&listmx.size()>0){
                    for (Map mapmx : listmx) {
                        //当贷款表的id等于明细表中的贷款id时
                        if(mapmx.get("lId").equals(maploan.get("lId"))){
                            //将明细表中的这条数据添加到拼接的数组中
                            listpj.add(mapmx);
                        }
                    }
                }
                //将拼接的数组添加到贷款表中的这条数据中
                maploan.put("tab",listpj);
            }
        }

        return listloan;
    }
}
