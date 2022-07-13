/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : config-jdbc

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/07/2022 21:37:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_properties
-- ----------------------------
DROP TABLE IF EXISTS `config_properties`;
CREATE TABLE `config_properties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key1` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `value1` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `application` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `profile` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `label` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of config_properties
-- ----------------------------
BEGIN;
INSERT INTO `config_properties` VALUES (1, 'spring.freemarker.suffix', '.ftl', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (2, 'spring.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (3, 'spring.datasource.type', 'com.alibaba.druid.pool.DruidDataSource', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (4, 'spring.datasource.username', 'root', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (5, 'spring.datasource.password', 'root', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (6, 'foo', 'admin', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (7, 'server.port', '8088', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (8, 'spring.datasource.url', 'jdbc:mysql://localhost:3306/work?characterEncoding=UTF-8', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (9, 'mybatis.mapper-locations', 'classpath:/mapper/*.xml', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (10, 'mybatis.type-aliases-package', 'com.hmm.entity', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (11, 'spring.web.resources.static-locations', 'classpath:/templates/,classpath:/static/', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (13, 'spring.freemarker.suffix', '.ftl', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (14, 'spring.datasource.driver-class-name', 'com.mysql.cj.jdbc.Driver', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (15, 'spring.datasource.type', 'com.alibaba.druid.pool.DruidDataSource', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (16, 'spring.datasource.username', 'root', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (17, 'spring.datasource.password', 'root', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (18, 'foo', 'admin', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (19, 'server.port', '8081', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (20, 'spring.datasource.url', 'jdbc:mysql://localhost:3306/inte?characterEncoding=UTF-8', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (21, 'mybatis.mapper-locations', 'classpath:/mapper/*.xml', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (22, 'mybatis.type-aliases-package', 'com.hmm.integral.entity', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (25, 'from', '4', 'inte', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (26, 'management.security.enabled', 'false', 'inte', 'dev', 'master', 'SpringBoot 默认开启了权限拦截，会导致 /refresh 出现401拒绝访问');
INSERT INTO `config_properties` VALUES (27, 'management.endpoints.web.exposure.include', '*', 'inte', 'dev', 'master', '在Actuator中默认只放开了 info和health 如果要放开所有*');
INSERT INTO `config_properties` VALUES (28, 'management.endpoints.enabled-by-default', 'true', 'inte', 'dev', 'master', '放开shutdown 接口');
INSERT INTO `config_properties` VALUES (29, 'management.security.enabled', 'false', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (30, 'management.endpoints.web.exposure.include', '*', 'work', 'dev', 'master', NULL);
INSERT INTO `config_properties` VALUES (31, 'management.endpoints.enabled-by-default', 'true', 'work', 'dev', 'master', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
