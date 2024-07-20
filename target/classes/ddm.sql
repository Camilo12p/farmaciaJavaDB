

-- PROCDIMIENTO PARA EL INSERT pais
DELIMITER &&

DROP PROCEDURE IF EXISTS pr_insertpais&&

CREATE PROCEDURE pr_insertpais(
        IN inNombre VARCHAR(45)
    )

BEGIN
    DECLARE mensaje VARCHAR(30);
    INSERT INTO pais (nombre) VALUES (inNombre);

    IF(ROW_COUNT()>0) THEN
    SET mensaje = "Se ha inscrito bien";
    ELSE 
    SET mensaje = "Error en inscripcion";
    END IF;

    SELECT mensaje as "Mensaje";
END 
&&

DELIMITER ;




-- PROCDIMIENTO PARA EL INSERT region
DELIMITER &&

DROP PROCEDURE IF EXISTS pr_insertregion&&

CREATE PROCEDURE pr_insertregion(
        IN inNombre VARCHAR(50),
        IN inIdpais INT
    )

BEGIN
    DECLARE mensaje VARCHAR(30);
    INSERT INTO region (nombre,id_pais) VALUES (inNombre,inIdpais);

    IF(ROW_COUNT()>0) THEN
    SET mensaje = "Se ha inscrito bien";
    ELSE 
    SET mensaje = "Error en inscripcion";
    END IF;

    SELECT mensaje as "Mensaje";
END 
&&

DELIMITER ;




-- PROCDIMIENTO PARA EL INSERT ciudad
DELIMITER &&

DROP PROCEDURE IF EXISTS pr_insertciudad&&

CREATE PROCEDURE pr_insertciudad(
        IN inNombre VARCHAR(50),
        IN inIdRegion INT
    )

BEGIN
    DECLARE mensaje VARCHAR(30);
    INSERT INTO ciudad (nombre,id_region) VALUES (inNombre,inIdRegion);

    IF(ROW_COUNT()>0) THEN
    SET mensaje = "Se ha inscrito bien";
    ELSE 
    SET mensaje = "Error en inscripcion";
    END IF;

    SELECT mensaje as "Mensaje";
END 
&&

DELIMITER ;


CALL pr_insertpais('COLOMBIA');
CALL pr_insertpais('ESTADOS UNIDOS');
CALL pr_insertpais('VENEZUELA');

CALL pr_insertregion('SANTANDER',1);
CALL pr_insertregion('CUNDINAMARCA',1);
CALL pr_insertregion('ATLANTICO',1);

CALL pr_insertciudad("BUCARAMANGA",1);