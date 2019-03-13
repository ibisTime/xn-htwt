package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarNews;

//CHECK ��鲢��ע�� 
public interface ICarNewsBO extends IPaginableBO<CarNews> {

    public boolean isCarNewsExist(String code);

    public String saveCarNews(String title, String author, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark);

    public int removeCarNews(String code);

    public int refreshCarNews(CarNews data, String title, String advPic,
            Long picNumber, String pic, String context, String tag,
            String updater, String remark);

    public void refreshStatus(CarNews carNews, String status);

    public List<CarNews> queryCarNewsList(CarNews condition);

    public CarNews getCarNews(String code);

    public void addReadCount(CarNews carNews);

}
