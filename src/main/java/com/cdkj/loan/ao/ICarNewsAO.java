package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarNews;

//CHECK ��鲢��ע�� 
public interface ICarNewsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCarNews(String title, String author, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark);

    public int dropCarNews(String code);

    public int editCarNews(String code, String title, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark);

    public void putOn(String code, String updater, String remark);

    public void putOff(String code, String updater);

    public Paginable<CarNews> queryCarNewsPage(int start, int limit,
            CarNews condition);

    public List<CarNews> queryCarNewsList(CarNews condition);

    public CarNews getCarNews(String code);

}
