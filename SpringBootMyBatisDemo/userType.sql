/*
Navicat MySQL Data Transfer

Source Server         : Aliyun
Source Server Version : 50173
Source Host           : 47.105.132.96:3306
Source Database       : trainproject

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-01-02 19:07:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `userType`
-- ----------------------------
DROP TABLE IF EXISTS `userType`;
CREATE TABLE `userType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userType
-- ----------------------------
INSERT INTO `userType` VALUES ('1', '指挥中心');
INSERT INTO `userType` VALUES ('2', '监理中心');
INSERT INTO `userType` VALUES ('3', '施工单位');
