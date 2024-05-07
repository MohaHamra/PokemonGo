DROP DATABASE dbpokemon;
DROP USER 'usrpokemon'@'localhost';
-- Create user for local access.
CREATE USER 'usrpokemon'@'localhost' IDENTIFIED BY 'pswpokemon';
-- Create database.
CREATE DATABASE dbpokemon
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
-- Grant permissions.
GRANT SELECT, INSERT, UPDATE, DELETE ON dbpokemon.* TO 'usrpokemon'@'localhost';
-- Use database.
USE dbpokemon;
-- Create table 'entrenadors'
CREATE TABLE `entrenadors` (
`id` INT(4) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL, 
`password` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `idx_name` (`name`)
) ENGINE=InnoDB;
-- Data insertion.
INSERT INTO `entrenadors` ( `name`, `password`) 
VALUES
(UPPER('user1'), 'user1'),
(UPPER('user2'), 'user2');
-- Create table 'pokedex'
CREATE TABLE `pokedex` (
`num` INT(4) NOT NULL ,
`name` VARCHAR(40) NOT NULL,
`type` VARCHAR(40) DEFAULT NULL,
PRIMARY KEY (`num`)
) ENGINE=InnoDB;
-- Data insertion.
INSERT INTO `pokedex` ( `num`, `name`, `type`) 
VALUES
(1,UPPER('Bulbasur'), 'planta'),
(2,UPPER('charizard'), 'fuego'),
(3,UPPER('charmaleon'), 'fuego'),
(4,UPPER('charmander'), 'fuego'),
(5,UPPER('ivy'), 'normal'),
(6,UPPER('pikachu'), 'electrico'),
(7,UPPER('Venusaur'), 'fuego'),
(25,UPPER('Charmeleon'), 'fuego');
-- Create table 'mochila'
CREATE TABLE `mochila` (
`id_entrenador` INT(4) NOT NULL , 
`num_pokemon` INT(4) NOT NULL ,
`CP` INT(4) NOT NULL,
FOREIGN KEY (`num_pokemon`) REFERENCES `pokedex` (`num`),
FOREIGN KEY (`id_entrenador`) REFERENCES `entrenadors` (`id`)
) ENGINE=InnoDB;

INSERT INTO `mochila` ( `id_entrenador`, `num_pokemon`, `CP`) 
VALUES
(1,1,50),
(1,5,99);