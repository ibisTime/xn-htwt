package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Carconfig;

//CHECK ��鲢��ע�� 
public interface ICarconfigBO extends IPaginableBO<Carconfig> {

    public boolean isCarconfigExist(String code);

    public String saveCarconfig(String name, String pic, String updater,
            String remark);

    public int removeCarconfig(String code);

    public int refreshCarconfig(Carconfig config, String name, String pic,
            String updater, String remark);

    public List<Carconfig> queryCarconfigList(Carconfig condition);

    public Carconfig getCarconfig(String code);

}
