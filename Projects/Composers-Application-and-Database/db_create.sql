use master
go
if exists (select * from sysdatabases where name='MusicComposers')
		drop database MusicComposers
go

create database MusicComposers;
go
use MusicComposers;

create table Composers(
	ComposerId int not null,
	ComposerFullName nvarchar(100) not null,
	Nationality nvarchar(50) not null,
	PlaceOfBirth nvarchar(50) not null,
	YearOfBirth int not null,
	NumberOfPieces int not null,
	primary key(ComposerId)
);
go

create table PlayedInstruments(
	InstrumentId int not null,
	ComposerId int not null,
	InstrumentName nvarchar(50) not null,
	InstrumentCategory nvarchar(50) not null,
	primary key(InstrumentId),
	foreign key (ComposerId) REFERENCES Composers(ComposerId)

);
go
create table MostFamousPieces(
	PieceId int not null,
	ComposerId int not null,
	PieceName nvarchar(100) not null,
	FormalPieceName nvarchar(100) not null,
	PieceGenre nvarchar(50) not null,
	primary key(PieceId),
	foreign key (ComposerId) REFERENCES Composers(ComposerId)
);
go

--Composers
insert into Composers values (1, 'Johann Sebastian Bach', 'German', 'Eisenach', 1685, 1000);
insert into Composers values (2, 'Ludwig van Beethoven', 'German', 'Bonn', 1770, 722);
insert into Composers values (3, 'Fryderyk Chopin', 'Polish', '¯elazowa Wola', 1810, 230);
insert into Composers values (4, 'Antonio Vivaldi', 'Italian', 'Venice', 1678, 500);
insert into Composers values (5, 'Kinga U³asik', 'Polish', 'Gdynia', 2000, 2);

--PlayedInstruments
insert into PlayedInstruments values(1,1,'Organ', 'Keyboard Instrument');
insert into PlayedInstruments values(2,1, 'Harpsichord', 'Keyboard Instrument');
insert into PlayedInstruments values(3, 1, 'Violin', 'String Instrument');
insert into PlayedInstruments values(4, 1, 'Viola', 'String Instrument');
insert into PlayedInstruments values(5, 2, 'Piano', 'Keyboard Instrument');
insert into PlayedInstruments values(6, 3, 'Piano', 'Keyboard Instrument' );
insert into PlayedInstruments values(7, 4, 'Violin', 'String Instrument');
insert into PlayedInstruments values(8, 5,'Piano', 'Keyboard Instrument');
insert into PlayedInstruments values(9, 5,'Guitar', 'String Instrument');
insert into PlayedInstruments values(10, 5,'Ukulele', 'String Instrument');

--MostFamousPieces
insert into MostFamousPieces values(1,1, 'St Matthew Passion', 'St Matthew Passion' ,'Passion');
insert into MostFamousPieces values(2,1, 'Toccata and Fugue in D minor', 'Toccata and Fugue in D minor Dorian', 'Work for organ');
insert into MostFamousPieces values(3, 2, 'Moonlight', 'Piano Sonata No. 14 in Cis minor', 'Sonata');
insert into MostFamousPieces values(4, 3, 'Revolutionary etude', 'Etude in C minor', 'Etude');
insert into MostFamousPieces values(5, 4, 'Spring','Concerto No. 1 in E major, Op. 8','Violin concert');
insert into MostFamousPieces values(6, 4, 'Summer','Concerto No. 2 in G minor, Op. 8','Violin concert');
insert into MostFamousPieces values(7, 4, 'Autumn','Concerto No. 2 in G minor, Op. 8','Violin concert');
insert into MostFamousPieces values(8, 4, 'Winter','Concerto No. 4 in F minor, Op. 8','Violin concert');
insert into MostFamousPieces values(9, 5, 'Hallelujah - own arrangment', 'Hallelujah - own arrangment', 'Piano cover');

