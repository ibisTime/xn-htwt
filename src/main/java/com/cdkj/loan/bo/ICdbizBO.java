package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Cdbiz;

//CHECK ��鲢��ע�� 
public interface ICdbizBO extends IPaginableBO<Cdbiz> {

    public boolean isCdbizExist(String code);

    public String saveCdbiz(String bankCode, String bizType, Long dkAmount,
            String ywyUser, String teamCode);

    public int removeCdbiz(String code);

    public int refreshCdbiz(Cdbiz data);

    public List<Cdbiz> queryCdbizList(Cdbiz condition);

    public List<Cdbiz> queryListByTeamCode(String teamCode);

    public List<Cdbiz> queryListByYwyUser(String ywyUser);

    public Cdbiz getCdbiz(String code);

    public void refreshStatus(Cdbiz cdbiz, String status);

    public void refreshMqStatus(Cdbiz cdbiz, String status);

    public void refreshFbhgpsStatus(Cdbiz cdbiz, String status);

    public void refreshFircundangStatus(Cdbiz cdbiz, String status);

    public void refreshSeccundangStatus(Cdbiz cdbiz, String status);

    public void refreshZfStatus(Cdbiz cdbiz, String status);

    public void refreshYwy(Cdbiz cdbiz, String ywyUser);

}
