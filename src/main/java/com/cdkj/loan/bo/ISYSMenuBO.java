package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.SYSMenu;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月16日 下午7:48:35 
 * @history:
 */
public interface ISYSMenuBO extends IPaginableBO<SYSMenu> {
    public boolean isSYSMenuExist(String code);

    public int saveSYSMenu(SYSMenu data);

    public int removeSYSMenu(String code);

    public int refreshSYSMenu(SYSMenu data);

    public SYSMenu getSYSMenu(String code);

    // 通过url查菜单
    public SYSMenu getSYSMenuByUrl(String url);

    public List<SYSMenu> querySYSMenuList(SYSMenu data);
}
