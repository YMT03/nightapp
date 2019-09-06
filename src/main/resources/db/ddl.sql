DROP DATABASE IF EXISTS nightapp;
CREATE DATABASE nightapp;
use nightapp;

DROP TABLE IF EXISTS establecimiento;
CREATE TABLE establecimiento
(
	id BIGINT AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL,
    CONSTRAINT establecimiento_pk PRIMARY KEY(id)
)ENGINE=INNODB;