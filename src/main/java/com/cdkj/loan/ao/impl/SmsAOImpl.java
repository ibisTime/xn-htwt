/**
 * @Title SmsAOImpl.java 
 * @Package com.ogc.standard.ao.impl 
 * @Description 
 * @author dl  
 * @date 2018年8月22日 下午3:14:45 
 * @version V1.0   
 */
package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISmsAO;
import com.cdkj.loan.bo.ISmsBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Sms;
import com.cdkj.loan.dto.req.XN805300Req;
import com.cdkj.loan.dto.req.XN805301Req;
import com.cdkj.loan.enums.EErrorCode_main;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ESmsStauts;
import com.cdkj.loan.exception.BizException;

/** 
 * @author: dl 
 * @since: 2018年8月22日 下午3:14:45 
 * @history:
 */
@Service
public class SmsAOImpl implements ISmsAO {

    @Autowired
    private ISmsBO smsBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String addSms(XN805300Req req) {
        Sms data = new Sms();
        data.setContent(req.getContent());
        data.setRemark(req.getRemark());
        data.setTitle(req.getTitle());
        data.setType(req.getType());
        data.setUpdater(req.getUpdater());
        data.setStatus(ESmsStauts.DRAFT.getCode());
        data.setCode(OrderNoGenerater.generate(EGeneratePrefix.XX.getCode()));
        return smsBO.saveSms(data);
    }

    @Override
    public void releaseSms(XN805301Req req) {

        Sms data = new Sms();
        data.setContent(req.getContent());
        data.setRemark(req.getRemark());
        data.setTitle(req.getTitle());
        data.setType(req.getType());
        data.setUpdater(req.getUpdater());
        data.setStatus(ESmsStauts.SENDED.getCode());
        // code是否为空
        if (StringUtils.isNotBlank(req.getCode())) {
            Sms sms = smsBO.getSms(req.getCode());
            // 判断该消息是否发布
            if (sms.getStatus().equals(ESmsStauts.SENDED.getCode())) {
                throw new BizException(EErrorCode_main.sms_PUBLISHED.getCode());
            }
            data.setCode(req.getCode());
            smsBO.refreshSms(data);
        } else {
            data.setCode(
                OrderNoGenerater.generate(EGeneratePrefix.XX.getCode()));
            smsBO.saveSms(data);
        }

    }

    @Override
    public void editStatus(String code, String updater, String remark) {
        smsBO.revokeSms(code, updater, remark);
    }

    @Override
    public Paginable<Sms> querySmsPage(int start, int limit, Sms condition) {
        return smsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Sms> querySmsList(Sms condition) {
        return smsBO.querySmsList(condition);
    }

    @Override
    public Sms getSms(String code) {
        if (!smsBO.isSmsExit(code)) {
            throw new BizException(EErrorCode_main.sms_NOTEXIST.getCode());
        }
        return smsBO.getSms(code);
    }

}
