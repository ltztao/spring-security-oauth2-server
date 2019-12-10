/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-10 14:18:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('dev', '', '$2a$10$xcxggzcVclrxVX3kTFtje.COuv8mxg3vGSa.uVCH4Gx4/bOOLHnjW', 'user_info', 'password,client_credentials,authorization_code,refresh_token', 'http://localhost:8082/ui/login', '', '3600', '3600', '{\"country\":\"CN\",\"country_code\":\"086\"}', 'true');

-- ----------------------------
-- Table structure for role_relation_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_relation_permission`;
CREATE TABLE `role_relation_permission` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_relation_permission
-- ----------------------------
INSERT INTO `role_relation_permission` VALUES ('1', '1', '1');
INSERT INTO `role_relation_permission` VALUES ('2', '1', '2');
INSERT INTO `role_relation_permission` VALUES ('3', '2', '2');
INSERT INTO `role_relation_permission` VALUES ('4', '2', '3');

-- ----------------------------
-- Table structure for user_relation_role
-- ----------------------------
DROP TABLE IF EXISTS `user_relation_role`;
CREATE TABLE `user_relation_role` (
  `id` bigint(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_relation_role
-- ----------------------------
INSERT INTO `user_relation_role` VALUES ('1', '1', '1');
INSERT INTO `user_relation_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for xb_permission
-- ----------------------------
DROP TABLE IF EXISTS `xb_permission`;
CREATE TABLE `xb_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(100) DEFAULT NULL,
  `permission_abbr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xb_permission
-- ----------------------------
INSERT INTO `xb_permission` VALUES ('1', '查询用户', 'FIND_USER');
INSERT INTO `xb_permission` VALUES ('2', '删除用户', 'DELETE_USER');
INSERT INTO `xb_permission` VALUES ('3', '查询当前用户权限', 'FIND_CURRENTUSER');

-- ----------------------------
-- Table structure for xb_role
-- ----------------------------
DROP TABLE IF EXISTS `xb_role`;
CREATE TABLE `xb_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `role_abbr` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xb_role
-- ----------------------------
INSERT INTO `xb_role` VALUES ('1', '管理员', 'admin');
INSERT INTO `xb_role` VALUES ('2', '访客', 'vistor');

-- ----------------------------
-- Table structure for xb_user
-- ----------------------------
DROP TABLE IF EXISTS `xb_user`;
CREATE TABLE `xb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mobile` int(12) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL COMMENT '1:男 2：女',
  `enabled` tinyint(2) DEFAULT NULL,
  `session_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xb_user
-- ----------------------------
INSERT INTO `xb_user` VALUES ('1', 'ltzhang', '$2a$10$xcxggzcVclrxVX3kTFtje.COuv8mxg3vGSa.uVCH4Gx4/bOOLHnjW', '1665516979', '1', '0', 'fd0f4271-6aa9-43a8-84cd-e71da1f17d7e');
INSERT INTO `xb_user` VALUES ('2', 'test', '$2a$10$xcxggzcVclrxVX3kTFtje.COuv8mxg3vGSa.uVCH4Gx4/bOOLHnjW', '122111', '2', '1', '2d8f007c-eb04-40b5-bac2-64fcb69ccc82');
