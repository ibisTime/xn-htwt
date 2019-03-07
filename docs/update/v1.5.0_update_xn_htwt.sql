ALTER TABLE `dev_xn_htwt`.`tmall_product_order` 
ADD COLUMN `repay_biz_code` VARCHAR(32) NULL COMMENT '还款业务编号' AFTER `code`,
ADD COLUMN `bankcardCode` VARCHAR(32) NULL COMMENT '银行卡编号' AFTER `product_specs_name`,
ADD COLUMN `sf_amount` BIGINT(20) NULL COMMENT '首付金额' AFTER `sf_rate`,
ADD COLUMN `loan_amount` BIGINT(20) NULL COMMENT '贷款金额' AFTER `sf_amount`,
ADD COLUMN `status` VARCHAR(4) NULL COMMENT '状态' AFTER `periods`;
ADD COLUMN `yunfei` BIGINT(20) NULL COMMENT '运费' AFTER `bank_rate`,
ADD COLUMN `deliverer` VARCHAR(32) NULL COMMENT '发货人' AFTER `yunfei`,
ADD COLUMN `delivery_datetime` DATETIME NULL COMMENT '发货时间' AFTER `deliverer`,
ADD COLUMN `logistics_company` VARCHAR(32) NULL COMMENT '物流公司编号' AFTER `delivery_datetime`,
ADD COLUMN `logistics_code` VARCHAR(32) NULL COMMENT '物流单号' AFTER `logistics_company`,
ADD COLUMN `pdf` VARCHAR(255) NULL COMMENT '物流单' AFTER `logistics_code`,
ADD COLUMN `signer` VARCHAR(32) NULL COMMENT '签收人' AFTER `pdf`,
ADD COLUMN `sign_datetime` DATETIME NULL COMMENT '签收时间' AFTER `signer`, COMMENT = '订单快照' , RENAME TO  `dev_xn_htwt`.`tmall_specs_order` ;


ALTER TABLE `dev_xn_htwt`.`tmall_order` 
DROP COLUMN `sign_datetime`,
DROP COLUMN `signer`,
DROP COLUMN `pdf`,
DROP COLUMN `logistics_code`,
DROP COLUMN `logistics_company`,
DROP COLUMN `delivery_datetime`,
DROP COLUMN `deliverer`,
DROP COLUMN `bank_rate`,
DROP COLUMN `periods`,
DROP COLUMN `loan_amount`,
DROP COLUMN `sf_amount`,
DROP COLUMN `sf_rate`,
DROP COLUMN `bankcard_code`,
DROP COLUMN `repay_biz_code`,
CHANGE COLUMN `amount` `amount` BIGINT(20) NULL DEFAULT NULL COMMENT '总金额' ,
CHANGE COLUMN `yunfei` `yunfei` BIGINT(20) NULL DEFAULT NULL COMMENT '总运费' , COMMENT = '订单' ;


ALTER TABLE `dev_xn_htwt`.`tstd_user` 
DROP COLUMN `kind`;


