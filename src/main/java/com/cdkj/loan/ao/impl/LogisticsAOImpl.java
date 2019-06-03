package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.IBankLoanBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSRole;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资料传递
 *
 * @author: silver
 * @since: 2018年5月29日 下午11:05:24
 * @history:
 */
@Service
public class LogisticsAOImpl implements ILogisticsAO {

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IGpsApplyBO gpsApplyBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSRoleBO sysRoleBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IBankLoanBO bankLoanBO;

    @Autowired
    private ICarPledgeBO carPledgeBO;

    @Override
    @Transactional(rollbackFor = BizException.class)
    public void sendLogistics(XN632150Req req) {

        Logistics logistics = logisticsBO.getLogistics(req.getCode());

        if (!ELogisticsStatus.TO_SEND.getCode().equals(logistics.getStatus())
                && !ELogisticsStatus.TO_SEND_AGAIN.getCode()
                .equals(logistics.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是待发货状态!");
        }

        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            if (logistics.getReceiver().equals(req.getOperator())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "gps申领人不能发件！");
            }
        }

        if (ELogisticsType.BUDGET.getCode().equals(logistics.getType())
                && StringUtils.isBlank(req.getFilelist())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "材料清单不能为空！");
        }

        // 发件
        logisticsBO.sendLogistics(req);

        switch (ELogisticsType.matchCode(logistics.getType())) {
            case GPS:
                gpsApplyBO.sendGps(logistics.getBizCode(), DateUtil.strToDate(
                        req.getSendDatetime(), DateUtil.DATA_TIME_PATTERN_1));
                break;

            case BUDGET:

                Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());

                if (logistics.getFromNodeCode().equals(ENode.submit_1.getCode())
                        && logistics.getToNodeCode().equals(ENode.receive_approve_1.getCode())) {
                    if (!ENode.submit_1.getCode().equals(cdbiz.getCurNodeCode())
                            && !ENode.re_submit_1.getCode().equals(cdbiz.getCurNodeCode())) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                                "未到银行放款环节，不能发件");
                    }
                }
                // 如果收件节点是待担保公司收件（车辆抵押）或提交银行（车辆抵押）
                if (logistics.getFromNodeCode().equals(ENode.submit_6.getCode())
                        && logistics.getToNodeCode().equals(ENode.receive_6.getCode())) {

                    if (!ENode.first_archive.getCode().equals(cdbiz.getEnterNodeCode())) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(), "第一次未入档，不能发件！");
                    }

                    cdbizBO.refreshEnterNodeStatus(cdbiz, ECdbizStatus.E1.getCode(),
                            ENode.receive_6.getCode());

                    // 日志记录
                    sysBizLogBO.saveNewSYSBizLog(cdbiz.getCode(), EBizLogType.LOGISTICS,
                            req.getCode(), ENode.submit_6.getCode(), req.getSendNote(),
                            req.getOperator());
//                    sysBizLogBO.saveSYSBizLog(cdbiz.getCode(), EBizLogType.LOGISTICS, req.getCode(),
//                            ENode.submit_6.getCode());

                    // 待办事项
                    bizTaskBO.handlePreAndAdd(EBizLogType.LOGISTICS, req.getCode(),
                            cdbiz.getCode(), ENode.submit_6.getCode(), ENode.receive_6.getCode(),
                            req.getOperator());
