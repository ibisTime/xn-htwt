package com.cdkj.loan.ao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILimuCreditAO;
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.LimuCredit;
import com.cdkj.loan.dto.req.XN632949Req;

@Service
public class LimuCreditAOImpl implements ILimuCreditAO {

    @Autowired
    private ILimuCreditBO limuCreditBO;

    @Override
    public void addLimuCredit(LimuCredit data) {
        limuCreditBO.saveLimuCredit(data);
    }

    @Override
    public int editLimuCredit(LimuCredit data) {
        return limuCreditBO.refreshLimuCredit(data);
    }

    @Override
    public Paginable<LimuCredit> queryLimuCreditPage(int start, int limit,
            LimuCredit condition) {
        return limuCreditBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<LimuCredit> queryLimuCreditList(LimuCredit condition) {
        return limuCreditBO.queryLimuCreditList(condition);
    }

    @Override
    public LimuCredit getLimuCredit(int id) {
        return limuCreditBO.getLimuCredit(id);
    }

    @Override
    public Object getLimuCreditByType(XN632949Req req) {
        LimuCredit condition = new LimuCredit();
        condition.setUserId(req.getUserId());
        condition.setBizType(req.getBizType());
        LimuCredit limuCredit = limuCreditBO.getLimuCreditByType(condition);
        if (limuCredit == null) {
            return false;
        }
        return true;
    }

    @Override
    public Object queryLimuCreditMap(String userId) {
        HashMap<String, String> map = new HashMap<String, String>();
        if (userId.equals("") || userId.equals(null)) {
            return map;
        }
        LimuCredit condition = new LimuCredit();
        condition.setUserId(userId);
        List<LimuCredit> creditList = limuCreditBO
            .queryLimuCreditList(condition);
        for (LimuCredit limuCredit : creditList) {
            // if (map.get(limuCredit.getBizType()) == null) {
            // map.put(limuCredit.getBizType(),
            // limuCredit.getId() + "," + limuCredit.getStatus());
            // }
            map.put(limuCredit.getBizType(), "{\"id\":" + limuCredit.getId()
                    + "," + "\"status\":" + limuCredit.getStatus() + "}");

        }
        return map;
    }
}
