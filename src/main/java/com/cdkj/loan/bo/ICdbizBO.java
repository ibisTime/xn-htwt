package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;

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

    /**
     * 获取车贷业务，操作时候用(加锁)
     */
    Cdbiz getCdbizForUpdate(String code);

    void refreshStatus(Cdbiz cdbiz, String status);

    void refreshStatus(Cdbiz cdbiz, String status, String remark);

    void refreshMqStatus(Cdbiz cdbiz, String status);

    void refreshFbhgpsStatus(Cdbiz cdbiz, String status);

    void refreshEnterNodeStatus(Cdbiz cdbiz, String status, String enterNodeCode);

    void refreshZfStatus(Cdbiz cdbiz, String status, String cancelNode);

    void refreshYwy(Cdbiz cdbiz, String ywyUser);

    void refreshMakeCardStatus(Cdbiz cdbiz, String status);

    void refreshMakeCardNode(Cdbiz cdbiz, String node);

    void refreshCurNodeCode(Cdbiz cdbiz, String node);

    void refreshInsideJob(Cdbiz cdbiz, String insideJob);

    void refreshIntevNodeStatus(Cdbiz cdbiz, String intevCurNodeCode,
            String mqStatus);

    void interview(Cdbiz cdbiz, XN632123Req req);

    void refreshCardAddress(Cdbiz cdbiz, String cardPostAddress, String cardPostProvince,
            String cardPostCity, String cardPostArea,String cardPostCode);

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

    /**
     * 修改入档位置
     */
    void refreshLocation(Cdbiz cdbiz);

    void icbankMakeCard(String code);
}
