package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IBrandLogoBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IBrandLogoDAO;
import com.cdkj.loan.domain.BrandLogo;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BrandLogoBOImpl extends PaginableBOImpl<BrandLogo> implements IBrandLogoBO {

    @Autowired
    private IBrandLogoDAO brandLogoDAO;

    @Override
    public String saveBrandLogo(BrandLogo data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.BRANDLOGO.getCode());
            data.setCode(code);
            brandLogoDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeBrandLogo(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            BrandLogo data = new BrandLogo();
            data.setCode(code);
            count = brandLogoDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshBrandLogo(BrandLogo data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = brandLogoDAO.update(data);
        }
        return count;
    }

    @Override
    public List<BrandLogo> queryBrandLogoList(BrandLogo condition) {
        return brandLogoDAO.selectList(condition);
    }

    @Override
    public BrandLogo getBrandLogo(String code) {
        BrandLogo data = null;
        if (StringUtils.isNotBlank(code)) {
            BrandLogo condition = new BrandLogo();
            condition.setCode(code);
            data = brandLogoDAO.select(condition);
            if (data == null) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(), "编号不存在");
            }
        }
        return data;
    }

    @Override
    public void insertBrandLogoList(List<BrandLogo> brandLogoList) {
        brandLogoDAO.insertBrandLogoList(brandLogoList);
    }
}