package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.IEnterFileListBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.EnterFileList;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.dto.req.XN632539Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EAttachmentType;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarPledgeAOImpl implements ICarPledgeAO {

    @Autowired
    private ICarPledgeBO carPledgeBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private ICarInfoBO carInfoBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private IEnterFileListBO enterFileListBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pledgeApply(XN632144Req req) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preCurNodeCode = cdbiz.getCurNodeCode();
        if (!ENode.bank_receipt.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是抵押申请节点，不能操作");
        }

        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                preCurNodeCode).getNextNode();

        // 车辆抵押信息
        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(req.getCode());
        // 判断车辆抵押副表是不是空，不为空说明预算单填写过抵押信息
        if (null == carPledge) {
            carPledgeBO.saveCarPledge(req.getCode(), req.getSupplementNote(),
                    req.getPledgeUser(), req.getPledgeUserIdCard(),
                    req.getPledgeAddress());
        } else {
            carPledge.setPledgeSupplementNote(req.getSupplementNote());
            carPledge.setPledgeUser(req.getPledgeUser());
            carPledge.setPledgeUserIdCard(req.getPledgeUserIdCard());
            carPledge.setPledgeAddress(req.getPledgeAddress());
            carPledgeBO.refreshCarPledge(carPledge);
        }

        //身份证正面反面落地
        attachmentBO.saveAttachment(req.getCode(),"pledge_user_id_card_front", "图片",req.getPledgeUserIdCardFront());
        attachmentBO.saveAttachment(req.getCode(),"pledge_user_id_card_reverse", "图片",req.getPledgeUserIdCardReverse());


        // 更新业务状态
        cdbiz.setStatus(ECdbizStatus.A17.getCode());
        cdbiz.setCurNodeCode(nextNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), preCurNodeCode, req.getSupplementNote(),
                req.getOperator());

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.Pledge, cdbiz.getCode(),
                req.getCode(), preCurNodeCode, nextNodeCode, req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saleManConfirm(XN632124Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preCurNodeCode = cdbiz.getCurNodeCode();
        if (!ENode.confirm_pledge_apply.getCode()
                .equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是内勤确认抵押申请节点，不能操作");
        }

        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                preCurNodeCode).getNextNode();

        // 业务员确认抵押
        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(req.getCode());
        carPledgeBO.saleManConfirm(carPledge, req);

        // 行驶证正面
        EAttachName pledgeUserIdCardFront = EAttachName.getMap().get(
                EAttachName.pledgeUserIdCardFront.getCode());
        attachmentBO.saveAttachment(carPledge.getBizCode(),
                pledgeUserIdCardFront.getCode(), pledgeUserIdCardFront.getValue(),
                req.getPledgeUserIdCardFront());
        // 行驶证反面
        EAttachName pledgeUserIdCardReverse = EAttachName.getMap().get(
                EAttachName.pledgeUserIdCardReverse.getCode());
        attachmentBO.saveAttachment(carPledge.getBizCode(),
                pledgeUserIdCardReverse.getCode(),
                pledgeUserIdCardReverse.getValue(),
                req.getPledgeUserIdCardReverse());

        // 更新业务状态
        cdbiz.setStatus(ECdbizStatus.A18.getCode());
        cdbiz.setCurNodeCode(nextNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), preCurNodeCode, null, req.getOperator());

        // 生成资料传递
        String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.FK_SEND_CAR_PLEDGE.getCode(),
                cdbiz.getCode(), cdbiz.getSaleUserId(), ENode.submit_3.getCode(),
                ENode.receive_approve_3.getCode(), null);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.LOGISTICS, logisticsCode,
                req.getCode(), preCurNodeCode, nextNodeCode, req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void entryPledgeInfo(XN632133Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        String preCurNodeCode = cdbiz.getCurNodeCode();
        if (!ENode.input_dy_info.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是业务员录入抵押信息节点，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(req.getCode());
        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                preCurNodeCode).getNextNode();

        // 录入抵押信息
        carPledgeBO.entryPledgeInfo(carPledge.getCode(), nextNodeCode, req);

        // 修改车辆信息
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        carInfo.setCarNumber(req.getCarNumber());
        carInfo.setCarSettleDatetime(
                DateUtil.strToDate(req.getCarSettleDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        carInfo.setSettleAddress(req.getSettleAddress());
        carInfoBO.refreshCarInfo(carInfo);

        // 添加附件
        attachmentBO.saveAttachment(cdbiz.getCode(),
                EAttachName.pledgeUserIdCardFront.getCode(), null,
                req.getPledgeUserIdCardFront());
        attachmentBO.saveAttachment(cdbiz.getCode(),
                EAttachName.pledgeUserIdCardReverse.getCode(), null,
                req.getPledgeUserIdCardReverse());
        attachmentBO.saveAttachment(cdbiz.getCode(), "car_regcerti", null,
                req.getCarRegcerti());
        attachmentBO.saveAttachment(cdbiz.getCode(), "car_pd", null,
                req.getCarPd());
        attachmentBO.saveAttachment(cdbiz.getCode(), "car_key", null,
                req.getCarKey());
        attachmentBO.saveAttachment(cdbiz.getCode(), "green_big_smj", null,
                req.getCarBigSmj());
        attachmentBO.saveAttachment(cdbiz.getCode(), "car_xsz_smj", null,
                req.getCarXszSmj());
        attachmentBO.saveAttachment(cdbiz.getCode(), "duty_paid_prove_smj",
                null, req.getDutyPaidProveSmj());

        // 更新业务状态
        cdbiz.setStatus(ECdbizStatus.A22.getCode());
        cdbiz.setCurNodeCode(nextNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.bank_push,
                cdbiz.getCode(), preCurNodeCode, null, req.getOperator());

        // 生成资料传递
        String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.SALE_SEND_CAR_PLEDGE.getCode(),
                cdbiz.getCode(), cdbiz.getSaleUserId(), ENode.submit_4.getCode(),
                ENode.receive_approve_4.getCode(), null);

        // 待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.LOGISTICS, logisticsCode,
                req.getCode(), preCurNodeCode, nextNodeCode, req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pledgeCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        String preCurNodeCode = cdbiz.getCurNodeCode();
        if (!ENode.to_commit_bank.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是抵押提交节点，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(code);
        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                cdbiz.getCurNodeCode()).getNextNode();

        // 抵押提交银行
        carPledgeBO.pledgeCommitBank(carPledge.getCode(), nextNodeCode, operator,
                pledgeBankCommitDatetime, pledgeBankCommitNote);

        // 更新业务状态
        cdbiz.setStatus(ECdbizStatus.A28.getCode());
        cdbiz.setCurNodeCode(nextNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 操作日志
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.bank_push,
                cdbiz.getCode(), preCurNodeCode, null, operator);

        // 待办事项
        bizTaskBO.handlePreBizTask(cdbiz.getCode(), EBizLogType.Pledge.getCode(), code,
                preCurNodeCode, operator);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmDone(String code, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ENode.dy_info_confirm_submit.getCode().equals(
                cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是抵押已提交节点，不能操作");
        }
        if (!ECdbizStatus.E3.getCode().equals(cdbiz.getEnterStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "第二次存档未完成，不能操作");
        }

        List<EnterFileList> enterFileListList = enterFileListBO
                .queryEnterFileListByBizCode(code);
        if (CollectionUtils.isEmpty(enterFileListList)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "入档清单不能为空");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(code);
        String nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(
                cdbiz.getCurNodeCode()).getNextNode();

        // 抵押确认完成
        carPledgeBO.confirmDone(carPledge.getCode(), nextNodeCode, operator);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        // bizTaskBO.saveBizTask(code, EBizLogType.Pledge, cdbiz.getCode(),
        // ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.bank_push,
                cdbiz.getCode(), nextNodeCode, null, operator);

    }

    @Override
    public Paginable<CarPledge> queryCarPledgePage(int start, int limit,
            CarPledge condition) {
        return carPledgeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CarPledge> queryCarPledgeList(CarPledge condition) {
        return carPledgeBO.queryCarPledgeList(condition);
    }

    @Override
    public CarPledge getCarPledge(String code) {
        return carPledgeBO.getCarPledge(code);
    }

    @Override
    public void inputPledgeInfo(XN632539Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ENode.input_budget.getCode().equals(cdbiz.getCurNodeCode())
                && !ENode.renew_budget.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是录入准入单资料节点，不能操作");
        }
        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(req.getCode());
        if (null == carPledge) {
            carPledgeBO.saveCarPledge(req.getCode(), req.getPledgeUser(),
                    req.getPledgeUserIdCard(), req.getPledgeAddress());
        } else {
            String code = carPledge.getCode();
            EntityUtils.copyData(req, carPledge);
            carPledge.setCode(code);
            carPledgeBO.refreshCarPledge(carPledge);
        }

        // 添加附件
        attachmentBO.saveAttachment(cdbiz.getCode(),
                EAttachName.pledgeUserIdCardFront.getCode(), null,
                req.getPledgeUserIdCardFront());
        attachmentBO.saveAttachment(cdbiz.getCode(),
                EAttachName.pledgeUserIdCardReverse.getCode(), null,
                req.getPledgeUserIdCardReverse());
    }

}
