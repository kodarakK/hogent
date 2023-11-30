-- hoeveel planten telt het assortiment?
-- Geef de kolom de naaam 'aantal planten'

-- SELECT * FROM planten;

-- SELECT COUNT(DISTINCT hoogte) FROM planten;

-- GEEF PER SOORT HET AANTAL BLOEMEN
SELECT soortID, COUNT(naam) AS 'aantal' FROM planten
WHERE soortID < 5
GROUP BY soortID
HAVING COUNT(naam) > 10
ORDER BY soortID;

-- OEFENING 2
-- Hoeveel planten die bloeien (waarvoor kleur ingevuld) telt het assortiment?
SELECT COUNT(kleurID) AS Aantal FROM planten
WHERE bl_b IS NOT NULL AND bl_e IS NOT NULL
;
-- Hoeveel verschillende bloeikleuren komen er in het assortiment voor?
SELECT COUNT(DISTINCT kleurID) AS Aantal FROM planten
;

-- Bij hoeveel leveranciers werd er reeds een bestelling geplaatst?
SELECT COUNT(DISTINCT levCode) AS Aantal FROM planten.bestellingen
;

-- Hoeveel verschillende artikelen zijn er reeds besteld geweest.
SELECT COUNT(DISTINCT artCodeLev) AS AANTAL FROM bestellijnen
;

-- Geef een overzicht van het aantal leveranciers per woonplaats.
SELECT levCode, COUNT(*) FROM leveranciers
GROUP BY woonplaats
;


/* alf 1 naam van planten */

SELECT MIN(naam) FROM planten
;

/* toon lijst woorplaatsen 2 of meer lev wonen*/
SELECT woonplaats, COUNT(woonplaats) FROM leveranciers
GROUP BY woonplaats
HAVING COUNT(woonplaats) >= 2
ORDER BY 1
;






SET sql_mode = 'ONLY_FULL_GROUP_BY';