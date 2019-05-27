package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.bo.IRepointAccountBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.RepointAccount;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632310Req;
import com.cdkj.loan.dto.res.XN632310ReqRes;
import com.cdkj.loan.enums.ERepointStatus;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jiafr
 * @since: 2018年6月9日 下午2:19:32
 * @history:
 */
@Service
public class RepointAOImpl implements IRepointAO {

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IRepointAccountBO repointAccountBO;

    @Override
    @Transactional(rollbackFor = BizException.class)
    public void confirmRepoint(XN632310Req req) {
        Repoint data = repointBO.getRepoint(req.getCode());

        //删除
        repointAccountBO.removeListByRepointCode(data.getCode());
        //添加
        for (XN632310ReqRes res : req.getRepointAccountList()) {
            RepointAccount repointAccount = new RepointAccount();
            repointAccount.setRepointCode(data.getCode());
            repointAccount.setRepointCardCode(res.getRepointCardCode());
            repointAccount.setActualAmount(StringValidater.toLong(res.getActualAmount()));
            repointAccount.setWaterBill(res.getWaterBill());
            repointAccount.setUpdater(req.getUpdater());
            repointAccount.setUpdateDatetime(new Date());
            repointAccount.setRemark(res.getRemark());
            repointAccountBO.saveRepointAccount(repointAccount);
        }

        data.setStatus(ERepointStatus.HANDLED.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        repointBO.refreshRepoint(data);
    }

    @Override
    public Paginable<Repoint> queryRepointPage(int start, int limit,
            Repoint condition) {
        Paginable<Repoint> paginable = repointBO.getPaginable(start, limit,
                condition);
        for (Repoint repoint : paginable.getList()) {
            SYSUser user = sysUserBO.getUser(repoint.getCaptain());
            repoint.setUser(user);
        }
        return paginable;
    }

    @Override
    public List<Repoint> queryRepointList(Repoint condition) {
        List<Repoint> repointList = repointBO.queryRepointList(condition);
        for (Repoint repoint : repointList) {
            Long actualAmount = 0L;
            SYSUser user = sysUserBO.getUser(repoint.getCaptain());
            repoint.setUser(user);

            //实返金额
            RepointAccount repointAccount = new RepointAccount();
            repointAccount.setRepointCode(repoint.getCode());
            List<RepointAccount> repointAccountList = repointAccountBO
                    .queryRepointAccountList(repointAccount);
            if (CollectionUtils.isNotEmpty(repointAccountList)) {
                for (RepointAccount data : repointAccountList) {
                    actualAmount += data.getActualAmount();
                }

            }
            repoint.setActualAmount(actualAmount);
        }
        return repointList;
    }

    @Override
    public Repoint getRepoint(String code) {
        Repoint repoint = repointBO.getRepoint(code);
        SYSUser user = sysUserBO.getUser(repoint.getCaptain());
        repoint.setUser(user);
        return repoint;
    }
}
