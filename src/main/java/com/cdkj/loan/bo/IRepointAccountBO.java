package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.RepointAccount;
import java.util.List;

/**
 * @author : cyl
 * @since : 2019-05-27 15:29
 */

public interface IRepointAccountBO extends IPaginableBO<RepointAccount> {

    String saveRepointAccount(RepointAccount data);

    int removeRepointAccount(String code);

    void removeListByRepointCode(String repointCode);

    int refreshRepointAccount(RepointAccount data);

    List<RepointAccount> queryRepointAccountList(RepointAccount condition);

    RepointAccount getRepointAccount(String code);


}