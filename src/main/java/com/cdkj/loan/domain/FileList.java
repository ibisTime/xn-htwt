package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 材料清单
* @author: CYunlai 
* @since: 2018-09-27 19:43:35
* @history:
*/
public class FileList extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private int id;

    // 序号
    private String number;

    // 名称
    private String name;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    /*-----------辅助字段--------------*/

    // 更新人名称
    private String updaterName;

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}
