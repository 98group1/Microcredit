package com.aaa.microcredit.controller;

import com.aaa.microcredit.entity.Apply;
import com.aaa.microcredit.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    /**
     * 根据id查询申请信息
     * @param applyId
     * @return
     */
    @RequestMapping("selectApplyId")
    @ResponseBody
    public Apply SelectApplyId(Integer applyId){
        return applyService.selectByPrimaryKey(applyId);
    }

}
