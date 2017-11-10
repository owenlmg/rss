drop table if exists `feed`;
drop table if exists `image`;
drop table if exists `item`;
drop table if exists `user`;


create table `image` (
    `id` int not null auto_increment,
    `title` varchar(32) ,
    `link` varchar(64),
    `url` varchar(64),
    `description` varchar(255),
    primary key (`id`)
) engine=InnoDB;

create table `item` (
    `id` int not null auto_increment,
    `title` varchar(64) not null,
    `link` varchar(64) not null,
    `author` varchar(64),
    `category` varchar(16),
    `pub_date` timestamp,
    `comments` varchar(64),
    `description_type` varchar(16),
    `description_value` varchar(10240),
    primary key (`id`)
) engine=InnoDB;

CREATE TABLE `feed` (
	`id`  int NOT NULL AUTO_INCREMENT ,
	`title`  varchar(255) NOT NULL COMMENT '标题' ,
	`link`  varchar(255) NOT NULL COMMENT 'rss链接' ,
    `url` varchar(255) default null,
    `image_id` int,
    `language` varchar(16),
    `rating` varchar(16),
    `copyright` varchar(32),
    `generator` varchar(16),
    `ttl` tinyint,
	`rss_type`  int NOT NULL COMMENT '类型' ,
	`last_upd_date`  timestamp NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最近一次更新时间' ,
	`refer_count`  int NOT NULL COMMENT '被使用次数' ,
	`upd_cycle`  int NULL COMMENT '更新周期' ,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;

create table `user` (
    `id` int not null auto_increment,
    `login_name` varchar(16) not null comment '账号',
    `login_pass` varchar(32) not null comment '密码',
    `nickname` varchar(32) not null comment '',
    `open_id` varchar(32),
    `sex` tinyint,
    `head_img_url` varchar(64),
    `create_time` timestamp,
    `last_use_time` timestamp,
    primary key (`id`)
) engine=InnoDB;