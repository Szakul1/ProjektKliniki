DROP PROCEDURE IF EXISTS wyswietlCzas;
delimiter $$
create procedure wyswietlCzas(in idpracownika int,in terminpod date)
procedura: begin
DECLARE rozpoczecievar,zakonczenievar time;
DECLARE dziennazwa varchar(20);
SET @@lc_time_names = 'pl_PL';
SET dziennazwa = (SELECT DAYNAME(terminpod));
SET dziennazwa = REPLACE(dziennazwa, 'ą', 'a');
SET dziennazwa = REPLACE(dziennazwa, 'ł', 'l');
SET dziennazwa = REPLACE(dziennazwa, 'ś', 's');
SET rozpoczecievar = (SELECT rozpoczecie FROM grafik WHERE id_pracownika=idpracownika AND dzien=dziennazwa);
SET zakonczenievar = (SELECT zakonczenie FROM grafik WHERE id_pracownika=idpracownika AND dzien=dziennazwa);
WITH RECURSIVE cte (t) AS
(
	SELECT rozpoczecievar 
	UNION 
	SELECT ADDTIME(t,"00:20:00") FROM cte WHERE ADDTIME(t,"00:20:00") <= zakonczenievar
)
SELECT * FROM cte WHERE t NOT IN (SELECT TIME(termin) FROM wizyty WHERE DAY(termin)=terminpod AND TIME(termin) BETWEEN rozpoczecievar AND zakonczenievar);
SET @@lc_time_names = 'en_US';
end $$
delimiter ;