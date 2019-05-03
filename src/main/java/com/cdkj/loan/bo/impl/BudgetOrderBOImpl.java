package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dao.IBudgetOrderDAO;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EIDKind;
import com.cdkj.loan.enums.ELoanProductStatus;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BudgetOrderBOImpl extends PaginableBOImpl<BudgetOrder>
        implements IBudgetOrderBO {

    @Autowired
    private IBudgetOrderDAO budgetOrderDAO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    public String saveBudgetOrder(Credit credit,
            List<CreditUser> creditUserList) {
        CreditUser applyCreditUser = null;
        CreditUser ghrCreditUser = null;
        CreditUser guaCreditUser = null;
        for (CreditUser creditUser : creditUserList) {
            if (applyCreditUser == null && ECreditUserLoanRole.APPLY_USER.getCode()
                .equals(creditUser.getLoanRole())) {
                applyCreditUser = creditUser;
            }
            if (ghrCreditUser == null && ECreditUserLoanRole.GHR.getCode()
                .equals(creditUser.getLoanRole())) {
                ghrCreditUser = creditUser;
            }
            if (guaCreditUser == null && ECreditUserLoanRole.GUARANTOR.getCode()
                .equals(creditUser.getLoanRole())) {
                guaCreditUser = creditUser;
            }
        }

        String code = null;
        if (credit != null) {
            BudgetOrder data = new BudgetOrder();
            code = OrderNoGenerater
                .generate(EGeneratePrefix.BUDGETORDER.getCode());
            data.setBizCode(credit.getBizCode());
            data.setCode(code);
            data.setCreditCode(credit.getCode());
            data.setBizType(credit.getBizType());

            data.setLoanAmount(credit.getLoanAmount());
            data.setLoanBank(credit.getLoanBankCode());
            Bank bank = bankBO.getBank(credit.getLoanBankCode());
            data.setRepayBankCode(bank.getCode());
            data.setRepayBankName(bank.getBankName());

            data.setRepaySubbranch(bank.getSubbranch());
            data.setApplyUserName(applyCreditUser.getUserName());
            data.setMobile(applyCreditUser.getMobile());
            data.setIdNo(applyCreditUser.getIdNo());
            data.setIdKind(EIDKind.IDCard.getCode());

            // 共还人=配偶
            if (ghrCreditUser != null) {
                data.setMateName(ghrCreditUser.getUserName());
                data.setMateMobile(ghrCreditUser.getMobile());
                data.setMateIdNo(ghrCreditUser.getIdNo());
            }

            if (guaCreditUser != null) {
                data.setGuaName(guaCreditUser.getUserName());
                data.setGuaMobile(guaCreditUser.getMobile());
                data.setGuaIdNo(guaCreditUser.getIdNo());
            }

            data.setApplyDatetime(new Date());
            data.setCompanyCode(credit.getCompanyCode());
            data.setSaleUserId(credit.getSaleUserId());
            data.setInsideJob(credit.getInsideJob());
            data.setIsInterview(EBoolean.NO.getCode());
            data.setIsEntryMortgage(EBoolean.NO.getCode());
            data.setCurNodeCode(ENode.input_budget.getCode());
            data.setIntevCurNodeCode(ENode.input_interview.getCode());
            // 准入单插入团队编号 来自业务员的所属团队
            SYSUser user = sysUserBO.getUser(credit.getSaleUserId());
            data.setTeamCode(user.getTeamCode());
            data.setPledgeStatus(EBoolean.NO.getCode());
            data.setIsGpsAz(EBoolean.NO.getCode());
            data.setIsLogistics(EBoolean.NO.getCode());
            data.setIsMortgage(EBoolean.NO.getCode());
            budgetOrderDAO.insert(data);
        }
        return code;
    }

    @Override
    public void refreshBudgetOrder(BudgetOrder data, XN632120Req req) {
        if (StringUtils.isNotBlank(data.getCode())) {
            Long loanAmount = StringValidater.toLong(req.getLoanAmount());
            data.setLoanAmount(loanAmount);
            // 上架贷款产品信息
            if (StringUtils.isNotBlank(req.getLoanProductCode())) {
                LoanProduct loanProduct = loanProductBO
                    .getLoanProduct(req.getLoanProductCode());
                if (!ELoanProductStatus.PUBLISH_YES.getCode()
                    .equals(loanProduct.getStatus())) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "贷款商品未上架");
                }
                data.setLoanProductCode(loanProduct.getCode());
                data.setLoanProductName(loanProduct.getName());
                data.setRegion(req.getRegion());
                data.setLoanBank(loanProduct.getLoanBank());
                data.setGpsFee(StringValidater.toLong(req.getGpsFee()));
                data.setAuthFee(StringValidater.toLong(req.getAuthFee()));
                data.setOtherFee(StringValidater.toLong(req.getOtherFee()));
                if (EDealType.SEND.getCode().equals(req.getDealType())) {
                    // 银行服务费=前置*贷款额/（1+前置）
                    Long amount = AmountUtil.mul(loanAmount,
                        loanProduct.getPreRate());
                    data.setBankFee(AmountUtil.div(amount,
                        (1.0 + loanProduct.getPreRate())));
                    // 根据是否前置计算公司服务费
                    Long companyFee = null;
                    if (EBoolean.YES.getCode().equals(loanProduct.getIsPre())) {
                        companyFee = AmountUtil.mul(loanAmount,
                            loanProduct.getPreRate());
                    } else {
                        Long amount1 = AmountUtil.mul(loanAmount,
                            (loanProduct.getYearRate() * 3 - 0.09));
                        companyFee = AmountUtil.div(amount1,
                            loanProduct.getPreRate() + 1);
                    }
                    data.setCompanyFee(companyFee);
                }
            }

            data.setTeamFee(StringValidater.toLong(req.getTeamFee()));

            data.setBizType(req.getBizType());
            data.setLoanPeriod(req.getLoanPeriod());
            data.setVehicleCompanyName(req.getVehicleCompanyName());
            data.setInvoiceCompany(req.getInvoiceCompany());
            data.setCarBrand(req.getCarBrand());
            data.setCarSeries(req.getCarSeries());

            data.setCarModel(req.getCarModel());
            data.setCarModelName(req.getCarModelName());
            data.setCarType(req.getCarType());
            data.setCarPic(req.getCarPic());
            data.setCarHgzPic(req.getCarHgzPic());
            data.setDriveLicenseFront(req.getDriveLicenseFront());
            data.setDriveLicenseReverse(req.getDriveLicenseReverse());
            data.setEvaluateColumn(req.getEvaluateColumn());
            data.setCarFrameNo(req.getCarFrameNo());
            data.setCarEngineNo(req.getCarEngineNo());
            data.setOriginalPrice(
                StringValidater.toLong(req.getOriginalPrice()));
            data.setInvoicePrice(StringValidater.toLong(req.getInvoicePrice()));

            data.setCarColor(req.getCarColor());
            data.setMonthDeposit(StringValidater.toLong(req.getMonthDeposit()));
            data.setFirstAmount(StringValidater.toLong(req.getFirstAmount()));
            data.setFirstRate(StringValidater.toDouble(req.getFirstRate()));

            data.setSettleAddress(req.getSettleAddress());
            data.setApplyUserName(req.getApplyUserName());
            data.setGender(req.getGender());
            data.setAge(StringValidater.toInteger(req.getAge()));
            data.setMarryState(req.getMarryState());
            data.setPolitical(req.getPolitical());
            data.setNation(req.getNation());

            data.setEducation(req.getEducation());
            data.setIdKind(EIDKind.IDCard.getCode());
            data.setIdNo(req.getIdNo());
            data.setFamilyNumber(
                StringValidater.toInteger(req.getFamilyNumber()));
            data.setMobile(req.getMobile());

            data.setNowAddress(req.getNowAddress());
            data.setIsCardMailAddress(req.getIsCardMailAddress());
            data.setPostCode1(req.getPostCode1());
            data.setResidenceAddress(req.getResidenceAddress());
            data.setPostCode2(req.getPostCode2());
            data.setFamilyMainAsset(req.getFamilyMainAsset());
            data.setMainAssetInclude(req.getMainAssetInclude());

            data.setMainIncome(req.getMainIncome());
            data.setWorkCompanyName(req.getWorkCompanyName());
            data.setWorkCompanyAddress(req.getWorkCompanyAddress());
            data.setWorkIsCardMailAddress(req.getWorkIsCardMailAddress());
            data.setWorkCompanyProperty(req.getWorkCompanyProperty());
            data.setWorkBelongIndustry(req.getWorkBelongIndustry());
            data.setWorkProfession(req.getWorkProfession());
            data.setWorkDatetime(req.getWorkDatetime());
            data.setSelfCompanyArea(req.getSelfCompanyArea());
            data.setOtherWorkNote(req.getOtherWorkNote());
            data.setWorkAssetPdf(req.getWorkAssetPdf());
            data.setEmployeeQuantity(
                StringValidater.toInteger(req.getEmployeeQuantity()));

            data.setEnterpriseMonthOutput(req.getEnterpriseMonthOutput());
            data.setPosition(req.getPosition());
            data.setPostTitle(req.getPostTitle());
            data.setMonthIncome(req.getMonthIncome());
            data.setMateName(req.getMateName());

            data.setMateMobile(req.getMateMobile());
            data.setMateIdNo(req.getMateIdNo());
            data.setMateEducation(req.getMateEducation());
            data.setMateCompanyName(req.getMateCompanyName());
            data.setMateCompanyAddress(req.getMateCompanyAddress());
            data.setMateCompanyContactNo(req.getMateCompanyContactNo());

            data.setMateZfbJourDatetimeStart(
                DateUtil.strToDate(req.getMateZfbJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setMateZfbJourDatetimeEnd(
                DateUtil.strToDate(req.getMateZfbJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setMateZfbJourInterest1(req.getMateZfbJourInterest1());
            data.setMateZfbJourInterest2(req.getMateZfbJourInterest2());
            data.setMateZfbInterest1(
                StringValidater.toLong(req.getMateZfbInterest1()));
            data.setMateZfbInterest2(
                StringValidater.toLong(req.getMateZfbInterest2()));

            data.setMateZfbJourIncome(
                StringValidater.toLong(req.getMateZfbJourIncome()));
            data.setMateZfbJourExpend(
                StringValidater.toLong(req.getMateZfbJourExpend()));
            data.setMateZfbJourBalance(
                StringValidater.toLong(req.getMateZfbJourBalance()));
            data.setMateZfbJourMonthIncome(
                StringValidater.toLong(req.getMateZfbJourMonthIncome()));
            data.setMateZfbJourMonthExpend(
                StringValidater.toLong(req.getMateZfbJourMonthExpend()));

            data.setMateZfbJourPic(req.getMateZfbJourPic());
            data.setMateZfbJourRemark(req.getMateZfbJourRemark());

            data.setMateWxJourDatetimeStart(
                DateUtil.strToDate(req.getMateWxJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setMateWxJourDatetimeEnd(
                DateUtil.strToDate(req.getMateWxJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setMateWxJourInterest1(req.getMateWxJourInterest1());
            data.setMateWxJourInterest2(req.getMateWxJourInterest2());
            data.setMateWxInterest1(
                StringValidater.toLong(req.getMateWxInterest1()));
            data.setMateWxInterest2(
                StringValidater.toLong(req.getMateWxInterest2()));

            data.setMateWxJourIncome(
                StringValidater.toLong(req.getMateWxJourIncome()));
            data.setMateWxJourExpend(
                StringValidater.toLong(req.getMateWxJourExpend()));
            data.setMateWxJourBalance(
                StringValidater.toLong(req.getMateWxJourBalance()));
            data.setMateWxJourMonthIncome(
                StringValidater.toLong(req.getMateWxJourMonthIncome()));
            data.setMateWxJourMonthExpend(
                StringValidater.toLong(req.getMateWxJourMonthExpend()));
            data.setMateWxJourPic(req.getMateWxJourPic());
            data.setMateWxJourRemark(req.getMateWxJourRemark());

            data.setMateJourDatetimeStart(
                DateUtil.strToDate(req.getMateJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setMateJourDatetimeEnd(
                DateUtil.strToDate(req.getMateJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setMateJourInterest1(req.getMateJourInterest1());
            data.setMateJourInterest2(req.getMateJourInterest2());
            data.setMateInterest1(
                StringValidater.toLong(req.getMateInterest1()));
            data.setMateInterest2(
                StringValidater.toLong(req.getMateInterest2()));

            data.setMateJourIncome(
                StringValidater.toLong(req.getMateJourIncome()));
            data.setMateJourExpend(
                StringValidater.toLong(req.getMateJourExpend()));
            data.setMateJourBalance(
                StringValidater.toLong(req.getMateJourBalance()));
            data.setMateJourMonthIncome(
                StringValidater.toLong(req.getMateJourMonthIncome()));
            data.setMateJourMonthExpend(
                StringValidater.toLong(req.getMateJourMonthExpend()));

            data.setMateJourPic(req.getMateJourPic());
            data.setMateJourRemark(req.getMateJourRemark());
            data.setMateAssetPdf(req.getMateAssetPdf());

            data.setGuaName(req.getGuaName());
            data.setGuaMobile(req.getGuaMobile());
            data.setGuaIdNo(req.getGuaIdNo());
            data.setGuaPhone(req.getGuaPhone());
            data.setGuaCompanyName(req.getGuaCompanyName());

            data.setGuaCompanyAddress(req.getGuaCompanyAddress());
            data.setGuaHouseAssetAddress(req.getGuaHouseAssetAddress());

            data.setGuaZfbJourDatetimeStart(
                DateUtil.strToDate(req.getGuaZfbJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setGuaZfbJourDatetimeEnd(
                DateUtil.strToDate(req.getGuaZfbJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setGuaZfbJourInterest1(req.getGuaZfbJourInterest1());
            data.setGuaZfbJourInterest2(req.getGuaZfbJourInterest2());
            data.setGuaZfbInterest1(
                StringValidater.toLong(req.getGuaZfbInterest1()));
            data.setGuaZfbInterest2(
                StringValidater.toLong(req.getGuaZfbInterest2()));

            data.setGuaZfbJourIncome(
                StringValidater.toLong(req.getGuaZfbJourIncome()));
            data.setGuaZfbJourExpend(
                StringValidater.toLong(req.getGuaZfbJourExpend()));
            data.setGuaZfbJourBalance(
                StringValidater.toLong(req.getGuaZfbJourBalance()));
            data.setGuaZfbJourMonthIncome(
                StringValidater.toLong(req.getGuaZfbJourMonthIncome()));
            data.setGuaZfbJourMonthExpend(
                StringValidater.toLong(req.getGuaZfbJourMonthExpend()));

            data.setGuaZfbJourPic(req.getGuaZfbJourPic());
            data.setGuaZfbJourRemark(req.getGuaZfbJourRemark());

            data.setGuaWxJourDatetimeStart(
                DateUtil.strToDate(req.getGuaWxJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setGuaWxJourDatetimeEnd(
                DateUtil.strToDate(req.getGuaWxJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setGuaWxJourInterest1(req.getGuaWxJourInterest1());
            data.setGuaWxJourInterest2(req.getGuaWxJourInterest2());
            data.setGuaWxInterest1(
                StringValidater.toLong(req.getGuaWxInterest1()));
            data.setGuaWxInterest2(
                StringValidater.toLong(req.getGuaWxInterest2()));

            data.setGuaWxJourIncome(
                StringValidater.toLong(req.getGuaWxJourIncome()));
            data.setGuaWxJourExpend(
                StringValidater.toLong(req.getGuaWxJourExpend()));
            data.setGuaWxJourBalance(
                StringValidater.toLong(req.getGuaWxJourBalance()));
            data.setGuaWxJourMonthIncome(
                StringValidater.toLong(req.getGuaWxJourMonthIncome()));
            data.setGuaWxJourMonthExpend(
                StringValidater.toLong(req.getGuaWxJourMonthExpend()));

            data.setGuaWxJourPic(req.getGuaWxJourPic());
            data.setGuaWxJourRemark(req.getGuaWxJourRemark());

            data.setGuaJourDatetimeStart(
                DateUtil.strToDate(req.getGuaJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setGuaJourDatetimeEnd(
                DateUtil.strToDate(req.getGuaJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setGuaJourInterest1(req.getGuaJourInterest1());
            data.setGuaJourInterest2(req.getGuaJourInterest2());
            data.setGuaInterest1(StringValidater.toLong(req.getGuaInterest1()));
            data.setGuaInterest2(StringValidater.toLong(req.getGuaInterest2()));

            data.setGuaJourIncome(
                StringValidater.toLong(req.getGuaJourIncome()));
            data.setGuaJourExpend(
                StringValidater.toLong(req.getGuaJourExpend()));
            data.setGuaJourBalance(
                StringValidater.toLong(req.getGuaJourBalance()));
            data.setGuaJourMonthIncome(
                StringValidater.toLong(req.getGuaJourMonthIncome()));
            data.setGuaJourMonthExpend(
                StringValidater.toLong(req.getGuaJourMonthExpend()));

            data.setGuaJourPic(req.getGuaJourPic());
            data.setGuaJourRemark(req.getGuaJourRemark());
            data.setGuaAssetPdf(req.getGuaAssetPdf());

            data.setEmergencyName1(req.getEmergencyName1());
            data.setEmergencyRelation1(req.getEmergencyRelation1());
            data.setEmergencyMobile1(req.getEmergencyMobile1());

            data.setEmergencyName2(req.getEmergencyName2());
            data.setEmergencyRelation2(req.getEmergencyRelation2());
            data.setEmergencyMobile2(req.getEmergencyMobile2());
            data.setZfbJourDatetimeStart(
                DateUtil.strToDate(req.getZfbJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setZfbJourDatetimeEnd(
                DateUtil.strToDate(req.getZfbJourDatetimeEnd(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setZfbJourInterest1(req.getZfbJourInterest1());
            data.setZfbJourInterest2(req.getZfbJourInterest2());
            data.setZfbInterest1(StringValidater.toLong(req.getZfbInterest1()));
            data.setZfbInterest2(StringValidater.toLong(req.getZfbInterest2()));

            data.setZfbJourIncome(
                StringValidater.toLong(req.getZfbJourIncome()));
            data.setZfbJourExpend(
                StringValidater.toLong(req.getZfbJourExpend()));
            data.setZfbJourBalance(
                StringValidater.toLong(req.getZfbJourBalance()));
            data.setZfbJourMonthIncome(
                StringValidater.toLong(req.getZfbJourMonthIncome()));
            data.setZfbJourMonthExpend(
                StringValidater.toLong(req.getZfbJourMonthExpend()));

            data.setZfbJourPic(req.getZfbJourPic());
            data.setZfbJourRemark(req.getZfbJourRemark());
            data.setWxJourDatetimeStart(
                DateUtil.strToDate(req.getWxJourDatetimeStart(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setWxJourDatetimeEnd(DateUtil.strToDate(
                req.getWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setWxJourInterest1(req.getWxJourInterest1());
            data.setWxJourInterest2(req.getWxJourInterest2());
            data.setWxInterest1(StringValidater.toLong(req.getWxInterest1()));
            data.setWxInterest2(StringValidater.toLong(req.getWxInterest2()));

            data.setWxJourIncome(StringValidater.toLong(req.getWxJourIncome()));
            data.setWxJourExpend(StringValidater.toLong(req.getWxJourExpend()));
            data.setWxJourBalance(
                StringValidater.toLong(req.getWxJourBalance()));
            data.setWxJourMonthIncome(
                StringValidater.toLong(req.getWxJourMonthIncome()));
            data.setWxJourMonthExpend(
                StringValidater.toLong(req.getWxJourMonthExpend()));

            data.setWxJourPic(req.getWxJourPic());
            data.setWxJourRemark(req.getWxJourRemark());
            data.setJourDatetimeStart(DateUtil.strToDate(
                req.getJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setJourDatetimeEnd(DateUtil.strToDate(req.getJourDatetimeEnd(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
            data.setJourInterest1(req.getJourInterest1());
            data.setJourInterest2(req.getJourInterest2());
            data.setInterest1(StringValidater.toLong(req.getInterest1()));
            data.setInterest2(StringValidater.toLong(req.getInterest2()));

            data.setJourIncome(StringValidater.toLong(req.getJourIncome()));
            data.setJourExpend(StringValidater.toLong(req.getJourExpend()));
            data.setJourBalance(StringValidater.toLong(req.getJourBalance()));
            data.setJourMonthIncome(
                StringValidater.toLong(req.getJourMonthIncome()));
            data.setJourMonthExpend(
                StringValidater.toLong(req.getJourMonthExpend()));

            data.setJourPic(req.getJourPic());
            data.setJourRemark(req.getJourRemark());
            data.setAssetPdf(req.getAssetPdf());
            data.setHouseContract(req.getHouseContract());
            data.setHousePicture(req.getHousePicture());
            data.setHkBookPdf(req.getHkBookPdf());
            data.setIdCardPdf(req.getIdCardPdf());
            data.setMarryPdf(req.getMarryPdf());
            data.setOtherPdf(req.getOtherPdf());
            data.setIsAdvanceFund(req.getIsAdvanceFund());
            data.setPledgeUser(req.getPledgeUser());
            data.setPledgeUserIdCardCopy(req.getPledgeUserIdCardCopy());
            data.setPledgeAddress(req.getPledgeAddress());
            //data.setIsFinancing(req.getIsFinancing());
            String preNodeCode = data.getCurNodeCode(); // 当前节点
            if (EDealType.SEND.getCode().equals(req.getDealType())) {
                // 下一个节点
                data.setCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(preNodeCode).getNextNode());
            }
            budgetOrderDAO.update(data);
        }
    }

    @Override
    public void refreshAreaApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterAreaApprove(data);
        }
    }

    @Override
    public void refreshriskApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterIskApprove(data);
        }
    }

    @Override
    public void refreshriskChargeApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterIskChargeApprove(data);
        }
    }

    @Override
    public void interview(BudgetOrder budgetOrder, XN632123Req req) {

        budgetOrder.setBankVideo(req.getBankVideo());
        budgetOrder.setBankPhoto(req.getBankPhoto());
        budgetOrder.setCompanyVideo(req.getCompanyVideo());
        budgetOrder.setCompanyContract(req.getCompanyContract());
        budgetOrder.setBankContract(req.getBankContract());
        budgetOrder.setAdvanceFundAmountPdf(req.getAdvanceFundAmountPdf());
        budgetOrder.setOtherVideo(req.getOtherVideo());
        budgetOrder.setInterviewOtherPdf(req.getInterviewOtherPdf());

        // 加入附件
        EAttachName attachName = EAttachName.bank_vedio;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(), req.getBankVideo());
        attachName = EAttachName.bank_photo;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(), req.getBankPhoto());
        attachName = EAttachName.company_vedio;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(), req.getCompanyVideo());
        attachName = EAttachName.company_contract;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(),
            req.getCompanyContract());
        attachName = EAttachName.bank_contract;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(), req.getBankContract());
        attachName = EAttachName.advance_fund_pdf;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(),
            req.getAdvanceFundAmountPdf());
        attachName = EAttachName.other_vedio;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(), req.getOtherVideo());
        attachName = EAttachName.interview_other_pdf;
        attachmentBO.saveAttachment(budgetOrder.getBizCode(),
            attachName.getCode(), attachName.getValue(),
            req.getInterviewOtherPdf());

        budgetOrderDAO.updaterInterview(budgetOrder);
    }

    @Override
    public void refreshInterviewInternal(BudgetOrder data) {
        budgetOrderDAO.updaterInterviewInternal(data);
    }

    @Override
    public void refreshbizChargeApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterBizChargeApprove(data);
        }
    }

    @Override
    public void advancefund(BudgetOrder budgetOrder, Date advanceFundDatetime,
            Long advanceFundAmount, String billPdf, String advanceNote) {
        if (StringUtils.isNotBlank(budgetOrder.getCode())) {
            budgetOrder.setAdvanceFundDatetime(advanceFundDatetime);
            budgetOrder.setAdvanceFundAmount(advanceFundAmount);
            budgetOrder.setBillPdf(billPdf);
            budgetOrder.setAdvanceNote(advanceNote);

            // 下个节点设置
            budgetOrder.setAdvanfCurNodeCode(ENode.input_fbh.getCode());
            budgetOrderDAO.updaterAdvancefund(budgetOrder);

            EAttachName attachName = EAttachName.water_bill;
            attachmentBO.saveAttachment(budgetOrder.getBizCode(),
                attachName.getCode(), attachName.getValue(), billPdf);
        }
    }

    @Override
    public void residentMortgageApply(BudgetOrder budgetOrder) {
        budgetOrderDAO.residentMortgageApply(budgetOrder);
    }

    @Override
    public void insidejobConfirm(BudgetOrder budgetOrder) {
        budgetOrderDAO.insidejobConfirm(budgetOrder);
    }

    @Override
    public void refreshGpsManagerApprove(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterGpsManagerApprove(data);
        }
    }

    @Override
    public void installGps(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterInstallGps(data);
        }
    }

    @Override
    public void carSettle(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterCarSettle(data);
        }
    }

    @Override
    public void refreshCommitBank(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterCommitBank(data);
        }
    }

    @Override
    public void refreshEntryFk(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterEntryFk(data);
        }
    }

    @Override
    public void refreshConfirmReceipt(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterConfirmReceipt(data);
        }
    }

    @Override
    public void entryMortgage(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterEntryMortgage(data);
        }
    }

    @Override
    public void refreshMortgageCommitBank(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterMortgageCommitBank(data);
        }
    }

    @Override
    public void refreshMortgageFinish(BudgetOrder data) {
        if (StringUtils.isNotBlank(data.getCode())) {
            budgetOrderDAO.updaterMortgageFinish(data);
        }
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderList(BudgetOrder condition) {
        return budgetOrderDAO.selectList(condition);
    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        BudgetOrder data = null;
        if (StringUtils.isNotBlank(code)) {
            BudgetOrder condition = new BudgetOrder();
            condition.setCode(code);
            data = budgetOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "预算单不存在！！");
            }
        }
        return data;
    }

    @Override
    public BudgetOrder getBudgetOrderByRepayBizCode(String repayBizCode) {
        BudgetOrder data = null;
        if (StringUtils.isNotBlank(repayBizCode)) {
            BudgetOrder condition = new BudgetOrder();
            condition.setRepayBizCode(repayBizCode);
            data = budgetOrderDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "预算单不存在！！");
            }
        }
        return data;
    }

    @Override
    public int archiveSuccess(BudgetOrder budgetOrder, String repayBizCode,
            String userId) {
        int count = 0;
        if (budgetOrder != null) {
            budgetOrder.setRepayBizCode(repayBizCode);
            budgetOrder.setApplyUserId(userId);
            count = budgetOrderDAO.updateArchiveSuccess(budgetOrder);
        }
        return count;
    }

    @Override
    public String logicOrderLoan(String code, String operator,
            String approveResult) {
        String result = EBoolean.NO.getCode();

        BudgetOrder budgetOrder = getBudgetOrder(code);
        String preCurNodeCode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        // 状态为不在物流传递中
        budgetOrder.setIsLogistics(EBoolean.NO.getCode());

        // 准入单日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurNodeCode,
            budgetOrder.getIntevCurNodeCode(), null, operator);

        if (EBoolean.YES.getCode().equals(approveResult)) {

        } else {

            budgetOrder.setIsLogistics(EBoolean.YES.getCode());

            String newLogisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.BANK_LOAN.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                nodeFlow.getCurrentNode(), nodeFlow.getNextNode(), null);

            sysBizLogBO.saveSYSBizLog(code, EBizLogType.LOGISTICS,
                newLogisticsCode, budgetOrder.getIntevCurNodeCode());
        }

        if (EBudgetOrderNode.INTERVIEW_INTERNAL_APPROVE.getCode()
            .equals(nodeFlow.getCurrentNode())
                || EBudgetOrderNode.DHAPPROVEDATA.getCode()
                    .equals(nodeFlow.getCurrentNode())
                || EBudgetOrderNode.RISK_CONTROLLER_APPROVE.getCode()
                    .equals(nodeFlow.getCurrentNode())) {
            String newLogisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.BANK_LOAN.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                nodeFlow.getCurrentNode(), nodeFlow.getNextNode(), null);

            // 资料传递日志
            sysBizLogBO.saveSYSBizLog(code, EBizLogType.LOGISTICS,
                newLogisticsCode, budgetOrder.getIntevCurNodeCode());
            result = EBoolean.YES.getCode();

        }
        budgetOrderDAO.updaterLogicNode(budgetOrder);

        return result;
    }

    /** 
     * @see com.cdkj.loan.bo.IBudgetOrderBO#logicOrder(com.cdkj.loan.domain.BudgetOrder)
     */
    @Override
    public String logicOrderMortgage(String code, String operator) {
        String result = EBoolean.NO.getCode();

        BudgetOrder budgetOrder = getBudgetOrder(code);
        String preCurNodeCode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        // 状态为不在物流传递中
        budgetOrder.setIsLogistics(EBoolean.NO.getCode());
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
            EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurNodeCode,
            budgetOrder.getCurNodeCode(), null, operator);

        if (EBudgetOrderNode.YWDH_APPROVE.getCode()
            .equals(nodeFlow.getCurrentNode())) {
            String newLogisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.CAR_MORTGAGE.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                nodeFlow.getCurrentNode(), nodeFlow.getNextNode(), null);
            // 产生物流单后改变状态为物流传递中
            // budgetOrder.setIsLogistics(EBoolean.YES.getCode());

            // 资料传递日志
            sysBizLogBO.saveSYSBizLog(code, EBizLogType.LOGISTICS,
                newLogisticsCode, budgetOrder.getCurNodeCode());
            result = EBoolean.YES.getCode();

        }
        budgetOrderDAO.updaterLogicNode(budgetOrder);

        return result;
    }

    @Override
    public Paginable<BudgetOrder> getPaginableByRoleCode(int start,
            int pageSize, BudgetOrder condition) {
        prepare(condition);
        long totalCount = budgetOrderDAO.selectTotalCountByRoleCode(condition);
        Paginable<BudgetOrder> page = new Page<BudgetOrder>(start, pageSize,
            totalCount);
        List<BudgetOrder> dataList = budgetOrderDAO
            .selectBudgetOrderByRoleCodeList(condition, page.getStart(),
                page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public List<BudgetOrder> getPaginableByDz(BudgetOrder condition) {
        return budgetOrderDAO.selectBudgetOrderByDzList(condition);
    }

    @Override
    public void saveBackAdvanceFund(BudgetOrder budgetOrder) {

        budgetOrderDAO.insertBackAdvanceFund(budgetOrder);

    }

    @Override
    public void confirmBackAdvanceFund(BudgetOrder budgetOrder) {
        budgetOrderDAO.confirmBackAdvanceFund(budgetOrder);
    }

    @Override
    public void applyCancel(BudgetOrder budgetOrder) {

        budgetOrderDAO.applyCancel(budgetOrder);

    }

    @Override
    public void cancelBizAudit(BudgetOrder budgetOrder) {
        budgetOrderDAO.cancelBizAudit(budgetOrder);
    }

    @Override
    public void cancelFinanceAudit(BudgetOrder budgetOrder) {
        budgetOrderDAO.cancelFinanceAudit(budgetOrder);
    }

    @Override
    public void dataSupplement(BudgetOrder budgetOrder) {
        budgetOrderDAO.dataSupplement(budgetOrder);
    }

    @Override
    public void updateIsLogistics(BudgetOrder budgetOrder) {
        budgetOrderDAO.updateIsLogistics(budgetOrder);
    }

    @Override
    public Paginable<BudgetOrder> getPaginableByTeamCode(int start, int limit,
            BudgetOrder condition) {
        prepare(condition);
        long totalCount = budgetOrderDAO.selectTotalCountByTeamCode(condition);
        Paginable<BudgetOrder> page = new Page<BudgetOrder>(start, limit,
            totalCount);
        List<BudgetOrder> dataList = budgetOrderDAO
            .selectBudgetOrderListByTeamCode(condition, page.getStart(),
                page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderByApplyUserName(
            BudgetOrder condition) {
        return budgetOrderDAO.queryBudgetOrderByApplyUserName(condition);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByUserId(int start,
            int limit, BudgetOrder condition) {
        prepare(condition);
        long totalCount = budgetOrderDAO.selectTotalCountByUserId(condition);
        Paginable<BudgetOrder> page = new Page<BudgetOrder>(start, limit,
            totalCount);
        List<BudgetOrder> dataList = budgetOrderDAO
            .selectBudgetOrderListByUserId(condition, page.getStart(),
                page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshBudgetOrderCurNode(BudgetOrder budgetOrder) {
        budgetOrderDAO.updateCurNodeCode(budgetOrder);
    }

    @Override
    public BudgetOrder getBudgetOrderByBizCode(String bizCode) {
        BudgetOrder condition = new BudgetOrder();
        condition.setBizCode(bizCode);
        return budgetOrderDAO.select(condition);
    }

}
