create database IF NOT EXISTS `trafficoffenders`;

USE `trafficoffenders`;

show tables;

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
	`id` int NOT NULL AUTO_INCREMENT,
    `offendername` varchar(255) NOT NULL,
	`licensenumber` varchar(255) NOT NULL,
	`dob` date NOT NULL,
    `address` text NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `booking` WRITE;

INSERT INTO `booking` VALUES ('Harsha','Banashankari','KA05','2019-06-23');

UNLOCK TABLES;

delete from `booking` LIMIT 1;