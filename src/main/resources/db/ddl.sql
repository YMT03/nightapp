DROP DATABASE IF EXISTS nightapp;
CREATE DATABASE nightapp;
use nightapp;

DROP TABLE IF EXISTS ubicacion;
CREATE TABLE ubicacion
(
	id BIGINT AUTO_INCREMENT,
	direccion VARCHAR(100) NOT NULL,
    longitud VARCHAR(50) NOT NULL,
	latitud VARCHAR(50) NOT NULL,
    CONSTRAINT ubicacion_pk PRIMARY KEY(id)
)ENGINE=INNODB;

DROP TABLE IF EXISTS establecimiento;
CREATE TABLE establecimiento
(
	id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT(2000),
    ubicacion_id BIGINT NOT NULL,
    CONSTRAINT establecimiento_pk PRIMARY KEY(id),
    CONSTRAINT establecimiento_ubicacion_fk1 FOREIGN KEY(ubicacion_id)
    		REFERENCES ubicacion(id) MATCH FULL ON UPDATE NO ACTION ON DELETE NO ACTION
)ENGINE=INNODB;