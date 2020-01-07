DELIMITER $$
CREATE procedure wyswietlPracownikow(IN podnazwa varchar(30))
begin 
case (select zawód from usługi where nazwa=podnazwa)
when  'technik' then SELECT id,imię,nazwisko FROM pracownicy;
when 'weterynarz' then select id,imię,nazwisko FROM pracownicy where zawód='weterynarz';
end case;
end $$
DELIMITER ;