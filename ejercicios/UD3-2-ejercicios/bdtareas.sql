DROP  DATABASE IF EXISTS bdtareas;
CREATE SCHEMA bdtareas DEFAULT CHARACTER SET utf8mb4 ;

USE bdtareas ;

    CREATE TABLE tareas (
  codigo		int NOT NULL,
  descripcion 	varchar(60) DEFAULT NULL,
  fecha_prevista DATE,
  terminada BOOLEAN,
  codcateg VARCHAR(10),
  PRIMARY KEY (codigo)
);

CREATE TABLE categorias (
  codigo		varchar(10) NOT NULL,
  descripcion 	varchar(60) DEFAULT NULL,
  PRIMARY KEY (codigo)
);

INSERT INTO categorias (codigo, descripcion) VALUES
	('TRA', 'Trabajo a realizar'),
	('EST', 'Estudio y análisis');


INSERT INTO tareas ( codigo, descripcion, fecha_prevista, terminada, codcateg) VALUES 
	(1,'Repasar SQL','2021-10-10',false,'EST'),
	(2,'Instalar NetBeans','2021-10-11',true,'TRA'),
    (3,'Realizar copia de seguridad','2021-10-10',false,'TRA'),
	(4,'Examinar en busca de virus','2021-10-03',true,'TRA');