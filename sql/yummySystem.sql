DROP DATABASE IF EXISTS `vivoFinal`;
CREATE DATABASE `vivoFinal` DEFAULT CHARACTER SET UTF8MB4;
USE `vivoFinal`;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` VARCHAR(64) NOT NULL,
  `customerMail` VARCHAR(64) NOT NULL,
  `customerPassword` VARCHAR(64) NOT NULL,
  `customerName` VARCHAR(64),
  `phoneNumber` VARCHAR(64),
  `active` BOOLEAN,
  PRIMARY KEY (`customerId`)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8MB4;

DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant` (
  `restaurantId` VARCHAR(64) NOT NULL,
  `restaurantPassword` VARCHAR(64) NOT NULL,
  `restaurantName` VARCHAR(64),
  `restaurantType` VARCHAR(64),
  PRIMARY KEY (`restaurantId`)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8MB4;