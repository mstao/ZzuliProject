/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : zzuli_lab

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-07-04 16:37:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_academia_committee
-- ----------------------------
DROP TABLE IF EXISTS `sys_academia_committee`;
CREATE TABLE `sys_academia_committee` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `title` varchar(10) DEFAULT NULL COMMENT '职称',
  `post_id` int(5) DEFAULT NULL,
  `research` varchar(20) DEFAULT NULL COMMENT '研究方向',
  `unit` varchar(20) DEFAULT NULL COMMENT '在所单位',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT '1',
  `author` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_academia_committee
-- ----------------------------

-- ----------------------------
-- Table structure for sys_achievement
-- ----------------------------
DROP TABLE IF EXISTS `sys_achievement`;
CREATE TABLE `sys_achievement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) DEFAULT NULL,
  `item_content` text,
  `achievement_type_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `author` varchar(36) DEFAULT NULL,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(1) DEFAULT '1',
  `has_attach` int(1) DEFAULT '0' COMMENT '是否有附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_achievement
-- ----------------------------
INSERT INTO `sys_achievement` VALUES ('10', null, '新增论文--草稿-1', '0', '2016-12-31 00:54:30', '河南省表界面科学重点实验室', '0', '0', '0');
INSERT INTO `sys_achievement` VALUES ('12', '发表论文', '<p>qw<br></p>', '1', '2017-04-11 16:37:12', '河南省表界面科学重点实验室', '0', '1', '0');
INSERT INTO `sys_achievement` VALUES ('13', '发明专利', '<table class=\"clicked\"><tbody><tr><td><span>&nbsp;发明专利</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table><p><br></p>', '2', '2017-04-05 21:05:30', '河南省表界面科学重点实验室', '0', '1', '0');
INSERT INTO `sys_achievement` VALUES ('14', '成果转化', '<table class=\"\"><tbody><tr><td><span>&nbsp;成果转化<br></span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table><p><br></p>', '3', '2017-04-05 21:06:10', '河南省表界面科学重点实验室', '1', '1', '0');

-- ----------------------------
-- Table structure for sys_achievement_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_achievement_type`;
CREATE TABLE `sys_achievement_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_achievement_type
-- ----------------------------
INSERT INTO `sys_achievement_type` VALUES ('1', '发表论文', 'kfl');
INSERT INTO `sys_achievement_type` VALUES ('2', '发明专利', 'kfz');
INSERT INTO `sys_achievement_type` VALUES ('3', '成果转化', 'kcz');

-- ----------------------------
-- Table structure for sys_committee_intro
-- ----------------------------
DROP TABLE IF EXISTS `sys_committee_intro`;
CREATE TABLE `sys_committee_intro` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `add_time` datetime DEFAULT NULL,
  `type_id` int(20) DEFAULT NULL,
  `is_publish` int(1) DEFAULT '1',
  `author` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_committee_intro
