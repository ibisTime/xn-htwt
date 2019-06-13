package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632115Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 按角色编号分页查询征信列表
 * @author: jiafr 
 * @since: 2018年5月26日 上午10:57:21 
 * @history:
 */
public class XN632115 extends AProcessor {

    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632115Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Cdbiz condition = new Cdbiz();
        condition.setCode(req.getCode());
        condition.setBizCode(req.getBizCode());
        condition.setSaleUserId(req.getSaleUserId());
        condition.setUserName(req.getUserName());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        // condition.setKeyword(req.getKeyword());
        condition.setRoleCode(req.getRoleCode());
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setCurNodeCodeList(req.getCurNodeCodeList());
        condition.setUserId(req.getUserId());
        // if (StringUtils.isNotBlank(req.getIsPass())) {
        // if (EBoolean.YES.getCode().equals(req.getIsPass())) {
        // condition.setCurNodeCode(ENode.ACHIEVE.getCode());
        // }
        // if (EBoolean.NO.getCode().equals(req.getIsPass())) {
        // condition.setNoPass(ENode.ACHIEVE.getCode());
        // }
        // }
        // condition.setIsCancel(req.getIsCancel());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICdbizAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());

        return cdbizAO.queryCdbizPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632115Req.class);
        ObjValidater.validateReq(req);

    }

}
