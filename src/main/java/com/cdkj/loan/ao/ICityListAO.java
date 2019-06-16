package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CityList;
import com.cdkj.loan.dto.req.XN630470Req;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface ICityListAO {

    static final String DEFAULT_ORDER_COLUMN = "id";

    void addCityList(CityList data);

    Paginable<CityList> queryCityListPage(int start, int limit,
            CityList condition);

    List<CityList> queryCityListList(CityList condition);

    CityList getCityList(int id);

    // 城市列表刷新
    void refreshCityList(XN630470Req req);

}
