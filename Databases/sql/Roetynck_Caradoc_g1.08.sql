-- vraag 1
SELECT primaryTitle FROM titles;
-- JOIN persons p ON ;

-- vraag 2
SELECT DISTINCT t.titleType, SUM(r.averageRating)/COUNT(r.averageRating) as 'gemiddeldeTypeRating' FROM titles t
JOIN ratings r ON t.tconst = r.tconst
GROUP BY t.titleType
;

-- vraag 3

SELECT DISTINCT d.nmconst, p.fullname, COUNT(t.tconst) AS numberOfMovies 
FROM directors d JOIN titles t ON t.tconst = d.tconst
JOIN persons p ON d.nmconst = p.nmconst
WHERE t.titleType = 'movie'
GROUP BY p.fullname
;
-- Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'imdb.d.nmconst' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

/*
SELECT p.nmconst, p.fullName, COUNT(t.tconst) As numberOfMovies
FROM persons p JOIN directors d ON p.nmconst = d.nmconst
JOIN titles t ON d.tconst = t.tconst
WHERE t.titleType = 'movie' -- AND numberOfMovies > 3
GROUP BY p.nmconst, p.fullName
ORDER BY p.fullname 
;
--*/

--  vraag 4
SELECT t.tconst, t.primaryTitle, w.nmconst FROM titles t
JOIN writers w ON t.tconst = w.tconst
WHERE t.primaryTitle LIKE '%wall'
;


-- vraag 5
SELECT primaryTitle, runtimeMinutes, 
CASE
	WHEN runtimeMinutes < 90
		THEN 'Kort'
	WHEN runtimeMinutes >= 90 AND runtimeMinutes > 150
		THEN 'Gemiddeld'
	ELSE 'Lang'
END AS duurtijd 
FROM titles
;

-- vraag 6
CREATE TABLE IF NOT EXISTS `Filmlocaties` 
(
	`LocatieID` 	INT AUTO_INCREMENT,
    `naam`			VARCHAR(50),
    `Stad`			VARCHAR(50),
    `Land`			VARCHAR(50),
    `Beschrijving`	TEXT,
    
    PRIMARY KEY (`LocatieID`)
);


INSERT INTO filmlocaties(naam) VALUES ('Times Square', 'Trevi-fontein');

INSERT INTO filmlocaties(Stad) VALUES ('New York City', 'Rome');

INSERT INTO filmlocaties(Land) VALUES ('Italië', 'Verenigde Staten');

INSERT INTO filmlocaties(Beschrijving) VALUES ('Beroemd plein in Manhatten', 'Beroemde fontein in Rome');