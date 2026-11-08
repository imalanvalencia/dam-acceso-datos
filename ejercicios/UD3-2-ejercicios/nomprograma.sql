USE bdapps;

/* Eliminar la función si ya existe */
DROP FUNCTION IF EXISTS nomprograma;

/* Crear la función */
DELIMITER //
CREATE FUNCTION nomprograma(pCodigo INT) 
	RETURNS VARCHAR(60)
  BEGIN
	DECLARE resul VARCHAR(60);
	
	SELECT nombre INTO resul FROM programas WHERE codigo=pCodigo;

	RETURN resul;
  END //
DELIMITER ;

/* Prueba desde Workbench */
SELECT nomprograma(1);
