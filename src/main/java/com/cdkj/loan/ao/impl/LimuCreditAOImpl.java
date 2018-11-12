package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ILimuCreditAO;
import com.cdkj.loan.bo.ILimuCreditBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LimuCredit;
import com.cdkj.loan.dto.req.XN632949Req;
import com.cdkj.loan.enums.ELimuCreditStatus;

@Service
public class LimuCreditAOImpl implements ILimuCreditAO {

    @Autowired
    private ILimuCreditBO limuCreditBO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

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
            int days = DateUtil.daysBetween(limuCredit.getFoundDatetime(),
                new Date());
            Map<String, String> configsMap = sysConfigBO
                .getConfigsMap("query_failure_days");
            Integer d = StringValidater.toInteger(configsMap.get("days"));
            if (d <= days) {
                limuCredit.setStatus(ELimuCreditStatus.RENEW_QUERY.getCode());
                limuCreditBO.refreshLimuCredit(limuCredit);
            }
            map.put(limuCredit.getBizType(), "{\"id\":" + limuCredit.getId()
                    + "," + "\"status\":" + limuCredit.getStatus() + "}");

        }
        return map;
    }
}
