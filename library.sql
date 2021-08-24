/*
 Navicat Premium Data Transfer

 Source Server         : chapter05
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 19/08/2021 15:02:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '《三体2》', '刘慈欣');
INSERT INTO `book` VALUES (2, '边城', '沈从文');
INSERT INTO `book` VALUES (3, '沙海', '南派三叔');
INSERT INTO `book` VALUES (4, '龙族2', '江南');
INSERT INTO `book` VALUES (5, '龙族3', '江南');
INSERT INTO `book` VALUES (6, '龙族', '江南');
INSERT INTO `book` VALUES (7, '龙族', '江南');
INSERT INTO `book` VALUES (8, '龙族', '江南');
INSERT INTO `book` VALUES (9, '龙族', '江南');
INSERT INTO `book` VALUES (11, '青年文摘', '小明');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passWord` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `realName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '12345', '张三');
INSERT INTO `user` VALUES (2, 'lisi', '12345', '李四');
INSERT INTO `user` VALUES (3, 'wangwu', '12345', '王五');

SET FOREIGN_KEY_CHECKS = 1;
