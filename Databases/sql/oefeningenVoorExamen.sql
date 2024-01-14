-- planten
/* 1) Toon een alfabetische adreslijst van alle leveranciers
	(naam, leverancierscode, adres en woonplaats). 
    Sorteer op woonplaats in dalende volgorde. 
    Bij gelijke woonplaats komen de namen van de leveranciers 
    in alfabetische volgorde.
*/

SELECT * FROM leveranciers
ORDER BY woonplaats DESC, naam
;

-- 2) Toon de unieke leverancierscode van de leveranciers 
--    waarbij bestellingen zijn geplaatst.

SELECT distinct levCode from bestellingen;

/*
Geef een alfabetische lijst van alle planten (naam) 
waarvan de naam eindigt op 'bloem'.
*/

select naam from planten
where naam like '%bloem'
order by naam;


/*
Geef een overzicht (alle gegevens) van alle leveranciers 
die wonen te Antwerpen, Heusden of Leuven.
*/

SELECT * FROM leveranciers
WHERE woonplaats IN ('Antwerpen', 'Heusden', 'Leuven');

/*
Toon de naam, artikelcode en prijs van de planten 
waarvan de bloei begint in april.
*/

SELECT naam, artcode, prijs FROM planten
WHERE bl_b=4;


/*
Geef een overzicht van alle planten waarvan de 
bloeiperiode begin en/of bloeiperiode einde niet is ingevuld. 
Toon de naam van de planten en een aanduiding, 
gebruik hiervoor een case expressie 
en noem de kolom "bloeiperiode", 
de volgende aanduidingen zijn mogelijk:

    Beginperiode niet opgegeven: 
		indien enkel bl_b niet is ingevuld
    Eindperiode niet opgegeven: 
		indien enkel bl_e niet is ingevuld
    Periodes niet opgegeven: 
		indien beide niet ingevuld
*/

SELECT naam, 
CASE 
	WHEN bl_b IS NULL AND NOT bl_e IS  NULL
		THEN 'Begin periode is niet opgegeven'
	WHEN NOT bl_b IS NULL AND bl_e IS  NULL
		THEN 'Eind periode is niet opgegeven'
	ELSE 'periodes niet opgegeven'
    
END AS 'bloeiperiode'
FROM planten
WHERE bl_b IS NULL OR bl_e IS NULL
;

/*
Geef de namen van de planten waarin het woordje 'boom' 
voorkomt of waarvan de naam bestaat uit 5 posities.
*/
select naam from planten
where naam like '%boom%' or length(naam) = 5;

/*
Toon naam en woonplaats van de leveranciers 
die niet in Lisse wonen.
*/

select naam, woonplaats from leveranciers
where not woonplaats='Lisse';

/*
Toon naam van de planten waarvan de bloeiperiode begint tussen 
juni en oktober.
*/

select naam from planten
-- where bl_b >= 6 and bl_b <= 10;
where bl_b between 6 and 10;

/*
Geef artikelcode en naam van de planten waarvan de naam 
begint met een L en eindigt met een E.
*/

select artcode, naam from planten
where naam like 'L%E';

/*
Geef de namen van de planten waarvan de naam een spatie bevat.
*/

select naam from planten
where naam like '% %';

/*
Toon de verschillende woonplaatsen (alfabetisch)
 van de leveranciers.
*/

select distinct woonplaats from leveranciers
order by woonplaats;

/*
Toon de bestelnummers van de bestellingen 
voor een bedrag van meer dan 250 euro 
die binnen de 14 dagen werden geleverd.
*/

select bestelnr from bestellingen
where bedrag < 250 and datediff(leverDatum, bestelDatum) < 14;

/*
Geef een alfabetisch overzicht van de plantnamen 
die uit maximaal 5 letters bestaan.
*/

select naam from planten
-- where naam like '_____';
where length(naam)<=5;

/*
Toon de naam en de hoogte van de planten 
die tussen de 10 en de 50 cm of de 100 en 150 cm hoog zijn. 
Naast de hoogte moet de tekst 'cm' worden weergegeven 
zoals in het voorbeeld hieronder.
*/

