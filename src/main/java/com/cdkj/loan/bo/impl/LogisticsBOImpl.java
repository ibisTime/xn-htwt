package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ILogisticsDAO;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ELogisticsStatus;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:40:49 
 * @history:
 */

@Component
public class LogisticsBOImpl extends PaginableBOImpl<Logistics> implements
        ILogisticsBO {
    @Autowired
    private ILogisticsDAO logisticsDAO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    public String saveLogistics(String type, String bizCode, String userId,
            String fromNodeCode, String toNodeCode, String refFileList) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.LOGISTICS
            .getCode());
        Logistics data = new Logistics();
        data.setCode(code);
        data.setType(type);
        data.setBizCode(bizCode);
        data.setUserId(userId);
        // 找到团队
        SYSUser sysUser = sysUserBO.getUser(userId);
        data.setTeamCode(sysUser.getTeamCode());

        data.setFromNodeCode(fromNodeCode);
        data.setToNodeCode(toNodeCode);
        data.setStatus(ELogisticsStatus.TO_SEND.getCode());
        data.setReceiver(EBoolean.NO.getCode());
        logisticsDAO.insert(data);
        return code;
    }

    @Override
    public String saveLogisticsGps(String type, String bizCode, String userId,
            String refFileList, String receiver) {
        String code = OrderNoGenerater.generate(EGeneratePrefix.LOGISTICS
            .getCode());
        Logistics data = new Logistics();
        data.setCode(code);
        data.setType(type);
        data.setBizCode(bizCode);
        data.setUserId(userId);

        // 找到团队
        SYSUser sysUser = sysUserBO.getUser(userId);
        data.setTeamCode(sysUser.getTeamCode());
        data.setStatus(ELogisticsStatus.TO_SEND.getCode());
        data.setReceiver(receiver);

        logisticsDAO.insert(data);
        // 日志
        sysBizLogBO
            .saveSYSBizLog(data.getCode(), EBizLogType.GPS_LOGISTICS,
                data.getCode(), ELogisticsStatus.SEND.getCode(),
                data.getTeamCode());
        return code;
    }

    @Override
    public void sendLogistics(Logistics data) {
        logisticsDAO.updateLogisticsSend(data);
    }

    @Override
    public void receiveLogistics(String code, String remark) {
        if (StringUtils.isNotBlank(code)) {
            Logistics condition = new Logistics();
            condition.setCode(code);
            condition.setRemark(remark);
            condition.setReceiptDatetime(new Date());
            condition.setStatus(ELogisticsStatus.RECEIVED.getCode());
            logisticsDAO.updateLogisticsReceive(condition);
        }
    }

    @Override
    public void sendAgainLogistics(String code, String remark) {
        if (StringUtils.isNotBlank(code)) {
            Logistics data = new Logistics();
            data.setCode(code);
            data.setRemark(remark);
            data.setStatus(ELogisticsStatus.TO_SEND_AGAIN.getCode());
            logisticsDAO.updateLogisticsReceive(data);
        }
    }

    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = null;
        if (StringUtils.isNotBlank(code)) {
            Logistics data = new Logistics();
            data.setCode(code);
            logistics = logisticsDAO.select(data);
        }
        return logistics;
    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        return logisticsDAO.selectList(condition);
    }

}
