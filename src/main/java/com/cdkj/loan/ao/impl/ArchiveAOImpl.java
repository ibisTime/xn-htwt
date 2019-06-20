package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IArchiveAO;
import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISocialRelationBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Archive;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.SocialRelation;
import com.cdkj.loan.dto.req.XN632800Req;
import com.cdkj.loan.dto.req.XN632800ReqChild;
import com.cdkj.loan.dto.req.XN632802Req;
import com.cdkj.loan.dto.req.XN632802ReqChild;
import com.cdkj.loan.dto.res.XN632803Res;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ESysUserType;
import com.cdkj.loan.enums.EWorkStatus;
import com.cdkj.loan.exception.BizException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author: jiafr
 * @since: 2018年6月4日 下午7:41:28
 * @history:
 */
@Service
public class ArchiveAOImpl implements IArchiveAO {

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private ISocialRelationBO socialRelationBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSUserAO sysUserAO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    @Transactional
    public String addArchive(XN632800Req req) {
        // 判断身份证和手机号是否存在，已存在就报错
        archiveBO.checkArchiveByMobile(req.getMobile(), null);
        archiveBO.checkArchiveByIdNo(req.getIdNo(), null);

        Archive data = new Archive();
        String code = OrderNoGenerater
                .generate(EGeneratePrefix.RECRUITAPPLY.getCode());
        data.setCode(code);
        data.setRealName(req.getRealName());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setAvatar(req.getAvatar());
        data.setJobNo(req.getJobNo());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        String departmentCode = departmentBO.getDepartment(req.getPostCode())
                .getParentCode();
        data.setDepartmentCode(departmentCode);
        data.setPostCode(req.getPostCode());
        data.setJobClasses(req.getJobClasses());
        data.setBirthday(DateUtil.strToDate(req.getBirthday(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGender(req.getGender());
        data.setNation(req.getNation());
        data.setNativePlace(req.getNativePlace());
        data.setMarryStatus(req.getMarryStatus());
        data.setPolitics(req.getPolitics());
        data.setMajor(req.getMajor());
        data.setEducation(req.getEducation());
        data.setWorkStatus(req.getWorkStatus());
        data.setHealth(req.getHealth());
        data.setSalaryCard(req.getSalaryCard());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setFiveInsuranceInfo(req.getFiveInsuranceInfo());
        data.setResidenceAddress(req.getResidenceAddress());
        data.setResidenceProperty(req.getResidenceProperty());
        data.setSocialSecurityRegDatetime(
                DateUtil.strToDate(req.getSocialSecurityRegDatetime(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCurrentAddress(req.getCurrentAddress());
        data.setEmergencyContact(req.getEmergencyContact());
        data.setEmergencyContactMobile(req.getEmergencyContactMobile());
        data.setContractDeadline(req.getContractDeadline());
        data.setContractType(req.getContractType());
        data.setProbationTime(req.getProbationTime());
        data.setConvertDatetime(DateUtil.strToDate(req.getConvertDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setLeaveDatetime(DateUtil.strToDate(req.getLeaveDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEntranceNo(req.getEntranceNo());
        data.setCheckNo(req.getCheckNo());
        data.setCarNo(req.getCarNo());
        data.setIdNoPdf(req.getIdNoPdf());
        data.setPhoto(req.getPhoto());
        data.setWechat(req.getWechat());
        data.setQq(req.getQq());
        data.setPerformSalaryStandard(req.getPerformSalaryStandard());
        data.setQuarterlyAwardStandard(req.getQuarterlyAwardStandard());
        data.setCommumicationFeeStandard(req.getCommumicationFeeStandard());
        data.setProvincialBedStandard(req.getProvincialBedStandard());
        data.setNoProvincialBedStandard(req.getNoProvincialBedStandard());
        data.setTrafficAward(StringValidater.toLong(req.getTrafficAward()));
        data.setMobileAward(StringValidater.toLong(req.getMobileAward()));
        data.setTaxiWard(StringValidater.toLong(req.getTaxiWard()));
        data.setMealAward(StringValidater.toLong(req.getMealAward()));
        data.setStatus(EBoolean.YES.getCode());
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        if (StringUtils.isNotBlank(req.getLeaveDatetime())
                && StringUtils.isNotBlank(req.getEntryDatetime())) {
            int num = DateUtil.daysBetween(req.getEntryDatetime(),
                    req.getLeaveDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING);
            String workingYears = String.valueOf(((int) (num / 365)));
            data.setWorkingYears(workingYears);
        }

        SYSUser sysUserLoginName = sysUserBO
                .getUserByLoginName(req.getRealName());
        if (sysUserLoginName != null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该姓名已存在，请重新填写！");
        }
        SYSUser sysUserMobile = sysUserBO.getUserByMobile(req.getMobile());
        if (sysUserMobile != null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该手机号已存在，请重新填写！");
        }
        String userId = null;
        // 默认生成账号为真实姓名，默认密码为手机号码
        userId = sysUserAO.doAddUser(ESysUserType.Plat.getCode(),
                req.getRealName(), req.getMobile(), req.getMobile(),
                req.getAvatar(), req.getRealName(), SysConstants.COMMON_ROLE,
                req.getPostCode(), code, null);
        data.setUserId(userId);
        archiveBO.saveArchive(data);

        List<XN632800ReqChild> socialRelationList = req.getSocialRelationList();
        if (CollectionUtils.isEmpty(socialRelationList)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "社会关系为空！");
        }
        for (XN632800ReqChild xn632800ReqChild : socialRelationList) {
            SocialRelation data1 = new SocialRelation();
            data1.setArchiveCode(code);
            data1.setRealName(xn632800ReqChild.getRealName());
            data1.setRelation(xn632800ReqChild.getRelation());
            data1.setCompanyName(xn632800ReqChild.getCompanyName());
            data1.setPost(xn632800ReqChild.getPost());
            data1.setContact(xn632800ReqChild.getContact());
            socialRelationBO.saveSocialRelation(data1);
        }

        return code;
    }

    @Override
    public void editArchive(XN632802Req req) {
        Archive data = archiveBO.getArchive(req.getCode());
        archiveBO.checkArchiveByMobile(req.getMobile(), data.getCode());
        archiveBO.checkArchiveByIdNo(req.getIdNo(), data.getCode());

        data.setCode(req.getCode());
        data.setRealName(req.getRealName());
        data.setIdNo(req.getIdNo());
        data.setMobile(req.getMobile());
        data.setAvatar(req.getAvatar());
        data.setJobNo(req.getJobNo());
        data.setEntryDatetime(DateUtil.strToDate(req.getEntryDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        String departmentCode = departmentBO.getDepartment(req.getPostCode())
                .getParentCode();
        data.setDepartmentCode(departmentCode);
        data.setPostCode(req.getPostCode());
        data.setJobClasses(req.getJobClasses());
        data.setBirthday(DateUtil.strToDate(req.getBirthday(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setGender(req.getGender());
        data.setNation(req.getNation());
        data.setNativePlace(req.getNativePlace());
        data.setMarryStatus(req.getMarryStatus());
        data.setPolitics(req.getPolitics());
        data.setMajor(req.getMajor());
        data.setEducation(req.getEducation());
        data.setWorkStatus(req.getWorkStatus());
        data.setHealth(req.getHealth());
        data.setSalaryCard(req.getSalaryCard());
        data.setBankName(req.getBankName());
        data.setSubbranch(req.getSubbranch());
        data.setFiveInsuranceInfo(req.getFiveInsuranceInfo());
        data.setResidenceAddress(req.getResidenceAddress());
        data.setResidenceProperty(req.getResidenceProperty());
        data.setSocialSecurityRegDatetime(
                DateUtil.strToDate(req.getSocialSecurityRegDatetime(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setCurrentAddress(req.getCurrentAddress());
        data.setEmergencyContact(req.getEmergencyContact());
        data.setEmergencyContactMobile(req.getEmergencyContactMobile());
        data.setContractDeadline(req.getContractDeadline());
        data.setContractType(req.getContractType());
        data.setProbationTime(req.getProbationTime());
        data.setConvertDatetime(DateUtil.strToDate(req.getConvertDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setLeaveDatetime(DateUtil.strToDate(req.getLeaveDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setEntranceNo(req.getEntranceNo());
        data.setCheckNo(req.getCheckNo());
        data.setCarNo(req.getCarNo());
        data.setIdNoPdf(req.getIdNoPdf());
        data.setPhoto(req.getPhoto());
        data.setWechat(req.getWechat());
        data.setQq(req.getQq());
        data.setPerformSalaryStandard(req.getPerformSalaryStandard());
        data.setQuarterlyAwardStandard(req.getQuarterlyAwardStandard());
        data.setCommumicationFeeStandard(req.getCommumicationFeeStandard());
        data.setProvincialBedStandard(req.getProvincialBedStandard());
        data.setNoProvincialBedStandard(req.getNoProvincialBedStandard());
        data.setTrafficAward(StringValidater.toLong(req.getTrafficAward()));
        data.setMobileAward(StringValidater.toLong(req.getMobileAward()));
        data.setTaxiWard(StringValidater.toLong(req.getTaxiWard()));
        data.setMealAward(StringValidater.toLong(req.getMealAward()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());
        data.setWorkingYears(req.getWorkingYears());

        socialRelationBO.removeSocialRelation(req.getCode());
        for (XN632802ReqChild xn632802ReqChild : req.getSocialRelationList()) {
            SocialRelation socialRelation = new SocialRelation();
            socialRelation.setArchiveCode(req.getCode());
            socialRelation.setRealName(xn632802ReqChild.getRealName());
            socialRelation.setRelation(xn632802ReqChild.getRelation());
            socialRelation.setCompanyName(xn632802ReqChild.getCompanyName());
            socialRelation.setPost(xn632802ReqChild.getPost());
            socialRelation.setContact(xn632802ReqChild.getContact());
            socialRelationBO.saveSocialRelation(socialRelation);
        }

        archiveBO.refreshArchive(data);

        // 判断是否有用户更新
        if (StringUtils.isNotBlank(data.getUserId())) {
            // 验证手机号
            sysUserBO.checkMobile(data.getMobile(), data.getUserId());

            SYSUser sysUser = sysUserBO.getUser(data.getUserId());
            sysUser.setMobile(data.getMobile());
            sysUser.setPhoto(req.getAvatar());
            sysUser.setRealName(data.getRealName());
            sysUser.setPostCode(data.getPostCode());
            sysUser.setDepartmentCode(data.getDepartmentCode());
            sysUser.setCompanyCode(
                    departmentBO.getCompanyByDepartment(data.getDepartmentCode()));
            sysUserBO.refreshMobileDepartment(sysUser);
        }
    }

    @Override
    public Paginable<Archive> queryArchivePage(int start, int limit,
            Archive condition) {
        return archiveBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Archive> queryArchiveList(Archive condition) {
        return archiveBO.queryArchiveList(condition);
    }

    @Override
    public Archive getArchive(String code) {
        Archive archive = archiveBO.getArchive(code);

        SocialRelation condition = new SocialRelation();
        condition.setArchiveCode(code);
        List<SocialRelation> list = socialRelationBO
                .querySocialRelationList(condition);

        archive.setSocialRelationList(list);

        return archive;
    }

    @Override
    @Transactional
    public void editLeaveArchive(Archive data) {
        if (!archiveBO.isArchiveExist(data.getCode())) {
            throw new BizException("xn0000", "人事档案不存在");
        }
        Archive archive = archiveBO.getArchive(data.getCode());
        archive.setRealName(data.getRealName());
        archive.setLeaveDatetime(data.getLeaveDatetime());
        archive.setHeirPeople(data.getHeirPeople());
        archive.setLeaveReason(data.getLeaveReason());
        archive.setUpdater(data.getUpdater());
        archive.setUpdateDatetime(new Date());
        archive.setRemark(data.getRemark());
        archive.setWorkStatus(EWorkStatus.LEAVE.getCode());
        archiveBO.refreshLeaveArchive(archive);

        // 锁定用户
        SYSUser sysUser = sysUserBO.getUserByArchiveCode(data.getCode());
        if (null != sysUser) {
            sysUserBO.refreshUserLock(sysUser.getUserId());
        }
    }

    @Override
    public void removeLeaveArchive(String code) {
        archiveBO.removeArchive(code);
    }

    @Override
    public void statisticsAge(Archive condition) {
        int age1to20 = 0;
        int age20to30 = 0;
        int age30to40 = 0;
        int age40to50 = 0;
        int age50to100 = 0;
        List<Archive> archiveList = archiveBO.queryArchiveList(condition);
        for (Archive archive : archiveList) {
            // 当前年
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int year = calendar.get(Calendar.YEAR);
            // 出生年
            calendar.setTime(archive.getBirthday());
            int birthday = calendar.get(Calendar.YEAR);
            // 年龄
            int age = year - birthday;
            if (age > 0 && age < 20) {
                age1to20 = age1to20 + 1;
            } else if (age >= 20 && age < 30) {
                age20to30 = age20to30 + 1;
            } else if (age >= 30 && age < 40) {
                age30to40 = age30to40 + 1;
            } else if (age >= 40 && age < 50) {
                age40to50 = age40to50 + 1;
            } else if (age >= 50 && age < 100) {
                age50to100 = age50to100 + 1;
            }
        }
    }

    @Override
    public List<XN632803Res> getTotal() {
        List<XN632803Res> list = new ArrayList<XN632803Res>();

        XN632803Res res1 = new XN632803Res();
        res1.setAge(0 + "至" + 20);
        int count1 = archiveBO.getTotalCount(0, 20);
        res1.setCount(count1);
        list.add(res1);

        XN632803Res res2 = new XN632803Res();
        res2.setAge(20 + "至" + 30);
        int count2 = archiveBO.getTotalCount(20, 30);
        res2.setCount(count2);
        list.add(res2);

        XN632803Res res3 = new XN632803Res();
        res3.setAge(30 + "至" + 40);
        int count3 = archiveBO.getTotalCount(30, 40);
        res3.setCount(count3);
        list.add(res3);

        XN632803Res res4 = new XN632803Res();
        res4.setAge(40 + "至" + 50);
        int count4 = archiveBO.getTotalCount(40, 50);
        res4.setCount(count4);
        list.add(res4);

        XN632803Res res5 = new XN632803Res();
        res5.setAge(50 + "至" + 100);
        int count5 = archiveBO.getTotalCount(50, 100);
        res5.setCount(count5);
        list.add(res5);
        return list;
    }

}
