-- =============================================================
-- UD3Ejer101 - Base de datos "bdapps"
-- Ejecutar desde MySQL Workbench (File > Open SQL Script, luego el rayo)
-- o desde consola:  mysql -u root -p < bdapps.sql
-- =============================================================

-- Se borra si ya existía para poder repetir el script sin errores.
DROP DATABASE IF EXISTS bdapps;

CREATE DATABASE bdapps
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE bdapps;

-- Colección de software: código, nombre y carpeta de instalación.
CREATE TABLE programas (
    codigo              INT           NOT NULL PRIMARY KEY,
    nombre              VARCHAR(100)  NOT NULL,
    carpeta_instalacion VARCHAR(255)  NOT NULL
);

-- Dos datos de ejemplo.
INSERT INTO programas (codigo, nombre, carpeta_instalacion) VALUES
    (1, 'NetBeans',        '/opt/netbeans'),
    (2, 'MySQL Workbench', '/usr/bin/mysql-workbench');

-- Comprobación: deben aparecer las dos filas insertadas.
SELECT * FROM programas;
