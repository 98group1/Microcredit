package com.aaa.microcredit.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
public interface HkDao {
    /**
     * 点击还款修改明细表里的贷款状态
     */
    @Update("update loan_mx set r_status=7 where l_id=#{loanId} and be_periods=#{bePeriods}")
    Integer updateLoanmx(Map map);


    /**
     * 点击还款时修改贷款表里的已还款金额
     * @param map
     * @return
     */
    @Update("update loan set r_money=#{rMoney} where l_id=#{loanId}")
    Integer updateLoanHK(Map map);

    /**
     * 修改贷款表里的贷款状态
     * @param loanId
     * @return
     */
    @Update("update loan set status=7 where l_id=#{loanId}")
    Integer updateLoan(Integer loanId);

    /**
     * 修改申请表里的贷款状态
     * @param ApplyId
     * @return
     */
    @Update("update apply set loan_status=7 where Apply_Id=#{ApplyId}")
    Integer updateApply(Integer ApplyId);


    /**
     * 查询出某客户最新的可用余额
     * @return
     */
    @Select("SELECT * from client_money where c_id=(select Max(c_id) from client_money where user_id=#{userId})")
    Map selectAvailMoney(Integer userId);

    /**
     * 向流水表里录入数据  充值
     * @param map
     * @return
     */
    @Insert("insert into client_money(c_id,user_id,c_Moneytype,c_changemoney,c_changetime,c_availmoney,c_describes) " +
            "values(0,#{user_id},#{c_Moneytype},#{c_changemoney},#{c_changetime},#{c_availmoney},#{c_describes})")
    Integer insertMoney(Map map);

    /**
     * 查询平台流水表里最新的可用余额
     * @return
     */
    @Select("select availmoney from platform_money where p_id=(SELECT Max(P_id) from platform_money)")
    Map selectPTAvailMoney();

    /**
     * 向平台流水表录入数据
     * @param map
     * @return
     */
    @Insert("insert into platform_money(loanid,Moneytype,changemoney,Change_time,availmoney,describes)" +
            "values (#{loanId},#{MoneyType},#{changemoney},#{Change_time},#{availmoney},#{describes})")
    Integer insertPTMoney(Map map);
}
