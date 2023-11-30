/*
	1 oversicht naam soortnm hooft van alle waterplanten sort hooogte
*/

SELECT p.naam, s.soort, p.hoogte FROM planten p
JOIN soorten s ON p.soortID = s.soortID
WHERE soort = 'water'
ORDER BY 3
;

/*
Geef een overzicht van de planten gesorteerd op soort en vervolgens op naam die noch boom,
 noch heester zijn en waarvan de hoogte tussen de 100 en de 200 cm, de kleur rood of blauw is
 en de bloeiperiode begint voor augustus.
*/

SELECT * FROM planten p
JOIN soorten s  ON p.soortID = s.soortID
JOIN kleuren k ON p.kleurID = k.kleurID
WHERE soort NOT IN('boom', 'meester') AND hoogte BETWEEN 100 AND 200 AND kleur IN('rood', 'blauw')
AND bl_b < 8
ORDER BY soort, naam
;

/*
Welke is de laagste prijs per plantensoort van de planten die de volledige periode van mei
 tot en met juni bloeien. De bloei mag beginnnen voor mei en eindigen na juni.
*/
SELECT soort, MIN(prijs) FROM planten p 
JOIN soorten s ON p.soortID = s.soortID
WHERE (p.bl_b <= 5 AND p.bl_e >= 6)
GROUP BY soort
;

/*

*/