package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IGpsApplyBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrder;
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
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
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
    private INodeBO nodeBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IGpsApplyBO gpsApplyBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ISYSRoleBO sysRoleBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

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
        // 操作人
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
        // String fileList = "";
        // for (String file : req.getFilelist()) {
        // fileList += file + ",";
        // }
        // if (StringUtils.isNotBlank(fileList)) {
        // fileList = fileList.substring(0, fileList.length() - 1);
        // }
        logistics.setFilelist(req.getFilelist());

        // 发件
        logistics.setSendType(req.getSendType());
        logistics.setLogisticsCompany(req.getLogisticsCompany());
        logistics.setLogisticsCode(req.getLogisticsCode());

        logistics.setSendDatetime(DateUtil.strToDate(req.getSendDatetime(),
            DateUtil.DATA_TIME_PATTERN_1));
        logistics.setSendNote(req.getSendNote());
        logistics.setStatus(ELogisticsStatus.TO_RECEIVE.getCode());
        logistics.setSender(req.getOperator());
        logisticsBO.sendLogistics(logistics);
        if (ELogisticsType.GPS.getCode().equals(logistics.getType())) {
            gpsApplyBO.sendGps(logistics.getBizCode(),
                logistics.getSendDatetime());

            // 日志
            if (ELogisticsStatus.TO_SEND.getCode()
                .equals(logistics.getStatus())) {
                sysBizLogBO.saveNewAndPreEndSYSBizLog(logistics.getCode(),
                    EBizLogType.GPS_LOGISTICS, logistics.getCode(),
                    ELogisticsStatus.SEND.getCode(),
                    ELogisticsStatus.RECEIVE.getCode(), req.getSendNote(),
                    req.getOperator(), null);
            }

        } else {
            // BudgetOrder budgetOrder = budgetOrderBO
            // .getBudgetOrder(logistics.getBizCode());
            // ELogisticsStatus pre = null;
            // ELogisticsStatus now = null;
            // EBizLogType bizLogType = null;
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.DHAPPROVEDATA.getCode())) {
            // pre = ELogisticsStatus.YWDH_SEND;
            // now = ELogisticsStatus.YWDH_RECEIVE;
            // bizLogType = EBizLogType.YWDH_LOGISTICS;
            // }
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.COMMITBANK3.getCode())) {
            // pre = ELogisticsStatus.ZHFK_SEND;
            // now = ELogisticsStatus.ZHFK_RECEIVE;
            // bizLogType = EBizLogType.ZHFK_LOGISTICS;
            // }
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.MORTGAGECOMMITBANK.getCode())) {
            // pre = ELogisticsStatus.ZHDY_SEND;
            // now = ELogisticsStatus.ZHDY_RECEIVE;
            // bizLogType = EBizLogType.ZHDY_LOGISTICS;
            // }
            /*
             * sysBizLogBO .saveNewAndPreEndSYSBizLog(logistics.getBizCode(),
             * bizLogType, logistics.getCode(), pre.getCode(), now.getCode(),
             * req.getSendNote(), req.getOperator(), budgetOrder.getTeamCode());
             */
        }
    }

    @Override
    @Transactional
    public BooleanRes receiveLogistics(String code, String operator,
            String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "资料不是待收件状态!");
        }

        if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            // 收件人必须是申领人
            if (!operator.equals(data.getReceiver())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "必须由GPS申领人收件！");
            }
        } else {
            if (operator.equals(data.getSender())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "收件人不能和发件人同一人！");
            }
        }

        String result = EBoolean.NO.getCode();
        logisticsBO.receiveLogistics(code, operator, remark);
        if (ELogisticsType.BUDGET.getCode().equals(data.getType())) {
            if (ELogisticsCurNodeType.BANK_LOAN.getCode()
                .equals(data.getCurNodeType())) {
                result = budgetOrderBO.logicOrderLoan(data.getBizCode(),
                    operator);
            } else {
                result = budgetOrderBO.logicOrderMortgage(data.getBizCode(),
                    operator);
            }
            // BudgetOrder budgetOrder = budgetOrderBO
            // .getBudgetOrder(data.getBizCode());
            // ELogisticsStatus pre = null;
            // EBizLogType bizLogType = null;
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.DHAPPROVEDATA.getCode())) {
            // pre = ELogisticsStatus.YWDH_SEND;
            // bizLogType = EBizLogType.YWDH_LOGISTICS;
            // }
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.COMMITBANK3.getCode())) {
            // pre = ELogisticsStatus.ZHFK_SEND;
            // bizLogType = EBizLogType.ZHFK_LOGISTICS;
            // }
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.MORTGAGECOMMITBANK.getCode())) {
            // pre = ELogisticsStatus.ZHDY_SEND;
            // bizLogType = EBizLogType.ZHDY_LOGISTICS;
            // }
            /*
             * sysBizLogBO.refreshPreSYSBizLog(bizLogType.getCode(),
             * data.getCode(), pre.getCode(), remark, operator);
             */

        } else if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            gpsApplyBO.receiveGps(data.getBizCode());
            /*
             * // 日志 sysBizLogBO.refreshPreSYSBizLog(
             * EBizLogType.GPS_LOGISTICS.getCode(), data.getCode(),
             * ELogisticsStatus.RECEIVE.getCode(), remark, operator);
             */
        }
        // 资料传递日志
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.LOGISTICS.getCode(), code,
            data.getToNodeCode(), remark, operator);
        return new BooleanRes(true, result);
    }

    @Override
    public void sendAgainLogistics(String code, String operator,
            String remark) {
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn0000", "资料不是待收件状态!");
        }

        if (ELogisticsType.GPS.getCode().equals(data.getType())) {
            // 收件人必须是申领人
            if (!operator.equals(data.getReceiver())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "必须由GPS申领人收件！");
            }
        }

        // 操作人入参验证 CX
        // SYSUser condition = new SYSUser();
        // condition.setUserId(operator);
        // condition.setTeamCode(data.getTeamCode());
        // long count = sysUserBO.getTotalCount(condition);
        // if (count <= 0) {
        // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
        // "发件人团队人员不能收件！");
        // }
        logisticsBO.sendAgainLogistics(code, remark);
        if (data.getType().equals(ELogisticsType.GPS.getCode())) {
            /*
             * // 日志 sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getCode(),
             * EBizLogType.GPS_LOGISTICS, data.getCode(),
             * ELogisticsStatus.RECEIVE.getCode(),
             * ELogisticsStatus.SEND.getCode(), remark, operator, null);
             */
        } else {
            // BudgetOrder budgetOrder = budgetOrderBO
            // .getBudgetOrder(data.getBizCode());
            // ELogisticsStatus pre = null;
            // ELogisticsStatus now = null;
            // EBizLogType bizLogType = null;
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.DHAPPROVEDATA.getCode())) {
            // pre = ELogisticsStatus.YWDH_SEND;
            // now = ELogisticsStatus.YWDH_RECEIVE;
            // bizLogType = EBizLogType.YWDH_LOGISTICS;
            // }
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.COMMITBANK3.getCode())) {
            // pre = ELogisticsStatus.ZHFK_SEND;
            // now = ELogisticsStatus.ZHFK_RECEIVE;
            // bizLogType = EBizLogType.ZHFK_LOGISTICS;
            // }
            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.MORTGAGECOMMITBANK.getCode())) {
            // pre = ELogisticsStatus.ZHDY_SEND;
            // now = ELogisticsStatus.ZHDY_RECEIVE;
            // bizLogType = EBizLogType.ZHDY_LOGISTICS;
            // }
            /*
             * sysBizLogBO.saveNewAndPreEndSYSBizLog(data.getBizCode(),
             * bizLogType, data.getCode(), pre.getCode(), now.getCode(), remark,
             * operator, budgetOrder.getTeamCode());
             */
        }
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
                EBudgetOrderNode.INTERVIEW_INTERNAL_APPROVE.getCode(),
                budgetOrder.getTeamCode());
        }
    }
}
