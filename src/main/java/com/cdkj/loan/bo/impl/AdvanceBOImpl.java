package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAdvanceDAO;
import com.cdkj.loan.domain.Advance;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

@Component
public class AdvanceBOImpl extends PaginableBOImpl<Advance>
        implements IAdvanceBO {

    @Autowired
    private IAdvanceDAO advanceDAO;

    @Override
    public String saveAdvance(String bizCode) {
        Advance advance = new Advance();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.ADVANCE.getCode());
        advance.setCode(code);
        advance.setBizCode(bizCode);
        advance.setStatus(ECdbizStatus.F0.getCode());
        advance.setCurNodeCode(ENode.sure_dz.getCode());

        advanceDAO.insert(advance);

        return code;
    }

    @Override
    public void confirmApply(String code, String curNodeCode, String status) {
        Advance advance = new Advance();

        advance.setCode(code);
        advance.setCurNodeCode(curNodeCode);
        advance.setStatus(status);

        advanceDAO.updateConfirmApply(advance);
    }

    @Override
    public void areaManageApprove(String code, String curNodeCode,
            String status, String approveNote) {
        Advance advance = new Advance();

        advance.setCode(code);
        advance.setCurNodeCode(curNodeCode);
        advance.setStatus(status);
        advance.setAdvanceNote(approveNote);

        advanceDAO.updateAreaManageApprove(advance);
    }

    @Override
    public void provinceManageApprove(String code, String curNodeCode,
            String status) {
        Advance advance = new Advance();

        advance.setCode(code);
        advance.setCurNodeCode(curNodeCode);
        advance.setStatus(status);

        advanceDAO.updateProvinceManageApprove(advance);
    }

    @Override
    public void confirmMakeBill(String code, String curNodeCode, String status,
            String makeBillNote) {
        Advance advance = new Advance();

        advance.setCode(code);
        advance.setCurNodeCode(curNodeCode);
        advance.setStatus(status);
        advance.setMakeBillNote(makeBillNote);

        advanceDAO.updateConfirmMakeBill(advance);
    }

    @Override
    public List<Advance> queryAdvanceList(Advance condition) {
        return advanceDAO.selectList(condition);
    }

    @Override
    public Advance getAdvance(String code) {
        Advance data = null;
        if (StringUtils.isNotBlank(code)) {
            Advance condition = new Advance();
            condition.setCode(code);
            data = advanceDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "财务垫资信息不存在");
            }
        }
        return data;
    }

}
