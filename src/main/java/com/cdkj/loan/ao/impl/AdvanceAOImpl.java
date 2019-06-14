package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IAdvanceAO;
import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.IAdvanceCollectCardBO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICollectBankcardBO;
import com.cdkj.loan.bo.IMissionBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Advance;
import com.cdkj.loan.domain.AdvanceCollectCard;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632462ReqMission;
import com.cdkj.loan.dto.req.XN632464Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class AdvanceAOImpl implements IAdvanceAO {

    @Autowired
    private IAdvanceBO advanceBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private IMissionBO missionBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private IAdvanceCollectCardBO advanceCollectCardBO;

    @Autowired
    private ICollectBankcardBO collectBankcardBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmApply(String code, String operator, String isAdvanceFund) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        cdbiz.setIsAdvanceFund(isAdvanceFund);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.sure_dz.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是确认用款单节点，不能操作");
        }

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.fund, code,
                preFbhgpsNode, null, operator);

        // 判断是否垫资，垫资的话去审核，不垫资的话去录入发保和
        String nextNodeCode;
        String nextStatus;
        if (EBoolean.YES.getCode().equals(isAdvanceFund)) {
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    preFbhgpsNode).getNextNode();
            nextStatus = ECdbizStatus.F1.getCode();

        } else {
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    preFbhgpsNode).getBackNode();
            nextStatus = ECdbizStatus.C01.getCode();
        }
        advanceBO.confirmApply(code, nextNodeCode, nextStatus);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.fund, code, code, preFbhgpsNode, nextNodeCode,
                operator);

        // 更新业务状态
        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbiz.setFbhgpsStatus(nextStatus);
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);


    }

    @Override
    public void areaManageApprove(String code, String operator,
            String approveResult, String approveNote) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.qy_manager_approve.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是用款一审节点，不能操作");
        }

        String nextNodeCode;
        String nextStatus;
        // 审批通过，去二审，不通过去录入发保和
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    preFbhgpsNode).getNextNode();
            nextStatus = ECdbizStatus.F2.getCode();

        } else {
            if (StringUtils.isBlank(approveNote)) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写审核不通过的审核说明");
            }
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    preFbhgpsNode).getBackNode();
            nextStatus = ECdbizStatus.C01.getCode();
            cdbiz.setIsAdvanceFund(EBoolean.NO.getCode());
        }
        Advance advance = advanceBO.getAdvanceByBizCode(code);
        advance.setAdvanceNote(approveNote);
        advanceBO.areaManageApprove(advance);

        // 更新业务状态
        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbiz.setFbhgpsStatus(nextStatus);
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.fund, code,
                preFbhgpsNode, approveNote, operator);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.fund, code, code, preFbhgpsNode, nextNodeCode,
                operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void provinceManageApprove(String code, String operator,
            String approveResult, String approveNote,
            List<XN632462ReqMission> missionList) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.sfgs_manage_approve.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是用款二审节点，不能操作");
        }

        Advance advance = advanceBO.getAdvanceByBizCode(code);

        String nextNodeCode;
        String nextStatus;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    preFbhgpsNode).getNextNode();
            nextStatus = ECdbizStatus.F3.getCode();

            if (CollectionUtils.isEmpty(missionList)) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "任务列表不能为空");
            }
            // 生成任务单
            for (XN632462ReqMission mission : missionList) {
                missionBO.saveMission(advance.getBizCode(), mission.getName(),
                        StringValidater.toLong(mission.getTime()), operator,
                        cdbiz.getSaleUserId());
            }
        } else {
            if (StringUtils.isBlank(approveNote)) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(), "请填写审核不通过的审核说明");
            }
            nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                    preFbhgpsNode).getBackNode();
            nextStatus = ECdbizStatus.C01.getCode();
            cdbiz.setIsAdvanceFund(EBoolean.NO.getCode());
        }
        advanceBO.provinceManageApprove(code, nextNodeCode, nextStatus);

        // 更新业务状态
        cdbiz.setFbhgpsStatus(nextStatus);
        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.fund, code,
                preFbhgpsNode, approveNote, operator);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.fund, code, code, preFbhgpsNode, nextNodeCode,
                operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmMakeBill(String code, String operator,
            String makeBillNote) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
        if (!ENode.confirm_make_bill.getCode().equals(cdbiz.getFbhgpsNode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是制单回录节点，不能操作");
        }

        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                preFbhgpsNode).getNextNode();

        advanceBO.confirmMakeBill(code, nextNodeCode,
                ECdbizStatus.F4.getCode(), makeBillNote);

        // 更新业务状态
        cdbiz.setFbhgpsNode(nextNodeCode);
        cdbiz.setFbhgpsStatus(ECdbizStatus.F4.getCode());
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.fund, code,
                preFbhgpsNode, makeBillNote, operator);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.fund, code, code, preFbhgpsNode, nextNodeCode,
                operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void advanceBackUp(XN632464Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preFbhgpsNode = cdbiz.getFbhgpsNode();
//        if (!ENode.upload_approve_back_bill.getCode().equals(
//                cdbiz.getFbhgpsNode())) {
//            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
//                    "当前不是垫资回录节点，不能操作");
//        }

        Advance advance = advanceBO.getAdvanceByBizCode(req.getCode());

//        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
//                preFbhgpsNode).getNextNode();

        advance.setAdvanceFundAmount(StringValidater.toInteger(req
                .getAdvanceFundAmount()));
        advance.setAdvanceFundDatetime(DateUtil.strToDate(
                req.getAdvanceFundDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        advance.setAdvanceCardCode(req.getAdvanceCardCode());
        advanceBO.advanceBackUp(advance);

        //收款账号列表
        for (String code : req.getCollectCardCodeList()) {
            if (code.equals(req.getAdvanceCardCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(), "收款账号与出款账号重复");
            }
            collectBankcardBO.getCollectBankcard(code);
            AdvanceCollectCard advanceCollectCard = new AdvanceCollectCard();
            advanceCollectCard.setBizCode(req.getCode());
            advanceCollectCard.setCollectBankcardCode(code);
            advanceCollectCardBO.saveAdvanceCollectCard(advanceCollectCard);
        }

        // 水单
        EAttachName attachName = EAttachName.getMap().get(
                EAttachName.advanceBillPdf.getCode());
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getBillPdf());

        // 更新业务状态
        cdbiz.setFbhgpsNode(ENode.input_fbh.getCode());
        cdbiz.setFbhgpsStatus(ECdbizStatus.C01.getCode());
        cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

        //查找当前节点的最新待办
        List<BizTask> bizTasks = bizTaskBO
                .queryLastBizTask(cdbiz.getCode(), null, null, preFbhgpsNode);
        //找本次节点的待办，如果没有，说明走后门，记录日志并产生下一步待办
        if (CollectionUtils.isEmpty(bizTasks)) {
            sysBizLogBO.saveFirstSYSBizLog(cdbiz.getCode(), EBizLogType.fund, req.getCode(),
                    preFbhgpsNode, null, req.getOperator());

            bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.fbh, req.getCode(),
                    ENode.input_fbh.getCode());
        } else {
            // 操作日志
            sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.fund,
                    req.getCode(), preFbhgpsNode, null, req.getOperator());

            // 待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.fbh, req.getCode(), req.getCode(), preFbhgpsNode,
                    ENode.input_fbh.getCode(), req.getOperator());
        }
    }

    @Override
    public Paginable<Advance> queryAdvancePage(int start, int limit,
            Advance condition) {
        return advanceBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Advance> queryAdvanceList(Advance condition) {
        return advanceBO.queryAdvanceList(condition);
    }

    @Override
    public Advance getAdvance(String code) {
        return advanceBO.getAdvance(code);
    }

}
