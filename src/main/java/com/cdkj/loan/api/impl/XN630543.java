package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayPlanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630543Req;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 当月还款名单(车贷)
 *
 * @author: CYL
 * @since: 2018年5月8日 下午5:25:57
 * @history:
 */
public class XN630543 extends AProcessor {

    private IRepayPlanAO repayPlanAO = SpringContextHolder
            .getBean(IRepayPlanAO.class);

    private XN630543Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(req.getRepayBizCode());
        condition.setUserId(req.getUserId());
        condition.setRefType(req.getRefType());
        if (EBoolean.YES.getCode().equals(req.getRefType())) {
            condition.setCurNodeCode(ERepayPlanNode.PRD_TO_REPAY.getCode());
            //当月
            condition.setRepayStartDatetime(DateUtil.getFirstDay());
        } else {
            condition.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
        }
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        condition.setOrder("cur_periods", true);
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repayPlanAO.queryCurrentMonthRepayPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630543Req.class);
        ObjValidater.validateReq(req);
    }
}
