package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICdbizDAO;
import com.cdkj.loan.dao.ICreditUserDAO;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import com.cdkj.loan.dto.req.XN798700Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.ECreditUserStatus;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.enums.ESystemCode;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.http.BizConnecter;
import com.cdkj.loan.http.JsonUtils;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CdbizBOImpl extends PaginableBOImpl<Cdbiz> implements ICdbizBO {

    @Autowired
    private ICdbizDAO cdbizDAO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private ICreditUserDAO creditUserDAO;

    static Logger logger = Logger.getLogger(CdbizBOImpl.class);

    @Override
    public List<Cdbiz> queryCdbizList(Cdbiz condition) {
        return cdbizDAO.selectList(condition);
    }

    @Override
    public void interview(Cdbiz cdbiz, XN632123Req req) {

        // 加入附件
        EAttachName attachName = EAttachName.bank_vedio;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getBankVideo());
        attachName = EAttachName.bank_photo;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getBankPhoto());
        attachName = EAttachName.company_vedio;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getCompanyVideo());
        attachName = EAttachName.company_contract;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getCompanyContract());
        attachName = EAttachName.bank_contract;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getBankContract());
        attachName = EAttachName.advance_fund_pdf;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getAdvanceFundAmountPdf());
        attachName = EAttachName.other_vedio;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getOtherVideo());
        attachName = EAttachName.interview_other_pdf;
        attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), req.getInterviewOtherPdf());

    }

    @Override
    public Cdbiz getCdbiz(String code) {
        Cdbiz data = null;
        if (StringUtils.isNotBlank(code)) {
            Cdbiz condition = new Cdbiz();
            condition.setCode(code);
            data = cdbizDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "业务不存在");
            }
        }
        return data;
    }

    @Override
    public Cdbiz getCdbizForUpdate(String code) {
        Cdbiz data = null;
        if (StringUtils.isNotBlank(code)) {
            Cdbiz condition = new Cdbiz();
            condition.setCode(code);
            data = cdbizDAO.selectForUpdate(condition);
            if (data == null) {
                throw new BizException("xn0000", "业务不存在");
            }
        }
        return data;
    }

    @Override
    public Cdbiz saveCdbiz(String bankCode, String bizType, Long dkAmount,
            SYSUser sysUser, BizTeam bizTeam, String node, String dealType,
            String remark) {
        String code = OrderNoGenerater
                .generate(EGeneratePrefix.Cdbiz.getCode());
        Cdbiz cdbiz = new Cdbiz();
        cdbiz.setCode(code);
        cdbiz.setBizCode(code);
        cdbiz.setBizType(bizType);
        cdbiz.setCompanyCode(sysUser.getCompanyCode());
        cdbiz.setTeamCode(bizTeam.getCode());
        cdbiz.setCaptainCode(bizTeam.getCaptain());
        cdbiz.setSaleUserId(sysUser.getUserId());
        cdbiz.setInsideJob(sysUser.getUserId());
        cdbiz.setLoanBank(bankCode);
        cdbiz.setLoanAmount(dkAmount);
        cdbiz.setApplyDatetime(new Date());
        String intevCurNodeCode = null;
        String status = null;
        String mqStatus = null;
        if (EDealType.SAVE.getCode().equals(dealType)) {
            status = ECdbizStatus.A0.getCode();
        } else {
            node = nodeFlowBO.getNodeFlowByCurrentNode(node).getNextNode();
            intevCurNodeCode = ENode.input_interview.getCode();

            status = ECdbizStatus.A1.getCode();
            mqStatus = ECdbizStatus.B00.getCode();
        }
        cdbiz.setCurNodeCode(node);
        cdbiz.setIntevCurNodeCode(intevCurNodeCode);
        cdbiz.setStatus(status);
        cdbiz.setIntevStatus(mqStatus);
        cdbiz.setCancelStatus(EBoolean.NO.getCode());

        cdbiz.setRemark(remark);
        cdbizDAO.insert(cdbiz);

        return cdbiz;
    }

    @Override
    public int refreshCdbiz(Cdbiz data) {
        return cdbizDAO.updateCdbiz(data);
    }

    @Override
    public int refreshCdbiz(Cdbiz cdbiz, XN632530Req req) {
        cdbiz.setIsAdvanceFund(req.getIsAdvanceFund());
        cdbiz.setIsGpsAz(req.getIsAzGps());
        cdbiz.setIsFinacing(req.getIsFinacing());
        cdbiz.setIsPlatInsure(req.getIsPlatInsure());
        return cdbizDAO.updateCdbiz(cdbiz);
    }

    @Override
    public int refreshCdbiz(Cdbiz cdbiz, XN632531Req req) {
        String code = cdbiz.getCode();
        EntityUtils.copyData(req, cdbiz);
        // 重置code
        cdbiz.setCode(code);
        return cdbizDAO.updateCdbiz(cdbiz);
    }

    @Override
    public void refreshStatus(Cdbiz cdbiz, String status) {
        cdbiz.setStatus(status);
        cdbizDAO.updateStatus(cdbiz);
    }

    @Override
    public void refreshStatus(Cdbiz cdbiz, String status, String remark) {
        cdbiz.setStatus(status);
        cdbiz.setRemark(remark);
        cdbizDAO.updateStatus(cdbiz);
    }

    @Override
    public void refreshMqStatus(Cdbiz cdbiz, String status) {
        cdbiz.setIntevStatus(status);
        cdbizDAO.updateMqStatus(cdbiz);
    }

    @Override
    public void refreshFbhgpsStatus(Cdbiz cdbiz, String status) {
        cdbiz.setFbhgpsStatus(status);
        cdbizDAO.updateFbhgpsStatus(cdbiz);
    }

    @Override
    public void refreshEnterNodeStatus(Cdbiz cdbiz, String status, String enterNodeCode) {
        cdbiz.setEnterStatus(status);
        cdbiz.setEnterNodeCode(enterNodeCode);
        cdbizDAO.updateEnterNodeStatus(cdbiz);
    }

    @Override
    public void refreshZfStatus(Cdbiz cdbiz, String status) {
        cdbiz.setCancelStatus(status);
        cdbizDAO.updateZfStatus(cdbiz);
    }

    @Override
    public List<Cdbiz> queryListByTeamCode(String teamCode) {
        Cdbiz condition = new Cdbiz();
        condition.setTeamCode(teamCode);
        List<Cdbiz> dataList = cdbizDAO.selectList(condition);
        return dataList;
    }

    @Override
    public List<Cdbiz> queryListByYwyUser(String ywyUser) {
        Cdbiz condition = new Cdbiz();
        List<Cdbiz> dataList = cdbizDAO.selectList(condition);
        return dataList;
    }

    @Override
    public void refreshYwy(Cdbiz cdbiz, String ywyUser) {
        cdbizDAO.updateStatus(cdbiz);
    }

    @Override
    public void refreshMakeCardStatus(Cdbiz cdbiz, String status) {
        cdbiz.setMakeCardStatus(status);
        cdbizDAO.updateMakeCardStatus(cdbiz);
    }

    @Override
    public void refreshCurNodeCode(Cdbiz cdbiz, String node) {
        cdbiz.setCurNodeCode(node);
        cdbizDAO.updateCurNodeCode(cdbiz);
    }

    @Override
    public void refreshIntevNodeStatus(Cdbiz cdbiz,
            String intevCurNodeCode, String mqStatus) {
        cdbiz.setIntevCurNodeCode(intevCurNodeCode);
        cdbiz.setIntevStatus(mqStatus);
        cdbizDAO.updateIntevNodeStatus(cdbiz);
    }

    @Override
    public void refreshInsideJob(Cdbiz cdbiz, String insideJob) {
        cdbiz.setInsideJob(insideJob);
        cdbizDAO.updateInsideJob(cdbiz);
    }

    @Override
    public Paginable<Cdbiz> getPaginableByRoleCode(Cdbiz condition, int start,
            int limit) {
        Long count = cdbizDAO.selectTotalCountByRoleCode(condition);
        Paginable<Cdbiz> page = new Page<Cdbiz>(start, limit, count);
        List<Cdbiz> dataList = cdbizDAO.selectListByRoleCode(condition,
                page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshCardAddress(Cdbiz cdbiz, String cardPostAddress) {
        cdbiz.setCardPostAddress(cardPostAddress);
        cdbizDAO.updateCdbiz(cdbiz);
    }

    @Override
    public void refreshMakeCardNode(Cdbiz cdbiz, String node) {
        cdbiz.setMakeCardNode(node);
        cdbizDAO.updateCdbiz(cdbiz);
    }

    @Override
    public void refreshRepayCard(Cdbiz cdbiz, String repayCardNumber) {
        cdbiz.setRepayCardNumber(repayCardNumber);
        cdbizDAO.updateCdbiz(cdbiz);

    }

    @Override
    public void refreshFbhgpsNodeStatus(Cdbiz cdbiz) {
        cdbizDAO.updateFbhgpsNodeStatus(cdbiz);
    }

    @Override
    public void creditIcBank(CreditUser creditUser) {
        Cdbiz cdbiz = getCdbiz(creditUser.getBizCode());
        CreditUser master = creditUserBO.getCreditUserByBizCode(
                cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);
        try {
            XN798700Req req = new XN798700Req();

            req.setOrderno(cdbiz.getCode());
            req.setMastername(master.getUserName());
            req.setCustname(creditUser.getUserName());
            req.setIdtype("000");
            req.setIdno(creditUser.getIdNo());
            req.setZoneno("3303");
            String relation = null;
            String idFront = null;
            String idReverse = null;
            String authPdf = null;
            if (ECreditUserLoanRole.APPLY_USER.getCode().equals(
                    creditUser.getLoanRole())) {
                relation = "本人";
                idFront = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.mainLoaner_id_front.getCode()).getUrl();
                idReverse = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.mainLoaner_id_reverse.getCode()).getUrl();
                authPdf = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.mainLoaner_auth_pdf.getCode()).getUrl();
            } else if (ECreditUserLoanRole.GHR.getCode().equals(
                    creditUser.getLoanRole())) {
                relation = "配偶";
                idFront = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.replier_id_front.getCode()).getUrl();
                idReverse = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.replier_id_reverse.getCode()).getUrl();
                authPdf = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.replier_auth_pdf.getCode()).getUrl();
            } else {
                relation = "反担保";
                idFront = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.assurance_id_front.getCode()).getUrl();
                idReverse = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.assurance_id_reverse.getCode()).getUrl();
                authPdf = attachmentBO.getAttachment(cdbiz.getCode(), null,
                        EAttachName.assurance_auth_pdf.getCode()).getUrl();
            }
            req.setRelation(relation);
            req.setIdNoFront(idFront);
            req.setIdNoReverse(idReverse);
            req.setAuthPdf(authPdf);
            req.setSystemCode(ESystemCode.HTWT.getCode());
            req.setCompanyCode(ESystemCode.HTWT.getCode());
            String icbankCode = BizConnecter.getBizData("798700",
                    JsonUtils.object2Json(req), String.class);
            creditUser.setIcbankCode(icbankCode);
            creditUser.setStatus(ECreditUserStatus.to_callback.getCode());
            creditUserDAO.updateIcbankCode(creditUser);
        } catch (Exception e) {
            logger.error("调用工行征信服务异常");
            throw new BizException("xn0000", "调用工行征信服务异常");
        }
    }

    @Override
    public void refreshCurNodeStatus(Cdbiz cdbiz) {
        cdbizDAO.updateCurNodeStatus(cdbiz);
    }

}
