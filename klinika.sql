-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-12-20 21:41:21.672

-- tables
-- Table: grafik
CREATE TABLE grafik (
    id_pracownika int NOT NULL,
    dzień enum('poniedzialek','wtorek','sroda','czwartek','piatek') NOT NULL,
    rozpoczęcie time NOT NULL,
    zakończenie time NOT NULL
) COMMENT 'przechowuje godziny pracy pracownikow';


-- Table: klienci
CREATE TABLE klienci (
    id int NOT NULL AUTO_INCREMENT,
    imie varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    CONSTRAINT klienci_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane klientow w klinice';

-- Table: pracownicy
CREATE TABLE pracownicy (
    id int NOT NULL AUTO_INCREMENT,
    imie varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    data_urodzenia date NOT NULL,
    pensja int NOT NULL CHECK (pensja>=0),
    zawod enum('weterynarz','technik') NOT NULL,
    CONSTRAINT pracownicy_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane pracowników pracujących w klinice';

-- Table: szczepienia
CREATE TABLE szczepienia (
    id_zwierzecia int NOT NULL,
    choroba int NOT NULL,
    czy_w_tej_klinice bool NOT NULL
);

-- Table: uslugi
CREATE TABLE uslugi (
    nazwa varchar(30) NOT NULL,
    cena int NOT NULL CHECK (cena>=0),
    zawod enum('weterynarz','technik') NOT NULL COMMENT 'kto może wykonać daną usługę',
    CONSTRAINT uslugi_pk PRIMARY KEY (nazwa)
) COMMENT 'przechowuje możliwe do wykonania usługi w klinice';

-- Table: użytkownicy
CREATE TABLE uzytkownicy (
    login varchar(30) NOT NULL,
    haslo varchar(32) NOT NULL,
    uprawnienia enum('klient','technik','weterynarz','dyrektor','admin') NOT NULL COMMENT 'stopień dostępu do bazy danych',
    id int NULL COMMENT 'id pracownika lub klienta',
    CONSTRAINT uzytkownicy_pk PRIMARY KEY (login)
) COMMENT 'przechowuje dane niezbędne do logowania';

-- Table: wizyty
CREATE TABLE wizyty (
    id_pracownika int NOT NULL,
    id_zwierzecia int NOT NULL,
    termin timestamp NOT NULL CHECK (TIME(termin) BETWEEN '7:00' AND '17:00'),
    cel_wizyty varchar(30) NOT NULL,
    oplata int NOT NULL CHECK (oplata>=0)
) COMMENT 'tabela przechowująca odbyte oraz zaplanowane wizyty';

-- Table: zwierzeta
CREATE TABLE zwierzeta (
    id_zwierzecia int NOT NULL AUTO_INCREMENT,
    id_klienta int NOT NULL,
    imie varchar(30) NOT NULL,
    data_urodzenia date NOT NULL,
    gatunek varchar(30) NOT NULL,
    waga int NOT NULL,
    plec enum('f','m') NOT NULL,
    kastrowane bool NOT NULL,
    kraj_pochodzenia varchar(30) NOT NULL,
    CONSTRAINT zwierzeta_pk PRIMARY KEY (id_zwierzecia)
) COMMENT 'tabela łącząca zwierzęta z klientami kliniki';

-- foreign keys
-- Reference: grafik_pracownicy (table: grafik)
ALTER TABLE grafik ADD CONSTRAINT grafik_pracownicy FOREIGN KEY grafik_pracownicy (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: pracownik_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT pracownik_wizyta FOREIGN KEY pracownik_wizyta (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: wizyta_usługa (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT wizyta_usluga FOREIGN KEY wizyta_usluga (cel_wizyty)
    REFERENCES uslugi (nazwa);

-- Reference: zwierzę_klienci (table: zwierzęta)
ALTER TABLE zwierzeta ADD CONSTRAINT zwierze_klienci FOREIGN KEY zwierze_klienci (id_klienta)
    REFERENCES klienci (id);

-- Reference: zwierzę_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT zwierze_wizyta FOREIGN KEY zwierze_wizyta (id_zwierzecia)
    REFERENCES zwierzeta (id_zwierzecia);

-- Reference: zwierzęta_szczepienia (table: szczepienia)
ALTER TABLE szczepienia ADD CONSTRAINT zwierzeta_szczepienia FOREIGN KEY zwierzeta_szczepienia (id_zwierzecia)
    REFERENCES zwierzeta (id_zwierzecia);

-- End of file.

