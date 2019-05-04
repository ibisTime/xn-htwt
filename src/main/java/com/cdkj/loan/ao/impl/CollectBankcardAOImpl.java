package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.bo.IChannelBankBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.ChannelBank;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632000Req;
import com.cdkj.loan.dto.req.XN632002Req;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectBankcardAOImpl implements ICollectBankcardAO {

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Autowired
    private IChannelBankBO channelBankBO;

    @Override
    public String addCollectBankcard(XN632000Req req) {
        CollectBankcard data = new CollectBankcard();
        BeanUtils.copyProperties(req, data);
        // 获取银行名称
        ChannelBank bank = channelBankBO.getChannelBank(req.getBankCode());
        data.setBankName(bank.getBankName());
        data.setPointRate(StringValidater.toDouble(req.getPointRate()));

        return collectBankcardBO.saveCollectBankcard(data);
    }

    @Override
    public int editCollectBankcard(XN632002Req req) {
        CollectBankcard data = collectBankcardBO
            .getCollectBankcard(req.getCode());
        BeanUtils.copyProperties(req, data);

        // 获取银行名称
        ChannelBank bank = channelBankBO.getChannelBank(req.getBankCode());
        data.setBankName(bank.getBankName());
        data.setPointRate(StringValidater.toDouble(req.getPointRate()));

        return collectBankcardBO.refreshCollectBankcard(data);
    }

    @Override
    public int dropCollectBankcard(String code) {
        return collectBankcardBO.removeCollectBankcard(code);
    }

    @Override
    public Paginable<CollectBankcard> queryCollectBankcardPage(int start,
            int limit, CollectBankcard condition) {
        return collectBankcardBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CollectBankcard> queryCollectBankcardList(
            CollectBankcard condition) {
        return collectBankcardBO.queryCollectBankcardList(condition);
    }

    @Override
    public CollectBankcard getCollectBankcard(String code) {
        return collectBankcardBO.getCollectBankcard(code);
    }
}
