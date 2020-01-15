DROP PROCEDURE IF EXISTS wyswietlCzas;
delimiter $$
create procedure wyswietlCzas(in idpracownika int,in terminpod date)
procedura: begin
DECLARE rozpoczecie,zakonczenie time;
SET @@lc_time_names = 'pl_PL';
SET rozpoczecie = (SELECT rozpoczecie FROM grafik WHERE id_pracownika=idpracownika AND dzien=(SELECT DAYNAME(terminpod) dayname));
SET zakonczenie = (SELECT zakonczenie FROM grafik WHERE id_pracownika=idpracownika AND dzien=(SELECT DAYNAME(terminpod) dayname));
SET @zajete := (SELECT TIME(termin) FROM wizyty WHERE termin=terminpod AND TIME(termin) BETWEEN rozpoczecie AND zakonczenie);
WITH RECURSIVE cte (t) AS
(
	SELECT rozpoczecie 
	UNION 
	SELECT ADDTIME(t,"20:00") FROM cte WHERE rozpoczecie <= zakonczenie
)
SELECT * FROM cte WHERE t NOT IN (@zajete);
SET @@lc_time_names = 'en_US';
end $$
delimiter ;