CREATE DATABASE IF NOT EXISTS `workshopSQL`;
USE `workshopSQL`;

CREATE TABLE IF NOT EXISTS `Spel` (
	`naam` 		varchar(20) NOT NULL,
    PRIMARY KEY(`naam`)
);

CREATE TABLE IF NOT EXISTS `Doelkaart` (
	`id`  		varchar(5),
    `naam`		varchar(30),
    PRIMARY KEY(id)
);