select naam, concat(hoogte, ' cm') as 'hoogte' from planten
where hoogte between 10 and 50 or hoogte between 100 and 150;




-- --------------------

/*
Hoeveel planten telt het assortiment? 
Geef de kolom de naam ‘aantal planten’.
*/

select count(*) as 'aantal planten' from planten;

/*
Hoeveel planten die bloeien (waarvoor kleur ingevuld) 
telt het assortiment?
*/

select count(kleurID) as Aantal from planten
where bl_b is not null and bl_e is not null
;

/*
Hoeveel verschillende bloeikleuren komen er in het 
assortiment voor?
*/

select count(distinct kleurID) from planten;

/*
Bij hoeveel leveranciers werd er reeds een 
bestelling geplaatst?
*/

select count(distinct levcode) from bestellingen;

/*
Hoeveel verschillende artikelen zijn er reeds besteld geweest.
*/

select count(distinct artCodeLev) from bestellijnen;

/*
Geef een overzicht van het aantal leveranciers per woonplaats.
*/

select woonplaats, count(*) from leveranciers
group by woonplaats;

/*
Toon voor de tabel planten de gemiddelde hoogte 
en de som van alle hoogtes gedeeld door het aantal planten. 
Zijn deze gelijk? Waarom?
*/

select sum(hoogte)/count(*), AVG(hoogte) from planten;


/*
Welke leveranciers bieden minstens 20 planten aan waarvan de levertermijn kleiner is dan 17 dagen. Toon code van de leverancier en het aantal verschillende planten. De leverancier die het meeste aantal planten aanbiedt staat bovenaan.

    4 records, 1ste record: levcode: 013 - aantal art.: 31
*/
SELECT levcode, COUNT(artcodelev) AS 'Aantal artikelen' 
FROM offertes 
WHERE levertermijn < 17 
GROUP BY levcode 
HAVING COUNT(artcodelev) > 20 
ORDER BY  COUNT(artcodelev) DESC 
;/*
Geef per bestelling het aantal bestellijnen, gesorteerd op aantal lijnen.

    15 records
*/
SELECT bestelnr, COUNT(*) AS 'Aantal bestellijnen' 
FROM bestellijnen 
GROUP BY bestelnr 
ORDER BY  COUNT(*) 
;/*
Wat is de laagste offerteprijs voor de plant met artikelcode 123.

    laagste offerteprijs: 0,35
*/
SELECT MIN(offerteprijs) AS 'laagste offerteprijs' 
FROM offertes 
WHERE artcode='123' 
;/*
Hoeveel artikels met artcodelev B111 werden reeds besteld?

    totaal aantal: 75
*/
SELECT SUM(aantal) AS 'Totaal aantal' 
FROM bestellijnen 
WHERE artCodeLev='B111' 
;/*
Geef per artikel (artcode) de minimale en maximale offerteprijs.

    119 records
*/
SELECT artcode, MIN(offerteprijs) AS 'min prijs', MAX(offerteprijs) AS 'max prijs' 
FROM offertes 
GROUP BY artcode 
;/*
Geef per levertermijn de gemiddelde offerteprijs.

    4 records - 1ste record: levertermijn: 7 - gemiddelde prijs: 0,651613
*/
SELECT levertermijn, AVG(offerteprijs) AS 'gemiddelde prijs' 
FROM offertes 
GROUP BY levertermijn 
;/*
Welke is alfabetisch gezien de eerste naam van de planten uit het assortiment.

    naam: Acacia
*/
SELECT MIN(naam) 
FROM planten 
;-- OF
SELECT naam 
FROM planten
ORDER BY naam 
LIMIT 1
;/*
Toon de lijst van de woonplaatsen waar 2 of meer leveranciers wonen. Sorteer alfabetisch.

    3 records - 4 in Aalsmeer, 2 in Hillegom, 4 in Lisse
*/
SELECT woonplaats, COUNT(*) AS Aantal 
FROM Leveranciers 
GROUP BY woonplaats 
HAVING COUNT(*) >= 2 
ORDER BY woonplaats ;



