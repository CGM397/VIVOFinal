DROP DATABASE IF EXISTS `vivoFinal`;
CREATE DATABASE `vivoFinal` DEFAULT CHARACTER SET UTF8MB4;
USE `vivoFinal`;

DROP TABLE IF EXISTS `parent`;
CREATE TABLE `parent` (
    `parentId` INT,
    `parentName` VARCHAR(64),
    `parentMail` VARCHAR(64),
    `parentPassword` VARCHAR(64),
    `studentId` VARCHAR(64),
    `studentName` VARCHAR(64),
    PRIMARY KEY (`parentId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
    `teacherId` INT,
    `teacherName` VARCHAR(64),
    `teacherMail` VARCHAR(64),
    `teacherPassword` VARCHAR(64),
    PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

DROP TABLE IF EXISTS `examScore`;
CREATE TABLE `examScore` (
    `examScoreId` INT,
    `examName` VARCHAR(64),
    `examTime` DATE,
    PRIMARY KEY (`examScoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

DROP TABLE IF EXISTS `scoreItem`;
CREATE TABLE `scoreItem` (
    `scoreItemId` INT,
    `studentId` VARCHAR(64),
    `examScore` DOUBLE(32, 2),
    PRIMARY KEY (`scoreItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;