//                    bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.LOGISTICS, req.getCode(),
//                            ENode.receive_6);
                } else if (logistics.getFromNodeCode().equals(ENode.submit_2.getCode())
                        && logistics.getToNodeCode().equals(ENode.receive_2.getCode())) {

                    cdbizBO.refreshEnterNodeStatus(cdbiz, ECdbizStatus.D1.getCode(),
                            ENode.receive_2.getCode());

                    // 日志记录
                    sysBizLogBO.saveNewSYSBizLog(cdbiz.getCode(), EBizLogType.LOGISTICS,
                            req.getCode(), ENode.submit_2.getCode(), req.getSendNote(),
                            req.getOperator());

                    // 待办事项
                    bizTaskBO.handlePreAndAdd(EBizLogType.LOGISTICS, req.getCode(),
                            cdbiz.getCode(), ENode.submit_2.getCode(), ENode.receive_2.getCode(),
                            req.getOperator());
                } else {

                    String preCurNodeCode = cdbiz.getCurNodeCode();
                    String nextNodeCode = nodeFlowBO
                            .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode())
                            .getNextNode();

                    switch (ENode.matchCode(cdbiz.getCurNodeCode())) {
                        // 1、业务员寄送银行放款材料
                        // 2、业务员重寄材料（银行放款）
                        case submit_1:
                        case re_submit_1:
                            cdbiz.setStatus(ECdbizStatus.A11.getCode());
                            cdbiz.setCurNodeCode(nextNodeCode);
                            cdbizBO.refreshCurNodeStatus(cdbiz);
                            break;

                        // 1、风控寄抵押合同
                        // 2、风控重寄抵押合同
                        case submit_3:
                        case re_submit_3:
                            cdbiz.setStatus(ECdbizStatus.A19.getCode());
                            cdbiz.setCurNodeCode(nextNodeCode);
                            cdbizBO.refreshCurNodeStatus(cdbiz);
                            break;

                        // 1、业务员寄送材料（车辆抵押）
                        // 2、业务员重寄送材料（车辆抵押）
                        case submit_4:
                        case re_submit_4:
                            cdbiz.setStatus(ECdbizStatus.A23.getCode());
                            cdbiz.setCurNodeCode(nextNodeCode);
                            cdbizBO.refreshCurNodeStatus(cdbiz);
                            break;

                        // 风控审核通过（车辆抵押）
                        case submit_5:
                            cdbiz.setStatus(ECdbizStatus.A26.getCode());
                            cdbiz.setCurNodeCode(nextNodeCode);
                            cdbizBO.refreshCurNodeStatus(cdbiz);
                            break;

                        // 待风控寄件（车辆抵押）
//                        case submit_6:
//                            if (!ENode.first_archive.getCode()
//                                    .equals(cdbiz.getEnterNodeCode())) {
//                                throw new BizException(
//                                        EBizErrorCode.DEFAULT.getCode(),
//                                        "第一次存档未完成，无法发件");
//                            }
//                            cdbizBO.refreshEnterNodeStatus(cdbiz,
//                                    ECdbizStatus.E1.getCode(), ENode.receive_6.getCode());
//                            break;

                        default:
                            break;
                    }

