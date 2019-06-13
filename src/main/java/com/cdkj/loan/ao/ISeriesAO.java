package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630410Req;
import com.cdkj.loan.dto.req.XN630412Req;
import com.cdkj.loan.dto.req.XN630418Req;
import java.util.List;

public interface ISeriesAO {

    String DEFAULT_ORDER_COLUMN = "order_no";

    // 新增品牌
    String addSeries(XN630410Req req);

    // 修改品牌
    void editSeries(XN630412Req req);

    // 上架品牌
    void upSeries(String code, String location, String orderNo,
            String updater, String remark);

    // 下架品牌
    void downSeries(String code, String updater, String remark);

    // 分页查询
    Paginable<Series> querySeriesPage(int start, int limit,
            Series condition);

    // 详情查询
    Series getSeries(String code);

    // 列表查询
    List<Series> querySeriesList(Series condition);

    void dropSeries(String code);

    // 车系刷新
    void refreshSeries(XN630418Req req);
}
