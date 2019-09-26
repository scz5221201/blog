/*
 Navicat Premium Data Transfer

 Source Server         : mysql56
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 25/09/2019 22:21:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for open_user
-- ----------------------------
DROP TABLE IF EXISTS `open_user`;
CREATE TABLE `open_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountId` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of open_user
-- ----------------------------
INSERT INTO `open_user` VALUES (1, 'https://avatars3.githubusercontent.com/u/15024605?v=4', '6ab2c81e-2fdc-4d06-adcb-9d9bc1091ca5', '15024605', '码工', '2015-10-08T02:04:09Z', '2019-09-17T13:17:58Z');
INSERT INTO `open_user` VALUES (2, 'https://avatars3.githubusercontent.com/u/15024605?v=4', 'ae1da3a2-d9bf-4f1c-8ca0-e953940df60c', '15024605', '码工', '2015-10-08T02:04:09Z', '2019-09-17T13:17:58Z');
INSERT INTO `open_user` VALUES (3, 'https://avatars3.githubusercontent.com/u/15024605?v=4', '22b1f35d-414e-4b7e-86fe-5ec0e17488c1', '15024605', '码工', '2015-10-08T02:04:09Z', '2019-09-17T13:17:58Z');
INSERT INTO `open_user` VALUES (4, 'https://avatars3.githubusercontent.com/u/15024605?v=4', '20bf06a6-299c-4811-9d5b-169e5433e412', '15024605', '码工', '2015-10-08T02:04:09Z', '2019-09-17T13:17:58Z');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_create` date NULL DEFAULT NULL,
  `gmt_modified` date NULL DEFAULT NULL,
  `view_count` int(20) NULL DEFAULT 0,
  `comment_count` int(20) NULL DEFAULT 0,
  `like_count` int(20) NULL DEFAULT 0,
  `creator_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (2, '111', '111', '111', NULL, NULL, 0, 0, 0, NULL);
INSERT INTO `question` VALUES (3, '学习springboot', '学习springboot学习springboot学习springboot学习springboot', 'java', NULL, NULL, 0, 0, 0, NULL);
INSERT INTO `question` VALUES (4, 'springboot', 'springboot', 'springboot', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (5, 'springboot', 'springboot', 'springboot', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (6, 'springboot', 'springboot', 'springboot', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (7, 'springboot', 'springboot', 'springboot', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (8, 'springcloud', 'springcloud', 'springcloud', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (9, 'springcloud', 'springcloud', 'springcloud', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (10, 'springcloud', 'springcloud', 'springcloud', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (11, 'springcloud', 'springcloud', 'springcloud', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (12, 'html', 'html', 'html', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (13, 'html', 'html', 'html', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (14, 'js', 'js', 'js', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (15, 'js', 'js', 'js', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (16, 'css', 'css', 'css', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (17, 'div', 'div', 'div', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (18, 'c', 'c', 'c', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (19, 'ok', 'ok', 'ok', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (20, 'home', 'home', 'home', NULL, NULL, 0, 0, 0, 3);
INSERT INTO `question` VALUES (21, '修改了时间', '修改了时间', 'time', '2019-09-25', '2019-09-25', 0, 0, 0, 3);
INSERT INTO `question` VALUES (22, 'token', 'token', 'token', '2019-09-25', '2019-09-25', 0, 0, 0, 4);

SET FOREIGN_KEY_CHECKS = 1;
