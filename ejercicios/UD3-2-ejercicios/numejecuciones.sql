USE bdapps;

/* Eliminar la función si ya existe */
DROP FUNCTION IF EXISTS numejecuciones;

/* Crear la función */
DELIMITER //
CREATE FUNCTION numejecuciones(pFecha DATE) 
	RETURNS INT
  BEGIN
	DECLARE resul INT;
	
	SELECT COUNT(*) INTO resul FROM ejecuciones WHERE fecha=pFecha;

	RETURN resul;
  END //
DELIMITER ;

/* Prueba desde Workbench */
SELECT numejecuciones('2021-10-15');
