-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-12-20 21:41:21.672

-- tables
-- Table: domowe
CREATE TABLE domowe (
    id int NOT NULL,
    imię varchar(30) NOT NULL,
    data_urodzenia date NOT NULL,
    gatunek varchar(30) NOT NULL,
    waga int NOT NULL,
    płeć enum('f','m') NOT NULL,
    kastrowane bool NOT NULL,
    CONSTRAINT domowe_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane zwierząt domowych';

-- Table: egzotyczne
CREATE TABLE egzotyczne (
    id int NOT NULL,
    imię varchar(30) NOT NULL,
    data_urodzenia date NOT NULL,
    gatunek varchar(30) NOT NULL,
    waga int NOT NULL,
    płeć enum('f','m') NOT NULL,
    kraj_pochodzenia varchar(30) NOT NULL,
    CONSTRAINT egzotyczne_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane zwierząt  egzotycznych';

-- Table: grafik
CREATE TABLE grafik (
    id_pracownika int NOT NULL,
    dzień enum('poniedziałek','wtorek','środa','czwartek','piątek') NOT NULL,
    rozpoczęcie time NOT NULL,
    zakończenie time NOT NULL
) COMMENT 'przechowuje godziny pracy pracowników';

-- Table: hodowlane
CREATE TABLE hodowlane (
    id int NOT NULL,
    imię varchar(30) NOT NULL,
    data_urodzenia date NOT NULL,
    gatunek varchar(30) NOT NULL,
    waga int NOT NULL,
    płeć enum('f','m') NOT NULL,
    przeznaczenie varchar(30) NOT NULL,
    CONSTRAINT hodowlane_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane zwierząt hodowlanych';

-- Table: klienci
CREATE TABLE klienci (
    id int NOT NULL AUTO_INCREMENT,
    imię varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    `zniżka%` int NOT NULL COMMENT 'zniżka na usługi w procentach' CHECK (`zniżka%` BETWEEN 0 AND 100),
    CONSTRAINT klienci_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane klientów w klinice';

-- Table: pracownicy
CREATE TABLE pracownicy (
    id int NOT NULL AUTO_INCREMENT,
    imię varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    data_urodzenia date NOT NULL,
    pensja int NOT NULL CHECK (pensja>=0),
    zawód enum('weterynarz','technik') NOT NULL,
    CONSTRAINT pracownicy_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane pracowników pracujących w klinice';

-- Table: szczepienia
CREATE TABLE szczepienia (
    id_zwierzęcia int NOT NULL,
    choroba int NOT NULL,
    czy_w_tej_klinice bool NOT NULL
);

-- Table: usługi
CREATE TABLE usługi (
    nazwa varchar(30) NOT NULL,
    cena int NOT NULL CHECK (cena>=0),
    zawód enum('weterynarz','technik') NOT NULL COMMENT 'kto może wykonać daną usługę',
    CONSTRAINT usługi_pk PRIMARY KEY (nazwa)
) COMMENT 'przechowuje możliwe do wykonania usługi w klinice';

-- Table: użytkownicy
CREATE TABLE użytkownicy (
    login varchar(30) NOT NULL,
    hasło varchar(32) NOT NULL,
    uprawnienia enum('klient','technik','weterynarz','dyrektor','admin') NOT NULL COMMENT 'stopień dostępu do bazy danych',
    id int NULL COMMENT 'id pracownika lub klienta',
    CONSTRAINT użytkownicy_pk PRIMARY KEY (login)
) COMMENT 'przechowuje dane niezbędne do logowania';

-- Table: wizyty
CREATE TABLE wizyty (
    id_pracownika int NOT NULL,
    id_zwierzęcia int NOT NULL,
    termin timestamp NOT NULL CHECK (TIME(termin) BETWEEN '7:00' AND '17:00'),
    cel_wizyty varchar(30) NOT NULL,
    opłata int NOT NULL CHECK (opłata>=0)
) COMMENT 'tabela przechowująca odbyte oraz zaplanowane wizyty';

-- Table: zwierzęta
CREATE TABLE zwierzęta (
    id_zwierzęcia int NOT NULL AUTO_INCREMENT,
    id_klienta int NOT NULL,
    rodzaj enum('domowe','hodowlane','egzotyczne') NOT NULL,
    CONSTRAINT zwierzęta_pk PRIMARY KEY (id_zwierzęcia,id_klienta,rodzaj)
) COMMENT 'tabela łącząca zwierzęta z klientami kliniki';

-- foreign keys
-- Reference: grafik_pracownicy (table: grafik)
ALTER TABLE grafik ADD CONSTRAINT grafik_pracownicy FOREIGN KEY grafik_pracownicy (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: pracownik_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT pracownik_wizyta FOREIGN KEY pracownik_wizyta (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: wizyta_usługa (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT wizyta_usługa FOREIGN KEY wizyta_usługa (cel_wizyty)
    REFERENCES usługi (nazwa);

-- Reference: zwierzę_klienci (table: zwierzęta)
ALTER TABLE zwierzęta ADD CONSTRAINT zwierzę_klienci FOREIGN KEY zwierzę_klienci (id_klienta)
    REFERENCES klienci (id);
    
-- Reference: zwierzę_domowe (table: zwierzęta)
ALTER TABLE zwierzęta ADD CONSTRAINT zwierzę_domowe FOREIGN KEY zwierzę_domowe (id_zwierzęcia)
    REFERENCES domowe (id);
    
-- Reference: zwierzę_klienci (table: zwierzęta)
ALTER TABLE zwierzęta ADD CONSTRAINT zwierzę_egzotyczne FOREIGN KEY zwierzę_egzotyczne (id_zwierzęcia)
    REFERENCES egzotyczne (id);
    
-- Reference: zwierzę_klienci (table: zwierzęta)
ALTER TABLE zwierzęta ADD CONSTRAINT zwierzę_hodowlane FOREIGN KEY zwierzę_hodowlane (id_zwierzęcia)
    REFERENCES hodowlane (id);

-- Reference: zwierzę_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT zwierzę_wizyta FOREIGN KEY zwierzę_wizyta (id_zwierzęcia)
    REFERENCES zwierzęta (id_zwierzęcia);

-- Reference: zwierzęta_szczepienia (table: szczepienia)
ALTER TABLE szczepienia ADD CONSTRAINT zwierzęta_szczepienia FOREIGN KEY zwierzęta_szczepienia (id_zwierzęcia)
    REFERENCES zwierzęta (id_zwierzęcia);

-- End of file.

