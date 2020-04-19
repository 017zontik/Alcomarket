CREATE DATABASE  IF NOT EXISTS `alcomarket`;
USE `alcomarket`;

CREATE TABLE `alcohols` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `alcoholTypes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);