-- ------------------
/*
Geef een overzicht (naam, soortnaam en hoogte) van alle waterplanten, gesorteerd op hoogte.

    9 records
*/;
SELECT naam, soort, hoogte 
FROM planten JOIN soorten ON planten.soortID = soorten.soortID  
WHERE soort='water' 
ORDER BY hoogte  
/*
Geef een overzicht van de planten gesorteerd op soort en vervolgens op naam die noch boom, noch heester zijn en waarvan de hoogte tussen de 100 en de 200 cm, de kleur rood of blauw is en de bloeiperiode begint voor augustus.

    4 records
*/;
SELECT * 
FROM planten  
    JOIN kleuren ON kleuren.kleurid = planten.kleurid 
    JOIN soorten ON planten.soortid = soorten.soortid 
WHERE (NOT soort IN ('boom', 'heester')) 
AND (hoogte BETWEEN 100 AND 200) AND (kleur IN ('rood', 'blauw')) AND (bl_b < 8) 
ORDER BY  soort, naam 

/*Welke is de laagste prijs per plantensoort van de planten die de volledige periode van mei tot en met juni bloeien. De bloei mag beginnnen voor mei en eindigen na juni.

    5 records
*/;
SELECT soort, MIN(prijs) 
FROM planten JOIN soorten ON soorten.soortid = planten.soortid 
WHERE (bl_b<=5 AND bl_e>=6)  
GROUP BY soort 

/*Toon de verschillende plantsoorten waarvoor rode planten beschikbaar zijn.

    6 records
*/;
SELECT soort 
FROM soorten 
    JOIN planten ON soorten.soortID = planten.soortID 
    JOIN kleuren ON kleuren.kleurID = planten.kleurID 
WHERE kleur='rood' 
GROUP BY soort 
/*
Geef een overzicht per soort en per kleur van het aantal verschillende planten.

    49 records
*/;
SELECT soort, kleur, COUNT(*) 
FROM planten 
    JOIN kleuren ON kleuren.kleurid = planten.kleurid 
    JOIN soorten ON planten.soortid = soorten.soortid 
GROUP BY soort, kleur 

/*Opm: indien in resultaat ook aantal 0 bij soort/kleur combinaties waarbij er geen planten zijn ...

    130 records
*/;
SELECT soort, kleur, count(artCode) as 'aantal planten' 
FROM soorten s cross join kleuren k  
    LEFT JOIN planten p on p.kleurId = k.kleurId and p.soortID = s.soortID 
GROUP BY soort, kleur 
/*
Toon per leverancier (naam) het aantal artikelen die hij binnen de 18 dagen kan leveren.

    10 records
*/;
SELECT naam, COUNT(*) AS 'Aantal artikelen' 
FROM leveranciers L 
    JOIN offertes O ON O.levcode=L.levcode 
WHERE levertermijn <= 18 
GROUP BY naam 
/*
Geef per leverdatum in het formaat dd/mm/yyyy en per bestelbon de naam van de leverancier, het totaal aantal artikelen besteld, en de som van het aantal maal de prijs per besteld artikel.

    15 records
*/;
SELECT convert(leverdatum,char(10)), B.bestelnr, naam, SUM(aantal) AS 'totaal aantal', SUM(aantal*prijs) AS 'bedrag' 
FROM bestellingen B  
    JOIN leveranciers L ON B.levCode = L.levcode 
    JOIN bestellijnen BL ON B.bestelnr = BL.bestelnr 
GROUP BY leverdatum, B.bestelnr, naam 
/*
    Eigenlijke oplossing via DATE_FORMAT:

    15 records
*/;
SELECT DATE_FORMAT(leverdatum, '%d/%m/%Y'), B.bestelnr, naam, SUM(aantal) AS 'totaal aantal', SUM(aantal*prijs) AS 'bedrag' 
FROM bestellingen B  
    JOIN leveranciers L ON B.levCode = L.levcode 
    JOIN bestellijnen BL ON B.bestelnr = BL.bestelnr 
