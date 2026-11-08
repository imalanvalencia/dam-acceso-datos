-- =============================================================
-- UD3Ejer103 - Categorías de tareas sobre la BD "bdtasks"
-- IMPORTANTE: ejecutar antes bdtasks.sql (la BD bdtasks y la tabla
-- tasks tienen que existir ya).
-- Ejecutar desde MySQL Workbench (File > Open SQL Script, luego el rayo)
-- o desde consola:  mysql -u root -p < bdtasks-categorias.sql
-- =============================================================

USE bdtasks;

-- -------------------------------------------------------------
-- 1) Tabla de categorías: código (texto de 10, PK) y descripción (60).
-- -------------------------------------------------------------
CREATE TABLE categorias (
    codigo      VARCHAR(10)  NOT NULL PRIMARY KEY,
    descripcion VARCHAR(60)  NOT NULL
);

-- -------------------------------------------------------------
-- 2) Dos categorías de ejemplo.
-- -------------------------------------------------------------
INSERT INTO categorias (codigo, descripcion) VALUES
    ('E', 'Estudios'),
    ('O', 'Ocio');

-- -------------------------------------------------------------
-- 3) Se añade el código de categoría a las tareas.
--    Se permite NULL: una tarea puede no tener categoría.
--    La clave foránea garantiza que el código exista en categorias.
-- -------------------------------------------------------------
ALTER TABLE tasks
    ADD COLUMN codcateg VARCHAR(10) NULL,
    ADD CONSTRAINT fk_tasks_categorias
        FOREIGN KEY (codcateg) REFERENCES categorias (codigo);

-- -------------------------------------------------------------
-- 4) Las tareas 1 y 2 pasan a ser de la categoría "E" (Estudios).
-- -------------------------------------------------------------
UPDATE tasks
   SET codcateg = 'E'
 WHERE codigo IN (1, 2);

-- -------------------------------------------------------------
-- 5) INNER JOIN: tareas con su categoría, sólo cuando la tarea
--    tiene categoría asignada (y la categoría tiene descripción).
-- -------------------------------------------------------------
SELECT t.descripcion AS tarea,
       c.descripcion AS categoria
  FROM tasks t
  INNER JOIN categorias c ON t.codcateg = c.codigo
 ORDER BY t.codigo;

-- -------------------------------------------------------------
-- 6) LEFT JOIN: todas las tareas, con su categoría o NULL si la
--    tarea no tiene categoría asignada.
-- -------------------------------------------------------------
SELECT t.descripcion AS tarea,
       c.descripcion AS categoria
  FROM tasks t
  LEFT JOIN categorias c ON t.codcateg = c.codigo
 ORDER BY t.codigo;

-- -------------------------------------------------------------
-- 7) LEFT JOIN + COALESCE: igual que la anterior, pero las tareas
--    sin categoría muestran "(Ninguna)" en lugar de NULL.
-- -------------------------------------------------------------
SELECT t.descripcion AS tarea,
       COALESCE(c.descripcion, '(Ninguna)') AS categoria
  FROM tasks t
  LEFT JOIN categorias c ON t.codcateg = c.codigo
 ORDER BY t.codigo;

-- -------------------------------------------------------------
-- 8) FULL OUTER JOIN: MySQL no lo soporta, se simula con UNION.
--    - LEFT JOIN  -> todas las tareas (categoría NULL si no tiene).
--    - RIGHT JOIN -> todas las categorías (tarea NULL si no tiene
--                    tareas asignadas, como "O" = Ocio).
--    UNION elimina la fila duplicada que aparece en las dos ramas.
-- -------------------------------------------------------------
SELECT t.descripcion AS tarea,
       c.descripcion AS categoria
  FROM tasks t
  LEFT JOIN categorias c ON t.codcateg = c.codigo
UNION
SELECT t.descripcion,
       c.descripcion
  FROM tasks t
  RIGHT JOIN categorias c ON t.codcateg = c.codigo
 ORDER BY tarea;
