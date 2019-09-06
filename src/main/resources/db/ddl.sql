DROP DATABASE IF EXISTS nightapp;
CREATE DATABASE nightapp;
use nightapp;

DROP TABLE IF EXISTS establecimiento;
CREATE TABLE establecimiento
(
	id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT(2000),
    CONSTRAINT establecimiento_pk PRIMARY KEY(id)
)ENGINE=INNODB;