GROUP BY leverdatum, B.bestelnr, naam 
/*
Selecteer de verschillende woonplaatsen van de leveranciers die een offerte gemaakt hebben voor 'vaste' planten.

    2 records
*/;
SELECT DISTINCT woonplaats 
FROM planten P  
    JOIN offertes O ON P.artCode = O.artCode 
    JOIN leveranciers L ON L.levCode = O.levCode 
    JOIN soorten S ON P.soortID = S.soortID 
WHERE soort = 'vast' 
/*
Geef per artikelcode de naam van de plant, laagste offerteprijs, de hoogste offerteprijs. Sorteer op plantnaam.

    119 records
*/;
SELECT P.artCode, naam, MIN(offerteprijs) AS 'min prijs', MAX(offerteprijs) AS 'max prijs' 
FROM planten P 
    JOIN offertes O ON P.artCode = O.artCode 
GROUP BY P.artCode, naam 
ORDER BY  naam 
/*
Geef een overzicht van alle bestellingen : bestelnr, leverdatum in het formaat dd/mm/yyyy, bedrag. Voeg een laatste kolom 'opmerking' toe. Indien de besteldatum > 5 maart 2003 dan moet in de laatste kolom de opmerking 'te laat' komen, anders komt in de laatste kolom geen opmerking.

    15 records

    met Union:
*/;
SELECT bestelnr, DATE_FORMAT(leverdatum, '%d/%m/%Y'), bedrag, DATE_FORMAT(besteldatum, '%d/%m/%Y'), 'te laat' AS opmerking 
FROM bestellingen 
WHERE besteldatum > '2003-03-05' 

;
SELECT bestelnr, DATE_FORMAT(leverdatum, '%d/%m/%Y'), bedrag, DATE_FORMAT(besteldatum, '%d/%m/%Y'), '  ' AS opmerking 
FROM bestellingen 
WHERE besteldatum <= '2003-03-05' 
ORDER BY bestelnr 
/*
    met case:

    15 records
*/;
SELECT bestelnr, DATE_FORMAT(leverdatum, '%d/%m/%Y'), DATE_FORMAT(besteldatum, '%d/%m/%Y'), bedrag,  
case when besteldatum > '2003-03-05' then 'te laat'  
Else '  ' 
End AS opmerking 
From bestellingen 
/*
Geef per leverancier het aantal verschillende soorten planten waarvoor hij een offerte heeft gemaakt. Sorteer op dalende volgorde van aantal.

    11 records
*/;
SELECT L.naam, COUNT(DISTINCT soortid) as aantal 
FROM leveranciers L  
    JOIN offertes O ON L.levCode = O.levCode 
    JOIN  planten P ON O.artCode = P.artcode 
GROUP BY L.naam 
ORDER BY aantal DESC 
/*
    Indien aantal 0 ook in resultaat moet komen:

    11 records
*/;
SELECT l.naam, count(distinct s.soortId) as 'aantal verschillende soorten planten' 
FROM leveranciers l left join offertes o on l.levCode = o.levCode  
LEFT JOIN planten p on o.artCode = p.artCode 
LEFT JOIN soorten s on s.soortId = p.soortId 
GROUP BY l.naam 
ORDER BY count(distinct s.soortId) DESC 
/*
Geef per leverancier de verschillende soorten planten waarvoor hij een offerte heeft ingediend.

    37 records
*/;
SELECT DISTINCT L.naam, soort 
FROM leveranciers L  
    JOIN offertes O ON L.levCode = O.levcOde 
    JOIN planten P ON O.artCode = P.artcode 
    JOIN soorten S ON S.soortID = P.soortID 
/*
Toon een lijst van alle vaste planten, gevolgd door de namen van de vaste planten die later op het jaar beginnen te bloeien. Toon de vaste planten die eerst beginnen bloeien bovenaan.

    299 records
*/;
SELECT p1.naam, p1.bl_b, p2.naam, P2.bl_b 
FROM planten p1 
    JOIN soorten ON p1.soortid = soorten.soortid 
    JOIN planten p2 ON p1.bl_b < p2.bl_b and p2.soortid = p1.soortid -- Planten uit p2 moeten later bloeien & ook van de vaste soort zijn.
