-- Voeg als kleuren appelblauwzeegroen en zwart toe.

INSERT INTO kleuren (kleur)
VALUES ("appelblauwzeegroen"), ("zwart")
;

-- Voeg als soorten vet en naald toe.
insert into soorten (soort)
values ("vet"), ("naald");

-- Voeg een spar toe aan de tabel planten. 
-- (artcode: 163, hoogte 3000, prijs : 12.5, soortID : 2, andere gegevens onbekend)
insert into planten (artCode, naam, hoogte, prijs, soortID)
values ("163", "spar", 3000, 12.5, 2)
;

-- Verhoog de prijs van alle planten met 5 procent.
update planten 
set prijs = prijs * 1.05;


-- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.

-- Voeg een sierui toe aan de tabel planten 
-- (artcode: 165, hoogte: 75, bl_e :8; bl_b: 6, prijs:3, soort : bol, kleur : blauw)
insert into planten 
values (165, "sierui", 3, 1, 75, 6, 8, 3);
