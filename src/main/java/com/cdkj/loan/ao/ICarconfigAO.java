package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarCarconfig;
import com.cdkj.loan.domain.Carconfig;

public interface ICarconfigAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCarconfig(String name, String pic, String updater,
            String remark);

    public int dropCarconfig(String code);

    public int editCarconfig(String code, String name, String pic,
            String updater, String remark);

    public Paginable<Carconfig> queryCarconfigPage(int start, int limit,
            Carconfig condition);

    public List<Carconfig> queryCarconfigList(Carconfig condition);

    public Carconfig getCarconfig(String code);

    public void setCarConfig(String carCode, List<String> configCodeList);

    public List<CarCarconfig> getCarCarconfigsByCar(String carCode);

}