WHERE soorten.soort='vast' 
ORDER BY p1.bl_b 
/*
Alternatieve, kortere oplossing (met een extra JOIN-conditie):
*/;
SELECT p1.naam, p1.bl_b, p2.naam, p2.bl_b 
FROM planten p1 JOIN planten p2 ON p1.bl_b < p2.bl_b 
    
    JOIN soorten S2 ON p2.soortid = S2.soortid 
WHERE S1.soort='vast' AND S2.soort='vast' 
ORDER BY p1.bl_b 
;/*
Hoeveel verschillen de gehanteerde bestelprijzen met de huidige offerteprijzen bij dezelfde leverancier. Toon telkens bestelnummer, artikelcode en het positieve of negatieve verschil.

    92 records
*/
SELECT b.bestelnr, o.artcodeLev, (prijs - offerteprijs) AS verschil 
FROM offertes 
    JOIN leveranciers l ON b.levcode = o.levcode
    JOIN bestellingen b ON l.levcode = b.levcode 
    JOIN bestellijnen bl ON bl.bestelnr = b.bestelnr
    WHERE bl.artcodeLev = o.artcodeLev;
;/*
Toon een lijst met bestelnummers, leverancierscode en besteldatum en zorg ervoor dat de de lijst ook de leveranciers bevat waarvoor nog geen bestelling geplaatst werd.

    17 records
*/
SELECT bestelnr, b.levcode, naam, besteldatum 
FROM leveranciers L 
    LEFT JOIN bestellingen B  ON L.levcode = B.levcode 

;
-- -------------------------

-- Voeg als kleuren appelblauwzeegroen en zwart toe.

INSERT INTO kleuren(kleur) VALUES('appelblauwzeegroen') ;
INSERT INTO kleuren(kleur) VALUES ('zwart') 
;
-- Voeg als soorten 'vet' en 'naald' toe

INSERT INTO soorten(soort) VALUES('vet') ;
INSERT INTO soorten(soort) VALUES('naald') ;
-- OF:
INSERT INTO soorten(soort) VALUES('vet'),('naald') 
;
-- Voeg een spar toe aan de tabel planten. (artcode : 163, hoogte 3000, prijs : 12.5, soortID : 2, andere gegevens onbekend)

INSERT INTO planten(artcode, naam,hoogte,prijs, soortID) VALUES(163,'spar',3000,12.5,2) -- (in values mag je geen selects gebruiken) 
;
-- Voeg een sierui toe aan de tabel planten (artcode : 165, hoogte : 75, bl_e :8; bl_b : 6,prijs :3 , soort : bol, kleur : blauw)

INSERT INTO planten(artcode, naam,hoogte,prijs, bl_b, bl_e, soortID, kleurID)  VALUES(165,'sierui',75,3,6,8, 1,2) 
;
-- erhoog de prijs van alle planten met 5 procent

UPDATE planten SET prijs = prijs * 1.05  ;

-- Verwijder kleur blauw. Werkt dit?

DELETE FROM kleuren WHERE kleur = 'blauw' ;

-- Voeg als soort bloem toe.

INSERT INTO soorten(soort) VALUES('bloem') 
;
/*
    Pas de tabel planten aan. Vervang de soort van alle planten die de Soort bol hebben naar de soort bloem.

    Opzoeken van de SoortID van bol, hierdoor weet je de SoortID van de soort bol:
*/
    SELECT soortID FROM soorten WHERE soort='bol';

-- Opzoeken van de SoortID van bloem, hierdoor weet je de SoortID van de soortbloem:

SELECT soortID FROM soorten WHERE soort='bloem'
;
-- Effectieve aanpassing, laten we stellen dat de soortID van bloem = 1 en bol = 3

UPDATE planten 
SET soortID = 1 
WHERE soortID = 3
/*
    Alternatief:

    Het is mogelijk via subqueries, maar dit is leerstof voor Databanken II:
*/;
UPDATE planten 
SET soortID=(select soortid from soorten where soort='bloem')  
    WHERE soortID=(select soortid from soorten WHERE soort='bol') 

;-- Verwijder alle planten

delete from planten
;


-- DB maken



