package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IActionAO;
import com.cdkj.loan.bo.IActionBO;
import com.cdkj.loan.bo.ICarNewsBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Action;
import com.cdkj.loan.domain.CarNews;
import com.cdkj.loan.enums.EActionToType;
import com.cdkj.loan.enums.EActionType;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class ActionAOImpl implements IActionAO {

    @Autowired
    private IActionBO actionBO;

    @Autowired
    private ICarNewsBO carNewsBO;

    @Override
    public String addAction(String type, String toType, String toCode,
            String creater, String remark) {
        // 资讯阅读量
        if (EActionToType.news.getCode().equals(toType)
                && EActionType.feet.getCode().equals(type)) {
            CarNews carNews = carNewsBO.getCarNews(toCode);
            carNewsBO.addReadCount(carNews);
        }
        return actionBO.saveAction(type, toType, toCode, creater, remark);
    }

    @Override
    public int editAction(Action data) {
        if (!actionBO.isActionExist(data.getCode())) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return actionBO.refreshAction(data);
    }

    @Override
    public int dropAction(String code) {
        if (!actionBO.isActionExist(code)) {
            throw new BizException("xn0000", "记录编号不存在");
        }
        return actionBO.removeAction(code);
    }

    @Override
    public Paginable<Action> queryActionPage(int start, int limit,
            Action condition) {
        return actionBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Action> queryActionList(Action condition) {
        return actionBO.queryActionList(condition);
    }

    @Override
    public Action getAction(String code) {
        return actionBO.getAction(code);
    }
}
