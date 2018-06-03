
CREATE DATABASE `olimpiada`;
USE `olimpiada`;


CREATE TABLE `olimpiada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ouro` int(5) NOT NULL,
  `prata` int(5) NOT NULL,
  `bronze` int(5) NOT NULL,
  `nomePais` VARCHAR (100) NOT NULL,
  `nomeModalidade` VARCHAR (100) NOT NULL,
  `ano` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO usuario VALUES("admin@admin", "admin");

SELECT * FROM usuario