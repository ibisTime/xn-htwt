UPDATE `tsys_node`
SET `code`='j1',
    `type`='j'
WHERE `code` = '003_01';
UPDATE `tsys_node`
SET `code`='j2',
    `type`='j'
WHERE `code` = '003_02';
UPDATE `tsys_node`
SET `code`='j3',
    `type`='j'
WHERE `code` = '003_03';
UPDATE `tsys_node`
SET `code`='j4',
    `type`='j'
WHERE `code` = '003_04';
UPDATE `tsys_node`
SET `code`='j5',
    `type`='j'
WHERE `code` = '003_05';
UPDATE `tsys_node`
SET `code`='j6',
    `type`='j'
WHERE `code` = '003_06';
UPDATE `tsys_node`
SET `code`='j7',
    `type`='j'
WHERE `code` = '003_07';
UPDATE `tsys_node`
SET `code`='j8',
    `type`='j'
WHERE `code` = '003_08';
UPDATE `tsys_node`
SET `code`='j9',
    `type`='j'
WHERE `code` = '003_09';
UPDATE `tsys_node`
SET `code`='j10',
    `type`='j'
WHERE `code` = '003_10';
UPDATE `tsys_node`
SET `code`='j11',
    `type`='j'
WHERE `code` = '003_11';
UPDATE `tsys_node`
SET `code`='j12',
    `type`='j'
WHERE `code` = '003_12';
UPDATE `tsys_node`
SET `code`='j13',
    `type`='j'
WHERE `code` = '003_13';
UPDATE `tsys_node`
SET `code`='j14',
    `type`='j'
WHERE `code` = '003_14';
UPDATE `tsys_node`
SET `code`='j15',
    `type`='j'
WHERE `code` = '003_15';
UPDATE `tsys_node`
SET `code`='j16',
    `type`='j'
WHERE `code` = '003_16';
UPDATE `tsys_node`
SET `code`='j17',
    `type`='j'
WHERE `code` = '003_17';
UPDATE `tsys_node`
SET `code`='j18',
    `type`='j'
WHERE `code` = '003_18';
UPDATE `tsys_node`
SET `code`='j19',
    `type`='j'
WHERE `code` = '003_19';
UPDATE `tsys_node`
SET `code`='j20',
    `type`='j'
WHERE `code` = '003_20';


UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j2',
    `next_node`='j3'
WHERE `id` = '119';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j3',
    `next_node`='j4',
    `back_node`='j2'
WHERE `id` = '120';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j4',
    `next_node`='j5',
    `back_node`='j2'
WHERE `id` = '121';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j5',
    `next_node`='j6',
    `back_node`='j2'
WHERE `id` = '122';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j6',
    `next_node`='j7'
WHERE `id` = '123';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j8',
    `next_node`='j9'
WHERE `id` = '124';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j9',
    `next_node`='j10'
WHERE `id` = '125';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j10',
    `next_node`='j11'
WHERE `id` = '126';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j11',
    `next_node`='j17',
    `back_node`='j13'
WHERE `id` = '127';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j17',
    `next_node`='j18'
WHERE `id` = '128';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j18',
    `next_node`='j19',
    `back_node`='j17'
WHERE `id` = '129';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j19',
    `back_node`='j18'
WHERE `id` = '130';
UPDATE `tsys_node_flow`
SET `type`='j',
    `current_node`='j20',
    `next_node`='j2',
    `back_node`='j1'
WHERE `id` = '134';


ALTER TABLE `tb_bank`
  CHANGE COLUMN `client_valid_date` `client_valid_date` VARCHAR(255) NULL DEFAULT NULL COMMENT '委托有效期',
  ADD COLUMN `mechanism_abb` VARCHAR(255) NULL COMMENT '贷款机构简称' AFTER `bank_name`,
  ADD COLUMN `bank_full_name` VARCHAR(255) NULL COMMENT '银行全称' AFTER `mechanism_abb`,
  ADD COLUMN `mobile` VARCHAR(32) NULL COMMENT '电话' AFTER `subbranch`;
