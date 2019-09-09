DROP DATABASE IF EXISTS nightapp;
CREATE DATABASE nightapp;
use nightapp;


DROP TABLE IF EXISTS ubicaciones;
CREATE TABLE ubicaciones
(
	id BIGINT AUTO_INCREMENT,
	direccion VARCHAR(100) NOT NULL,
    longitud VARCHAR(50) NOT NULL,
	latitud VARCHAR(50) NOT NULL,
    CONSTRAINT ubicaciones_pk PRIMARY KEY(id)
)ENGINE=INNODB;

DROP TABLE IF EXISTS establecimientos;
CREATE TABLE establecimientos
(
	id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT(2000),
    ubicacion_id BIGINT NOT NULL,
    CONSTRAINT establecimientos_pk PRIMARY KEY(id),
    CONSTRAINT establecimientos_fk1 FOREIGN KEY(ubicacion_id)
    		REFERENCES ubicaciones(id) MATCH FULL ON UPDATE NO ACTION ON DELETE NO ACTION
)ENGINE=INNODB;


DROP TABLE IF EXISTS comentarios;
CREATE TABLE comentarios
(
	id BIGINT AUTO_INCREMENT,
    establecimiento_id BIGINT NOT NULL,
    titulo VARCHAR(70) NOT NULL,
	descripcion TEXT(800) NOT NULL,
    CONSTRAINT comentarios_pk PRIMARY KEY(id),
	CONSTRAINT comentarios_fk1 FOREIGN KEY(establecimiento_id)
		REFERENCES establecimientos(id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=INNODB;

CREATE TABLE categorias
(
	id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT categorias_pk PRIMARY KEY(id)
)ENGINE=INNODB;
