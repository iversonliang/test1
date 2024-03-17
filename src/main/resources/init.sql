-- 如果没有数据库，创建数据库，如果不想创建数据库，注意修改连接配置参数
create database bear;
use bear;

CREATE TABLE `order_info` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                              `period` int(11) NOT NULL COMMENT '账期月份',
                              `amount` decimal(10,4) NOT NULL COMMENT '金额',
                              `user_name` varchar(20) NOT NULL COMMENT '下单人',
                              `phone` varchar(11) NOT NULL COMMENT '手机号',
                              `created` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                              `creator` varchar(20) NOT NULL COMMENT '创建人',
                              `modified` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                              `modifier` varchar(20) NOT NULL COMMENT '修改人',
                              PRIMARY KEY (`id`),
                              KEY `idx_period` (`period`),
                              KEY `idx_modified` (`modified`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 子查询
explain
select * from (select id from order_info where period = 202208 order by modified limit 0, 1000)
                  as temp join order_info where temp.id = order_info.id;

explain
select * from order_info where period = 202208 order by modified limit 0, 1000;
show PROFILES;


CREATE INDEX idx_period_modified ON order_info(period, modified);
DROP INDEX idx_period_modified ON order_info;


select max(id) from order_info;

desc order_info;
select * from order_info limit 100;

select distinct(period) from order_info;