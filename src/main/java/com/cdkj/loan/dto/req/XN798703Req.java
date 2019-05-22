package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 专项卡申请信息上送
 * @author: silver 
 * @since: Dec 19, 2018 4:52:24 PM 
 * @history:
 */
public class XN798703Req {
    // 业务发生地
    @NotBlank
    private String zoneno;

    // 订单编号
    @NotBlank
    private String orderno;

    // 业务类型
    @NotBlank
    private String busitype;

    // 申请分期金额
    private String loanamount;

    // 贷款期限
    private String term;

    // 手续费率
    private String feeratio;

    // 手续费
    private String feeamount;

    // 车辆价格
    private String carprice;

    // 贷款成数
    private String loanratio;

    // 专项额度核定图片
    @NotBlank
    private String checkPic;

    // 必填，开卡申请表图片
    @NotBlank
    private String applicationForm;

    // 营销代码
    private String dscode;

    // 证件类型
    @NotBlank
    private String custsort;

    // 证件号码
    @NotBlank
    private String custcode;

    // 姓名
    @NotBlank
    private String chnsname;

    // 姓名拼音或英文名
    @NotBlank
    private String engname;

    // 性别
    @NotBlank
    private String sex;

    // 婚姻状况
    @NotBlank
    private String mrtlstat;

    // 出生日期
    private String birthdate;

    // 教育程度
    private String edulvl;

    // 住宅情况
    private String homestat;

    // 住宅地址选择
    private String hadrchoic;

    // 住宅地址省份
    @NotBlank
    private String hprovince;

    // 住宅地址市
    @NotBlank
    private String hcity;

    // 住宅地址县
    @NotBlank
    private String hcounty;

    // 住宅地址
    @NotBlank
    private String haddress;

    // 住宅地址ID
    private String haddrid;

    // 住宅地址邮编
    @NotBlank
    private String homezip;

    // 住宅电话区号
    private String hphonzono;

    // 住宅电话号码
    @NotBlank
    private String hphoneno;

    // 住宅电话分机
    private String hphonext;

    // 手机选择
    private String mblchoic;

    // 手机号码
    @NotBlank
    private String mvblno;

    // 手机ID
    private String mblid;

    // 工作单位
    @NotBlank
    private String unitname;

    // 单位电话区号
    @NotBlank
    private String cophozono;

    // 单位电话号码
    @NotBlank
    private String cophoneno;

    // 单位电话分机
    @NotBlank
    private String cophonext;

    // 单位地址选择
    private String cadrchoic;

    // 单位地址省份
    @NotBlank
    private String cprovince;

    // 单位地址市
    @NotBlank
    private String ccity;

    // 单位地址县
    @NotBlank
    private String ccounty;

    // 工作单位地址
    @NotBlank
    private String caddress;

    // 单位地址ID
    private String caddrid;

    // 单位邮编
    @NotBlank
    private String corpzip;

    // 本人年收入
    private String yearincome;

    // 单位性质
    @NotBlank
    private String modelcode;

    // 职业
    @NotBlank
    private String occptn;

    // 通讯地址选择
    private String comchoic;

    // 通讯地址省份
    private String commprov;

    // 通讯地址市
    private String commcity;

    // 通讯地址县
    private String commcounty;

    // 通讯地址
    private String commaddr;

    // 通讯地址ID
    private String commaddrid;

    // 选填，通讯地址邮编
    private String commazip;

    // 联系人一姓名
    @NotBlank
    private String reltname1;

    // 联系人一性别
    @NotBlank
    private String reltsex1;

    // 联系人一与主卡申请人关系
    @NotBlank
    private String reltship1;

    // 联系人一手机
    @NotBlank
    private String reltmobl1;

    // 联系人一联系电话区
    private String reltphzon1;

    // 联系人一联系电话
    @NotBlank
    private String relaphone1;

    // 联系人一联系电话分
    private String reltphext1;

