ALTER TABLE `tdq_credit` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;


ALTER TABLE `tdq_budget_order` 
ADD COLUMN `biz_code` VARCHAR(32) NULL COMMENT '业务编号' AFTER `code`;


insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a1','新录征信资料','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a2','录入征信结果','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a3','审核征信','a',NULL);
insert into `tsys_node` (`code`, `name`, `type`, `remark`) values('a1x','重录征信资料','a',NULL);





insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a1','a2',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a2','a3',NULL,NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a3','b1','a1x',NULL,NULL);
insert into `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`, `file_list`, `remark`) values('a','a1x','a2',NULL,NULL,NULL);