//                    if (StringUtils.isNotBlank(cdbiz.getEnterStatus())) {
//                        switch (cdbiz.getEnterStatus()) {
//                            // 风控寄送银行放款材料
//                            case "000":
//                                cdbizBO.refreshEnterNodeStatus(cdbiz,
//                                        ECdbizStatus.D1.getCode(), ENode.receive_2.getCode());
//                                break;
//
//                            default:
//                                break;
//                        }
//                    }

                    // 待办事项
                    bizTaskBO.handlePreAndAdd(EBizLogType.LOGISTICS, req.getCode(), cdbiz.getCode(),
                            preCurNodeCode, nextNodeCode, req.getOperator());

                    // 日志记录
                    sysBizLogBO.saveNewSYSBizLog(cdbiz.getCode(), EBizLogType.LOGISTICS,
                            req.getCode(), preCurNodeCode, req.getSendNote(), req.getOperator());
                }

                break;

            default:
                break;

        }

    }

    @Override
    @Transactional(rollbackFor = BizException.class)
    public BooleanRes receiveApprove(String code, String approveResult,
            String operator, String remark) {
        Logistics logistics = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode()
                .equals(logistics.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "资料不是待收件状态!");
        }

        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            if (!operator.equals(logistics.getReceiver())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "必须由GPS申领人收件！");
            }
        } else {
            if (operator.equals(logistics.getSender())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "收件人不能和发件人同一人！");
            }
        }

        String result = EBoolean.NO.getCode();

        // 更新资料传递状态
        if (EBoolean.YES.getCode().equals(approveResult)) {
            logisticsBO.receiveLogistics(code, operator, remark);
        } else {
            logisticsBO.sendAgainLogistics(code, remark);
        }

        switch (ELogisticsType.matchCode(logistics.getType())) {
            case GPS:
                gpsApplyBO.receiveGps(logistics.getBizCode());
                break;

            case BUDGET:

                Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());

                // 资料传递操作日志
                sysBizLogBO.saveNewSYSBizLog(cdbiz.getCode(), EBizLogType.bank_push,
                        logistics.getCode(), logistics.getToNodeCode(), remark, operator);

                String preNodeCode;
                String nextNodeCode;
                String bizStatus;
                // 如果收件节点是待担保公司收件（车辆抵押）或提交银行（车辆抵押）
                if (logistics.getFromNodeCode().equals(ENode.submit_6.getCode())
                        && logistics.getToNodeCode().equals(ENode.receive_6.getCode())) {
                    if (EBoolean.NO.getCode().equals(approveResult)) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                                "该节点不能补件");
                    }
                    preNodeCode = cdbiz.getEnterNodeCode();
                    nextNodeCode = ENode.second_received_archive.getCode();
                    bizStatus = ECdbizStatus.E2.getCode();
                    // 更新入档状态
                    cdbizBO.refreshEnterNodeStatus(cdbiz, bizStatus, nextNodeCode);

                    bizTaskBO.handlePreAndAdd(EBizLogType.enter, cdbiz.getCode(),
                            cdbiz.getCode(), preNodeCode, nextNodeCode, operator);
                } else if (logistics.getFromNodeCode().equals(ENode.submit_5.getCode())
                        && logistics.getToNodeCode().equals(ENode.receive_5.getCode())) {
                    if (EBoolean.NO.getCode().equals(approveResult)) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                                "该节点不能补件");
                    }
                    preNodeCode = cdbiz.getCurNodeCode();
                    nextNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
                            .getNextNode();
                    bizStatus = ECdbizStatus.A27.getCode();
                    cdbiz.setStatus(bizStatus);
                    cdbiz.setCurNodeCode(nextNodeCode);
                    cdbizBO.refreshCurNodeStatus(cdbiz);

                    // 主流程待办事项
                    bizTaskBO.handlePreAndAdd(EBizLogType.bank_push, cdbiz.getCode(),
                            cdbiz.getCode(), preNodeCode, nextNodeCode, operator);

                } else if (logistics.getFromNodeCode().equals(ENode.submit_2.getCode())
                        && logistics.getToNodeCode().equals(ENode.receive_2.getCode())) {
                    if (EBoolean.NO.getCode().equals(approveResult)) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                                "该节点不能补件");
                    }
                    preNodeCode = cdbiz.getEnterNodeCode();
                    nextNodeCode = ENode.first_receive_archive.getCode();
                    bizStatus = ECdbizStatus.D2.getCode();
                    // 更新入档状态
                    cdbizBO.refreshEnterNodeStatus(cdbiz, bizStatus, nextNodeCode);

                    bizTaskBO.handlePreAndAdd(EBizLogType.enter, cdbiz.getCode(),
                            cdbiz.getCode(), preNodeCode, nextNodeCode, operator);
                } else {

                    if (EBoolean.YES.getCode().equals(approveResult)) {
                        nextNodeCode = nodeFlowBO
                                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode())
                                .getNextNode();
                    } else {
                        nextNodeCode = nodeFlowBO
                                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode())
                                .getBackNode();
                    }

                    switch (ENode.matchCode(cdbiz.getCurNodeCode())) {
                        // 风控审核收件（银行放款）
                        case receive_approve_1:

                            preNodeCode = cdbiz.getCurNodeCode();
                            if (EBoolean.YES.getCode().equals(approveResult)) {
                                cdbizBO.refreshStatus(cdbiz,
                                        ECdbizStatus.A13.getCode());
                                cdbizBO.refreshEnterNodeStatus(cdbiz,
                                        ECdbizStatus.D0.getCode(), ENode.submit_2.getCode());

                                // 生成银行放款
                                bankLoanBO.saveBankLoan(cdbiz.getCode());

                                // 生成资料传递
                                String logisticsCode = logisticsBO.saveLogistics(
                                        ELogisticsType.BUDGET.getCode(),
                                        ELogisticsCurNodeType.FK_SEND_BANK_LOAN
                                                .getCode(),
                                        cdbiz.getCode(), cdbiz.getSaleUserId(),
                                        ENode.submit_2.getCode(),
                                        ENode.receive_2.getCode(), null);

                                // 主流程待办事项
                                bizTaskBO.handlePreAndAdd(EBizLogType.bank_push, cdbiz.getCode(),
                                        cdbiz.getCode(), preNodeCode, nextNodeCode, operator);

                                // 入档资料传递待办事项
                                bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.enter,
                                        logisticsCode, ENode.submit_2);
                            } else {

                                cdbizBO.refreshStatus(cdbiz,
                                        ECdbizStatus.A12.getCode());

                                // 重新发件的待办
                                bizTaskBO.handlePreAndAdd(EBizLogType.bank_push,
                                        logistics.getCode(), cdbiz.getCode(), preNodeCode,
                                        nextNodeCode, operator);

                            }
                            break;

                        // 业务员审核抵押合同
                        case receive_approve_3:
                            bizStatus = EBoolean.YES.getCode().equals(approveResult)
                                    ? ECdbizStatus.A20.getCode()
                                    : ECdbizStatus.A21.getCode();

                            cdbiz.setCurNodeCode(nextNodeCode);
                            cdbiz.setStatus(bizStatus);
                            cdbizBO.refreshCurNodeStatus(cdbiz);

                            EBizLogType bizLogType = EBoolean.YES.getCode().equals(approveResult)
                                    ? EBizLogType.bank_push
                                    : EBizLogType.LOGISTICS;
                            // 待办事项
                            bizTaskBO.handlePreAndAdd(bizLogType, cdbiz.getCode(),
                                    cdbiz.getCode(), logistics.getToNodeCode(), nextNodeCode,
                                    operator);
                            break;

                        // 待风控审核收件（车辆抵押）
                        case receive_approve_4:
                            if (EBoolean.YES.getCode().equals(approveResult)) {

                                cdbiz.setStatus(ECdbizStatus.A24.getCode());
                                cdbiz.setCurNodeCode(nextNodeCode);
                                cdbizBO.refreshCurNodeStatus(cdbiz);
//                                cdbizBO.refreshEnterNodeStatus(cdbiz,
//                                        ECdbizStatus.E0.getCode(), ENode.submit_6.getCode());

                                // 生成【风控寄送材料】资料传递
                                String fkSendlogisticsCode = logisticsBO
                                        .saveLogistics(ELogisticsType.BUDGET.getCode(),
                                                ELogisticsCurNodeType.FK_SEND_CAR_PLEDGE.getCode(),
                                                cdbiz.getCode(), cdbiz.getSaleUserId(),
                                                ENode.submit_6.getCode(), ENode.receive_6.getCode(),
                                                null);

                                // 资料传递待办事项
                                bizTaskBO.saveBizTaskNew(cdbiz.getCode(), EBizLogType.enter,
                                        fkSendlogisticsCode, ENode.submit_6);

                                // 生成【风控审核通过】资料传递
                                String fkApprovelogisticsCode = logisticsBO
                                        .saveLogistics(ELogisticsType.BUDGET.getCode(),
                                                ELogisticsCurNodeType.FK_APPROVE_PASS_CAR_PLEDGE
                                                        .getCode(),
                                                cdbiz.getCode(), cdbiz.getSaleUserId(),
                                                ENode.submit_5.getCode(),
                                                ENode.receive_5.getCode(), null);

                                // 资料传递待办事项
                                bizTaskBO.handlePreAndAdd(EBizLogType.ZHDY_LOGISTICS,
                                        fkApprovelogisticsCode, cdbiz.getCode(),
                                        logistics.getToNodeCode(), nextNodeCode, operator);

                                // 资料传递操作日志
//                                sysBizLogBO.recordCurOperate(cdbiz.getCode(),
//                                        EBizLogType.ZHDY_LOGISTICS,
//                                        fkApprovelogisticsCode, nextNodeCode, null,
//                                        operator);

                            } else {

                                cdbizBO.refreshStatus(cdbiz,
                                        ECdbizStatus.A25.getCode());
                                // 资料传递待办事项
                                bizTaskBO.handlePreAndAdd(EBizLogType.ZHDY_LOGISTICS,
                                        logistics.getCode(), cdbiz.getCode(),
                                        logistics.getToNodeCode(), nextNodeCode, operator);
                            }
                            break;

                        default:
                            break;
                    }
                    cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);
                }

            default:
                break;
        }

        // 资料传递日志
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.LOGISTICS.getCode(), code,
                logistics.getToNodeCode(), remark, operator);
        return new BooleanRes(true, result);
    }

    @Override
    public void receive(String code, String operator, String remark) {
        Logistics logistics = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode()
                .equals(logistics.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态!");
        }

        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            // 收件人必须是申领人
            if (!operator.equals(logistics.getReceiver())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "必须由GPS申领人收件！");
            }
        }

        switch (ELogisticsType.matchCode(logistics.getType())) {
            case GPS:
                gpsApplyBO.receiveGps(logistics.getBizCode());
                break;

            case BUDGET:

                Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());

                switch (ENode.matchCode(logistics.getToNodeCode())) {

                    // 银行收件（车辆抵押）
                    case receive_5:
                        String nextNodeCode = nodeFlowBO
                                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode())
                                .getNextNode();
                        cdbiz.setStatus(ECdbizStatus.A27.getCode());
                        cdbiz.setCurNodeCode(nextNodeCode);
                        cdbizBO.refreshCurNodeStatus(cdbiz);
                        break;

                    // 待担保公司收件（车辆抵押）
                    case receive_6:
                        cdbizBO.refreshEnterNodeStatus(cdbiz,
                                ECdbizStatus.E2.getCode(), ENode.second_received_archive.getCode());
                        break;

                    // 贷后收件（银行放款）
                    case receive_2:
                        cdbizBO.refreshEnterNodeStatus(cdbiz,
                                ECdbizStatus.D2.getCode(), ENode.first_receive_archive.getCode());
                        break;

                    default:
                        break;
                }

