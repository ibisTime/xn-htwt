package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBoolean;

public interface IGpsBO extends IPaginableBO<Gps> {

    public void checkGpsDevNo(String gpsDevNo);

    public void saveGps(Gps data);

    public void applyGps(Gps code);

    public void refreshApplyGps(String code, SYSUser user, String applyCode);

    public void refreshUseGps(String code, String budgetOrder, EBoolean e);

    public List<Gps> queryGpsList(Gps condition);

    public List<Gps> queryGpsList(String applyCode);

    public Gps getGps(String code);

    public Gps getGpsByDevNo(String gpsDevNo);

    public void editGps(Gps gps);

}
