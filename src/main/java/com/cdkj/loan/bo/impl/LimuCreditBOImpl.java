package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.dao.ILimuCreditDAO;
import com.cdkj.loan.domain.LimuCredit;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.exception.BizException;

@Component
public class LimuCreditBOImpl extends PaginableBOImpl<LimuCredit>
        implements ILimuCreditBO {

    @Autowired
    private ILimuCreditDAO limuCreditDAO;

    public void saveLimuCredit(LimuCredit data) {
        limuCreditDAO.insert(data);
    }

    @Override
    public void dropLimuCredit(int id) {
        LimuCredit limuCredit = getLimuCredit(id);
        if (limuCredit == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "立木征信编号不存在！");
        }
        limuCreditDAO.delete(limuCredit);
    }

    @Override
    public int refreshLimuCredit(LimuCredit data) {
        return limuCreditDAO.update(data);
    }

    @Override
    public List<LimuCredit> queryLimuCreditList(LimuCredit condition) {
        return limuCreditDAO.selectList(condition);
    }

    @Override
    public LimuCredit getLimuCredit(int id) {
        LimuCredit data = null;
        if (id != 0) {
            LimuCredit condition = new LimuCredit();
            condition.setId(id);
            data = limuCreditDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "立木征信编号不存在！");
            }
        }
        return data;
    }

    @Override
    public LimuCredit getLimuCreditByUid(String uid) {
        LimuCredit data = null;
        if (StringUtils.isBlank(uid)) {
            LimuCredit condition = new LimuCredit();
            // condition.setToken(token);
            condition.setUserId(uid);
            data = limuCreditDAO.select(condition);
        }
        return data;
    }

    @Override
    public LimuCredit getLimuCreditByUserName(String userName, String bizType) {
        LimuCredit data = null;
        if (StringUtils.isBlank(userName)) {
            LimuCredit condition = new LimuCredit();
            // condition.setToken(token);
            condition.setUserName(userName);
            condition.setBizType(bizType);
            data = limuCreditDAO.select(condition);
        }
        return data;
    }

}
