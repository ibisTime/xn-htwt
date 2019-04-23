package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.GpsApply;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.SYSRole;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632150Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

/**
 * 资料传递
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

    @Override
    @Transactional
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
        logistics = logisticsBO.sendLogistics(req);

        switch (ELogisticsType.matchCode(logistics.getType())) {
            case GPS:
                gpsApplyBO.sendGps(logistics.getBizCode(),
                    logistics.getSendDatetime());
                break;

            case BUDGET:

                Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());

                String nextNodeCode = nodeFlowBO
                    .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode())
                    .getNextNode();

                switch (ENode.matchCode(cdbiz.getCurNodeCode())) {
                    // 1、业务员寄送银行放款材料
                    // 2、业务员重寄材料（银行放款）
                    case submit_1:
                    case re_submit_1:
                        cdbizBO.refreshStatus(cdbiz,
                            ECdbizStatus.A11.getCode());
                        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);
                        break;

                    // TODO 第一次存档节点
                    // 风控寄送银行放款材料
                    case submit_2:
                        cdbizBO.refreshFircundangStatus(cdbiz,
                            ECdbizStatus.D1.getCode());
                        break;

                    // 1、风控寄抵押合同
                    // 2、风控重寄抵押合同
                    case submit_3:
                    case re_submit_3:
                        cdbizBO.refreshStatus(cdbiz,
                            ECdbizStatus.A19.getCode());
                        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);
                        break;

                    // 1、业务员寄送材料（车辆抵押）
                    // 2、业务员重寄送材料（车辆抵押）
                    case submit_4:
                    case re_submit_4:
                        cdbizBO.refreshStatus(cdbiz,
                            ECdbizStatus.A23.getCode());
                        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);
                        break;

                    // 风控审核通过（车辆抵押）
                    case submit_5:
                        cdbizBO.refreshStatus(cdbiz,
                            ECdbizStatus.A26.getCode());
                        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);
                        break;

                    // TODO 第二次存档节点
                    // 待风控寄件（车辆抵押）
                    case submit_6:
                        if (!ECdbizStatus.D3.getCode()
                            .equals(cdbiz.getFircundangStatus())) {
                            throw new BizException(
                                EBizErrorCode.DEFAULT.getCode(),
                                "第一次存档未完成，无法发件");
                        }
                        cdbizBO.refreshSeccundangStatus(cdbiz,
                            ECdbizStatus.E1.getCode());
                        break;

                    default:
                        break;
                }

                // 完成待办事项
                bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
                    cdbiz.getCode(),
                    ENode.getMap().get(cdbiz.getCurNodeCode()));

                // 添加待办事项
                bizTaskBO.saveBizTask(cdbiz.getCode(), EBizLogType.BUDGET_ORDER,
                    req.getCode(), ENode.getMap().get(cdbiz.getCurNodeCode()),
                    null);

                // 日志记录
                sysBizLogBO.recordCurOperate(cdbiz.getCode(),
                    EBizLogType.BUDGET_ORDER, req.getCode(),
                    cdbiz.getCurNodeCode(), req.getSendNote(),
                    req.getOperator());

                break;

            default:
                break;

        }
    }

    @Override
    @Transactional
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
        Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());
        String nextNodeCode = null;

        // 更新资料传递状态
        if (EBoolean.YES.getCode().equals(approveResult)) {
            logisticsBO.receiveLogistics(code, operator, remark);
            nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();
        } else {
            logisticsBO.sendAgainLogistics(code, remark);
            nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getBackNode();
        }

        switch (ELogisticsType.matchCode(logistics.getType())) {
            case GPS:
                gpsApplyBO.receiveGps(logistics.getBizCode());
                break;

            case BUDGET:

                String bizStatus = null;

                switch (ENode.matchCode(cdbiz.getCurNodeCode())) {
                    // 风控审核收件（银行放款）
                    case receive_approve_1:
                        if (EBoolean.YES.getCode().equals(approveResult)) {

                            cdbizBO.refreshStatus(cdbiz,
                                ECdbizStatus.A13.getCode());
                            cdbizBO.refreshFircundangStatus(cdbiz,
                                ECdbizStatus.D0.getCode());

                            // TODO 生成资料传递
                            String logisticsCode = logisticsBO.saveLogistics(
                                ELogisticsType.BUDGET.getCode(),
                                ELogisticsCurNodeType.CAR_MORTGAGE.getCode(),
                                cdbiz.getCode(), cdbiz.getSaleUserId(),
                                cdbiz.getCurNodeCode(), nextNodeCode, null);

                            // 资料传递待办事项
                            bizTaskBO.saveBizTask(code,
                                EBizLogType.ZHDY_LOGISTICS, logisticsCode,
                                ENode.matchCode(nextNodeCode), operator);

                            // 资料传递操作日志
                            sysBizLogBO.recordCurOperate(code,
                                EBizLogType.ZHDY_LOGISTICS, logisticsCode,
                                nextNodeCode, null, operator);
                        } else {

                            cdbizBO.refreshStatus(cdbiz,
                                ECdbizStatus.A12.getCode());

                        }
                        break;

                    // 业务员审核抵押合同
                    case receive_approve_3:
                        bizStatus = EBoolean.YES.getCode().equals(approveResult)
                                ? ECdbizStatus.A20.getCode()
                                : ECdbizStatus.A21.getCode();

                        cdbizBO.refreshStatus(cdbiz, bizStatus);
                        break;

                    // 风控审核收件（车辆抵押）
                    case receive_approve_4:
                        if (EBoolean.YES.getCode().equals(approveResult)) {

                            cdbizBO.refreshStatus(cdbiz,
                                ECdbizStatus.A24.getCode());
                            cdbizBO.refreshSeccundangStatus(cdbiz,
                                ECdbizStatus.E0.getCode());

                            // TODO 生成资料传递
                            String logisticsCode = logisticsBO.saveLogistics(
                                ELogisticsType.BUDGET.getCode(),
                                ELogisticsCurNodeType.CAR_MORTGAGE.getCode(),
                                cdbiz.getCode(), cdbiz.getSaleUserId(),
                                cdbiz.getCurNodeCode(), nextNodeCode, null);

                            // 资料传递待办事项
                            bizTaskBO.saveBizTask(code,
                                EBizLogType.ZHDY_LOGISTICS, logisticsCode,
                                ENode.matchCode(nextNodeCode), operator);

                            // 资料传递操作日志
                            sysBizLogBO.recordCurOperate(code,
                                EBizLogType.ZHDY_LOGISTICS, logisticsCode,
                                nextNodeCode, null, operator);

                        } else {

                            cdbizBO.refreshStatus(cdbiz,
                                ECdbizStatus.A25.getCode());

                        }
                        break;

                    default:
                        break;
                }

                cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);

            default:
                break;
        }

        if (ELogisticsType.BUDGET.getCode().equals(logistics.getType())) {
            if (ELogisticsCurNodeType.BANK_LOAN.getCode()
                .equals(logistics.getCurNodeType())) {
                result = budgetOrderBO.logicOrderLoan(logistics.getBizCode(),
                    operator, approveResult);
            } else {
                result = budgetOrderBO
                    .logicOrderMortgage(logistics.getBizCode(), operator);
            }
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

        Cdbiz cdbiz = cdbizBO.getCdbiz(logistics.getBizCode());
        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();

        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);

        switch (ENode.matchCode(cdbiz.getCurNodeCode())) {

            // 贷后收件（银行放款）
            case receive_2:
                cdbizBO.refreshFircundangStatus(cdbiz,
                    ECdbizStatus.D2.getCode());
                break;

            // 银行收件（车辆抵押）
            case receive_5:
                cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A27.getCode());
                break;

            // 待担保公司收件（车辆抵押）
            case receive_6:
                cdbizBO.refreshSeccundangStatus(cdbiz,
                    ECdbizStatus.E2.getCode());
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
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(logistics.getBizCode());
                logistics.setCustomerName(budgetOrder.getApplyUserName());
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
        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            GpsApply gpsApply = gpsApplyBO.getGpsApply(logistics.getBizCode());
            logistics.setGpsApply(gpsApply);
        }
        if (ELogisticsType.BUDGET.getCode().equals(logistics.getType())) {
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrder(logistics.getBizCode());
            if (StringUtils.isNotBlank(budgetOrder.getSaleUserId())) {
                SYSUser saleuser = sysUserBO
                    .getUser(budgetOrder.getSaleUserId());
                logistics.setSaleUserName(saleuser.getRealName());
            }
            if (StringUtils.isNotBlank(budgetOrder.getInsideJob())) {
                SYSUser jobuser = sysUserBO.getUser(budgetOrder.getInsideJob());
                logistics.setInsideJobName(jobuser.getRealName());
            }
        }
        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            GpsApply gpsApply = gpsApplyBO.getGpsApply(logistics.getBizCode());
            if (StringUtils.isNotBlank(gpsApply.getBudgetOrderCode())) {
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(gpsApply.getBudgetOrderCode());
                if (StringUtils.isNotBlank(budgetOrder.getSaleUserId())) {
                    SYSUser saleuser = sysUserBO
                        .getUser(budgetOrder.getSaleUserId());
                    logistics.setSaleUserName(saleuser.getRealName());
                }
                if (StringUtils.isNotBlank(budgetOrder.getInsideJob())) {
                    SYSUser jobuser = sysUserBO
                        .getUser(budgetOrder.getInsideJob());
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

    @Override
    public void linshi() {
        BudgetOrder condition = new BudgetOrder();
        ArrayList<String> list = new ArrayList<String>();
        list.add("002_09");// 业务团队安装GPS
        list.add("002_10");// GPS管理员审核
        list.add("002_11");// 业务团队车辆落户
        list.add("002_07");// 财务垫资
        list.add("002_13");// 业务贷后审核材料
        condition.setCurNodeCodeList(list);
        List<BudgetOrder> budgetOrderList = budgetOrderBO
            .queryBudgetOrderList(condition);
        for (BudgetOrder budgetOrder : budgetOrderList) {
            // 生成资料传递
            String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.BANK_LOAN.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                EBudgetOrderNode.INTERVIEW_INTERNAL_APPROVE.getCode(),
                EBudgetOrderNode.DHAPPROVEDATA.getCode(), null);
            // 资料传递日志
            sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                EBizLogType.LOGISTICS, logisticsCode,
                EBudgetOrderNode.DHAPPROVEDATA.getCode());
        }
    }
}
