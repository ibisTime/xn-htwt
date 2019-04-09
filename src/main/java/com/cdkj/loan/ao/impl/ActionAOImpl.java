package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IActionAO;
import com.cdkj.loan.bo.IActionBO;
import com.cdkj.loan.bo.ICarBO;
import com.cdkj.loan.bo.ICarCarconfigBO;
import com.cdkj.loan.bo.ICarNewsBO;
import com.cdkj.loan.bo.ICarconfigBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Action;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.CarCarconfig;
import com.cdkj.loan.domain.CarNews;
import com.cdkj.loan.domain.User;
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

    @Autowired
    private ICarBO carBO;

    @Autowired
    private ICarconfigBO carconfigBO;

    @Autowired
    private ICarCarconfigBO carCarconfigBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String addAction(String type, String toType, String toCode,
            String creater, String remark) {
        // 资讯阅读量
        if (EActionToType.news.getCode().equals(toType)
                && EActionType.feet.getCode().equals(type)) {
            CarNews carNews = carNewsBO.getCarNews(toCode);
            carNewsBO.addReadCount(carNews);
        }
        // 是否重复收藏
        if (EActionToType.car.getCode().equals(toType)
                && EActionType.collect.getCode().equals(type)
                && actionBO.isExist(creater, toType, toType)) {
            throw new BizException("xn0000", "已收藏，无需重复收藏");
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
        Paginable<Action> page = actionBO.getPaginable(start, limit, condition);
        for (Action action : page.getList()) {
            init(action);
        }
        return page;
    }

    @Override
    public List<Action> queryActionList(Action condition) {
        List<Action> dataList = actionBO.queryActionList(condition);
        for (Action action : dataList) {
            init(action);
        }
        return dataList;
    }

    @Override
    public Action getAction(String code) {
        Action action = actionBO.getAction(code);
        init(action);
        return action;
    }

    private void init(Action action) {
        User user = userBO.getUser(action.getCreater());
        if (EActionToType.car.getCode().equals(action.getToType())) {
            Car car = carBO.getCar(action.getToCode());
            List<CarCarconfig> configList = carCarconfigBO.getCarconfigs(car
                .getCode());
            for (CarCarconfig carCarconfig : configList) {
                carCarconfig.setConfig(carconfigBO.getCarconfig(carCarconfig
                    .getConfigCode()));
            }
            car.setCaonfigList(configList);
            action.setCar(car);
        } else if (EActionToType.news.getCode().equals(action.getToType())) {
            action.setCarNews(carNewsBO.getCarNews(action.getToCode()));
        }
        action.setUser(user);
    }

    @Override
    public void cancelCollect(String userId, String carCode) {
        Action condition = new Action();
        condition.setToCode(carCode);
        condition.setType(EActionType.collect.getCode());
        List<Action> actions = actionBO.queryActionList(condition);
        if (actions.isEmpty()) {
            throw new BizException("biz0000", "该收藏不存在");
        }
        actionBO.removeAction(actions.get(0).getCode());
    }
}
