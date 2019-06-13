package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepointAccount;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author : cyl
 * @since : 2019-05-27 15:28
 */
@Component
public interface IRepointAccountAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    String addRepointAccount(RepointAccount data);

    int dropRepointAccount(String code);

    int editRepointAccount(RepointAccount data);

    Paginable<RepointAccount> queryRepointAccountPage(int start, int limit,
            RepointAccount condition);

    List<RepointAccount> queryRepointAccountList(RepointAccount condition);

    RepointAccount getRepointAccount(String code);

}