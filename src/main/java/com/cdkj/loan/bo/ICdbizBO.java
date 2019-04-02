package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Cdbiz;

//CHECK ��鲢��ע�� 
public interface ICdbizBO extends IPaginableBO<Cdbiz> {

    public boolean isCdbizExist(String code);

    public String saveCdbiz(String bizCode, String mainLoaner, String bankCode,
            String bizType, Long dkAmount, String ywyUser, String teamCode);

    public int removeCdbiz(String code);

    public int refreshCdbiz(Cdbiz data);

    public List<Cdbiz> queryCdbizList(Cdbiz condition);

    public Cdbiz getCdbiz(String code);

    public void refreshStatus(Cdbiz cdbiz, String status);

}
