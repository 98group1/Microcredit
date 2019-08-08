package com.aaa.microcredit.dao;

import com.aaa.microcredit.entity.Loan;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
@Repository
public interface LoanMapper {
    int deleteByPrimaryKey(Integer lId);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);
    /**
     * 查询贷款信息
     * @return
     */
    List<Map> selectAll(Map map);
    /**
     * 联合明细表查询
     * @return
     */
    List<Map> selectMxAll();
    /**
     * 查询贷款条数
     * @return
     */
    Integer selectAllCount(Map map);
    /**
     * 用Map拼接还款表和明细表
     * @return
     */
    List<Map> selectMxPjAll(Map map);

    /**
     *     查询cp_info loan dictionary表
     * @param map
     * @return
     */
     List<Map> selectCpAndLoan(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int queryPageCount(Map map);

    /**
     * 放款添加表数据
     * @param map
     * @return
     */
    int insertLoan(Map map);

    /**
     放款成功修改贷款状态为待还款

     * @return
     */

    int updateLoStatus(Map map);

    /**
     *     放款成功根据分期数添加明细表
     * @param map
     * @return
     */


  int insertMX(Map map);

    /**
     * 根据查询loan所有信息
     *
     * @return
     */
    Map selectLoan(Integer l_id);




    /**
     * 根据前台用户id查询贷款信息
     * @param map
     * @return
     */
    List<Map> selectLoan1(Map map);
    /**
     * 查询贷款条数
     * @return
     */
    Integer selectLoanCount(Integer userId);

}