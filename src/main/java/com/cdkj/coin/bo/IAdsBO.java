package com.cdkj.coin.bo;

import com.cdkj.coin.bo.base.Paginable;
import com.cdkj.coin.domain.AdsSell;
import com.cdkj.coin.enums.ETradeType;

import java.math.BigDecimal;

/**
 * Created by tianlei on 2017/十一月/14.
 */
public interface IAdsBO {

    void insertAdsSell(AdsSell adsSell);

    public AdsSell adsSellDetail(String adsCode);

    public boolean checkAdsBelongUser(String adsCode, String userId, ETradeType type);

    public void changeLeftAmount(String adsCode, BigDecimal value, ETradeType type);

    public void checkXiaJia(String adsCode, ETradeType type);

    public void xiaJiaAds(String adsCode, ETradeType type);

    public void shangJiaAds(String adsCode, ETradeType type);

    public Paginable<AdsSell> frontSellPage(Integer start, Integer limit, String coin);

    public Paginable<AdsSell> ossSellPage(Integer start, Integer limit, String coin);

}