    // 联系人二姓名
    @NotBlank
    private String reltname2;

    // 联系人二性别
    @NotBlank
    private String reltsex2;

    // 联系人二与主卡申请人关系
    @NotBlank
    private String reltship2;

    // 联系人二手机
    @NotBlank
    private String reltmobl2;

    // 联系人二联系电话区
    private String rtcophzn2;

    // 联系人二联系电话号码
    @NotBlank
    private String rtcophon2;

    // 联系人二联系电话分
    private String rtcophet2;

    // 联合单位会员号
    private String almebno;

    // 对账单寄送方式
    @NotBlank
    private String accgetm;

    // 对账单寄送地址
    private String accaddrf;

    // 申请本币额度
    private String rmbcred;

    // 主卡发送移动电话
    @NotBlank
    private String mamobile;

    // 发送短信账单手机号码
    @NotBlank
    private String smsphone;

    // 问题编号
    private String qesno;

    // 问题答案
    private String answer;

    // 产品标志
    private String crdrflag;

    // 发证机关
    @NotBlank
    private String authref;

    // 证件有效期
    @NotBlank
    private String statdate;

    // 何时入住现址
    @NotBlank
    private String indate;

    // 进入单位时间
    @NotBlank
    private String joindate;

    // 关系账号
    private String reltno;

    // 卡片领取方式
    @NotBlank
    private String drawmode;

    // 卡片寄送地址类型
    private String drawaddr;

    // 主卡开通余额变动提醒
    @NotBlank
    private String machgf;

    // 主卡余额提醒发送手机号码
    private String machgmobile;

    // 开通email对账单
    @NotBlank
    private String emladdrf;

    // 对账单email
    private String stmtemail;

    // 自动还款转出账户类型1
    private String outacctype1;

    // 转出卡号/账号1
    private String outcardno1;

    // 还款金额类型1
    private String ddamttype1;

    // 自动还款转出账户类型2
    private String outacctype2;

    // 转出卡号/账号2
    private String outcardno2;

    // 还款金额类型2
    private String ddamttype2;

    // 提前还款天数
    private String paydays;

    // 同步签订外币自动还款
    private String fftrxtype;

    // 电子现金标志
    private String ecshflag;

    // 产品编号
    private String creditcardno;

    // 产品简称
    private String prodname;

    // 产品特色类别
    private String featgype;

    // 产品特色名称
    private String featname;

    // 所属发卡机构名称
    private String fakaorg;

    // 系统编号
    @NotBlank
    private String systemCode;

    // 公司编号
    @NotBlank
    private String companyCode;

    public String getZoneno() {
        return zoneno;
    }

