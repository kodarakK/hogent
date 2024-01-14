/*
ALL IN 'planten script database'

CREATE DATABASE	 bib
DROP DATABASE bib
----------
CREATE TABLE `boeken` (
	ISBN int NOT NULL primary key, OF contraint `boeken_PK` ISBN PRIMARY KEY // op het einde
    title varchar(100),
    contraint `cath_PK` FOREIGN KEY cath REFERENCES cathegorieen(cath)
)
----------
DROP TABLE boeken
----------
ALTER TABLE 
  ADD | MODIFY | DROP

*/