/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : work

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/07/2022 21:49:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', 1);
INSERT INTO `user` VALUES (51, '12', 12);
INSERT INTO `user` VALUES (52, '2', 2);
INSERT INTO `user` VALUES (53, '3', 3);
INSERT INTO `user` VALUES (54, '4', 5);
INSERT INTO `user` VALUES (58, '123', 123);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
