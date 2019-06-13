package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.EnterFileList;
import com.cdkj.loan.dto.req.XN632220Req;
import com.cdkj.loan.dto.req.XN632222Req;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public interface IEnterFileListAO {

    static final String DEFAULT_ORDER_COLUMN = "code";


    String addEnterFileList(XN632220Req req);

    int dropEnterFileList(String code, String operator);

    int editEnterFileList(XN632222Req req);

    Paginable<EnterFileList> queryEnterFileListPage(int start, int limit,
            EnterFileList condition);

    List<EnterFileList> queryEnterFileListList(EnterFileList condition);

    EnterFileList getEnterFileList(String code);

}