-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2019-12-20 21:41:21.672

-- tables
-- Table: grafik
CREATE TABLE grafik (
    id_pracownika int NOT NULL,
    dzieñ enum('poniedzia³ek','wtorek','œroda','czwartek','pi¹tek') NOT NULL,
    rozpoczêcie time NOT NULL,
    zakoñczenie time NOT NULL
) COMMENT 'przechowuje godziny pracy pracowników';


-- Table: klienci
CREATE TABLE klienci (
    id int NOT NULL AUTO_INCREMENT,
    imiê varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    CONSTRAINT klienci_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane klientów w klinice';

-- Table: pracownicy
CREATE TABLE pracownicy (
    id int NOT NULL AUTO_INCREMENT,
    imiê varchar(30) NOT NULL,
    nazwisko varchar(30) NOT NULL,
    numer_tel int NOT NULL,
    data_urodzenia date NOT NULL,
    pensja int NOT NULL CHECK (pensja>=0),
    zawód enum('weterynarz','technik') NOT NULL,
    CONSTRAINT pracownicy_pk PRIMARY KEY (id)
) COMMENT 'przechowuje dane pracowników pracuj¹cych w klinice';

-- Table: szczepienia
CREATE TABLE szczepienia (
    id_zwierzêcia int NOT NULL,
    choroba int NOT NULL,
    czy_w_tej_klinice bool NOT NULL
);

-- Table: us³ugi
CREATE TABLE us³ugi (
    nazwa varchar(30) NOT NULL,
    cena int NOT NULL CHECK (cena>=0),
    zawód enum('weterynarz','technik') NOT NULL COMMENT 'kto mo¿e wykonaæ dan¹ us³ugê',
    CONSTRAINT us³ugi_pk PRIMARY KEY (nazwa)
) COMMENT 'przechowuje mo¿liwe do wykonania us³ugi w klinice';

-- Table: u¿ytkownicy
CREATE TABLE u¿ytkownicy (
    login varchar(30) NOT NULL,
    has³o varchar(32) NOT NULL,
    uprawnienia enum('klient','technik','weterynarz','dyrektor','admin') NOT NULL COMMENT 'stopieñ dostêpu do bazy danych',
    id int NULL COMMENT 'id pracownika lub klienta',
    CONSTRAINT u¿ytkownicy_pk PRIMARY KEY (login)
) COMMENT 'przechowuje dane niezbêdne do logowania';

-- Table: wizyty
CREATE TABLE wizyty (
    id_pracownika int NOT NULL,
    id_zwierzêcia int NOT NULL,
    termin timestamp NOT NULL CHECK (TIME(termin) BETWEEN '7:00' AND '17:00'),
    cel_wizyty varchar(30) NOT NULL,
    op³ata int NOT NULL CHECK (op³ata>=0)
) COMMENT 'tabela przechowuj¹ca odbyte oraz zaplanowane wizyty';

-- Table: zwierzêta
CREATE TABLE zwierzêta (
    id_zwierzêcia int NOT NULL AUTO_INCREMENT,
    id_klienta int NOT NULL,
    imiê varchar(30) NOT NULL,
    data_urodzenia date NOT NULL,
    gatunek varchar(30) NOT NULL,
    waga int NOT NULL,
    p³eæ enum('f','m') NOT NULL,
    kastrowane bool NOT NULL,
    kraj_pochodzenia varchar(30) NOT NULL,
    CONSTRAINT zwierzêta_pk PRIMARY KEY (id_zwierzêcia)
) COMMENT 'tabela ³¹cz¹ca zwierzêta z klientami kliniki';

-- foreign keys
-- Reference: grafik_pracownicy (table: grafik)
ALTER TABLE grafik ADD CONSTRAINT grafik_pracownicy FOREIGN KEY grafik_pracownicy (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: pracownik_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT pracownik_wizyta FOREIGN KEY pracownik_wizyta (id_pracownika)
    REFERENCES pracownicy (id);

-- Reference: wizyta_us³uga (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT wizyta_us³uga FOREIGN KEY wizyta_us³uga (cel_wizyty)
    REFERENCES us³ugi (nazwa);

-- Reference: zwierzê_klienci (table: zwierzêta)
ALTER TABLE zwierzêta ADD CONSTRAINT zwierzê_klienci FOREIGN KEY zwierzê_klienci (id_klienta)
    REFERENCES klienci (id);

-- Reference: zwierzê_wizyta (table: wizyty)
ALTER TABLE wizyty ADD CONSTRAINT zwierzê_wizyta FOREIGN KEY zwierzê_wizyta (id_zwierzêcia)
    REFERENCES zwierzêta (id_zwierzêcia);

-- Reference: zwierzêta_szczepienia (table: szczepienia)
ALTER TABLE szczepienia ADD CONSTRAINT zwierzêta_szczepienia FOREIGN KEY zwierzêta_szczepienia (id_zwierzêcia)
    REFERENCES zwierzêta (id_zwierzêcia);

-- End of file.

