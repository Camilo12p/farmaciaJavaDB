
DROP DATABASE IF EXISTS farmacia;
CREATE DATABASE farmacia;

USE farmacia;



CREATE TABLE pais(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(45),

    CONSTRAINT pk_id_pais PRIMARY KEY (id)
); 


CREATE TABLE region(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    id_pais INT,

    CONSTRAINT pk_id_region PRIMARY KEY (id),
    CONSTRAINT fk_idpais_region FOREIGN KEY (id_pais) REFERENCES pais(id) ON DELETE CASCADE
);


CREATE TABLE ciudad (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    id_region INT,

    CONSTRAINT pk_id_ciudad PRIMARY KEY (id),
    CONSTRAINT fk_idregion_ciudad FOREIGN KEY (id_region) REFERENCES region(id) ON DELETE CASCADE   
);

CREATE TABLE barrio (
    id INT AUTO_INCREMENT,
    calle_principal VARCHAR(20),
    interseccion VARCHAR(20),
    detalles VARCHAR(40),
    nombre VARCHAR(50),
    id_ciudad INT,

    CONSTRAINT pk_id_ciudad PRIMARY KEY (id),
    CONSTRAINT fk_idciudad_barrio FOREIGN KEY (id_ciudad) REFERENCES ciudad(id) ON DELETE CASCADE   
);

CREATE TABLE tipodocumento(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(30),
    id_pais INT,
 
    CONSTRAINT pk_id_tdocumento PRIMARY KEY (id),
    CONSTRAINT fk_idpais_tdocumento FOREIGN KEY (id_pais) REFERENCES pais(id) ON DELETE CASCADE
);

CREATE TABLE cliente(
    id BIGINT,
    id_tipo_documento INT,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    edad TINYINT,
    fecha_nacimiento DATE,
    fecha_creacion DATE DEFAULT (CURDATE()),
    id_barrio INT,

    CONSTRAINT pk_id_cliente PRIMARY KEY (id),
    CONSTRAINT fk_idbarrio_cliente FOREIGN KEY (id_barrio) REFERENCES barrio(id) ON DELETE CASCADE,
    CONSTRAINT fk_idtdocumento_cliente FOREIGN KEY (id_tipo_documento) REFERENCES tipodocumento(id) ON DELETE CASCADE

);

CREATE TABLE unidad_de_medida(
    id INT,
    nombre VARCHAR(25),


    CONSTRAINT pk_id_unidadDeMedida PRIMARY KEY (id)
);

CREATE TABLE laboratorio(
    id INT,
    nombre VARCHAR(50),
    id_pais INT,

    CONSTRAINT pk_id_laboratorio PRIMARY KEY (id),
    CONSTRAINT fk_idpais_laboratorio FOREIGN KEY (id_pais) REFERENCES pais(id) ON DELETE CASCADE
);

CREATE TABLE proveedor(
    id INT,
    nombre VARCHAR(50),

    CONSTRAINT pk_id_proveedor PRIMARY KEY (id)
);


CREATE TABLE presentacion(
    id INT,
    nombre VARCHAR(50),

    CONSTRAINT pk_id_presentacion PRIMARY KEY (id)
);

CREATE TABLE producto(
    id INT,
    nombre VARCHAR(60),
    registro_invima INT,
    via_de_administracion VARCHAR(30),
    principio_activo VARCHAR(30),
    id_unidad_de_medida INT,
    id_laboratorio INT,
    id_proveedor INT,
    id_presentacion INT,
    fecha_caducidad DATE,
    stock INT,
    stock_min INT,
    stock_max INT, 
    valor_venta FLOAT,

    CONSTRAINT pk_id_presentacion PRIMARY KEY (id),
    CONSTRAINT fk_idunidadMedida_producto FOREIGN KEY (id_unidad_de_medida) REFERENCES unidad_de_medida(id),
    CONSTRAINT fk_idlaboratorio_producto FOREIGN KEY (id_laboratorio) REFERENCES laboratorio(id),
    CONSTRAINT fk_idproveedor_producto FOREIGN KEY (id_proveedor) REFERENCES proveedor(id),
    CONSTRAINT fk_idpresentacion_producto FOREIGN KEY (id_presentacion) REFERENCES presentacion(id)
);

