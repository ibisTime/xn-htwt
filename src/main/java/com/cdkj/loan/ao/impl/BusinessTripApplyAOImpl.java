package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBusinessTripApplyAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IBusinessTripApplyBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.BusinessTripApply;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632690Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBusinessTripApplyNode;
import com.cdkj.loan.exception.BizException;

/**
 * 出差申请
 * @author: jiafr 
 * @since: 2018年6月23日 下午3:15:51 
 * @history:
 */
@Service
public class BusinessTripApplyAOImpl implements IBusinessTripApplyAO {

    @Autowired
    private IBusinessTripApplyBO businessTripApplyBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addBusinessTripApply(XN632690Req req) {

        BusinessTripApply data = new BusinessTripApply();
        data.setApplyUserCode(req.getApplyUserCode());
        SYSUser sysUser = sysUserBO.getUser(req.getApplyUserCode());
        data.setDepartmentCode(sysUser.getDepartmentCode());
        data.setPostCode(sysUser.getPostCode());
        Archive archive = archiveBO.getArchiveByUserid(data.getApplyUserCode());
        if (archive != null) {
            data.setJobNo(archive.getJobNo());
        }

        data.setApplyDatetime(new Date());
        data.setTripDatetimeStart(DateUtil.strToDate(
            req.getTripDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setTripDatetimeEnd(DateUtil.strToDate(req.getTripDatetimeEnd(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setTripReason(req.getTripReason());
        data.setTripLine(req.getTripLine());
        data.setAircraftFeeStandard(req.getAircraftFeeStandard());
        data.setAircraftDays(req.getAircraftDays());
        if (null == req.getAircraftBudget()) {
            data.setAircraftBudget(0L);
        } else {
            data.setAircraftBudget(StringValidater.toLong(req
                .getAircraftBudget()));
        }
        data.setTrainFeeStandard(req.getTrainFeeStandard());
        data.setTrainDays(req.getTrainDays());
        if (null == req.getTrainBudget()) {
            data.setTrainBudget(0L);
        } else {
            data.setTrainBudget(StringValidater.toLong(req.getTrainBudget()));
        }

        data.setUrbanFeeStandart(req.getUrbanFeeStandart());
        data.setUrbanDays(req.getUrbanDays());
        if (null == req.getUrbanBudget()) {
            data.setUrbanBudget(0L);
        } else {
            data.setUrbanBudget(StringValidater.toLong(req.getUrbanBudget()));
        }
        if (null == req.getHotelCost()) {
            data.setHotelCost(0L);
        } else {
            data.setHotelCost(StringValidater.toLong(req.getHotelCost()));
        }

        if (null == req.getFoodSubsidy()) {
            data.setFoodSubsidy(0L);
        } else {
            data.setFoodSubsidy(StringValidater.toLong(req.getFoodSubsidy()));
        }
        if (null == req.getEntertainmentCost()) {
            data.setEntertainmentCost(0L);
        } else {
            data.setEntertainmentCost(StringValidater.toLong(req
                .getEntertainmentCost()));
        }

        data.setOther(req.getOther());
        Long subtotal = 0L;
        subtotal = data.getAircraftBudget() + data.getTrainBudget()
                + data.getUrbanBudget() + data.getHotelCost()
                + data.getFoodSubsidy() + data.getEntertainmentCost();
        data.setSubtotal(subtotal);
        if (null == req.getSpareCash()) {
            data.setSpareCash(0L);
        } else {
            data.setSpareCash(StringValidater.toLong(req.getSpareCash()));
        }

        Long costTotal = 0L;
        costTotal = data.getSpareCash() + subtotal;
        data.setCostTotal(costTotal);
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setApplyNote(req.getApplyNote());

        String nextNode = nodeFlowBO.getNodeFlowByCurrentNode(
            EBusinessTripApplyNode.APPLY.getCode()).getNextNode();

        EBusinessTripApplyNode node = EBusinessTripApplyNode.getMap().get(
            nextNode);

        data.setCurNodeCode(node.getCode());

        String code = businessTripApplyBO.saveBusinessTripApply(data);

        // 日志记录
        sysBizLogBO.saveSYSBizLog(code, EBizLogType.BUSINESS_TRIP_APPLY, code,
            node.getCode(), req.getApplyNote(), req.getUpdater());

        return code;
    }

    @Override
    public int editBusinessTripApply(BusinessTripApply data) {
        if (!businessTripApplyBO.isBusinessTripApplyExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return businessTripApplyBO.refreshBusinessTripApply(data);
    }

    @Override
    public int dropBusinessTripApply(String code) {
        if (!businessTripApplyBO.isBusinessTripApplyExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return businessTripApplyBO.removeBusinessTripApply(code);
    }

    @Override
    public Paginable<BusinessTripApply> queryBusinessTripApplyPage(int start,
            int limit, BusinessTripApply condition) {
        return businessTripApplyBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BusinessTripApply> queryBusinessTripApplyList(
            BusinessTripApply condition) {
        return businessTripApplyBO.queryBusinessTripApplyList(condition);
    }

    @Override
    public BusinessTripApply getBusinessTripApply(String code) {
        BusinessTripApply data = businessTripApplyBO.getBusinessTripApply(code);
        init(data);
        return data;
    }

    @Override
    public void departmentAudit(String code, String operator,
            String approveResult, String approveNote) {

        BusinessTripApply data = businessTripApplyBO.getBusinessTripApply(code);
        data.setDepartmentManagerCode(operator);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);

        String preNodeCode = data.getCurNodeCode();

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getNextNode());
        }
        if (EApproveResult.NOT_PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getBackNode());
        }
        EBusinessTripApplyNode node = EBusinessTripApplyNode.getMap().get(
            data.getCurNodeCode());

        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.BUSINESS_TRIP_APPLY, data.getCode(), preNodeCode,
            node.getCode(), approveNote, operator);

        businessTripApplyBO.departmentAudit(data);

    }

    @Override
    public void financeAudit(String code, String operator,
            String approveResult, String approveNote) {

        BusinessTripApply data = businessTripApplyBO.getBusinessTripApply(code);
        data.setFinanceManagerCode(operator);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);

        String preNodeCode = data.getCurNodeCode();

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getNextNode());
        }
        if (EApproveResult.NOT_PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getBackNode());
        }
        EBusinessTripApplyNode node = EBusinessTripApplyNode.getMap().get(
            data.getCurNodeCode());

        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.BUSINESS_TRIP_APPLY, data.getCode(), preNodeCode,
            node.getCode(), approveNote, operator);

        businessTripApplyBO.financeAudit(data);

    }

    @Override
    public void generalAudit(String code, String operator,
            String approveResult, String approveNote) {

        BusinessTripApply data = businessTripApplyBO.getBusinessTripApply(code);
        data.setGeneralManagerCode(operator);
        data.setUpdateDatetime(new Date());
        data.setRemark(approveNote);

        String preNodeCode = data.getCurNodeCode();

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getNextNode());
        }
        if (EApproveResult.NOT_PASS.getCode().equals(approveResult)) {
            data.setCurNodeCode(nodeFlowBO
                .getNodeFlowByCurrentNode(preNodeCode).getBackNode());
        }
        EBusinessTripApplyNode node = EBusinessTripApplyNode.getMap().get(
            data.getCurNodeCode());

        sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
            EBizLogType.BUSINESS_TRIP_APPLY, data.getCode(), preNodeCode,
            node.getCode(), approveNote, operator);

        businessTripApplyBO.generalAudit(data);

    }

    @Override
    public Paginable<BusinessTripApply> queryBusinessTripApplyPageByRoleCode(
            int start, int limit, BusinessTripApply condition) {
        Paginable<BusinessTripApply> page = businessTripApplyBO
            .getPaginableByRoleCode(start, limit, condition);

        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (BusinessTripApply data : page.getList()) {
                init(data);
            }
        }

        return page;
    }

    private BusinessTripApply init(BusinessTripApply data) {

        if (StringUtils.isNotBlank(data.getApplyUserCode())) {
            SYSUser user = sysUserBO.getUser(data.getApplyUserCode());
            data.setApplyUserName(user.getRealName());
        }

        if (StringUtils.isNotBlank(data.getDepartmentCode())) {
            Department department = departmentBO.getDepartment(data
                .getDepartmentCode());
            data.setDepartmentName(department.getName());
        }

        if (StringUtils.isNotBlank(data.getPostCode())) {
            Department post = departmentBO.getDepartment(data.getPostCode());
            data.setPostName((post.getName()));
        }
        return data;

    }
}
