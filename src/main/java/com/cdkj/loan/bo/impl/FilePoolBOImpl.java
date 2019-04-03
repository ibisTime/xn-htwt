package com.cdkj.loan.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IFilePoolBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IFilePoolDAO;
import com.cdkj.loan.domain.FilePool;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class FilePoolBOImpl extends PaginableBOImpl<FilePool>
        implements IFilePoolBO {

    @Autowired
    private IFilePoolDAO filePoolDAO;

    @Override
    public String saveFilePool(String bizCode, String fileName, String fileType,
            String number, String url) {
        FilePool data = new FilePool();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.FILE_POOL.getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        data.setFileName(fileName);
        data.setFileType(fileType);
        data.setNumber(number);

        data.setUrl(url);
        data.setCreateDatetime(new Date());
        filePoolDAO.insert(data);
        return code;
    }

    @Override
    public List<FilePool> queryFilePoolList(FilePool condition) {
        return filePoolDAO.selectList(condition);
    }

    @Override
    public FilePool getFilePool(String code) {
        FilePool data = null;
        if (StringUtils.isNotBlank(code)) {
            FilePool condition = new FilePool();
            condition.setCode(code);
            data = filePoolDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "资源池不存在");
            }
        }
        return data;
    }
}
