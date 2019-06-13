package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Calculate;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630419Req;
import com.cdkj.loan.dto.req.XN630420Req;
import com.cdkj.loan.dto.req.XN630422Req;
import java.util.List;

public interface ICarAO {

    String DEFAULT_ORDER_COLUMN = "order_no";

    // 新增品牌
    String addCar(XN630420Req req);

    // 修改品牌
    void editCar(XN630422Req req);

    // 上架品牌
    void upCar(String code, String location, String orderNo,
            String updater, String remark);

    // 下架品牌
    void downCar(String code, String updater, String remark);

    // 分页查询
    Paginable<Car> queryCarPage(int start, int limit, Car condition);

    // 详情查询
    Car getCar(String code, String userId);

    // 列表查询
    List<Series> queryCarList(Car condition);

    // 车贷计算器
    Calculate calculate(String carCode, String period, String isTotal);

    List<Car> queryList(Car condition);

    void dropCar(String code);

    void refreshCar(XN630419Req req);
}
