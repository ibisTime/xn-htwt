package com.cdkj.loan.ao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.exception.BizException;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午11:05:24 
 * @history:
 */
@Service
public class LogisticsAOImpl implements ILogisticsAO {
    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IGpsApplyBO gpsApplyBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    @Transactional
    public void sendLogistics(XN632150Req req) {
        Logistics logistics = logisticsBO.getLogistics(req.getCode());
        if (!ELogisticsStatus.TO_SEND.getCode().equals(logistics.getStatus())
                && !ELogisticsStatus.TO_SEND_AGAIN.getCode().equals(
                    logistics.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待发货状态!");
        }
        // 操作人
        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            if (logistics.getReceiver().equals(req.getOperator())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "gps申领人不能发");
            }
        }
        // 发件
        logistics.setSendFileList(req.getSendFileList());
        logistics.setSendType(req.getSendType());
        logistics.setLogisticsCompany(req.getLogisticsCompany());
        logistics.setLogisticsCode(req.getLogisticsCode());

        logistics.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        logistics.setSendNote(req.getSendNote());
        logistics.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        logisticsBO.sendLogistics(logistics);

        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            gpsApplyBO.sendGps(logistics.getBizCode(),
                logistics.getSendDatetime());
        }
    }

    @Override
    @Transactional
    public BooleanRes receiveLogistics(String code, String operator,
            String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态!");
        }

        if (data.getUserId().equals(operator)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "收件人不能和发件人同一人！");
        }
        // SYSUser condition = new SYSUser();
        // condition.setUserId(operator);
        // condition.setTeamCode(data.getTeamCode());
        // long count = sysUserBO.getTotalCount(condition);
        // if (count > 0) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // "发件人团队成员不能收件！");
        // }

        String result = EBoolean.NO.getCode();
        logisticsBO.receiveLogistics(code, remark);
        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            result = budgetOrderBO.logicOrder(data.getBizCode(), operator);
        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.receiveGps(data.getBizCode());
        }
        return new BooleanRes(true, result);
    }

    @Override
    public void sendAgainLogistics(String code, String operator, String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态!");
        }

        // 操作人入参验证
        SYSUser condition = new SYSUser();
        condition.setUserId(operator);
        condition.setTeamCode(data.getTeamCode());
        long count = sysUserBO.getTotalCount(condition);
        if (count <= 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "发件人团队人员不能收件！");
        }

        logisticsBO.sendAgainLogistics(code, remark);
    }

    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        if (StringUtils.isNotBlank(condition.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(condition.getUserId());
            condition.setTeamCode(sysUser.getTeamCode());
            condition.setUserId(null);
        }

        Paginable<Logistics> page = logisticsBO.getPaginable(start, limit,
            condition);
        List<Logistics> logisticsList = page.getList();
        for (Logistics logistics : logisticsList) {
            initLogistics(logistics);
        }
        return page;
    }

    private void initLogistics(Logistics logistics) {
        if (StringUtils.isNotBlank(logistics.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(logistics.getUserId());
            logistics.setUserName(sysUser.getRealName());
        }
    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        List<Logistics> logisticsList = logisticsBO
            .queryLogisticsList(condition);
        for (Logistics logistics : logisticsList) {
            initLogistics(logistics);
        }
        return logisticsList;
    }

    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = logisticsBO.getLogistics(code);
        initLogistics(logistics);

        return logistics;
    }
}
