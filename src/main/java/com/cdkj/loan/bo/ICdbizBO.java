package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import java.util.List;

//CHECK ��鲢��ע�� 
public interface ICdbizBO extends IPaginableBO<Cdbiz> {

    public boolean isCdbizExist(String code);

    public String saveCdbiz(String bankCode, String bizType, Long dkAmount,
            SYSUser sysUser, String node, String remark);

    public int removeCdbiz(String code);

    public int refreshCdbiz(Cdbiz data);

    public int refreshCdbiz(Cdbiz cdbiz, XN632530Req req);

    public int refreshCdbiz(Cdbiz cdbiz, XN632531Req req);

    public List<Cdbiz> queryCdbizList(Cdbiz condition);

    public List<Cdbiz> queryListByTeamCode(String teamCode);

    public List<Cdbiz> queryListByYwyUser(String ywyUser);

    public Paginable<Cdbiz> getPaginableByRoleCode(Cdbiz condition, int start,
            int limit);

    public Cdbiz getCdbiz(String code);

    public void refreshStatus(Cdbiz cdbiz, String status);

    public void refreshStatus(Cdbiz cdbiz, String status, String remark);

    public void refreshMqStatus(Cdbiz cdbiz, String status);

    public void refreshFbhgpsStatus(Cdbiz cdbiz, String status);

    public void refreshFircundangStatus(Cdbiz cdbiz, String status);

    public void refreshSeccundangStatus(Cdbiz cdbiz, String status);

    public void refreshZfStatus(Cdbiz cdbiz, String status);

    public void refreshYwy(Cdbiz cdbiz, String ywyUser);

    public void refreshMakeCardStatus(Cdbiz cdbiz, String status);

    public void refreshMakeCardNode(Cdbiz cdbiz, String node);

    public void refershCurNodeCode(Cdbiz cdbiz, String node);

    public void refreshInsideJob(Cdbiz cdbiz, String insideJob);

    public void refreshIntevCurNodeCode(Cdbiz cdbiz, String intevCurNodeCode);

    public void interview(Cdbiz cdbiz, XN632123Req req);

    public void refreshCardAddress(Cdbiz cdbiz, String cardPostAddress);

    public void refreshRepayCard(Cdbiz cdbiz, String repayCardNumber);

}
