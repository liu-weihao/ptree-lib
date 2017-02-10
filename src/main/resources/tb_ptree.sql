/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50529
Source Host           : 127.0.0.1:3306
Source Database       : ptree

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2017-02-10 22:18:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_ptree`
-- ----------------------------
DROP TABLE IF EXISTS `tb_ptree`;
CREATE TABLE `tb_ptree` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '节点id',
  `name` varchar(64) NOT NULL COMMENT '节点名称',
  `left_id` int(11) NOT NULL COMMENT '左节点id',
  `right_id` int(11) NOT NULL COMMENT '右节点id',
  `nlevel` int(11) NOT NULL COMMENT '节点层级，根节点为0',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_ptree
-- ----------------------------
INSERT INTO `tb_ptree` VALUES ('1', 'root', '1', '2', '0', '2017-02-10 22:17:59');
