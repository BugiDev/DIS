CREATE DATABASE DISbaza DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

Use DISbaza;

create table Vrata
(
    VRATA_ID         bigint not null auto_increment,
    VRATA_NAZIV       varchar(50) not null,
    VRATA_PROIZVODJAC       varchar(50) not null,
    VRATA_DIMENZIJE       varchar(50) not null,
    VRATA_TIP       varchar(50) not null,
    VRATA_MATERIJAL         varchar(50) not null,
    VRATA_OPIS           varchar(300) not null,
    VRATA_CENA           varchar(50) not null,
    VRATA_ACTIVE           varchar(50) not null,
    primary key (VRATA_ID)
);

create table Prozori
(
    PROZORI_ID         bigint not null auto_increment,
    PROZORI_NAZIV       varchar(50) not null,
    PROZORI_PROIZVODJAC       varchar(50) not null,
    PROZORI_DIMENZIJE       varchar(50) not null,
    PROZORI_TIP       varchar(50) not null,
    PROZORI_MATERIJAL         varchar(50) not null,
    PROZORI_OPIS           varchar(300) not null,
    PROZORI_CENA           varchar(50) not null,
    PROZORI_ACTIVE           varchar(50) not null,
    primary key (PROZORI_ID)
);

create table Bpod
(
    BPOD_ID         bigint not null auto_increment,
    BPOD_NAZIV       varchar(50) not null,
    BPOD_PROIZVODJAC       varchar(50) not null,
    BPOD_DIMENZIJE       varchar(50) not null,
    BPOD_TIP       varchar(50) not null,
    BPOD_MATERIJAL         varchar(50) not null,
    BPOD_OPIS           varchar(300) not null,
    BPOD_CENA           varchar(50) not null,
    BPOD_ACTIVE           varchar(50) not null,
    primary key (BPOD_ID)
);

create table Lamperija
(
    LAMPERIJA_ID         bigint not null auto_increment,
    LAMPERIJA_NAZIV       varchar(50) not null,
    LAMPERIJA_PROIZVODJAC       varchar(50) not null,
    LAMPERIJA_DIMENZIJE       varchar(50) not null,
    LAMPERIJA_TIP       varchar(50) not null,
    LAMPERIJA_MATERIJAL         varchar(50) not null,
    LAMPERIJA_OPIS           varchar(300) not null,
    LAMPERIJA_CENA           varchar(50) not null,
    LAMPERIJA_ACTIVE           varchar(50) not null,
    primary key (LAMPERIJA_ID)
);

create table Laminat
(
    LAMINAT_ID         bigint not null auto_increment,
    LAMINAT_NAZIV       varchar(50) not null,
    LAMINAT_PROIZVODJAC       varchar(50) not null,
    LAMINAT_DIMENZIJE       varchar(50) not null,
    LAMINAT_TIP       varchar(50) not null,
    LAMINAT_MATERIJAL         varchar(50) not null,
    LAMINAT_OPIS           varchar(300) not null,
    LAMINAT_CENA           varchar(50) not null,
    LAMINAT_ACTIVE           varchar(50) not null,
    primary key (LAMINAT_ID)
);

create table OstalaDG
(
    OSTALADG_ID         bigint not null auto_increment,
    OSTALADG_NAZIV       varchar(50) not null,
    OSTALADG_PROIZVODJAC       varchar(50) not null,
    OSTALADG_DIMENZIJE       varchar(50) not null,
    OSTALADG_TIP       varchar(50) not null,
    OSTALADG_VRSTA       varchar(50) not null,
    OSTALADG_MATERIJAL         varchar(50) not null,
    OSTALADG_OPIS           varchar(300) not null,
    OSTALADG_CENA           varchar(50) not null,
    OSTALADG_ACTIVE           varchar(50) not null,
    primary key (OSTALADG_ID)
);

create table DodatniMAT
(
    DODATNIMAT_ID         bigint not null auto_increment,
    DODATNIMAT_NAZIV       varchar(50) not null,
    DODATNIMAT_PROIZVODJAC       varchar(50) not null,
    DODATNIMAT_DIMENZIJE       varchar(50) not null,
    DODATNIMAT_TIP       varchar(50) not null,
    DODATNIMAT_NAMENA       varchar(200) not null,
    DODATNIMAT_MATERIJAL         varchar(50) not null,
    DODATNIMAT_OPIS           varchar(300) not null,
    DODATNIMAT_CENA           varchar(50) not null,
    DODATNIMAT_ACTIVE           varchar(50) not null,
    primary key (DODATNIMAT_ID)
);

create table Korisnik
(
    KORISNIK_ID         bigint not null auto_increment,
    KORISNIK_IME        varchar(25) not null,
    KORISNIK_PASS       varchar(25) not null,
    KORISNIK_ACTIVE       bool not null,
    KORISNIK_USER         varchar(30) not null,
    KORISNIK_TS           timestamp DEFAULT CURRENT_TIMESTAMP,
    KORISNIK_ROLA       varchar(30) not null,
    primary key (KORISNIK_ID)
);

create table Email
(
    EMAIL_ID         bigint not null auto_increment,
    EMAIL_VREDNOST       varchar(300) not null,
    primary key (EMAIL_ID)
);

insert INTO Korisnik (KORISNIK_IME, KORISNIK_PASS, KORISNIK_ACTIVE, KORISNIK_USER, KORISNIK_ROLA) VALUES('admin','admin', true, 'Default', 'ADMIN');
