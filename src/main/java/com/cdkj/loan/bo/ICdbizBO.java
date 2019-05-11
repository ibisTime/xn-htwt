package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import java.util.List;

public interface ICdbizBO extends IPaginableBO<Cdbiz> {

    Cdbiz saveCdbiz(String bankCode, String bizType, Long dkAmount,
            SYSUser sysUser, BizTeam bizTeam, String node, String dealType,
            String remark);

    int refreshCdbiz(Cdbiz data);

    int refreshCdbiz(Cdbiz cdbiz, XN632530Req req);

    int refreshCdbiz(Cdbiz cdbiz, XN632531Req req);

    List<Cdbiz> queryListByTeamCode(String teamCode);

    List<Cdbiz> queryCdbizList(Cdbiz condition);

    List<Cdbiz> queryListByYwyUser(String ywyUser);

    Paginable<Cdbiz> getPaginableByRoleCode(Cdbiz condition, int start,
            int limit);

    Cdbiz getCdbiz(String code);

    void refreshStatus(Cdbiz cdbiz, String status);

    void refreshStatus(Cdbiz cdbiz, String status, String remark);

    void refreshMqStatus(Cdbiz cdbiz, String status);

    void refreshFbhgpsStatus(Cdbiz cdbiz, String status);

    void refreshEnterNodeStatus(Cdbiz cdbiz, String status, String enterNodeCode);

    void refreshZfStatus(Cdbiz cdbiz, String status);

    void refreshYwy(Cdbiz cdbiz, String ywyUser);

    void refreshMakeCardStatus(Cdbiz cdbiz, String status);

    void refreshMakeCardNode(Cdbiz cdbiz, String node);

    void refreshCurNodeCode(Cdbiz cdbiz, String node);

    void refreshInsideJob(Cdbiz cdbiz, String insideJob);

    void refreshIntevNodeStart(Cdbiz cdbiz, String intevCurNodeCode, String mqStatus);

    void refreshIntevCurNodeCode(Cdbiz cdbiz, String intevCurNodeCode);

    void interview(Cdbiz cdbiz, XN632123Req req);

    void refreshCardAddress(Cdbiz cdbiz, String cardPostAddress);

    void refreshRepayCard(Cdbiz cdbiz, String repayCardNumber);

    /**
     * 发保合节点更新
     */
    void refreshFbhgpsNodeStatus(Cdbiz cdbiz);

    void creditIcBank(CreditUser creditUser);

    /**
     * 更新主流程节点状态
     */
    void refreshCurNodeStatus(Cdbiz cdbiz);
}