//                if (StringUtils.isNotBlank(cdbiz.getFircundangStatus())) {
//                    switch (cdbiz.getFircundangStatus()) {
//                        // 贷后收件（银行放款）
//                        case "001":
//                            cdbizBO.refreshFircundangStatus(cdbiz,
//                                    ECdbizStatus.D2.getCode());
//                            break;
//
//                        default:
//                            break;
//                    }
//                }

                break;

            default:
                break;
        }

        logisticsBO.receiveLogistics(code, operator, remark);
    }

    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        if (StringUtils.isNotBlank(condition.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(condition.getUserId());
            if (StringUtils.isNotBlank(sysUser.getTeamCode())) {
                condition.setTeamCode(sysUser.getTeamCode());
            }
            condition.setUserId(null);
            condition.setRoleCode(sysUser.getRoleCode());
        }else {
            condition.setRoleCode("RO201800000000000001");
        }

        Paginable<Logistics> page = logisticsBO.getPaginable(start, limit,
                condition);
        List<Logistics> logisticsList = page.getList();
        for (Logistics logistics : logisticsList) {
            initLogistics(logistics);
        }
        return page;
    }

    private void initLogistics(Logistics logistics) {
        if (StringUtils.isNotBlank(logistics.getUserId())) {
            SYSUser sysUser = sysUserBO.getUser(logistics.getUserId());
            logistics.setUserName(sysUser.getRealName());
            SYSRole sysRole = sysRoleBO.getSYSRole(sysUser.getRoleCode());
            logistics.setUserRole(sysRole.getName());
        }
        if (StringUtils.isNotBlank(logistics.getTeamCode())) {
            BizTeam bizTeam = bizTeamBO.getBizTeam(logistics.getTeamCode());
            logistics.setTeamName(bizTeam.getName());
        }
        if (StringUtils.isNotBlank(logistics.getBizCode())) {
            if (ELogisticsType.BUDGET.getCode().equals(logistics.getType())) {
                CreditUser creditUser = creditUserBO.getCreditUserByBizCode(
                        logistics.getBizCode(), ECreditUserLoanRole.APPLY_USER);
                if (null != creditUser) {
                    logistics.setCustomerName(creditUser.getUserName());
                }
            }
        }
        if (StringUtils.isNotBlank(logistics.getSender())) {
            SYSUser user = sysUserBO.getUser(logistics.getSender());
            logistics.setSenderName(user.getRealName());
        }
        if (StringUtils.isNotBlank(logistics.getReceiver())) {
            SYSUser user = sysUserBO.getUser(logistics.getReceiver());
            logistics.setReceiverName(user.getRealName());
        }
        if (ELogisticsType.BUDGET.getCode().equals(logistics.getType())) {
            Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());

            if (StringUtils.isNotBlank(cdbiz.getSaleUserId())) {
                SYSUser saleuser = sysUserBO.getUser(cdbiz.getSaleUserId());
                logistics.setSaleUserName(saleuser.getRealName());
            }
            if (StringUtils.isNotBlank(cdbiz.getInsideJob())) {
                SYSUser jobuser = sysUserBO.getUser(cdbiz.getInsideJob());
                logistics.setInsideJobName(jobuser.getRealName());
            }
        }
        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            GpsApply gpsApply = gpsApplyBO.getGpsApply(logistics.getBizCode());
            gpsApply.setGpsList(gpsBO.queryGpsList(gpsApply.getCode()));
            logistics.setGpsApply(gpsApply);

            if (StringUtils.isNotBlank(gpsApply.getBudgetOrderCode())) {
                Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());
                if (StringUtils.isNotBlank(cdbiz.getSaleUserId())) {
                    SYSUser saleuser = sysUserBO.getUser(cdbiz.getSaleUserId());
                    logistics.setSaleUserName(saleuser.getRealName());
                }
                if (StringUtils.isNotBlank(cdbiz.getInsideJob())) {
                    SYSUser jobuser = sysUserBO.getUser(cdbiz.getInsideJob());
                    logistics.setInsideJobName(jobuser.getRealName());
                }
            }
        }

    }

    @Override
    public List<Logistics> queryLogisticsList(Logistics condition) {
        List<Logistics> logisticsList = logisticsBO
                .queryLogisticsList(condition);
        for (Logistics logistics : logisticsList) {
            initLogistics(logistics);
        }
        return logisticsList;
    }

    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = logisticsBO.getLogistics(code);
        initLogistics(logistics);

        return logistics;
    }
}
