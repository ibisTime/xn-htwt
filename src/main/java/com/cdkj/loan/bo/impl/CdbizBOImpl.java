package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.ICdbizDAO;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Component
public class CdbizBOImpl extends PaginableBOImpl<Cdbiz> implements ICdbizBO {

    @Autowired
    private ICdbizDAO cdbizDAO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Override
    public boolean isCdbizExist(String code) {
        Cdbiz condition = new Cdbiz();
        condition.setCode(code);
        if (cdbizDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int removeCdbiz(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Cdbiz data = new Cdbiz();
            data.setCode(code);
            count = cdbizDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<Cdbiz> queryCdbizList(Cdbiz condition) {
        return cdbizDAO.selectList(condition);
    }

    @Override
    public Cdbiz getCdbiz(String code) {
        Cdbiz data = null;
        if (StringUtils.isNotBlank(code)) {
            Cdbiz condition = new Cdbiz();
            condition.setCode(code);
            data = cdbizDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "业务不存在");
            }
        }
        return data;
    }

    @Override
    public String saveCdbiz(String bankCode, String bizType, Long dkAmount,
            SYSUser sysUser, String node) {
        BizTeam bizTeam = bizTeamBO.getBizTeam(sysUser.getTeamCode());
        String code = OrderNoGenerater
            .generate(EGeneratePrefix.Cdbiz.getCode());
        Cdbiz cdbiz = new Cdbiz();
        cdbiz.setCode(code);
        cdbiz.setBizType(bizType);
        cdbiz.setCompanyCode(sysUser.getCompanyCode());
        cdbiz.setTeamCode(sysUser.getTeamCode());
        cdbiz.setCaptainCode(bizTeam.getCaptain());
        cdbiz.setSaleUserId(sysUser.getUserId());
        cdbiz.setInsideJob(sysUser.getUserId());
        cdbiz.setLoanBank(bankCode);
        cdbiz.setLoanAmount(dkAmount);
        cdbiz.setStatus(ECdbizStatus.A0.getCode());
        cdbiz.setCurNodeCode(node);
        cdbiz.setZfStatus("0");
        cdbizDAO.insert(cdbiz);
        return code;
    }

    @Override
    public int refreshCdbiz(Cdbiz data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void refreshStatus(Cdbiz cdbiz, String status) {
        cdbiz.setStatus(status);
        cdbizDAO.updateStatus(cdbiz);
    }

    @Override
    public void refreshMqStatus(Cdbiz cdbiz, String status) {
        cdbiz.setMqStatus(status);
        cdbizDAO.updateMqStatus(cdbiz);
    }

    @Override
    public void refreshFbhgpsStatus(Cdbiz cdbiz, String status) {
        cdbiz.setFbhgpsStatus(status);
        cdbizDAO.updateFbhgpsStatus(cdbiz);
    }

    @Override
    public void refreshFircundangStatus(Cdbiz cdbiz, String status) {
        cdbiz.setFircundangStatus(status);
        cdbizDAO.updateFircundangStatus(cdbiz);
    }

    @Override
    public void refreshSeccundangStatus(Cdbiz cdbiz, String status) {
        cdbiz.setSeccundangStatus(status);
        cdbizDAO.updateSeccundangStatus(cdbiz);
    }

    @Override
    public void refreshZfStatus(Cdbiz cdbiz, String status) {
        cdbiz.setZfStatus(status);
        cdbizDAO.updateZfStatus(cdbiz);
    }

    @Override
    public List<Cdbiz> queryListByTeamCode(String teamCode) {
        Cdbiz condition = new Cdbiz();
        condition.setTeamCode(teamCode);
        List<Cdbiz> dataList = cdbizDAO.selectList(condition);
        return dataList;
    }

    @Override
    public List<Cdbiz> queryListByYwyUser(String ywyUser) {
        Cdbiz condition = new Cdbiz();
        List<Cdbiz> dataList = cdbizDAO.selectList(condition);
        return dataList;
    }

    @Override
    public void refreshYwy(Cdbiz cdbiz, String ywyUser) {
        cdbizDAO.updateStatus(cdbiz);
    }

    @Override
    public void refreshMakeCardStatus(Cdbiz cdbiz, String status) {
        cdbiz.setMakeCardStatus(status);
        cdbizDAO.updateMakeCardStatus(cdbiz);
    }

    @Override
    public void refershCurNodeCode(Cdbiz cdbiz, String node) {
        cdbiz.setCurNodeCode(node);
        cdbizDAO.updateCurNodeCode(cdbiz);
    }

    @Override
    public void refreshInsideJob(Cdbiz cdbiz, String insideJob) {
        cdbiz.setInsideJob(insideJob);
        cdbizDAO.updateInsideJob(cdbiz);
    }

    @Override
    public Paginable<Cdbiz> getPaginableByRoleCode(Cdbiz condition, int start,
            int limit) {
        Long count = cdbizDAO.selectTotalCountByRoleCode(condition);
        Paginable<Cdbiz> page = new Page<Cdbiz>(start, limit, count);
        List<Cdbiz> dataList = cdbizDAO.selectListByRoleCode(condition, start,
            limit);
        page.setList(dataList);
        return page;
    }

}
