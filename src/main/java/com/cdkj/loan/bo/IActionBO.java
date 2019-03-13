package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Action;

//CHECK ��鲢��ע�� 
public interface IActionBO extends IPaginableBO<Action> {

    public boolean isActionExist(String code);

    public String saveAction(String type, String toType, String toCode,
            String creater, String remark);

    public int removeAction(String code);

    public int refreshAction(Action data);

    public List<Action> queryActionList(Action condition);

    public Action getAction(String code);

}
