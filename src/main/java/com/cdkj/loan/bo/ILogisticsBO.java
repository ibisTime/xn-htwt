package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.dto.req.XN632150Req;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午10:34:47 
 * @history:
 */
public interface ILogisticsBO extends IPaginableBO<Logistics> {
    // 添加资料传递记录
    public String saveLogistics(String type, String curNodeType, String bizCode,
            String userId, String fromNodeCode, String toNodeCode,
            String refFileList);

    public String saveLogisticsGps(String type, String bizCode, String userId,
            String refFileList, String receiver, String teamCode);

    // 发货
    public Logistics sendLogistics(XN632150Req req);

    // 收货
    public void receiveLogistics(String code, String operator, String remark);

    // 补发
    public void sendAgainLogistics(String code, String remark);

    // 查询
    public Logistics getLogistics(String code);

    // 列表查
    public List<Logistics> queryLogisticsList(Logistics condition);
}
