/**
 * @Title XN632515Req.java
 * @Package com.cdkj.loan.dto.req
 * @Description
 * @author taojian
 * @date 2019年4月2日 下午7:34:42
 * @version V1.0
 */
package com.cdkj.loan.dto.req;

import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 分页查业务
 *
 * @author: taojian
 * @since: 2019年4月2日 下午7:34:42
 * @history:
 */
@Data
public class XN632957Req extends APageReq {

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 业务类型（0新车1二手车）
    private String type;

    // 预算单类型 (1正常单2外单)
    private String bizType;

    // 还款业务编号
    private String repayBizCode;

    // 业务公司编号
    private String companyCode;

    // 团队编号
    private String teamCode;

    // 团队队长
    private String captainCode;

    // 业务员编号
    private String saleUserId;

    // 内勤编号
    private String insideJob;

    // 贷款银行
    private String loanBank;

    // 贷款额
    private Long loanAmount;

    // 入档位置
    private String enterLocation;

    // 入档时间
    private Date enterDatetime;

    // 档案目录
    private String enterFilelist;

    // 主线状态
    private String status;

    // 制卡状态
    private String makeCardStatus;

    // 面签状态
    private String intevStatus;

    // 发保合GPS状态
    private String fbhgpsStatus;

    // 存档状态
    private String enterStatus;

    // 作废状态
    private String cancelStatus;

    // 当前节点编号
    private String curNodeCode;

    // 面签节点编号
    private String intevCurNodeCode;

    // 制卡节点
    private String makeCardNode;

    // 发保合gps节点
    private String fbhgpsNode;

    // 客户申请作废时的节点编号
    private String cancelNodeCode;

    // 是否需要安装GPS
    private String isGpsAz;

    // 是否融资
    private String isFinacing;

    // 是否垫资
    private String isAdvanceFund;

    // 是否我司续保
    private String isPlatInsure;

    // 应收手续费总额
    private Long shouldFeeAmount;

    // 实收手续费总额
    private Long realFeeAmount;

    // 担保方式
    private String guaMode;

    // 征信说明
    private String creditNote;

    // 申请时间
    private Date applyDatetime;

    // 备注
    private String remark;

    // *********************************

    private SYSUser sysUser;

    private Credit credit;

    private BudgetOrder budgetOrder;

    private List<Attachment> attachments;

    private List<BizTask> bizTasks;

    private List<SYSBizLog> bizLogs;

    private List<String> curNodeCodeList;

    private List<String> intevCurNodeCodeList;

    private List<String> makeCardNodeList;

    private List<String> fbhgpsNodeList;

    private List<String> enterNodeCodeList;

    private List<String> cancelNodeCodeList;

    private String roleCode;

    private String userId;

    // 主贷人
    private CreditUser creditUser;

    // 贷款银行
    private String loanBankName;

    // 申请时间起
    private Date applyDatetimeStart;

    // 申请时间止
    private Date applyDatetimeEnd;

    private String userName;

    private String isMy;

}
