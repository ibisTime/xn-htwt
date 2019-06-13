package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.EnterFileList;
import java.util.List;


public interface IEnterFileListBO extends IPaginableBO<EnterFileList> {


    String saveEnterFileList(EnterFileList data);


    int removeEnterFileList(String code);


    int refreshEnterFileList(EnterFileList data);


    List<EnterFileList> queryEnterFileListList(EnterFileList condition);

    List<EnterFileList> queryEnterFileListByBizCode(String bizCode);


    EnterFileList getEnterFileList(String code);


}