    public void setZoneno(String zoneno) {
        this.zoneno = zoneno;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getBusitype() {
        return busitype;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype;
    }

    public String getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(String loanamount) {
        this.loanamount = loanamount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getFeeratio() {
        return feeratio;
    }

    public void setFeeratio(String feeratio) {
        this.feeratio = feeratio;
    }

    public String getFeeamount() {
        return feeamount;
    }

    public void setFeeamount(String feeamount) {
        this.feeamount = feeamount;
    }

    public String getCarprice() {
        return carprice;
    }

    public void setCarprice(String carprice) {
        this.carprice = carprice;
    }

    public String getLoanratio() {
        return loanratio;
    }

    public void setLoanratio(String loanratio) {
        this.loanratio = loanratio;
    }

    public String getCheckPic() {
        return checkPic;
    }

    public void setCheckPic(String checkPic) {
        this.checkPic = checkPic;
    }

    public String getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(String applicationForm) {
        this.applicationForm = applicationForm;
    }

    public String getDscode() {
        return dscode;
    }

    public void setDscode(String dscode) {
        this.dscode = dscode;
    }

    public String getCustsort() {
        return custsort;
    }

    public void setCustsort(String custsort) {
        this.custsort = custsort;
    }

    public String getCustcode() {
        return custcode;
    }

    public void setCustcode(String custcode) {
        this.custcode = custcode;
    }

    public String getChnsname() {
        return chnsname;
    }

    public void setChnsname(String chnsname) {
        this.chnsname = chnsname;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMrtlstat() {
        return mrtlstat;
    }

    public void setMrtlstat(String mrtlstat) {
        this.mrtlstat = mrtlstat;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEdulvl() {
        return edulvl;
    }

    public void setEdulvl(String edulvl) {
        this.edulvl = edulvl;
    }

    public String getHomestat() {
        return homestat;
    }

    public void setHomestat(String homestat) {
        this.homestat = homestat;
    }

    public String getHadrchoic() {
        return hadrchoic;
    }

    public void setHadrchoic(String hadrchoic) {
        this.hadrchoic = hadrchoic;
    }

    public String getHprovince() {
        return hprovince;
    }

    public void setHprovince(String hprovince) {
        this.hprovince = hprovince;
    }

    public String getHcity() {
        return hcity;
    }

    public void setHcity(String hcity) {
        this.hcity = hcity;
    }

    public String getHcounty() {
        return hcounty;
    }

    public void setHcounty(String hcounty) {
        this.hcounty = hcounty;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHaddrid() {
        return haddrid;
    }

    public void setHaddrid(String haddrid) {
        this.haddrid = haddrid;
    }

    public String getHomezip() {
        return homezip;
    }

    public void setHomezip(String homezip) {
        this.homezip = homezip;
    }

    public String getHphonzono() {
        return hphonzono;
    }

    public void setHphonzono(String hphonzono) {
        this.hphonzono = hphonzono;
    }

    public String getHphoneno() {
        return hphoneno;
    }

    public void setHphoneno(String hphoneno) {
        this.hphoneno = hphoneno;
    }

    public String getHphonext() {
        return hphonext;
    }

    public void setHphonext(String hphonext) {
        this.hphonext = hphonext;
    }

    public String getMblchoic() {
        return mblchoic;
    }

    public void setMblchoic(String mblchoic) {
        this.mblchoic = mblchoic;
    }

    public String getMvblno() {
        return mvblno;
    }

    public void setMvblno(String mvblno) {
        this.mvblno = mvblno;
    }

    public String getMblid() {
        return mblid;
    }

    public void setMblid(String mblid) {
        this.mblid = mblid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getCophozono() {
        return cophozono;
    }

    public void setCophozono(String cophozono) {
        this.cophozono = cophozono;
    }

    public String getCophoneno() {
        return cophoneno;
    }

    public void setCophoneno(String cophoneno) {
        this.cophoneno = cophoneno;
    }

    public String getCophonext() {
        return cophonext;
    }

    public void setCophonext(String cophonext) {
        this.cophonext = cophonext;
    }

    public String getCadrchoic() {
        return cadrchoic;
    }

    public void setCadrchoic(String cadrchoic) {
        this.cadrchoic = cadrchoic;
    }

    public String getCprovince() {
        return cprovince;
    }

    public void setCprovince(String cprovince) {
        this.cprovince = cprovince;
    }

    public String getCcity() {
        return ccity;
    }

    public void setCcity(String ccity) {
        this.ccity = ccity;
    }

    public String getCcounty() {
        return ccounty;
    }

    public void setCcounty(String ccounty) {
        this.ccounty = ccounty;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCaddrid() {
        return caddrid;
    }

    public void setCaddrid(String caddrid) {
        this.caddrid = caddrid;
    }

    public String getCorpzip() {
        return corpzip;
    }

    public void setCorpzip(String corpzip) {
        this.corpzip = corpzip;
    }

    public String getYearincome() {
        return yearincome;
    }

    public void setYearincome(String yearincome) {
        this.yearincome = yearincome;
    }

    public String getModelcode() {
        return modelcode;
    }

    public void setModelcode(String modelcode) {
        this.modelcode = modelcode;
    }

    public String getOccptn() {
        return occptn;
    }

    public void setOccptn(String occptn) {
        this.occptn = occptn;
    }

    public String getComchoic() {
        return comchoic;
    }

    public void setComchoic(String comchoic) {
        this.comchoic = comchoic;
    }

    public String getCommprov() {
        return commprov;
    }

    public void setCommprov(String commprov) {
        this.commprov = commprov;
    }

    public String getCommcity() {
        return commcity;
    }

    public void setCommcity(String commcity) {
        this.commcity = commcity;
    }

    public String getCommcounty() {
        return commcounty;
    }

    public void setCommcounty(String commcounty) {
        this.commcounty = commcounty;
    }

    public String getCommaddr() {
        return commaddr;
    }

    public void setCommaddr(String commaddr) {
        this.commaddr = commaddr;
    }

    public String getCommaddrid() {
        return commaddrid;
    }

    public void setCommaddrid(String commaddrid) {
        this.commaddrid = commaddrid;
    }

    public String getCommazip() {
        return commazip;
    }

    public void setCommazip(String commazip) {
        this.commazip = commazip;
    }

    public String getReltname1() {
        return reltname1;
    }

    public void setReltname1(String reltname1) {
        this.reltname1 = reltname1;
    }

    public String getReltsex1() {
        return reltsex1;
    }

    public void setReltsex1(String reltsex1) {
        this.reltsex1 = reltsex1;
    }

    public String getReltship1() {
        return reltship1;
    }

    public void setReltship1(String reltship1) {
        this.reltship1 = reltship1;
    }

    public String getReltmobl1() {
        return reltmobl1;
    }

    public void setReltmobl1(String reltmobl1) {
        this.reltmobl1 = reltmobl1;
    }

    public String getReltphzon1() {
        return reltphzon1;
    }

    public void setReltphzon1(String reltphzon1) {
        this.reltphzon1 = reltphzon1;
    }

    public String getRelaphone1() {
        return relaphone1;
    }

    public void setRelaphone1(String relaphone1) {
        this.relaphone1 = relaphone1;
    }

    public String getReltphext1() {
        return reltphext1;
    }

    public void setReltphext1(String reltphext1) {
        this.reltphext1 = reltphext1;
    }

    public String getReltname2() {
        return reltname2;
    }

    public void setReltname2(String reltname2) {
        this.reltname2 = reltname2;
    }

    public String getReltsex2() {
        return reltsex2;
    }

    public void setReltsex2(String reltsex2) {
        this.reltsex2 = reltsex2;
    }

    public String getReltship2() {
        return reltship2;
    }

    public void setReltship2(String reltship2) {
        this.reltship2 = reltship2;
    }

    public String getReltmobl2() {
        return reltmobl2;
    }

    public void setReltmobl2(String reltmobl2) {
        this.reltmobl2 = reltmobl2;
    }

    public String getRtcophzn2() {
        return rtcophzn2;
    }

    public void setRtcophzn2(String rtcophzn2) {
        this.rtcophzn2 = rtcophzn2;
    }

    public String getRtcophon2() {
        return rtcophon2;
    }

    public void setRtcophon2(String rtcophon2) {
        this.rtcophon2 = rtcophon2;
    }

    public String getRtcophet2() {
        return rtcophet2;
    }

    public void setRtcophet2(String rtcophet2) {
        this.rtcophet2 = rtcophet2;
    }

    public String getAlmebno() {
        return almebno;
    }

    public void setAlmebno(String almebno) {
        this.almebno = almebno;
    }

    public String getAccgetm() {
        return accgetm;
    }

    public void setAccgetm(String accgetm) {
        this.accgetm = accgetm;
    }

    public String getAccaddrf() {
        return accaddrf;
    }

    public void setAccaddrf(String accaddrf) {
        this.accaddrf = accaddrf;
    }

    public String getRmbcred() {
        return rmbcred;
    }

    public void setRmbcred(String rmbcred) {
        this.rmbcred = rmbcred;
    }

    public String getMamobile() {
        return mamobile;
    }

    public void setMamobile(String mamobile) {
        this.mamobile = mamobile;
    }

    public String getSmsphone() {
        return smsphone;
    }

    public void setSmsphone(String smsphone) {
        this.smsphone = smsphone;
    }

    public String getQesno() {
        return qesno;
    }

    public void setQesno(String qesno) {
        this.qesno = qesno;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCrdrflag() {
        return crdrflag;
    }

    public void setCrdrflag(String crdrflag) {
        this.crdrflag = crdrflag;
    }

    public String getAuthref() {
        return authref;
    }

    public void setAuthref(String authref) {
        this.authref = authref;
    }

    public String getStatdate() {
        return statdate;
    }

    public void setStatdate(String statdate) {
        this.statdate = statdate;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getReltno() {
        return reltno;
    }

    public void setReltno(String reltno) {
        this.reltno = reltno;
    }

    public String getDrawmode() {
        return drawmode;
    }

    public void setDrawmode(String drawmode) {
        this.drawmode = drawmode;
    }

    public String getDrawaddr() {
        return drawaddr;
    }

    public void setDrawaddr(String drawaddr) {
        this.drawaddr = drawaddr;
    }

    public String getMachgf() {
        return machgf;
    }

    public void setMachgf(String machgf) {
        this.machgf = machgf;
    }

    public String getMachgmobile() {
        return machgmobile;
    }

    public void setMachgmobile(String machgmobile) {
        this.machgmobile = machgmobile;
    }

    public String getEmladdrf() {
        return emladdrf;
    }

    public void setEmladdrf(String emladdrf) {
        this.emladdrf = emladdrf;
    }

    public String getStmtemail() {
        return stmtemail;
    }

    public void setStmtemail(String stmtemail) {
        this.stmtemail = stmtemail;
    }

    public String getOutacctype1() {
        return outacctype1;
    }

    public void setOutacctype1(String outacctype1) {
        this.outacctype1 = outacctype1;
    }

    public String getOutcardno1() {
        return outcardno1;
    }

    public void setOutcardno1(String outcardno1) {
        this.outcardno1 = outcardno1;
    }

    public String getDdamttype1() {
        return ddamttype1;
    }

    public void setDdamttype1(String ddamttype1) {
        this.ddamttype1 = ddamttype1;
    }

    public String getOutacctype2() {
        return outacctype2;
    }

    public void setOutacctype2(String outacctype2) {
        this.outacctype2 = outacctype2;
    }

    public String getOutcardno2() {
        return outcardno2;
    }

    public void setOutcardno2(String outcardno2) {
        this.outcardno2 = outcardno2;
    }

    public String getDdamttype2() {
        return ddamttype2;
    }

    public void setDdamttype2(String ddamttype2) {
        this.ddamttype2 = ddamttype2;
    }

    public String getPaydays() {
        return paydays;
    }

    public void setPaydays(String paydays) {
        this.paydays = paydays;
    }

    public String getFftrxtype() {
        return fftrxtype;
    }

    public void setFftrxtype(String fftrxtype) {
        this.fftrxtype = fftrxtype;
    }

    public String getEcshflag() {
        return ecshflag;
    }

    public void setEcshflag(String ecshflag) {
        this.ecshflag = ecshflag;
    }

    public String getCreditcardno() {
        return creditcardno;
    }

    public void setCreditcardno(String creditcardno) {
        this.creditcardno = creditcardno;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getFeatgype() {
        return featgype;
    }

    public void setFeatgype(String featgype) {
        this.featgype = featgype;
    }

    public String getFeatname() {
        return featname;
    }

    public void setFeatname(String featname) {
        this.featname = featname;
    }

    public String getFakaorg() {
        return fakaorg;
    }

    public void setFakaorg(String fakaorg) {
        this.fakaorg = fakaorg;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

}
