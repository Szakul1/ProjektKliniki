-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-12-20 21:41:21.672

-- tables
-- Table: grafik
CREATE TABLE grafik (
    id_pracownika int NOT NULL,
    dzie� enum('poniedzia�ek','wtorek','�roda','czwartek','pi�tek') NOT NULL,
    rozpocz�cie time NOT NULL,
    zako�czenie time NOT NULL
) COMMENT 'przechowuje godziny pracy pracownik�w';


-- Table: klienci
CREATE TABLE klienci (
    id int NOT NULL AUTO_INCREMENT,
    imi� varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    CONSTRAINT klienci_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane klient�w w klinice';

-- Table: pracownicy
CREATE TABLE pracownicy (
    id int NOT NULL AUTO_INCREMENT,
    imi� varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    data_urodzenia date NOT NULL,
    pensja int NOT NULL CHECK (pensja>=0),
    zaw�d enum('weterynarz','technik') NOT NULL,
    CONSTRAINT pracownicy_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane pracownik�w pracuj�cych w klinice';

-- Table: szczepienia
CREATE TABLE szczepienia (
    id_zwierz�cia int NOT NULL,
    choroba int NOT NULL,
    czy_w_tej_klinice bool NOT NULL
);

-- Table: us�ugi
CREATE TABLE us�ugi (
    nazwa varchar(30) NOT NULL,
    cena int NOT NULL CHECK (cena>=0),
    zaw�d enum('weterynarz','technik') NOT NULL COMMENT 'kto mo�e wykona� dan� us�ug�',
    CONSTRAINT us�ugi_pk PRIMARY KEY (nazwa)
) COMMENT 'przechowuje mo�liwe do wykonania us�ugi w klinice';

-- Table: u�ytkownicy
CREATE TABLE u�ytkownicy (
    login varchar(30) NOT NULL,
    has�o varchar(32) NOT NULL,
    uprawnienia enum('klient','technik','weterynarz','dyrektor','admin') NOT NULL COMMENT 'stopie� dost�pu do bazy danych',
    id int NULL COMMENT 'id pracownika lub klienta',
    CONSTRAINT u�ytkownicy_pk PRIMARY KEY (login)
) COMMENT 'przechowuje dane niezb�dne do logowania';

-- Table: wizyty
CREATE TABLE wizyty (
    id_pracownika int NOT NULL,
    id_zwierz�cia int NOT NULL,
    termin timestamp NOT NULL CHECK (TIME(termin) BETWEEN '7:00' AND '17:00'),
    cel_wizyty varchar(30) NOT NULL,
    op�ata int NOT NULL CHECK (op�ata>=0)
) COMMENT 'tabela przechowuj�ca odbyte oraz zaplanowane wizyty';

-- Table: zwierz�ta
CREATE TABLE zwierz�ta (
    id_zwierz�cia int NOT NULL AUTO_INCREMENT,
    id_klienta int NOT NULL,
    imi� varchar(30) NOT NULL,
    data_urodzenia date NOT NULL,
    gatunek varchar(30) NOT NULL,
    waga int NOT NULL,
    p�e� enum('f','m') NOT NULL,
    kastrowane bool NOT NULL,
    kraj_pochodzenia varchar(30) NOT NULL,
    CONSTRAINT zwierz�ta_pk PRIMARY KEY (id_zwierz�cia)
) COMMENT 'tabela ��cz�ca zwierz�ta z klientami kliniki';

-- foreign keys
-- Reference: grafik_pracownicy (table: grafik)
ALTER TABLE grafik ADD CONSTRAINT grafik_pracownicy FOREIGN KEY grafik_pracownicy (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: pracownik_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT pracownik_wizyta FOREIGN KEY pracownik_wizyta (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: wizyta_us�uga (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT wizyta_us�uga FOREIGN KEY wizyta_us�uga (cel_wizyty)
    REFERENCES us�ugi (nazwa);

-- Reference: zwierz�_klienci (table: zwierz�ta)
ALTER TABLE zwierz�ta ADD CONSTRAINT zwierz�_klienci FOREIGN KEY zwierz�_klienci (id_klienta)
    REFERENCES klienci (id);

-- Reference: zwierz�_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT zwierz�_wizyta FOREIGN KEY zwierz�_wizyta (id_zwierz�cia)
    REFERENCES zwierz�ta (id_zwierz�cia);

-- Reference: zwierz�ta_szczepienia (table: szczepienia)
ALTER TABLE szczepienia ADD CONSTRAINT zwierz�ta_szczepienia FOREIGN KEY zwierz�ta_szczepienia (id_zwierz�cia)
    REFERENCES zwierz�ta (id_zwierz�cia);

-- End of file.

