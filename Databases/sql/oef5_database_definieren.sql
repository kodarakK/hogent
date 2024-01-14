CREATE DATABASE IF NOT EXISTS `WorkshopDDL`;
USE `WorkshopDDL`;

CREATE TABLE `Spel` (
	`naam` varchar(20) NOT NULL,
    PRIMARY KEY (`naam`)
);

CREATE TABLE `Doelkaart` (
	`id` char(5) NOT NULL,
    `naam` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Gangkaart` (
	`id` char(5) NOT NULL,
    `type`varchar(8) DEFAULT NULL,
    `schat` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)    
);

CREATE TABLE `Speler` (
	`id` int AUTO_INCREMENT,
    `naam` varchar(100) NOT NULL,
    `geboorte_jaar` int,
    `kleur` char(10) check (kleur in ('rood', 'zwart')),
	`huidigvak` CHAR(20),
	`IsAanDeBeurt` BOOLEAN,
	`Spelnaam` varchar(20),
    PRIMARY KEY (`id`)
);

CREATE TABLE `spelerdoelkaart` (
	`spelerID` 	INT NOT NULL,
	`doelID` 	CHAR(5)	NOT NULL,
	`volgorde` 	INT
);

ALTER TABLE `spelerdoelkaart`
	ADD CONSTRAINT PK_spelerdoelkaart PRIMARY KEY (`spelerID, doelID`);
ALTER TABLE `spelerdoelkaart`
	ADD CONSTRAINT FK_speler FOREIGN KEY (spelerID) REFERENCES speler(spelerID);


ALTER TABLE Speler
ADD COLUMN Email VARCHAR(50);

ALTER TABLE Speler
MODIFY COLUMN Email VARCHAR(100);

ALTER TABLE Speler 
DROP COLUMN Email;
