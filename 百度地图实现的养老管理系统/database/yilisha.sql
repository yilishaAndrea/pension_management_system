/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : yilisha
Target Host     : localhost:3306
Target Database : yilisha
Date: 2018-12-30 10:11:21
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for familymember
-- ----------------------------
DROP TABLE IF EXISTS `familymember`;
CREATE TABLE `familymember` (
  `memberID` varchar(18) NOT NULL,
  `memberName` varchar(10) NOT NULL COMMENT '亲属姓名',
  `relation` varchar(10) NOT NULL COMMENT '关系',
  `memberTel` varchar(11) NOT NULL COMMENT '亲属电话',
  `address` varchar(200) NOT NULL COMMENT '地址或工作单位',
  `relationMemberID` varchar(18) NOT NULL COMMENT '与使用养老系统的人的Id',
  PRIMARY KEY (`memberID`),
  KEY `relationMember` (`relationMemberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of familymember
-- ----------------------------
INSERT INTO `familymember` VALUES ('320723199110070442', 'bbb', '儿子', '11111111', '地球', '320723199510050446');
INSERT INTO `familymember` VALUES ('320723199510050441', 'aaa', '女儿', '1', '火星', '320723199510050446');

-- ----------------------------
-- Table structure for insuredtype
-- ----------------------------
DROP TABLE IF EXISTS `insuredtype`;
CREATE TABLE `insuredtype` (
  `insuredTypeID` int(2) NOT NULL COMMENT '参保的Id',
  `insuredName` varchar(20) NOT NULL COMMENT '参保名称',
  `insuredCount` varchar(20) NOT NULL COMMENT '参保对应的标准',
  PRIMARY KEY (`insuredTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insuredtype
-- ----------------------------
INSERT INTO `insuredtype` VALUES ('1', '人寿保险', '50%');
INSERT INTO `insuredtype` VALUES ('2', '医疗保险', '30%');
INSERT INTO `insuredtype` VALUES ('3', '农村合作医疗', '70%');

-- ----------------------------
-- Table structure for orderform
-- ----------------------------
DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `orderNumber` varchar(30) NOT NULL COMMENT '服务单号',
  `userId` varchar(18) NOT NULL COMMENT '户用ID',
  `serviceContent` varchar(300) NOT NULL COMMENT '服务内容',
  `serviceTypeId` int(2) NOT NULL COMMENT '服务类型',
  `serviceStatus` int(1) NOT NULL DEFAULT '0' COMMENT '服务状态（0，无人接收；1，已接受正处理；）',
  `serverId` varchar(18) DEFAULT NULL COMMENT '服务人员ID',
  PRIMARY KEY (`orderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderform
-- ----------------------------
INSERT INTO `orderform` VALUES ('201610081848', '320723199510050446', '洗衣服', '4', '1', '320723199510050421');
INSERT INTO `orderform` VALUES ('201610081857', '320723199510050447', '煮饭', '3', '1', '320723199510050421');
INSERT INTO `orderform` VALUES ('201611021130', '320723199510051223', '扫地', '4', '0', '');
INSERT INTO `orderform` VALUES ('201611021896', '320723199510050889', '种地', '1', '0', '');

-- ----------------------------
-- Table structure for server
-- ----------------------------
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server` (
  `serverID` varchar(18) NOT NULL COMMENT '服务人员身份证号',
  `serverName` varchar(10) NOT NULL COMMENT '服务人员姓名',
  `serverWorkplaceID` int(10) NOT NULL COMMENT '服务人员所属服务单位ID',
  `serverTel` varchar(11) NOT NULL COMMENT '服务电话',
  `serverCoordinateX` double NOT NULL COMMENT '服务人员所在坐标X',
  `serverCoordinateY` double NOT NULL COMMENT '服务人员所在坐标Y',
  `serverStatus` int(2) NOT NULL DEFAULT '0' COMMENT '前当服务状态（0，没有服务，1，正在服务）',
  PRIMARY KEY (`serverID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of server
-- ----------------------------
INSERT INTO `server` VALUES ('320723199510050410', '1111', '140204102', '234567897', '120.897858', '32.174634', '1');
INSERT INTO `server` VALUES ('320723199510050411', '1111', '140204108', '123456767', '120.905116', '32.013684', '0');
INSERT INTO `server` VALUES ('320723199510050412', '2222', '140204105', '122345670', '120.897175', '32.017603', '0');
INSERT INTO `server` VALUES ('320723199510050413', '3333', '140204103', '123456787', '120.902781', '32.016011', '1');
INSERT INTO `server` VALUES ('320723199510050414', '4444', '140204106', '123456778', '120.907093', '32.017175', '0');
INSERT INTO `server` VALUES ('320723199510050415', '5555', '140204104', '123456789', '120.898074', '32.016011', '1');
INSERT INTO `server` VALUES ('320723199510050420', '6666', '140204105', '123452345', '120.895235', '32.022563', '0');
INSERT INTO `server` VALUES ('320723199510050421', '啦啦啦', '140204104', '111111111', '120.923442', '32.016501', '0');
INSERT INTO `server` VALUES ('320723199510050422', '7777', '140204102', '134566666', '120.943851', '32.010837', '1');
INSERT INTO `server` VALUES ('320723199510050423', '9999', '140204204', '444444444', '120.957326', '32.061312', '0');
INSERT INTO `server` VALUES ('320723199510050424', '点点', '140204108', '223334556', '120.93175', '32.004634', '0');
INSERT INTO `server` VALUES ('320723199510050425', '一粒沙', '140204107', '888888888', '120.941197', '32.002334', '1');
INSERT INTO `server` VALUES ('320723199510050427', '0000', '140204101', '333333333', '120.922197', '32.100434', '0');
INSERT INTO `server` VALUES ('320723199510050428', '9999', '140204105', '234567899', '120.900197', '32.01134', '0');
INSERT INTO `server` VALUES ('320723199510050429', '斤斤计较', '140204106', '122456788', '120.920197', '32.100634', '1');
INSERT INTO `server` VALUES ('320723199510050445', '老张', '140204104', '111111111', '120.910197', '32.074634', '1');
INSERT INTO `server` VALUES ('320723199510050446', '哈哈哈', '140204103', '111111111', '120.890197', '32.100034', '0');

-- ----------------------------
-- Table structure for servertrace
-- ----------------------------
DROP TABLE IF EXISTS `servertrace`;
CREATE TABLE `servertrace` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '轨迹ID',
  `serverID` varchar(18) NOT NULL DEFAULT '320723199510050445' COMMENT '服务人员ID',
  `date` date NOT NULL COMMENT '日期',
  `time` time NOT NULL COMMENT '时间',
  `serverCoordinateX` double NOT NULL DEFAULT '134.880197' COMMENT '服务人员坐标X',
  `serverCoordinateY` double NOT NULL DEFAULT '34.774634' COMMENT '服务人员坐标Y',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servertrace
-- ----------------------------
INSERT INTO `servertrace` VALUES ('1', '320723199510050410', '2016-11-02', '08:00:00', '120.897858', '32.174634');
INSERT INTO `servertrace` VALUES ('2', '320723199510050410', '2016-11-02', '08:05:00', '120.897847', '32.174634');
INSERT INTO `servertrace` VALUES ('3', '320723199510050410', '2016-11-02', '08:10:00', '120.897836', '32.174634');
INSERT INTO `servertrace` VALUES ('4', '320723199510050410', '2016-11-02', '08:15:00', '120.897825', '32.174634');
INSERT INTO `servertrace` VALUES ('5', '320723199510050410', '2016-11-02', '08:20:00', '120.897814', '32.174634');
INSERT INTO `servertrace` VALUES ('6', '320723199510050410', '2016-11-02', '08:25:00', '120.897803', '32.174634');
INSERT INTO `servertrace` VALUES ('7', '320723199510050410', '2016-11-02', '08:30:00', '120.897852', '32.100434');
INSERT INTO `servertrace` VALUES ('8', '320723199510050410', '2016-11-02', '08:35:00', '120.897851', '32.174634');
INSERT INTO `servertrace` VALUES ('9', '320723199510050410', '2016-11-02', '08:40:00', '120.89785', '32.174634');
INSERT INTO `servertrace` VALUES ('10', '320723199510050410', '2016-11-02', '08:45:00', '134.880197', '32.174634');
INSERT INTO `servertrace` VALUES ('11', '320723199510050411', '2016-11-02', '09:00:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('12', '320723199510050411', '2016-11-02', '09:05:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('13', '320723199510050411', '2016-11-02', '09:10:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('14', '320723199510050411', '2016-11-02', '09:15:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('15', '320723199510050411', '2016-11-02', '09:20:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('16', '320723199510050411', '2016-11-02', '09:25:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('17', '320723199510050411', '2016-11-02', '09:30:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('18', '320723199510050411', '2016-11-02', '09:35:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('19', '320723199510050411', '2016-11-02', '09:40:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('20', '320723199510050411', '2016-11-02', '09:45:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('31', '320723199510050412', '2016-11-02', '10:00:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('32', '320723199510050412', '2016-11-02', '10:05:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('33', '320723199510050412', '2016-11-02', '10:10:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('34', '320723199510050412', '2016-11-02', '10:15:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('35', '320723199510050412', '2016-11-02', '10:20:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('36', '320723199510050412', '2016-11-02', '10:25:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('37', '320723199510050412', '2016-11-02', '10:30:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('38', '320723199510050412', '2016-11-02', '10:35:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('39', '320723199510050412', '2016-11-02', '10:40:00', '134.880197', '34.774634');
INSERT INTO `servertrace` VALUES ('40', '320723199510050412', '2016-11-02', '10:45:00', '134.880197', '34.774634');

-- ----------------------------
-- Table structure for serverworkspace
-- ----------------------------
DROP TABLE IF EXISTS `serverworkspace`;
CREATE TABLE `serverworkspace` (
  `serverWorkplaceID` int(10) NOT NULL AUTO_INCREMENT COMMENT '服务商ID',
  `serverWorkplaceName` varchar(100) NOT NULL COMMENT '服务商名称',
  `serverWorkplaceCoordinateX` double NOT NULL COMMENT '服务商坐标X',
  `serverWorkplaceCoordinateY` double NOT NULL COMMENT '服务商坐标Y',
  `serverWorkplaceAddress` varchar(200) NOT NULL COMMENT '服务商地址',
  PRIMARY KEY (`serverWorkplaceID`)
) ENGINE=InnoDB AUTO_INCREMENT=140204109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serverworkspace
-- ----------------------------
INSERT INTO `serverworkspace` VALUES ('140204101', '医院', '120.903212', '32.002317', '宇宙');
INSERT INTO `serverworkspace` VALUES ('140204102', '餐厅', '120.930197', '32.104634', '金星');
INSERT INTO `serverworkspace` VALUES ('140204103', '警察局', '120.94001', '32.031211', '地球');
INSERT INTO `serverworkspace` VALUES ('140204104', '不知名', '120.920001', '32.1', '火星');
INSERT INTO `serverworkspace` VALUES ('140204105', '学校', '120.930197', '32.00017', '黑洞');
INSERT INTO `serverworkspace` VALUES ('140204106', '消防局', '120.950197', '32.101111', '中国');
INSERT INTO `serverworkspace` VALUES ('140204107', '市场', '120.890197', '32.024634', '某个角落');
INSERT INTO `serverworkspace` VALUES ('140204108', '古古怪怪', '121.940197', '32.124634', '不知道');

-- ----------------------------
-- Table structure for servicecontent
-- ----------------------------
DROP TABLE IF EXISTS `servicecontent`;
CREATE TABLE `servicecontent` (
  `orderNumber` varchar(30) NOT NULL COMMENT '服务单号',
  `serverID` varchar(18) NOT NULL COMMENT '服务人员ID',
  `startDate` varchar(20) DEFAULT NULL COMMENT '服务日期',
  `startTime` varchar(20) NOT NULL COMMENT '开始服务时间',
  `stopTime` varchar(20) NOT NULL COMMENT '停止服务时间',
  `serviceId` int(1) NOT NULL COMMENT '服务类型Id',
  `serviceThing` varchar(500) NOT NULL COMMENT '服务具体备注',
  `userID` varchar(18) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`orderNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servicecontent
-- ----------------------------
INSERT INTO `servicecontent` VALUES ('201610081848', '320723199510050445', '2016-10-08', '19:21:06', '21:21:09', '4', '洗衣服', '320723199510050446');

-- ----------------------------
-- Table structure for servicecost
-- ----------------------------
DROP TABLE IF EXISTS `servicecost`;
CREATE TABLE `servicecost` (
  `serviceCostId` varchar(20) NOT NULL DEFAULT '服务花费ID',
  `serverId` varchar(18) NOT NULL COMMENT '服务人员ID',
  `serviceTime` double NOT NULL,
  `serviceCost` double NOT NULL,
  PRIMARY KEY (`serviceCostId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servicecost
-- ----------------------------
INSERT INTO `servicecost` VALUES ('201610081848', '320723199510050445', '1', '20');

-- ----------------------------
-- Table structure for servicetype
-- ----------------------------
DROP TABLE IF EXISTS `servicetype`;
CREATE TABLE `servicetype` (
  `serviceId` int(2) NOT NULL COMMENT '服务类型编号',
  `serviceName` varchar(10) NOT NULL COMMENT '务服类型名称',
  `servicePrice` double NOT NULL COMMENT '务服类型对应的价格',
  `serviceDuration` double NOT NULL COMMENT '服务时长',
  PRIMARY KEY (`serviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of servicetype
-- ----------------------------
INSERT INTO `servicetype` VALUES ('1', '干农活', '50', '3');
INSERT INTO `servicetype` VALUES ('2', '做家务', '30', '2');
INSERT INTO `servicetype` VALUES ('3', '煮饭', '20', '1');
INSERT INTO `servicetype` VALUES ('4', '洗衣服', '15', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` varchar(18) NOT NULL DEFAULT '' COMMENT '身份证号码',
  `userName` varchar(10) NOT NULL COMMENT '用户名',
  `userGender` varchar(2) DEFAULT NULL COMMENT '户用性别',
  `userAge` int(3) NOT NULL COMMENT '户用年龄',
  `userTel` varchar(11) NOT NULL COMMENT '户用电话号码',
  `userCoordinateX` double NOT NULL COMMENT '用户坐标X',
  `userCoordinateY` double NOT NULL COMMENT '用户坐标Y',
  `insuredTypeID` int(1) DEFAULT '0' COMMENT '参保类型（）',
  `userAddress` varchar(200) NOT NULL COMMENT '用户住址',
  `userStatus` int(1) NOT NULL COMMENT '是否呼叫服务，1呼叫，0没有呼叫',
  PRIMARY KEY (`userID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('320723199510050411', 'III', '女', '111', '23333333333', '120.899619', '32.015828', '0', '南通', '0');
INSERT INTO `user` VALUES ('320723199510050412', 'III', '女', '111', '44444444444', '120.903212', '32.054634', '0', '南通', '1');
INSERT INTO `user` VALUES ('320723199510050413', 'JJJ', '女', '100', '00000000000', '120.908853', '32.054634', '0', '南通', '0');
INSERT INTO `user` VALUES ('320723199510050414', 'KKK', '女', '111', '23345556677', '120.901451', '32.012582', '0', '南通', '1');
INSERT INTO `user` VALUES ('320723199510050440', 'GGG', '男', '111', '11111111111', '121.180197', '32.034634', '0', '南通', '0');
INSERT INTO `user` VALUES ('320723199510050441', 'EEE', '女', '300', '15962990639', '120.895271', '32.011143', '0', '南通', '1');
INSERT INTO `user` VALUES ('320723199510050442', 'FFF', '男', '100', '15962990630', '120.89563', '32.014634', '0', '南通', '1');
INSERT INTO `user` VALUES ('320723199510050446', 'AAA', '女', '80', '15962990631', '120.919633', '32.013317', '1', '南通', '0');
INSERT INTO `user` VALUES ('320723199510050447', 'BBB', '男', '89', '15962990633', '120.980197', '32.014634', '2', '南通', '1');
INSERT INTO `user` VALUES ('320723199510050448', 'CCC', '女', '101', '11111111111', '120.906949', '32.002264', '0', '南通', '0');
INSERT INTO `user` VALUES ('320723199510050449', 'DDD', '男', '200', '22222222222', '120.890636', '32.00998', '0', '南通', '1');

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `workNumber` varchar(10) NOT NULL COMMENT '工号',
  `workDate` varchar(20) NOT NULL COMMENT '日期',
  `startWork` varchar(20) NOT NULL COMMENT '上班时间',
  `endWork` varchar(20) NOT NULL COMMENT '下班时间',
  PRIMARY KEY (`workNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('1001011', '2016-10-08', '19:15:39', '11:15:43');
INSERT INTO `worker` VALUES ('1001012', '2016-10-14', '23:16:08', '13:16:13');
