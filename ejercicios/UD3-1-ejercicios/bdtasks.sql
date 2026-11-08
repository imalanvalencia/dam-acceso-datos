-- =============================================================
-- UD3Ejer102 - Base de datos "bdtasks" (agenda de tareas)
-- Ejecutar desde MySQL Workbench (File > Open SQL Script, luego el rayo)
-- o desde consola:  mysql -u root -p < bdtasks.sql
-- =============================================================

-- Se borra si ya existía para poder repetir el script sin errores.
DROP DATABASE IF EXISTS bdtasks;

CREATE DATABASE bdtasks
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE bdtasks;

-- -------------------------------------------------------------
-- 1) Tabla de tareas: código (PK numérica) y descripción.
-- -------------------------------------------------------------
CREATE TABLE tasks (
    codigo      INT           NOT NULL PRIMARY KEY,
    descripcion VARCHAR(200)  NOT NULL
);

-- -------------------------------------------------------------
-- 2) Dos tareas iniciales.
-- -------------------------------------------------------------
INSERT INTO tasks (codigo, descripcion) VALUES
    (1, 'Repasar SQL'),
    (2, 'Instalar NetBeans');

-- -------------------------------------------------------------
-- 3) Se añaden dos campos al final: fecha prevista y terminada.
--    BOOLEAN en MySQL es un alias de TINYINT(1): 0 = false, 1 = true.
-- -------------------------------------------------------------
ALTER TABLE tasks
    ADD COLUMN fecha_prevista DATE    NULL,
    ADD COLUMN terminada      BOOLEAN NOT NULL DEFAULT FALSE;

-- -------------------------------------------------------------
-- 4) Fechas relativas al día de ejecución:
--    tarea 1 -> mañana, tarea 2 -> pasado mañana. Ninguna terminada.
-- -------------------------------------------------------------
UPDATE tasks
   SET fecha_prevista = CURDATE() + INTERVAL 1 DAY,
       terminada      = FALSE
 WHERE codigo = 1;

UPDATE tasks
   SET fecha_prevista = CURDATE() + INTERVAL 2 DAY,
       terminada      = FALSE
 WHERE codigo = 2;

-- -------------------------------------------------------------
-- 5) Dos tareas más (con fecha, para que la consulta por día
--    posterior tenga datos en todos los grupos).
-- -------------------------------------------------------------
INSERT INTO tasks (codigo, descripcion, fecha_prevista, terminada) VALUES
    (3, 'Hacer los ejercicios de JDBC', CURDATE() + INTERVAL 3 DAY, FALSE),
    (4, 'Leer el tema de conectores',   CURDATE() + INTERVAL 4 DAY, FALSE);

-- -------------------------------------------------------------
-- 6) Tareas cuyo código es inferior a 3.
-- -------------------------------------------------------------
SELECT * FROM tasks WHERE codigo < 3;

-- -------------------------------------------------------------
-- 7) Tareas cuya descripción contiene la palabra "instalar".
--    La collation utf8mb4_unicode_ci no distingue mayúsculas,
--    así que "Instalar" también coincide.
-- -------------------------------------------------------------
SELECT * FROM tasks WHERE descripcion LIKE '%instalar%';

-- -------------------------------------------------------------
-- 8) Código de la última tarea (el mayor código).
-- -------------------------------------------------------------
SELECT MAX(codigo) AS ultimo_codigo FROM tasks;

-- -------------------------------------------------------------
-- 9) Cantidad de tareas almacenadas.
-- -------------------------------------------------------------
SELECT COUNT(*) AS total_tareas FROM tasks;

-- -------------------------------------------------------------
-- 10) Cantidad de tareas que hay para cada día.
-- -------------------------------------------------------------
SELECT fecha_prevista, COUNT(*) AS num_tareas
  FROM tasks
 GROUP BY fecha_prevista
 ORDER BY fecha_prevista;

-- -------------------------------------------------------------
-- 11) Código de la tarea más antigua (menor código)
--     que contenga la palabra "NetBeans".
-- -------------------------------------------------------------
SELECT MIN(codigo) AS codigo_mas_antigua_netbeans
  FROM tasks
 WHERE descripcion LIKE '%NetBeans%';

-- -------------------------------------------------------------
-- 12) Descripción y fecha prevista de las tareas cuyo código es
--     superior al de la tarea más antigua que contiene "NetBeans".
--     La subconsulta devuelve un único valor, así que se puede
--     comparar directamente con el operador >.
-- -------------------------------------------------------------
SELECT descripcion, fecha_prevista
  FROM tasks
 WHERE codigo > (SELECT MIN(codigo)
                   FROM tasks
                  WHERE descripcion LIKE '%NetBeans%')
 ORDER BY codigo;
