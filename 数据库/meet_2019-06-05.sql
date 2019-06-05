# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.21)
# Database: meet
# Generation Time: 2019-06-05 14:46:57 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table affairs_people
# ------------------------------------------------------------

DROP TABLE IF EXISTS `affairs_people`;

CREATE TABLE `affairs_people` (
  `people_id` int(8) NOT NULL AUTO_INCREMENT,
  `affairs_id` int(8) NOT NULL,
  `user_id` int(8) NOT NULL,
  PRIMARY KEY (`people_id`),
  KEY `apid` (`affairs_id`),
  KEY `upid` (`user_id`),
  CONSTRAINT `apid` FOREIGN KEY (`affairs_id`) REFERENCES `affairs_table` (`affairs_id`),
  CONSTRAINT `upid` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `affairs_people` WRITE;
/*!40000 ALTER TABLE `affairs_people` DISABLE KEYS */;

INSERT INTO `affairs_people` (`people_id`, `affairs_id`, `user_id`)
VALUES
	(1,1,2),
	(2,3,2),
	(3,4,2),
	(4,5,2),
	(5,7,2),
	(6,9,2),
	(7,10,2),
	(8,12,2),
	(9,14,2),
	(10,17,2),
	(11,18,2),
	(12,25,2),
	(13,26,2),
	(14,2,3),
	(15,8,3),
	(16,11,3),
	(17,13,3),
	(18,6,4),
	(19,15,4),
	(20,20,4),
	(22,16,5),
	(23,19,5),
	(25,22,5),
	(26,23,5),
	(27,24,5),
	(38,42,2),
	(39,42,5),
	(40,42,4),
	(41,42,3),
	(42,42,1),
	(44,24,1),
	(45,24,2),
	(46,43,3),
	(47,43,4),
	(48,43,2),
	(49,44,4),
	(50,44,2),
	(51,45,5),
	(52,45,4),
	(53,45,3),
	(54,45,2),
	(55,46,2),
	(56,46,5),
	(57,46,4),
	(58,46,3);

/*!40000 ALTER TABLE `affairs_people` ENABLE KEYS */;
UNLOCK TABLES;

DELIMITER ;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 CREATE */ /*!50017 DEFINER=`root`@`localhost` */ /*!50003 TRIGGER `affairs_log` AFTER INSERT ON `affairs_people` FOR EACH ROW insert into message_log(user_id,message,`status`) values(NEW.`user_id`,'有新添加的会议日程,请尽快查看','1') */;;
DELIMITER ;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;


# Dump of table affairs_table
# ------------------------------------------------------------

DROP TABLE IF EXISTS `affairs_table`;

CREATE TABLE `affairs_table` (
  `affairs_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NOT NULL,
  `room_id` int(8) NOT NULL,
  `theme` varchar(512) NOT NULL DEFAULT 'null' COMMENT '会议主题',
  `file` varchar(2048) DEFAULT NULL COMMENT '会议文件',
  `participate` int(2) NOT NULL COMMENT '参与人数',
  `affairs_status` int(2) NOT NULL DEFAULT '0' COMMENT '待审核0 通过1',
  `arrangement_periodstart` datetime NOT NULL COMMENT '会议开始时间',
  `arrangement_periodend` datetime NOT NULL COMMENT '会议结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`affairs_id`),
  KEY `auid` (`user_id`),
  KEY `arid` (`room_id`),
  CONSTRAINT `arid` FOREIGN KEY (`room_id`) REFERENCES `meeting_room` (`room_id`),
  CONSTRAINT `auid` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申请事务表';

LOCK TABLES `affairs_table` WRITE;
/*!40000 ALTER TABLE `affairs_table` DISABLE KEYS */;

INSERT INTO `affairs_table` (`affairs_id`, `user_id`, `room_id`, `theme`, `file`, `participate`, `affairs_status`, `arrangement_periodstart`, `arrangement_periodend`, `create_time`, `edit_time`)
VALUES
	(1,2,1,'生物信息技术在社会中的用处','无',20,1,'2019-05-25 15:30:00','2019-05-26 18:50:00','2019-04-21 11:51:39','2019-06-03 00:13:38'),
	(2,3,3,'人工智能的推广','无',5,0,'2019-05-26 12:00:00','2019-05-26 12:30:00','2019-04-27 13:45:58','2019-06-03 00:02:01'),
	(3,2,1,'Python与爬虫讲座','无',12,0,'2019-05-23 12:00:00','2019-05-23 12:40:00','2019-04-28 12:17:42','2019-06-03 00:02:03'),
	(4,2,2,'大数据云计算','无',0,1,'2019-05-23 08:00:00','2019-05-23 09:00:00','2019-04-28 12:17:56','2019-05-21 11:15:31'),
	(5,2,4,'嵌入式','无',0,-1,'2019-05-23 19:00:00','2019-05-23 20:00:00','2019-04-28 12:23:26','2019-05-21 11:15:49'),
	(6,4,7,'图形处理','无',0,0,'2019-05-22 10:30:00','2019-05-22 12:00:00','2019-04-28 12:23:36','2019-06-03 00:02:04'),
	(7,2,1,'人工智能','无',0,1,'2019-05-22 08:00:00','2019-05-22 09:00:00','2019-04-28 12:23:44','2019-05-26 18:32:54'),
	(8,3,2,'形势与政策','无',0,1,'2019-05-22 19:00:00','2019-05-22 19:30:00','2019-04-28 12:23:50','2019-06-03 00:13:54'),
	(9,2,5,'用户体验设计','无',0,0,'2019-05-29 19:00:00','2019-05-29 19:30:00','2019-04-28 12:23:58','2019-06-03 00:02:06'),
	(10,2,6,'编译原理','无',0,0,'2019-05-29 10:00:00','2019-05-29 10:30:00','2019-04-28 12:24:05','2019-06-03 00:02:06'),
	(11,3,1,'汇编语言','无',0,0,'2019-05-29 09:00:00','2019-05-22 09:30:00','2019-04-28 12:24:12','2019-06-03 00:02:07'),
	(12,2,7,'Lisp在人工智能的用处','无',0,0,'2019-05-28 19:00:00','2019-05-28 19:30:00','2019-04-28 12:24:26','2019-06-03 00:02:07'),
	(13,3,2,'Javaee企业级应用开发讲座','无',0,0,'2019-05-31 09:00:00','2019-05-31 10:00:00','2019-04-28 12:24:32','2019-06-03 00:02:08'),
	(14,2,8,'国际金融贸易宣传','无',0,0,'2019-05-31 20:00:00','2019-05-22 20:45:00','2019-04-28 12:24:40','2019-06-03 00:02:09'),
	(15,4,2,'电影与人文','无',0,0,'2019-05-31 21:00:00','2019-05-31 23:30:00','2019-05-05 23:52:37','2019-06-03 00:02:09'),
	(16,5,8,'移动安全与信息防护','无',14,0,'2019-06-01 08:00:00','2019-06-01 10:00:00','2019-05-05 23:53:06','2019-06-03 00:02:10'),
	(17,2,4,'Kail的推广应用','FILE/meetfile/uploadxm/201905161037299780.txt',20,0,'2019-06-01 10:35:00','2019-06-01 11:55:00','2019-05-16 10:37:38','2019-06-03 00:02:10'),
	(18,2,4,'MySQL','FILE/meetfile/uploadxm/201905161045059362.docx',15,0,'2019-06-02 10:40:00','2019-06-02 12:40:00','2019-05-16 10:45:08','2019-06-03 00:02:11'),
	(19,5,2,'1','FILE/meetfile/uploadxl/201905191907464425.jpg',1,0,'2019-06-02 10:05:00','2019-06-02 10:30:00','2019-05-19 19:10:35','2019-06-03 00:02:11'),
	(20,4,1,'狗狗与人','FILE/meetfile/uploadxh/201905191916434014.docx',10,0,'2019-06-02 21:00:00','2019-06-02 22:30:00','2019-05-19 19:16:45','2019-05-21 11:21:10'),
	(22,5,5,'1','无',12,0,'2019-06-03 13:10:00','2019-06-03 14:50:00','2019-05-20 21:13:17','2019-05-21 11:21:52'),
	(23,5,4,'1','无',1,0,'2019-06-03 19:00:00','2019-06-03 21:00:00','2019-05-20 21:32:37','2019-06-03 00:02:15'),
	(24,5,5,'123','FILE/meetfile/uploadxl/201905202301547583.png',19,1,'2019-06-11 07:00:00','2019-06-11 07:55:00','2019-05-20 23:01:56','2019-05-21 11:22:34'),
	(25,2,3,'111111','FILE/meetfile/uploadxm/201905221402389159.png',12,1,'2019-05-22 22:00:00','2019-05-22 23:15:00','2019-05-22 14:02:40','2019-05-27 15:19:48'),
	(26,2,3,'1111','无',12,0,'2019-05-22 23:30:00','2019-05-23 03:30:00','2019-05-22 14:31:52','2019-05-22 14:31:52'),
	(27,4,7,'小花的会议','FILE/meetfile/uploadxh/201905261912107746.PNG',12,0,'2019-05-27 04:10:00','2019-05-27 05:50:00','2019-05-26 19:12:13','2019-05-26 19:12:13'),
	(42,2,8,'测试关于数据裤是否可以完美插入两个表','FILE/meetfile/uploadxm/201906021941554029.jpg',3,0,'2019-06-03 03:40:00','2019-06-03 04:40:00','2019-06-02 19:42:02','2019-06-02 19:42:02'),
	(43,3,5,'测试而已','FILE/meetfile/uploadwz/201906030016177573.jpg',12,0,'2019-06-03 08:15:00','2019-06-03 12:15:00','2019-06-03 00:16:19','2019-06-03 00:16:19'),
	(44,4,8,'测试小敏','无',2,1,'2019-06-03 09:05:00','2019-06-03 09:55:00','2019-06-03 01:07:45','2019-06-03 01:12:48'),
	(45,5,4,'小李测试','FILE/meetfile/uploadxl/201906030135007444.jpg',3,1,'2019-06-03 09:30:00','2019-06-03 15:30:00','2019-06-03 01:35:03','2019-06-03 01:35:33'),
	(46,2,3,'周总','FILE/meetfile/uploadxm/201906052241499494.jpg',3,1,'2019-06-05 14:40:00','2019-06-06 06:40:00','2019-06-05 22:41:51','2019-06-05 22:42:44');

/*!40000 ALTER TABLE `affairs_table` ENABLE KEYS */;
UNLOCK TABLES;

DELIMITER ;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" */;;
/*!50003 CREATE */ /*!50017 DEFINER=`root`@`localhost` */ /*!50003 TRIGGER `meetapp_log` AFTER UPDATE ON `affairs_table` FOR EACH ROW begin
if(NEW.affairs_status=1)then
insert into message_log(user_id,message,`status`) values(NEW.`user_id`,CONCAT('管理员通过了您的主题为',NEW.theme,'会议!'),'1');
end if;
if(NEW.affairs_status=-1)then
insert into message_log(user_id,message,`status`) values(NEW.`user_id`,CONCAT('管理员拒绝了您的主题为',NEW.theme,'会议!'),'1');

end if;
end */;;
DELIMITER ;
/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;


# Dump of table cultivate_class
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cultivate_class`;

CREATE TABLE `cultivate_class` (
  `class_id` int(8) NOT NULL AUTO_INCREMENT,
  `cultivate_id` int(32) NOT NULL,
  `user_id` int(32) NOT NULL,
  `jointime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入班时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`class_id`),
  KEY `cuid` (`user_id`),
  KEY `ccid` (`cultivate_id`),
  CONSTRAINT `ccid` FOREIGN KEY (`cultivate_id`) REFERENCES `cultivate_info` (`cultivate_id`),
  CONSTRAINT `cuid` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训班级表';

LOCK TABLES `cultivate_class` WRITE;
/*!40000 ALTER TABLE `cultivate_class` DISABLE KEYS */;

INSERT INTO `cultivate_class` (`class_id`, `cultivate_id`, `user_id`, `jointime`, `create_time`, `edit_time`)
VALUES
	(1,2,1,'2019-04-22 00:00:00','2019-04-21 12:51:38','2019-04-21 12:51:38');

/*!40000 ALTER TABLE `cultivate_class` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cultivate_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cultivate_info`;

CREATE TABLE `cultivate_info` (
  `cultivate_id` int(8) NOT NULL AUTO_INCREMENT,
  `cultivate_name` varchar(64) NOT NULL COMMENT '培训课程名字',
  `cultivate_peo` int(8) DEFAULT '0' COMMENT '班级可容纳人数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `cultivat_peo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cultivate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训信息表';

LOCK TABLES `cultivate_info` WRITE;
/*!40000 ALTER TABLE `cultivate_info` DISABLE KEYS */;

INSERT INTO `cultivate_info` (`cultivate_id`, `cultivate_name`, `cultivate_peo`, `create_time`, `edit_time`, `cultivat_peo`)
VALUES
	(1,'Spring boot开发进阶',0,'2019-04-21 12:37:28','2019-04-21 12:37:28',20),
	(2,'玩转Spring security',0,'2019-04-21 12:38:41','2019-04-21 12:38:41',10),
	(3,'Vue.js进阶',0,'2019-04-21 12:39:19','2019-04-21 12:39:49',10);

/*!40000 ALTER TABLE `cultivate_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table department_table
# ------------------------------------------------------------

DROP TABLE IF EXISTS `department_table`;

CREATE TABLE `department_table` (
  `department_id` int(8) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(64) NOT NULL COMMENT '部门名称',
  `department_pho` varchar(32) NOT NULL DEFAULT 'null' COMMENT '部门联系方式',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deapartment_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

LOCK TABLES `department_table` WRITE;
/*!40000 ALTER TABLE `department_table` DISABLE KEYS */;

INSERT INTO `department_table` (`department_id`, `department_name`, `department_pho`, `create_time`, `edit_time`, `deapartment_email`)
VALUES
	(1,'人事部','110','2019-04-20 19:28:37','2019-04-21 10:09:12','123@163.com'),
	(2,'市场部','119','2019-04-20 19:29:30','2019-04-21 10:12:10','1622357726@qq.com'),
	(3,'开发部','120','2019-04-21 10:04:33','2019-04-21 10:09:16','1294191169@qq.com');

/*!40000 ALTER TABLE `department_table` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hibernate_sequence
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;

INSERT INTO `hibernate_sequence` (`next_val`)
VALUES
	(1),
	(1);

/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table meet_category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meet_category`;

CREATE TABLE `meet_category` (
  `category_id` int(8) NOT NULL COMMENT '0为小型1为中型2为大型',
  `room_id` int(8) NOT NULL,
  `category_name` varchar(32) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`),
  KEY `rid` (`room_id`),
  CONSTRAINT `rid` FOREIGN KEY (`room_id`) REFERENCES `meeting_room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议室类型表';

LOCK TABLES `meet_category` WRITE;
/*!40000 ALTER TABLE `meet_category` DISABLE KEYS */;

INSERT INTO `meet_category` (`category_id`, `room_id`, `category_name`, `create_time`, `edit_time`)
VALUES
	(1,1,'小型私用','2019-04-21 10:34:07','2019-04-21 10:37:17');

/*!40000 ALTER TABLE `meet_category` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table meeting_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meeting_log`;

CREATE TABLE `meeting_log` (
  `log_id` int(8) NOT NULL AUTO_INCREMENT,
  `affairs_id` int(8) NOT NULL,
  `user_id` int(8) NOT NULL,
  `room_id` int(8) NOT NULL,
  `theme` varchar(512) NOT NULL DEFAULT 'null' COMMENT '会议主题',
  `file` varchar(2048) DEFAULT NULL COMMENT '会议文件',
  `participate` int(2) NOT NULL DEFAULT '0' COMMENT '参与人数',
  `meeting_summarize` varchar(1024) DEFAULT NULL COMMENT '会议各个人的总结',
  `meeting_img` varchar(1024) DEFAULT NULL COMMENT '会议进行照片',
  `arrangement_periodstart` datetime NOT NULL COMMENT '会议开始时间',
  `arrangement_periodend` datetime NOT NULL COMMENT '会议结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `affairs_table_affairs_id` int(11) NOT NULL,
  `meeting_room_room_id` int(11) NOT NULL,
  `user_info_user_id` int(11) NOT NULL,
  PRIMARY KEY (`log_id`),
  KEY `muid` (`user_id`),
  KEY `mrid` (`room_id`),
  CONSTRAINT `mrid` FOREIGN KEY (`room_id`) REFERENCES `meeting_room` (`room_id`),
  CONSTRAINT `muid` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='已完成的会议情况表';

LOCK TABLES `meeting_log` WRITE;
/*!40000 ALTER TABLE `meeting_log` DISABLE KEYS */;

INSERT INTO `meeting_log` (`log_id`, `affairs_id`, `user_id`, `room_id`, `theme`, `file`, `participate`, `meeting_summarize`, `meeting_img`, `arrangement_periodstart`, `arrangement_periodend`, `create_time`, `edit_time`, `affairs_table_affairs_id`, `meeting_room_room_id`, `user_info_user_id`)
VALUES
	(1,1,2,1,'生物信息技术在社会中的用处','暂无',20,'生物工程技术将是200年来最有展望的领域','图片是我','2019-04-22 15:30:00','2019-04-22 19:30:00','2019-04-21 12:24:05','2019-05-13 21:33:43',0,0,0),
	(2,2,3,3,'人工智能的推广','暂无',5,'人工智能鱼深度学习有紧密关系','我是图片2','2019-04-22 12:00:00','2019-04-22 12:30:00','2019-04-27 13:47:08','2019-04-27 13:47:08',0,0,0);

/*!40000 ALTER TABLE `meeting_log` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table meeting_room
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meeting_room`;

CREATE TABLE `meeting_room` (
  `room_id` int(8) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(64) NOT NULL COMMENT '会议室名称',
  `room_icon` varchar(1024) DEFAULT NULL COMMENT '会议室预览图',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议室表';

LOCK TABLES `meeting_room` WRITE;
/*!40000 ALTER TABLE `meeting_room` DISABLE KEYS */;

INSERT INTO `meeting_room` (`room_id`, `room_name`, `room_icon`, `create_time`, `edit_time`)
VALUES
	(1,'国际会议厅','测试缩略图','2019-04-21 10:19:53','2019-04-21 10:23:09'),
	(2,'圆桌会议厅','测试1','2019-04-27 13:43:45','2019-04-27 13:43:45'),
	(3,'中心会议厅','测试2','2019-04-27 13:44:01','2019-04-27 13:44:01'),
	(4,'实验会议室','测试3','2019-04-27 13:44:25','2019-04-27 13:44:25'),
	(5,'云会议室','测试4','2019-05-20 19:09:29','2019-05-20 19:09:29'),
	(6,'太阳会议室','测试5','2019-05-20 19:09:48','2019-05-20 19:09:48'),
	(7,'月亮会议室','测试6','2019-05-20 19:09:58','2019-05-20 19:09:58'),
	(8,'星星会议室','测试7','2019-05-20 19:10:15','2019-05-20 19:10:15');

/*!40000 ALTER TABLE `meeting_room` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table message_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `message_log`;

CREATE TABLE `message_log` (
  `message_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NOT NULL,
  `message` varchar(2048) NOT NULL,
  `status` int(8) NOT NULL COMMENT '消息状态 1 未读 0 已读 -1 删除',
  PRIMARY KEY (`message_id`),
  KEY `msuid` (`user_id`),
  CONSTRAINT `msuid` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `message_log` WRITE;
/*!40000 ALTER TABLE `message_log` DISABLE KEYS */;

INSERT INTO `message_log` (`message_id`, `user_id`, `message`, `status`)
VALUES
	(8,2,'管理员通过了您的主题为生物信息技术在社会中的用处会议!',0),
	(9,3,'管理员通过了您的主题为形势与政策会议!',0),
	(10,3,'有新添加的会议日程,请尽快查看',0),
	(11,4,'有新添加的会议日程,请尽快查看',0),
	(12,2,'有新添加的会议日程,请尽快查看',0),
	(13,4,'有新添加的会议日程,请尽快查看',0),
	(14,2,'有新添加的会议日程,请尽快查看',0),
	(15,4,'管理员通过了您的主题为测试小敏会议!',0),
	(16,5,'有新添加的会议日程,请尽快查看',0),
	(17,4,'有新添加的会议日程,请尽快查看',0),
	(18,3,'有新添加的会议日程,请尽快查看',0),
	(19,2,'有新添加的会议日程,请尽快查看',0),
	(20,5,'管理员通过了您的主题为小李测试会议!',0),
	(21,2,'有新添加的会议日程,请尽快查看',0),
	(22,5,'有新添加的会议日程,请尽快查看',0),
	(23,4,'有新添加的会议日程,请尽快查看',0),
	(24,3,'有新添加的会议日程,请尽快查看',0),
	(25,2,'管理员通过了您的主题为周总会议!',0);

/*!40000 ALTER TABLE `message_log` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `login_name`, `name`, `tel`, `sex`)
VALUES
	(1,'1','1','1',1),
	(2,'2','2','2',2),
	(3,'3','3','3',3),
	(4,'4','4','4',4),
	(5,'5','5','5',5);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL COMMENT '用户姓名',
  `user_code` varchar(32) NOT NULL COMMENT '用户账号',
  `emp_code` varchar(48) NOT NULL,
  `user_salt` varchar(64) DEFAULT NULL,
  `login_password` varchar(32) NOT NULL COMMENT '用户密码',
  `login_icon` varchar(1024) DEFAULT 'null' COMMENT '用户头像小图',
  `department_id` int(8) NOT NULL COMMENT '部门编号',
  `user_status` int(2) NOT NULL COMMENT '基本用户为0,高层用户为1,最高权限2',
  `job_jointime` timestamp NULL DEFAULT NULL,
  `person_des` varchar(512) DEFAULT NULL,
  `person_phone` varchar(20) DEFAULT NULL,
  `person_email` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`),
  KEY `did` (`department_id`),
  CONSTRAINT `did` FOREIGN KEY (`department_id`) REFERENCES `department_table` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;

INSERT INTO `user_info` (`user_id`, `user_name`, `user_code`, `emp_code`, `user_salt`, `login_password`, `login_icon`, `department_id`, `user_status`, `job_jointime`, `person_des`, `person_phone`, `person_email`, `create_time`, `edit_time`)
VALUES
	(1,'管理员','admin','D0U01928762','8d78869f470951332959580424d4bf4f','1234567','UserIcon/D0U01928762icon.jpg',1,2,'2014-05-25 00:00:00','最高级','1234','1234@163.com','2019-04-20 19:29:58','2019-06-02 19:40:42'),
	(2,'小冥','xm','D1U21025678',NULL,'1234567','UserIcon/D1U21025678icon.jpg',2,0,'2017-04-07 00:00:00','兢兢业业,一直从事在一线岗位,为公司争取了许多中标机会','13708202587','123456@qq.com','2019-04-25 19:38:04','2019-05-22 16:18:19'),
	(3,'王巢','wz','D2U39087654',NULL,'1234567','UserIcon/D2U39087654icon.jpg',2,1,'2019-05-19 00:00:00','公司创始人之一,以办事果决,待人亲和的特点获得了员工的爱戴','110','wym@163.com','2019-04-25 19:38:40','2019-05-27 15:20:09'),
	(4,'小花','xh','D1U49876542',NULL,'1234567','UserIcon/D1U49876542icon.jpg',2,0,'2017-05-15 00:00:00','性格大方开朗，是公司的接待前台哦','18781950547','2101@163.com','2019-05-05 23:50:10','2019-05-22 21:02:09'),
	(5,'小离','xl','D1U59876756',NULL,'1234567','UserIcon/D1U59876756icon.jpg',2,0,'2015-12-29 00:00:00','经理，在管理员工方面相当有经验，是老板的得力助手','1234','12941911@qq.com','2019-05-05 23:51:32','2019-05-20 23:07:44');

/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping routines (PROCEDURE) for database 'meet'
--
DELIMITER ;;

# Dump of PROCEDURE test
# ------------------------------------------------------------

/*!50003 DROP PROCEDURE IF EXISTS `test` */;;
/*!50003 SET SESSION SQL_MODE="ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"*/;;
/*!50003 CREATE*/ /*!50020 DEFINER=`root`@`localhost`*/ /*!50003 PROCEDURE `test`()
BEGIN 
update `message_log` SET `status` = 0 WHERE status <> 0; 
END */;;

/*!50003 SET SESSION SQL_MODE=@OLD_SQL_MODE */;;
DELIMITER ;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
