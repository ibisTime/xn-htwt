package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Repoint;
import java.util.List;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月9日 下午2:20:11 
 * @history:
 */
public interface IRepointBO extends IPaginableBO<Repoint> {

    public String saveRepoint(Repoint data);

    public int refreshRepoint(Repoint data);

    public List<Repoint> queryRepointList(Repoint condition);

    public List<Repoint> queryRepointList(String bizCode);


    public Repoint getRepoint(String code);

}
