package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.dao.IBudgetOrderGpsDAO;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGpsUseStatus;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetOrderGpsBOImpl extends PaginableBOImpl<BudgetOrderGps>
        implements IBudgetOrderGpsBO {

    @Autowired
    private IBudgetOrderGpsDAO budgetOrderGpsDAO;

    @Autowired
    private IGpsBO gpsBO;

    public String saveBudgetOrderGps(BudgetOrderGps data) {
        String code = null;
        if (data != null) {
            budgetOrderGpsDAO.insert(data);
        }
        return code;
    }

    @Override
    public void saveBudgetOrderGpsList(String code,
            List<XN632126ReqGps> gpsAzList) {
        if (CollectionUtils.isNotEmpty(gpsAzList)) {
            for (XN632126ReqGps reqGps : gpsAzList) {
                BudgetOrderGps data = new BudgetOrderGps();
                Gps gps = gpsBO.getGps(reqGps.getCode());
                if (EGpsUseStatus.USED.getCode().equals(gps.getUseStatus())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                            "该gps已使用，请重新选择！");
                }
                data.setCode(reqGps.getCode());
                data.setGpsDevNo(gps.getGpsDevNo());
                data.setGpsType(gps.getGpsType());
                data.setAzLocation(reqGps.getAzLocation());
                data.setAzDatetime(DateUtil.strToDate(reqGps.getAzDatetime(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
                data.setAzUser(reqGps.getAzUser());
                data.setDevPhotos(reqGps.getDevPhotos());
                data.setAzPhotos(reqGps.getAzPhotos());
                data.setRemark(reqGps.getRemark());
                data.setBudgetOrder(code);
                saveBudgetOrderGps(data);
                gpsBO.refreshUseGps(gps.getCode(), code, EBoolean.YES);// gps改为已使用
            }
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "gps安装列表为空！");
        }
    }

    @Override
    public int removeBudgetOrderGps(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrderGps data = new BudgetOrderGps();
            data.setCode(code);
            count = budgetOrderGpsDAO.delete(data);
        }
        return count;
    }

    @Override
    public void removeBudgetOrderGpsList(String code) {
        BudgetOrderGps condition = new BudgetOrderGps();
        condition.setBudgetOrder(code);
        List<BudgetOrderGps> queryBudgetOrderGpsList = queryBudgetOrderGpsList(
                condition);
        for (BudgetOrderGps budgetOrderGps : queryBudgetOrderGpsList) {
            budgetOrderGpsDAO.delete(budgetOrderGps);
        }
    }

    @Override
    public int refreshBudgetOrderGps(BudgetOrderGps data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = budgetOrderGpsDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BudgetOrderGps> queryBudgetOrderGpsList(String budgetOrder) {
        BudgetOrderGps condition = new BudgetOrderGps();
        condition.setBudgetOrder(budgetOrder);
        return budgetOrderGpsDAO.selectList(condition);
    }

    @Override
    public List<BudgetOrderGps> queryBudgetOrderGpsList(
            BudgetOrderGps condition) {
        return budgetOrderGpsDAO.selectList(condition);
    }

    @Override
    public BudgetOrderGps getBudgetOrderGps(String code) {
        BudgetOrderGps data = null;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrderGps condition = new BudgetOrderGps();
            condition.setCode(code);
            data = budgetOrderGpsDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "gps安装不存在");
            }
        }
        return data;
    }

}
