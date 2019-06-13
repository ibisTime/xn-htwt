package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IEnterFileListBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IEnterFileListDAO;
import com.cdkj.loan.domain.EnterFileList;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EnterFileListBOImpl extends PaginableBOImpl<EnterFileList> implements
        IEnterFileListBO {

    @Autowired
    private IEnterFileListDAO enterFileListDAO;

    @Override
    public String saveEnterFileList(EnterFileList data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                    .generate(EGeneratePrefix.ENTER_FILE_LIST.getCode());
            data.setCode(code);
            enterFileListDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeEnterFileList(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            EnterFileList data = new EnterFileList();
            data.setCode(code);
            count = enterFileListDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshEnterFileList(EnterFileList data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = enterFileListDAO.update(data);
        }
        return count;
    }

    @Override
    public List<EnterFileList> queryEnterFileListList(EnterFileList condition) {
        return enterFileListDAO.selectList(condition);
    }

    @Override
    public List<EnterFileList> queryEnterFileListByBizCode(String bizCode) {
        EnterFileList enterFileList = new EnterFileList();
        enterFileList.setBizCode(bizCode);
        return enterFileListDAO.selectList(enterFileList);
    }

    @Override
    public EnterFileList getEnterFileList(String code) {
        EnterFileList data = null;
        if (StringUtils.isNotBlank(code)) {
            EnterFileList condition = new EnterFileList();
            condition.setCode(code);
            data = enterFileListDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "存放清单编号不存在");
            }
        }
        return data;
    }
}