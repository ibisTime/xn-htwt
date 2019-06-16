package com.cdkj.loan.common;

public class SysConstants {

    public static final String admin = "admin";

    public static final String COMMON_ROLE = "SR20180000000000000PTYG"; // 普通员工角色编号

    public static final String WITHDRAW_FEE = "withdraw_fee"; // 提现手续费

    // 信用分配置
    public static final String REGISTER_ADD = "register_add"; // 新用户注册初始信用分

    public static final String CAR_NORMAL = "car_normal"; // 车贷还款计划每正常执行一次

    public static final String PRODUCT_NORMAL = "product_normal"; // 商品还款计划每正常执行一次

    public static final String CAR_DELAY = "car_delay"; // 商品还款计划每延期执行一次

    public static final String PRODUCT_DELAY = "product_delay"; // 商品还款计划每延期执行一次

    // 七牛云图片配置
    public static String QINIU_ACCESS_KEY = "qiniu_access_key";

    public static String QINIU_SECRET_KEY = "qiniu_secret_key";

    public static String QINIU_BUCKET = "qiniu_bucket";

    public static String QINIU_DOMAIN = "qiniu_domain";

    // 取现规则配置
    public static String CUSERQXBS = "CUSERQXBS"; // C端用户取现倍数

    public static String CUSERQXFL = "CUSERQXFL"; // C端用户取现费率

    public static String CUSERQXSX = "CUSERQXSX"; // C端用户取现时效

    public static String CUSERMONTIMES = "CUSERMONTIMES"; // C端用户每月取现次数

    public static String TRANSAMOUNTBS = "TRANSAMOUNTBS"; // C端2C端转账金额倍数

    public static String QXDBZDJE = "QXDBZDJE"; // 取现单笔最大金额

    public static String TQ_SERVICE = "tq_service";// 提前还款服务费

    // 短信模板
    public static String WITHDRAW = "您有一个新的取现订单（编号：%s）需要处理！"; // 有人提现

    // 短信通知配置
    public static String ZC_SMS_NOTICE = "zc_sms_notice"; // 仲裁短信通知

    public static String QX_SMS_NOTICE = "qx_sms_notice";// 取现短信通知

    // 年假天数
    public static String LEAVE_YEAR_HOUR = "leave_year_hour";// 年假天数

    // 公告范围类型
    public static String SCOPE_PEOPLE_TYPE = "scope_people_type";// 公告范围类型

    // 腾讯云配置
    public static String TX_APP_CODE = "tx_app_code";// 应用编号

    public static String TX_APP_ADMIN = "tx_app_admin";// 应用编号

    public static String TX_ACCESS_KEY = "tx_access_key";// 公钥

    public static String TX_SECRET_KEY = "tx_secret_key";// 私钥

    public static String TX_ACCOUNT_TYPE = "tx_account_type";// 账号类型

    // 每次处理的条数
    public static String REPAYPLAN_STEP = "repayplan_step";// 每次处理的条数

    // gps提成比例
    public static String BUDGET_GPS_DEDUCT_RATE = "budget_gps_deduct_rate";

    // 油补提成比例
    public static String BUDGET_OIL_SUBSIDY_RATE = "budget_oil_subsidy_rate";

    // 阿里云请求url
    public static String ALIYUN_HOST = "ALIYUN_HOST";

    // 阿里云请求url编号
    public static String ALIYUN_HOST_REST_PATH = "ALIYUN_HOST_REST_CODE";

    // 阿里云appcode
    public static String ALIYUN_APPCODE = "ALIYUN_APPCODE";
}
