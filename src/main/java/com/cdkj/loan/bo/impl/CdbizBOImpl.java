package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.IProductBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.Product;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.dto.req.XN798703Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBizType;
import com.cdkj.loan.enums.EReqBudgetNode;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private ICarInfoBO carInfoBO;

    @Autowired
    private ILoanProductBO loanProductBO;

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
        cdbiz.setCancelStatus(ECdbizStatus.G0.getCode());

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
    public void refreshEnterNodeStatus(Cdbiz cdbiz, String status,
            String enterNodeCode) {
        cdbiz.setEnterStatus(status);
        cdbiz.setEnterNodeCode(enterNodeCode);
        cdbizDAO.updateEnterNodeStatus(cdbiz);
    }

    @Override
    public void refreshZfStatus(Cdbiz cdbiz, String status, String cancelNode) {
        cdbiz.setCancelStatus(status);
        cdbiz.setCancelNodeCode(cancelNode);
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
    public void refreshIntevNodeStatus(Cdbiz cdbiz, String intevCurNodeCode,
            String mqStatus) {
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
    public void refreshCardAddress(Cdbiz cdbiz, String cardPostAddress, String cardPostProvince,
            String cardPostCity, String cardPostArea,String cardPostCode) {
        cdbiz.setCardPostAddress(cardPostAddress);
        cdbiz.setCardPostProvince(cardPostProvince);
        cdbiz.setCardPostCity(cardPostCity);
        cdbiz.setCardPostArea(cardPostArea);
        cdbiz.setCardPostCode(cardPostCode);
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
    public void icbankMakeCard(String code) {
        Cdbiz cdbiz = getCdbiz(code);
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(code);
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(code);
        LoanProduct loanProduct = loanProductBO.getLoanProduct(repayBiz.getLoanProductCode());
        CreditUser creditUser = creditUserBO
                .getCreditUserByBizCode(code, ECreditUserLoanRole.APPLY_USER);
        try {

            XN798703Req req = new XN798703Req();
            req.setZoneno("3303");
            //新车
            String type = "1";
            //二手车
            if (cdbiz.getType().equals("1")) {
                type = "907";
            }
            req.setBusitype(type);
            req.setOrderno(code);
            req.setLoanamount(Long.toString(cdbiz.getLoanAmount() / 1000));
            req.setTerm(repayBiz.getPeriods().toString());
            // 应收手续费=银行服务费+公证费+gps费+月供保证金+公司服务费+服务费
            Long amount = AmountUtil.mul(cdbiz.getLoanAmount(),
                    loanProduct.getPreRate());
            Long bankFee = AmountUtil.div(amount, (1.0 + loanProduct.getPreRate()));
            long feeAmount = (bankFee + carInfo.getAuthFee()
                    + carInfo.getGpsFee() + carInfo.getMonthDeposit()
                    + carInfo.getCompanyFee() + carInfo.getOtherFee());
            req.setFeeamount(Long.toString(feeAmount / 1000));
            //手续费率
            double feeRatio = feeAmount / cdbiz.getLoanAmount();
            req.setFeeratio(Double.toString(feeRatio * 100));
            req.setCarprice(
                    Long.toString(StringValidater.toLong(carInfo.getInvoicePrice()) / 1000));
            req.setLoanratio(repayBiz.getSfRate().toString());
            Attachment checkPic = attachmentBO
                    .getAttachment(cdbiz.getCode(), null, "special_quato_pic");
            if (null == checkPic) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "请在申请制卡时录入专项额度核定申请表");
            }
            req.setCheckPic(checkPic.getUrl());
            Attachment redCardPicWithIdPic = attachmentBO
                    .getAttachment(cdbiz.getCode(), null, "red_card_pic_with_id_pic");
            if (null == redCardPicWithIdPic) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "请在申请制卡时录入开卡申请表");
            }
            req.setApplicationForm(redCardPicWithIdPic.getUrl());
            req.setCustsort("000");
            req.setCustcode(creditUser.getIdNo());
            req.setChnsname(creditUser.getUserName());
            req.setEngname(creditUser.getEnglishName());
            String gender = "1";
            if ("女".equals(creditUser.getGender())) {
                gender = "2";
            }
            req.setSex(gender);
            req.setMrtlstat(creditUser.getMarryState());
            req.setEdulvl(creditUser.getEducation());
            //住宅地信息
            req.setHprovince(creditUser.getNowAddressProvince());
            req.setHcity(creditUser.getNowAddressCity());
            req.setHcounty(creditUser.getNowAddressArea());
            req.setHaddress(creditUser.getNowAddress());
            req.setHomezip(creditUser.getNowPostCode());
            req.setHphoneno("0");

            req.setMvblno(creditUser.getMobile());
            //单位信息
            req.setUnitname(creditUser.getCompanyName());
            req.setCophozono("0");
            req.setCophoneno(creditUser.getCompanyContactNo());
            req.setCophonext("0");
            req.setCprovince(creditUser.getCompanyProvince());
            req.setCcity(creditUser.getCompanyCity());
            req.setCcounty(creditUser.getCompanyArea());
            req.setCaddress(creditUser.getCompanyAddress());
            req.setCorpzip("0");
            req.setModelcode(creditUser.getWorkCompanyProperty());
            req.setOccptn(creditUser.getWorkProfession());
            //通讯地址（卡邮寄地址）
            req.setCommprov(cdbiz.getCardPostProvince());
            req.setCommcity(cdbiz.getCardPostCity());
            req.setCommcounty(cdbiz.getCardPostArea());
            req.setCommaddr(cdbiz.getCardPostAddress());
            req.setCommazip(cdbiz.getCardPostCode());
            //联系人信息
            req.setReltname1(creditUser.getEmergencyName1());
            req.setReltsex1(creditUser.getEmergencySex1());
            req.setReltship1(creditUser.getEmergencyRelation1());
            req.setReltmobl1(creditUser.getEmergencyMobile1());
            req.setReltphzon1("0");
            req.setReltname2(creditUser.getEmergencyName2());
            req.setReltsex2(creditUser.getEmergencySex2());
            req.setReltship2(creditUser.getEmergencyRelation2());
            req.setReltmobl2(creditUser.getEmergencyMobile2());
            req.setRtcophon2("0");

            req.setAccgetm("4");
            req.setMamobile(creditUser.getMobile());
            req.setSmsphone(creditUser.getMobile());
            req.setAuthref(creditUser.getAuthref());
            //日期格式修改(yyyymmdd)
            String[] date=creditUser.getStatdate().split("-");
            String statdate="";
            for(String dateString:date){
                statdate+=dateString;
            }
            req.setStatdate(statdate);
            req.setIndate(creditUser.getNowAddressDate());
            date=creditUser.getWorkDatetime().split("-");
            String workDatetime="";
            for(String dateString :date){
                workDatetime+=dateString;
            }
            req.setJoindate(workDatetime);
            req.setDrawmode("2");

            req.setMachgf("0");
            req.setEmladdrf("0");
            BizConnecter.getBizData("798703",
                    JsonUtils.object2Json(req), String.class);

        } catch (Exception e) {
            logger.error("调用工行制卡服务异常");
            throw new BizException("xn0000", "调用工行制卡服务异常");
        }
    }

    @Override
    public void refreshCurNodeStatus(Cdbiz cdbiz) {
        cdbizDAO.updateCurNodeStatus(cdbiz);
    }

    @Override
    public void refreshLocation(Cdbiz cdbiz) {
        cdbizDAO.updateCdbizLocation(cdbiz);
    }


}
