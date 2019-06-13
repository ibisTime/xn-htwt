/**
 * @Title SYSDictAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:19:00 
 * @version V1.0   
 */
package com.cdkj.loan.ao.impl;

import com.cdkj.loan.dto.res.CityRes;
import com.cdkj.loan.dto.res.ProvinceRes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISYSDictAO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630030Req;
import com.cdkj.loan.enums.EDictType;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:19:00 
 * @history:
 */
@Service
public class SYSDictAOImpl implements ISYSDictAO {
    @Autowired
    ISYSDictBO sysDictBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public List<SYSDict> queryRegionBelongList(String key) {
        SYSDict condition=new SYSDict();
        condition.setParentKey("region_belong");
        List<SYSDict> regionBelongs=sysDictBO.querySYSDictList(condition);
        List<SYSDict> result=new ArrayList<SYSDict>();
        for (SYSDict regionBelong : regionBelongs){
            if(regionBelong.getDkey().startsWith(key)){
                result.add(regionBelong);
            }
        }
        if(result.isEmpty()){
            SYSDict dict=sysDictBO.getSYSDictByParentKeyAndDkey("belong",key);
            result.add(dict);
        }
        return result;
    }

    @Override
    public Long addSecondDict(XN630030Req req) {
        String parentKey = req.getParentKey();
        String key = req.getDkey();
        sysDictBO.checkKeys(parentKey, key);
        SYSDict sysDict = new SYSDict();
        sysDict.setType(EDictType.SECOND.getCode());
        sysDict.setParentKey(parentKey);
        sysDict.setDkey(key);
        sysDict.setDvalue(req.getDvalue());

        sysDict.setUpdater(req.getUpdater());
        sysDict.setUpdateDatetime(new Date());
        sysDict.setRemark(req.getRemark());

        return sysDictBO.saveSecondDict(sysDict);
    }

    @Override
    public void dropSYSDict(Long id) {
        sysDictBO.removeSYSDict(id);
    }

    @Override
    public void editSYSDict(Long id, String value, String updater,
            String remark) {
        sysDictBO.refreshSYSDict(id, value, updater, remark);
    }

    @Override
    public Paginable<SYSDict> querySYSDictPage(int start, int limit,
            SYSDict condition) {
        Paginable<SYSDict> page = sysDictBO.getPaginable(start, limit,
            condition);

        if (null != page && CollectionUtils.isNotEmpty(page.getList())) {
            for (SYSDict sysDict : page.getList()) {
                if (!"admin".equals(sysDict.getUpdater())) {
                    SYSUser sysUser = sysUserBO.getUser(sysDict.getUpdater());
                    if (null != sysUser) {
                        sysDict.setUpdater(sysUser.getLoginName());
                    }
                }
            }
        }

        return page;
    }

    @Override
    public List<SYSDict> querySysDictList(SYSDict condition) {
        return sysDictBO.querySYSDictList(condition);
    }

    @Override
    public SYSDict getSYSDict(Long id) {
        return sysDictBO.getSYSDict(id);
    }

    @Override
    public List<ProvinceRes> queryRegionDate() {
        SYSDict condition=new SYSDict();
        condition.setParentKey("region_belong");
        List<SYSDict> regionBelongs=sysDictBO.querySYSDictList(condition);
        condition.setParentKey("belong");
        List<SYSDict> belongs=sysDictBO.querySYSDictList(condition);
        List<ProvinceRes> provinceResList=new ArrayList<ProvinceRes>();
        for(SYSDict belong: belongs){
            ProvinceRes pRes=new ProvinceRes();
            pRes.setKey(belong.getDkey());
            pRes.setValue(belong.getDvalue());
            List<CityRes> cityResList=new ArrayList<CityRes>();
            for(SYSDict regionBelong: regionBelongs){

                if (regionBelong.getDkey().startsWith(belong.getDkey())&&!regionBelong.getDkey().equals(belong.getDkey())){
                    CityRes cRes=new CityRes();
                    cRes.setKey(regionBelong.getDkey());
                    cRes.setValue(regionBelong.getDvalue());
                    cityResList.add(cRes);
                }

            }
            pRes.setCityResList(cityResList);
            provinceResList.add(pRes);
        }
        return provinceResList;
    }
}
