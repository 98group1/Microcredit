package com.aaa.microcredit.service;

import com.aaa.microcredit.dao.LoanMapper;
import com.aaa.microcredit.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public int deleteByPrimaryKey(Integer lId) {
        return loanMapper.deleteByPrimaryKey(lId) ;
    }

    @Override
    public int insert(Loan record) {
        return loanMapper.insert(record);
    }

    @Override
    public int insertSelective(Loan record) {
        return loanMapper.insertSelective(record);
    }

    @Override
    public Loan selectByPrimaryKey(Integer lId) {
        return loanMapper.selectByPrimaryKey(lId);
    }

    @Override
    public int updateByPrimaryKeySelective(Loan record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Loan record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Map> selectCpAndLoan(Map map) {
        return loanMapper.selectCpAndLoan(map);
    }

    @Override
    public int queryPageCount(Map map) {
        return loanMapper.queryPageCount(map);
    }

    @Override
    public int insertLoan(Map map) {

        return loanMapper.insertLoan(map);
    }

    @Override
    public int updateLoStatus(Map map) {
        return loanMapper.updateLoStatus(map);
    }

    @Override
    public int insertMX(Map map) {
        return loanMapper.insertMX(map);
    }

    @Override
    public Map selectLoan(Integer l_id) {
        return loanMapper.selectLoan(l_id);
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

    /**
     * 根据前台用户id查询贷款信息及其明细
     * @param map
     * @return
     */
    @Override
    public List<Map> selectLoan1(Map map) {
        //先查询出贷款表
        List<Map> listloan = loanMapper.selectLoan1(map);
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

    @Override
    public Integer selectLoanCount(Integer userId) {
        return loanMapper.selectLoanCount(userId);
    }



}
