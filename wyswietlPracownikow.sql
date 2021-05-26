DELIMITER $$
CREATE procedure wyswietlPracownikow(IN podnazwa varchar(30))
begin 
case (select zawod from uslugi where nazwa=podnazwa)
when  'technik' then SELECT id,imie,nazwisko FROM pracownicy;
when 'weterynarz' then select id,imie,nazwisko FROM pracownicy where zawod='weterynarz';
end case;
end $$
DELIMITER ;