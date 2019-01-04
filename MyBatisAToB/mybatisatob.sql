/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : mybatisatob

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-01-04 13:57:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `countryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京', '1');
INSERT INTO `city` VALUES ('2', '上海', '1');
INSERT INTO `city` VALUES ('3', '东京', '2');

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '软件1班');
INSERT INTO `class` VALUES ('2', '软件2班');
INSERT INTO `class` VALUES ('3', '软件3班');

-- ----------------------------
-- Table structure for `country`
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '中国');
INSERT INTO `country` VALUES ('2', '外国');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '1');
INSERT INTO `student` VALUES ('2', '李四', '1');
INSERT INTO `student` VALUES ('3', '王五', '2');
