package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.dto.req.XN632115Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 按角色编号分页查询征信列表
 * @author: jiafr 
 * @since: 2018年5月26日 上午10:57:21 
 * @history:
 */
public class XN632115 extends AProcessor {

    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632115Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Credit condition = new Credit();
        condition.setCode(req.getCode());
        condition.setSaleUserId(req.getSaleUserId());
        condition.setUserNameQuery(req.getUserName());
        condition.setTeamCode(req.getTeamCode());
        condition.setBudgetCodeQuery(req.getBudgetOrderCode());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setKeyword(req.getKeyword());
        condition.setRoleCode(req.getRoleCode());
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setCurNodeCodeList(req.getCurNodeCodeList());
        if (StringUtils.isNotBlank(req.getIsPass())) {
            if (EBoolean.YES.getCode().equals(req.getIsPass())) {
                condition.setCurNodeCode(ECreditNode.ACHIEVE.getCode());
            }
            if (EBoolean.NO.getCode().equals(req.getIsPass())) {
                condition.setNoPass(ECreditNode.ACHIEVE.getCode());
            }
        }
        condition.setIsCancel(req.getIsCancel());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());

        return creditAO.queryCreditPageByRoleCode(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632115Req.class);
        ObjValidater.validateReq(req);

    }

}
