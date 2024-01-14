CREATE DATABASE `WorkshopDDL` IF NOT EXISTS;
USE `WorkshopDDL`;

CREATE TABLE IF NOT EXISTS `Spel`
(
	`Naam`		VARCHAR(20),
	CONSTRAINT PK_Spel PRIMARY KEY(`Naam`)
);

CREATE TABLE IF NOT EXISTS `Doelkaart`
(
	`id`		VARCHAR(5),
	`naam`		VARCHAR(30),
	CONSTRAINT PK_Doelkaart PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `Gangkaart`
(
	`id` 		VARCHAR(5),
	`type` 		VARCHAR(8),
	`schat` 	VARCHAR(20),
	CONSTRAINT PK_Gangkaart PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `Speler`
(
	`id` 		INT AUTO_INCREMENT,
	`naam`		VARCHAR(100) NOT NULL,
	`geboortejaar`	INT,
	`kleur`		VARCHAR(10),
	`huidigvak`	VARCHAR(20),
	`IsAanDeBeurt`	BOOLEAN,
    `spelnaam` 		varchar(100),
	CONSTRAINT PK_Speler PRIMARY KEY(`id`),
	CONSTRAINT FK_Speler_Spel FOREIGN KEY(`Spelnaam`) REFERENCES Spel(`naam`),
	CONSTRAINT CH_Speler_Kleuren CHECK (`Kleur` IN ('rood','zwart'))
);