package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CityList;
import java.util.List;

public interface ICityListBO extends IPaginableBO<CityList> {

    void saveCityList(CityList data);

    void removeCityList(CityList data);

    List<CityList> queryCityListList(CityList condition);

    CityList getCityList(int id);

}
