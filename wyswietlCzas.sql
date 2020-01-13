DROP PROCEDURE IF EXISTS wyswietlCzas;
delimiter $$
create procedure wyswietlCzas(in idpracownika int,in terminpod date)
procedura: begin
DECLARE rozpoczecie,zakonczenie time;
SET @@lc_time_names = 'pl_PL';
SET rozpoczecie = (SELECT rozpoczecie FROM grafik WHERE id_pracownika=idpracownika AND dzien=(SELECT DAYNAME(terminpod) dayname));
SET zakonczenie = (SELECT zakonczenie FROM grafik WHERE id_pracownika=idpracownika AND dzien=(SELECT DAYNAME(terminpod) dayname));
WHILE rozpoczecie < zakonczenie DO
	IF NOT EXISTS (SELECT termin FROM wizyty WHERE DAY(termin)=DAY(terminpod) AND TIME(termin) = rozpoczecie) THEN
		SELECT rozpoczecie;
        SET @@lc_time_names = 'en_US';
        LEAVE procedura;
    END IF;
    SET rozpoczecie = ADDTIME(rozpoczecie,"20:00");
END WHILE;
SET @@lc_time_names = 'en_US';
end $$
delimiter ;