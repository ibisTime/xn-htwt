INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('h3', '制卡完成', 'h');

UPDATE `tsys_dict` SET `dkey`='1' WHERE `id`='821';
UPDATE `tsys_dict` SET `dkey`='0' WHERE `id`='822';


INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g1', '确认用款单', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g2', '用款一审', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g3', '用款二审', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g4', '制单回录', 'g');
INSERT INTO `tsys_node` (`code`, `name`, `type`) VALUES ('g5', '垫资回录', 'g');

INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('g', 'g1', 'g2');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('g', 'g2', 'g3', 'c1');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`, `back_node`) VALUES ('g', 'g3', 'g4', 'c1');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('g', 'g4', 'g5');
INSERT INTO `tsys_node_flow` (`type`, `current_node`, `next_node`) VALUES ('g', 'g5', 'c1');

INSERT INTO `tdq_file_list` (`category`, `kname`, `vname`, `attach_type`, `number`) VALUES ('advance', 'advance_bill_pdf', '垫资水单', '图片', '1');

DELETE FROM `tsys_node` WHERE `code`='e6';
UPDATE `tsys_node_flow` SET `next_node`='f1' WHERE `id`='94';
DELETE FROM `tsys_node_flow` WHERE `id`='95';
