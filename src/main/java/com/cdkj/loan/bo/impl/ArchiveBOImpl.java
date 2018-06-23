package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IArchiveDAO;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

/**
 * 人事档案
 * @author: jiafr 
 * @since: 2018年6月4日 下午5:29:23 
 * @history:
 */
@Component
public class ArchiveBOImpl extends PaginableBOImpl<Archive> implements
        IArchiveBO {

    @Autowired
    private IArchiveDAO archiveDAO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public boolean isArchiveExist(String code) {
        Archive condition = new Archive();
        condition.setCode(code);
        condition.setStatus("1");
        if (archiveDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void checkArchiveByMobile(String mobile, String code) {
        if (StringUtils.isNotBlank(mobile)) {
            Archive condition = new Archive();
            condition.setMobile(mobile);
            List<Archive> list = archiveDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                Archive archive = list.get(0);
                if (StringUtils.isNotBlank(code)) {
                    if (!code.equals(archive.getCode())) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                            "手机号已在其他档案中存在");
                    }
                }
            }
        }
    }

    @Override
    public void checkArchiveByIdNo(String idNo, String code) {
        if (StringUtils.isNotBlank(idNo)) {
            Archive condition = new Archive();
            condition.setIdNo(idNo);
            List<Archive> list = archiveDAO.selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                Archive archive = list.get(0);
                if (StringUtils.isNotBlank(code)) {
                    if (!code.equals(archive.getCode())) {
                        throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                            "身份证号已在其他档案中存在");
                    }
                }
            }
        }
    }

    @Override
    public String saveArchive(Archive data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.RECRUITAPPLY
                .getCode());
            data.setCode(code);
            data.setStatus("1");
            archiveDAO.insert(data);
        }
        return code;
    }

    @Override
    public void removeArchive(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Archive data = new Archive();
            data.setCode(code);
            data.setStatus("0");
            count = archiveDAO.delete(data);
        }
    }

    @Override
    public void refreshArchive(Archive data) {

        if (StringUtils.isNotBlank(data.getCode())) {
            archiveDAO.update(data);
        }
    }

    @Override
    public List<Archive> queryArchiveList(Archive condition) {
        List<Archive> archiveList = archiveDAO.selectList(condition);
        for (Archive archive : archiveList) {
            archive.setDepartmentName(departmentBO.getDepartment(
                archive.getDepartmentCode()).getName());
            archive.setPostName(departmentBO.getDepartment(
                archive.getPostCode()).getName());
        }
        return archiveList;
    }

    @Override
    public Archive getArchive(String code) {
        Archive data = null;
        if (StringUtils.isNotBlank(code)) {
            Archive condition = new Archive();
            condition.setCode(code);
            condition.setStatus("1");
            data = archiveDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "人事档案不存在");
            }
        }
        return data;
    }

    @Override
    public void refreshLeaveArchive(Archive data) {

        if (StringUtils.isNotBlank(data.getCode())) {
            archiveDAO.updateLeaveArchive(data);
        }
    }

    @Override
    public Archive getArchiveByUserid(String userId) {
        Archive data = null;
        if (StringUtils.isNotBlank(userId)) {
            Archive condition = new Archive();
            condition.setUserId(userId);
            condition.setStatus("1");
            data = archiveDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "人事档案不存在");
            }
        }
        return data;
    }

    @Override
    public int getTotalCount(int ageStart, int ageEnd) {
        Archive condition = new Archive();
        condition.setAgeStart(ageStart);
        condition.setAgeEnd(ageEnd);
        condition.setStatus("1");
        return (int) archiveDAO.selectTotalCount(condition);

    }

    @Override
    public void doCheck(String userId) {
        Archive condition = new Archive();
        condition.setUserId(userId);
        condition.setStatus("1");
        long count = archiveDAO.selectTotalCount(condition);
        if (count == 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该申请人不在人事档案中！");
        }
    }

    @Override
    public void refreshBelongUser(Archive data) {
        if (data != null) {
            archiveDAO.updateBelongUser(data);
        }
    }

}
