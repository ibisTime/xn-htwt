package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Action;

//CHECK ��鲢��ע�� 
public interface IActionAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addAction(String type, String toType, String toCode,
            String creater, String remark);

    public int dropAction(String code);

    public int editAction(Action data);

    public Paginable<Action> queryActionPage(int start, int limit,
            Action condition);

    public List<Action> queryActionList(Action condition);

    public Action getAction(String code);

    public void cancelCollect(String userId, String carCode);

}
