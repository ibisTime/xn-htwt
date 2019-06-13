/**
 * @Title XN630530.java
 * @Package com.cdkj.loan.api.impl
 * @Description
 * @author haiqingzheng
 * @date 2018年5月6日 下午5:46:47
 * @version V1.0
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRemindLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630531Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 催款
 * @author: CYL
 * @since: 2018年5月9日 上午10:10:14 
 * @history:
 */
public class XN630531 extends AProcessor {

    private IRemindLogAO remindLogAO = SpringContextHolder
        .getBean(IRemindLogAO.class);

    private XN630531Req req = null;

    /**
     * @see com.cdkj.loan.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        remindLogAO.collect(req.getCode(), req.getWay());
        return new BooleanRes(true);
    }

    /**
     * @see com.cdkj.loan.api.IProcessor#doCheck(java.lang.String, java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630531Req.class);
        ObjValidater.validateReq(req);
    }

}