-- ----------------------------
INSERT INTO `sys_committee_intro` VALUES ('1', '<p>\n        学术委员会内容\n        </p><p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><p><br></p>', '2017-04-05 16:53:44', '2', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_committee_intro` VALUES ('2', '<br><br><br>&nbsp;&nbsp;&nbsp;&nbsp; <br><p><br></p>', '2017-04-20 16:41:15', '1', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_committee_intro` VALUES ('3', '<p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p>qwe<br></p><p>asd<br></p>', '2017-04-05 21:16:28', '3', '1', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_committee_intro_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_committee_intro_type`;
CREATE TABLE `sys_committee_intro_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) DEFAULT NULL,
  `type_flag` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_committee_intro_type
-- ----------------------------
INSERT INTO `sys_committee_intro_type` VALUES ('1', '管理委员会', 'glw');
INSERT INTO `sys_committee_intro_type` VALUES ('2', '学术委员会', 'xsw');
INSERT INTO `sys_committee_intro_type` VALUES ('3', '实验室主任委员会', 'szw');

-- ----------------------------
-- Table structure for sys_contact
-- ----------------------------
DROP TABLE IF EXISTS `sys_contact`;
CREATE TABLE `sys_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_contact
-- ----------------------------
INSERT INTO `sys_contact` VALUES ('1', '<p><span></span>邮箱：449445428@qq.com<br></p><p>qweeqe</p><br><p>\nwangEditor\n\n基于javascript和css开发的 Web富文本编辑器， 轻量、简洁、易用、开源免费\n</p><table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table><p><br></p>', '2017-04-05 20:22:31', '1', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_director_committee
-- ----------------------------
DROP TABLE IF EXISTS `sys_director_committee`;
CREATE TABLE `sys_director_committee` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` varchar(10) DEFAULT NULL,
  `post` varchar(20) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL COMMENT '职称',
  `research` varchar(20) DEFAULT NULL COMMENT '研究方向',
  `unit` varchar(20) DEFAULT NULL COMMENT '所在单位',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_director_committee
-- ----------------------------
INSERT INTO `sys_director_committee` VALUES ('1', 'qweq', '男', '1967-04', '32', 'qwe', 'qwe', 'eqw', '2017-04-05 21:41:22', '1', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_employ
-- ----------------------------
DROP TABLE IF EXISTS `sys_employ`;
CREATE TABLE `sys_employ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_employ
-- ----------------------------
INSERT INTO `sys_employ` VALUES ('2', '\n        \n        <p>招聘人才<br></p>\n        <p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table>\n        <p><br></p>', '2017-04-05 19:52:55', '1', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `file_belong_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `item_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('1', '20170228网站栏目规划-万科城小学.doc', '20170228网站栏目规划-万科城小学22450d01-05ea-4a51-a6a1-f7c3fd403723.doc', '2', '2017-04-11 20:28:09', '57');
INSERT INTO `sys_file` VALUES ('2', '2017-04-19_130831.png', '2017-04-19_13083126538734-548a-4054-ab6b-8ba105af86d6.png', '2', '2017-05-12 14:28:26', '59');
INSERT INTO `sys_file` VALUES ('3', 'classdetails.css', 'classdetails2a8bb4b6-bc33-4764-b2db-5e51bdbf7591.css', '2', '2017-05-12 14:28:26', '59');

-- ----------------------------
-- Table structure for sys_file_belong
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_belong`;
CREATE TABLE `sys_file_belong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `belong_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file_belong
-- ----------------------------
INSERT INTO `sys_file_belong` VALUES ('1', '规章制度', 'fgz');
INSERT INTO `sys_file_belong` VALUES ('2', '新闻公告', 'fsg');
INSERT INTO `sys_file_belong` VALUES ('3', '科学研究', 'fky');
INSERT INTO `sys_file_belong` VALUES ('4', '成果转化', 'fcz');
INSERT INTO `sys_file_belong` VALUES ('5', '仪器规章制度', 'fyz');

-- ----------------------------
-- Table structure for sys_instruments
-- ----------------------------
DROP TABLE IF EXISTS `sys_instruments`;
CREATE TABLE `sys_instruments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instrument_name` varchar(36) DEFAULT NULL,
  `instrument_info` text,
  `instrument_image` varchar(255) DEFAULT NULL,
  `instrument_url` varchar(255) DEFAULT NULL,
  `is_publish` int(1) DEFAULT '1',
  `add_time` datetime DEFAULT NULL,
  `view_count` int(20) DEFAULT '0',
  `author` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_instruments
-- ----------------------------
INSERT INTO `sys_instruments` VALUES ('4', '322', '<p>12331c 31 1<br></p><p><br></p>', '/ZzuliProject/Uploads/images/h742cafc0-8805-4586-b340-96c1f6770034.jpg', '123', '1', '2017-04-13 13:28:02', '2', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_instrument_rule
-- ----------------------------
DROP TABLE IF EXISTS `sys_instrument_rule`;
CREATE TABLE `sys_instrument_rule` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT '1',
  `author` varchar(20) DEFAULT NULL,
  `view_count` int(20) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_instrument_rule
-- ----------------------------
INSERT INTO `sys_instrument_rule` VALUES ('1', '111', '\n        <p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><ol><li>q&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; w<br><table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table></li></ol>\n        <p><br></p>', '2017-04-05 21:19:52', '1', '河南省表界面科学重点实验室', '2');

-- ----------------------------
-- Table structure for sys_intro
-- ----------------------------
DROP TABLE IF EXISTS `sys_intro`;
CREATE TABLE `sys_intro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_content` text,
  `intro_type_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_intro
-- ----------------------------
INSERT INTO `sys_intro` VALUES ('3', '\n        <span><font><span></span></font></span>&nbsp;&nbsp;&nbsp; <br><p>qweqweeq <br></p>', '2', '2017-04-20 16:41:33', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_intro` VALUES ('4', '<p style=\"text-align: center;\" align=\"center\"></p><br><p>实验室logo</p><p><br></p>', '6', '2017-03-16 08:02:16', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_intro` VALUES ('7', '<table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table><br><br><br><ul><li>xxx</li></ul><p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射</p><p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p><p>实验任务：\n通过访问各大网站发现Ajax技术主要应用在哪些功能实现上，了解Ajax技术的应用范围。\n（1）	使用浏览器检索关键字时，会弹出一系列以ap开头的字符串\n</p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p>', '7', '2017-04-05 19:45:01', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_intro` VALUES ('8', '<br><p>一个历史表中有大量的数据，现在要通过分页式查询处理转换数据。\n\n现在将处理数据的逻辑放在线程池中处理，以加快处理流程。\n\n可是总是出现事务方面的异常\n\n比如 ： SQLNonTransientConnectionException\n\n请问该如何解决上述异常，或者有什么好的多线程分页查</p>\n        \n        <p>“表界面科学实验室”是在原国家轻工业部重点实验室 “应用化学实验室”（国轻人[1998] 122号）的基础上，依托“应用化学”河南省重点学科，经过连续多年投资和建设而成。2007年4月，经河南省科技厅批准组建“河南省表界面科学重点实验室”（豫科[2007] 69号）。\n\n    实验室依据国家、河南省科技发展规划，结合自身特色和优势，针对我国特别是河南省经济建设和社会发展的要求，逐渐凝练形成了5个特色明显、优势突出的研究方向：聚合物表界面科学与技术；材料表面修饰与电极界面性质研究；气（液）/固界面性质及应用；两亲分子的合成与性能研究；功能纳米材料的可控制备及微纳器件加工研究。\n\n    实验室现有固定研究人员63人，客座研究人员13人，仪器设备专职管理人员13人，其中，双聘院士1人，博导（含兼职）11人。固定研究人员中，教授19人，博士（后）学位人员占88％。研究队伍中，享受国务院特殊津贴专家、河南省优秀专家、省特聘教授、以及省各类人才项目资助对象12人，已形成了以院士、长江学者为学术顾问，中青年教授、博士为骨干的学术梯队。实验室建有“应用化学”、“材料学”、“化学工艺”3个河南省第七批重点学科；拥有“材料学”、“材料物理与化学”、“应用化学”、“化学工艺”、“化学工程”5个硕士学位授权点，建有“聚合物基复合材料”河南省高校科技创新团队、河南省创新型科技团队。\n\n    实验室建有完备的形貌观察、结构鉴定、热分析、光谱、色谱等专门仪器设备室，拥有X-射线光电子能谱仪(XPS)、高分辨透射电子显微镜(HRTEM)、热场场发射扫描电子显微镜(FESEM)、X-射线单晶衍射仪、原子力显微镜(AFM)、扫描电子显微镜(SEM)、X射线衍射仪以及电感耦合等离子体质谱仪等一批先进仪器设备，仪器设备总值达6000多万元。\n\n    自组建以来，实验室共承担国家自然科学基金项目56项，河南省2010年重大公益科研项目1项，教育部重点项目1项，国际合作项目3项，河南省创新型科技团队、河南省杰出人才基金、河南省杰出青年基金、河南省高校科技创新人才支持计划等省级人才项目19项，其他纵向项目44项，以及利华制药、中铝集团、中烟公司等企业的横向课题20多项；在国内外期刊发表论文181篇，被SCI、EI收录119篇；申报国家专利15项，其中授权发明专利4项，实用新型3项。培养硕士研究生60名，目前在读107名，联合培养博士（含在读）11名。\n\n    实验室本着“自主创新、重点发展、服务河南经济”的方针，根据自身的基础和优势，以开展表界面科学领域的研究为重点，强化原始创新和集成创新，目前已日渐成为在国内外有一定影响的科学研究基地、科技创新基地和人才培养基地。 </p><p><br></p>', '1', '2017-04-13 15:39:46', '1', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_intro_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_intro_type`;
CREATE TABLE `sys_intro_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_intro_type
-- ----------------------------
INSERT INTO `sys_intro_type` VALUES ('1', '实验室概况', 'isg');
INSERT INTO `sys_intro_type` VALUES ('2', '组织结构', 'izj');
INSERT INTO `sys_intro_type` VALUES ('3', '管理委员会', 'igw');
INSERT INTO `sys_intro_type` VALUES ('4', '学术委员会', 'ixw');
INSERT INTO `sys_intro_type` VALUES ('5', '实验室主任委员会', 'isz');
INSERT INTO `sys_intro_type` VALUES ('6', '实验室LOGO', 'isl');
INSERT INTO `sys_intro_type` VALUES ('7', '实验室大事记', 'isd');

-- ----------------------------
-- Table structure for sys_manage_committee
-- ----------------------------
DROP TABLE IF EXISTS `sys_manage_committee`;
CREATE TABLE `sys_manage_committee` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT NULL,
  `post_id` int(5) DEFAULT NULL,
  `research` varchar(20) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(1) DEFAULT '1',
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_manage_committee
-- ----------------------------

-- ----------------------------
-- Table structure for sys_news
-- ----------------------------
DROP TABLE IF EXISTS `sys_news`;
CREATE TABLE `sys_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) DEFAULT NULL,
  `item_content` text,
  `news_type_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `author` varchar(36) DEFAULT NULL,
  `view_count` int(11) DEFAULT '0' COMMENT '浏览量',
  `is_publish` int(1) DEFAULT '1' COMMENT '新闻是否发布 1发布 0存为草稿',
  `is_image` int(1) DEFAULT '0' COMMENT '新闻是否包含图片',
  `has_attach` int(1) DEFAULT '0' COMMENT '否是存在附件',
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `news_type_id` (`news_type_id`),
  KEY `is_publish` (`is_publish`),
  KEY `is_image` (`is_image`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_news
-- ----------------------------
INSERT INTO `sys_news` VALUES ('54', '2', '<p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><p><br></p>', '2', '2017-04-05 17:02:24', '河南省表界面科学重点实验室', '2', '1', '0', '0', null);
INSERT INTO `sys_news` VALUES ('55', '3', '<p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><p><br></p>', '3', '2017-04-05 21:19:08', '河南省表界面科学重点实验室', '1', '1', '0', '0', null);
INSERT INTO `sys_news` VALUES ('57', '中方回应印度邀达赖窜访藏南:违背承诺挑起争端中方回应印度邀达赖窜访藏南:违背承诺挑起争端', '<p> 3月20日，应材料与化学工程学院邀请，郑州大学博士生导师侯红卫教授在科学校区化工楼218室作了题为“二价铁配合物的磁性与催化性能的研究”的学术报告，我院相关专业教师、学生参加了此次报告。 <br></p><p>\n    侯红卫教授介绍了MOFs 材料作为非均相催化剂的应用研究现状及其相比于均相催化剂所具有的优势；详细讲解了二价铁配合物的制备方法以及影响其磁性与催化性能的因素；结合课题组近期在配位聚合物领域的研究，侯教授重点介绍了配位聚合物在催化方面的应用。 <br></p><p>会后，侯红卫教授结合自己多年撰写和评审国基金的经验，现场对我院相关专业教师的国基金申请书进行了点评指导。 </p><p><img src=\"/ZzuliProject/Uploads/images/2e8e330d-6002-4d6f-bac3-a8f53972196d.png\" alt=\"2017-04-19_130831\" style=\"max-width:100%;\" class=\"clicked\"></p><p><br></p>', '1', '2017-05-12 14:26:40', '河南省表界面科学重点实验室', '25', '1', '1', '0', '/ZzuliProject/Uploads/images/2e8e330d-6002-4d6f-bac3-a8f53972196d.png');
INSERT INTO `sys_news` VALUES ('58', '会议', 'qwe额企鹅额请问<p><br></p>', '4', '2017-04-05 21:18:50', '河南省表界面科学重点实验室', '0', '1', '0', '0', null);
INSERT INTO `sys_news` VALUES ('59', '请问企鹅奥所多大所', '<p>按时大大 ad</p><p><img src=\"/ZzuliProject/Uploads/images/4c3d5f5f-3dec-4f10-9fa3-9e53d80689f4.png\" alt=\"2017-04-19_130552\" style=\"max-width:100%;\"></p><p><br></p>', '1', '2017-05-12 14:28:26', '河南省表界面科学重点实验室', '1', '1', '1', '0', '/ZzuliProject/Uploads/images/4c3d5f5f-3dec-4f10-9fa3-9e53d80689f4.png');
INSERT INTO `sys_news` VALUES ('60', '请问而且', '恶趣味恶趣味<br>', '2', '2017-05-12 14:27:33', '河南省表界面科学重点实验室', '0', '1', '0', '0', '0');
INSERT INTO `sys_news` VALUES ('61', '请问而且', '<p>请问饿请问</p><p><img src=\"/ZzuliProject/Uploads/images/f1016b87-dc8e-4ad7-a234-4ba6379c9d45.png\" alt=\"表界面logo最终\" style=\"max-width: 100%; width: 444px; height: 429px;\" class=\"\"></p><p><br></p>', '2', '2017-05-12 14:27:46', '河南省表界面科学重点实验室', '0', '1', '1', '0', '/ZzuliProject/Uploads/images/f1016b87-dc8e-4ad7-a234-4ba6379c9d45.png');

-- ----------------------------
-- Table structure for sys_news_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_news_type`;
CREATE TABLE `sys_news_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_news_type
-- ----------------------------
INSERT INTO `sys_news_type` VALUES ('1', '实验室新闻', 'xsx');
INSERT INTO `sys_news_type` VALUES ('2', '公告通知', 'xgt');
INSERT INTO `sys_news_type` VALUES ('3', '学术讲座与报告', 'xxb');
INSERT INTO `sys_news_type` VALUES ('4', '专题研讨与会议', 'xzh');

-- ----------------------------
-- Table structure for sys_person
-- ----------------------------
DROP TABLE IF EXISTS `sys_person`;
CREATE TABLE `sys_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` varchar(36) DEFAULT NULL,
  `avatar_file` varchar(255) DEFAULT NULL,
  `person_post` varchar(36) DEFAULT NULL,
  `person_info` text,
  `author` varchar(100) DEFAULT NULL,
  `is_gugan` int(1) DEFAULT '1' COMMENT '是否为骨干 1为骨干 默认为1',
  `add_time` datetime DEFAULT NULL,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `is_gugan` (`is_gugan`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_person
-- ----------------------------
INSERT INTO `sys_person` VALUES ('2', 'qweqe', '/ZzuliProject/Uploads/images/classbg684a540a-98e2-4b5f-ae0f-994a8cf0128e.jpg', 'qweq', '\n        \n        \n        <p>qweeeqwee<br></p>\n        <p><br></p>\n        \n        ', '河南省表界面科学重点实验室', '1', '2017-04-05 21:42:29', '4', '1');

-- ----------------------------
-- Table structure for sys_person_intro
-- ----------------------------
DROP TABLE IF EXISTS `sys_person_intro`;
CREATE TABLE `sys_person_intro` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `author` varchar(30) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_person_intro
-- ----------------------------
INSERT INTO `sys_person_intro` VALUES ('1', '<span>人才队伍现状内容-test</span><p><br></p>', '人才队伍', '2017-01-03 20:30:12', '1');

-- ----------------------------
-- Table structure for sys_post_style
-- ----------------------------
DROP TABLE IF EXISTS `sys_post_style`;
CREATE TABLE `sys_post_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post` varchar(20) DEFAULT NULL,
  `post_flag` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_post_style
-- ----------------------------
INSERT INTO `sys_post_style` VALUES ('1', '主任', 'director');
INSERT INTO `sys_post_style` VALUES ('2', '副主任', 'vice-director');
INSERT INTO `sys_post_style` VALUES ('3', '委员', 'commission');
INSERT INTO `sys_post_style` VALUES ('4', '秘书', 'mishu');

-- ----------------------------
-- Table structure for sys_project_foundation
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_foundation`;
CREATE TABLE `sys_project_foundation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `number` varchar(255) DEFAULT NULL COMMENT '项目编号',
  `person` varchar(255) DEFAULT NULL COMMENT '项目负责人',
  `outlay` float(11,0) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL COMMENT '起止时间',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_project_foundation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_project_horizontal_cooperation
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_horizontal_cooperation`;
CREATE TABLE `sys_project_horizontal_cooperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `cooperator` varchar(255) DEFAULT NULL COMMENT '合作单位',
  `person` varchar(255) DEFAULT NULL COMMENT '负责人',
  `outlay` float(11,0) DEFAULT NULL COMMENT '合同经费',
  `time` varchar(25) DEFAULT NULL COMMENT '年份',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_project_horizontal_cooperation
-- ----------------------------

-- ----------------------------
-- Table structure for sys_project_provincial
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_provincial`;
CREATE TABLE `sys_project_provincial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameid` varchar(255) DEFAULT NULL COMMENT '项目名称与编号',
  `person` varchar(255) DEFAULT NULL COMMENT '主持人',
  `source` varchar(255) DEFAULT NULL COMMENT '来源',
  `outlay` float DEFAULT NULL COMMENT '经费',
  `time` varchar(255) DEFAULT NULL COMMENT '起止时间',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_project_provincial
-- ----------------------------

-- ----------------------------
-- Table structure for sys_research
-- ----------------------------
DROP TABLE IF EXISTS `sys_research`;
CREATE TABLE `sys_research` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(50) DEFAULT NULL,
  `item_content` text,
  `add_time` datetime DEFAULT NULL,
  `research_type_id` int(11) DEFAULT NULL,
  `author` varchar(36) DEFAULT NULL,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(1) DEFAULT '1',
  `is_image` int(1) DEFAULT '0' COMMENT '是否有图片',
  `has_attach` int(1) DEFAULT '0' COMMENT '否是有附件',
  PRIMARY KEY (`id`),
  KEY `research_type_id` (`research_type_id`),
  KEY `is_image` (`is_image`),
  KEY `is_publish` (`is_publish`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_research
-- ----------------------------
INSERT INTO `sys_research` VALUES ('2', 'pppppp', '\n        <p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table>\n        <p><br></p>', '2017-04-05 21:16:49', '1', '河南省表界面科学重点实验室', '8', '1', '0', '0');
INSERT INTO `sys_research` VALUES ('3', 'wqee', '<p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p><table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table><p><br></p>', '2017-04-05 19:49:59', '3', '河南省表界面科学重点实验室', '1', '1', '0', '0');
INSERT INTO `sys_research` VALUES ('4', 'qwee', '<p>qweeqweqweq</p><br><p>eqweqweq</p><br><table><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table><p>e</p><p>qweqeqweqwe</p><br><p>eq</p><p><br></p>', '2017-04-05 19:50:39', '2', '河南省表界面科学重点实验室', '3', '1', '0', '0');

-- ----------------------------
-- Table structure for sys_research_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_research_type`;
CREATE TABLE `sys_research_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_research_type
-- ----------------------------
INSERT INTO `sys_research_type` VALUES ('1', '平台建设', 'kpj');
INSERT INTO `sys_research_type` VALUES ('2', '研究亮点', 'kyl');
INSERT INTO `sys_research_type` VALUES ('3', '在研项目', 'kzx');

-- ----------------------------
-- Table structure for sys_result_awards
-- ----------------------------
DROP TABLE IF EXISTS `sys_result_awards`;
CREATE TABLE `sys_result_awards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '成果名称',
  `awards` varchar(255) DEFAULT NULL COMMENT '奖励情况',
  `person` varchar(255) DEFAULT NULL COMMENT '获奖者',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_result_awards
-- ----------------------------
INSERT INTO `sys_result_awards` VALUES ('1', '为企鹅去', '请问请问', '请问', '2017-01', '2017-05-12 14:47:13', '1');

-- ----------------------------
-- Table structure for sys_result_identification
-- ----------------------------
DROP TABLE IF EXISTS `sys_result_identification`;
CREATE TABLE `sys_result_identification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '成果名称',
  `identification_number` varchar(255) DEFAULT NULL COMMENT '鉴定号',
  `person` varchar(255) DEFAULT NULL COMMENT '完成人',
  `time` varchar(255) DEFAULT NULL COMMENT '鉴定时间',
  `level` varchar(255) DEFAULT NULL COMMENT '成果水平',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_result_identification
-- ----------------------------

-- ----------------------------
-- Table structure for sys_result_patent
-- ----------------------------
DROP TABLE IF EXISTS `sys_result_patent`;
CREATE TABLE `sys_result_patent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `style` varchar(255) DEFAULT NULL COMMENT '专利类别及专利号',
  `person` varchar(255) DEFAULT NULL COMMENT '获得者',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1' COMMENT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_result_patent
-- ----------------------------

-- ----------------------------
-- Table structure for sys_result_thesis
-- ----------------------------
DROP TABLE IF EXISTS `sys_result_thesis`;
CREATE TABLE `sys_result_thesis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `style` varchar(255) DEFAULT NULL COMMENT '成果类型',
  `author` varchar(255) DEFAULT NULL COMMENT '主要作者',
  `name` varchar(255) DEFAULT NULL COMMENT '论文名称',
  `publication_division` varchar(255) DEFAULT NULL COMMENT '出版处',
  `page_number` varchar(255) DEFAULT NULL COMMENT '期、卷、页码',
  `add_time` datetime DEFAULT NULL,
  `is_publish` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_result_thesis
-- ----------------------------

-- ----------------------------
-- Table structure for sys_rules
-- ----------------------------
DROP TABLE IF EXISTS `sys_rules`;
CREATE TABLE `sys_rules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_title` varchar(50) DEFAULT NULL,
  `rule_content` text,
  `add_time` datetime DEFAULT NULL,
  `author` varchar(36) DEFAULT NULL,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(1) DEFAULT '0',
  `has_attach` int(1) DEFAULT '0' COMMENT '是否有附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_rules
-- ----------------------------
INSERT INTO `sys_rules` VALUES ('1', '1', '\n        <p>实验室面积 </p><table class=\"\"><tbody><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;qwe</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;qweqwe</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr><tr><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td><td><span>&nbsp;</span></td></tr></tbody></table>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p>\n<p>拥有X射线光电子能谱仪、高分辨液质联用仪、高分辨透射电子显微镜、热场发射扫描电子显微镜、X-射线单晶衍射仪、稳态瞬态荧光光谱仪等一批先进仪器设备，仪器设备总值达6000多万元。 </p>\n<p><br></p><p><br></p>\n        ', '2017-04-05 21:18:16', '河南省表界面科学重点实验室', '2', '1', '0');

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `sys_student`;
CREATE TABLE `sys_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_content` text,
  `add_time` datetime DEFAULT NULL,
  `student_type_id` int(11) DEFAULT NULL,
  `is_publish` int(1) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_student
-- ----------------------------
INSERT INTO `sys_student` VALUES ('6', '<p>qeqweqweqeqee</p><p>qweqe</p><p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p><p><br></p><p><br></p>', '2017-04-05 21:17:08', '1', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_student` VALUES ('7', '<p>实验室面积 </p>\n<p>现有实验室面积 8600 m2左右，其中大型仪器用房 2600m2，科研用房 5900m2，办公用房 100m2。 </p>\n<p>仪器设备配置 </p>\n<p>实验室按功能划分为X射线衍射、光（色）谱、表界面性能、热分析、电镜观察、微纳加工等不同的功能区域。 </p><p>qwe<br></p>', '2017-04-05 21:17:24', '3', '1', '河南省表界面科学重点实验室');
INSERT INTO `sys_student` VALUES ('8', '<p>weqe<br></p>', '2017-04-05 21:17:15', '2', '1', '河南省表界面科学重点实验室');

-- ----------------------------
-- Table structure for sys_student_cultivate
-- ----------------------------
DROP TABLE IF EXISTS `sys_student_cultivate`;
CREATE TABLE `sys_student_cultivate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL,
  `item_content` text,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(11) DEFAULT '1',
  `is_image` int(11) DEFAULT '0',
  `type_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_student_cultivate
-- ----------------------------

-- ----------------------------
-- Table structure for sys_student_cultivate_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_student_cultivate_type`;
CREATE TABLE `sys_student_cultivate_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_student_cultivate_type
-- ----------------------------
INSERT INTO `sys_student_cultivate_type` VALUES ('1', '本科生培养', 'xbp');
INSERT INTO `sys_student_cultivate_type` VALUES ('2', '研究生培养', 'xyp');
INSERT INTO `sys_student_cultivate_type` VALUES ('3', '学生培养成果', 'xxp');

-- ----------------------------
-- Table structure for sys_student_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_student_type`;
CREATE TABLE `sys_student_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(36) DEFAULT NULL,
  `type_flag` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_flag` (`type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_student_type
-- ----------------------------
INSERT INTO `sys_student_type` VALUES ('1', '本科生培养', 'xbp');
INSERT INTO `sys_student_type` VALUES ('2', '研究生培养', 'xyp');
INSERT INTO `sys_student_type` VALUES ('3', '学生培养成果', 'xxp');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('3', 'admin', '2AED12F64A16D3F9D244787589CBEA1C7DAE05423B7F371A235C425B', null, null);
INSERT INTO `sys_user` VALUES ('4', 'changong', '6C5DBAAF4CA6100007EA2E12D8C44D8D218DA904A82CEF9B430BDBD0', null, null);
