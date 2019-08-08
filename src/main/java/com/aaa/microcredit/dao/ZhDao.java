package com.aaa.microcredit.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ZhDao {
    /**
     * 查询出某客户最新的可用余额
     * @return
     */
    @Select("SELECT * from client_money where c_id=(select Max(c_id) from client_money " +
            "where user_id=#{userId})")
    Map selectAvailMoney(Integer userId);

    /**
     * 查询该用户的贷款的信息，将对应的值显示在账户上
     * @param userId //参数
     * @return
     */
    @Select("select l_id , l.loan_money ,r_money ,z_periobs ,r_capital , l.status\n" +
            "from loan l,cp_info cp, login where  cp.cp_id=l.cp_id and login.username=cp.username and l.status=6 and login.id=#{userId}")
    List<Map> selectLoan(Integer userId);
}
