/*
Script que crea la base de datos, tablas, y triggers del sistema.
*/

DROP DATABASE IF EXISTS banco_transacciones;
CREATE DATABASE banco_transacciones;
USE banco_transacciones;

CREATE TABLE domicilios(
	id INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(50),
    colonia VARCHAR(50),
    ciudad VARCHAR(30),
    estado VARCHAR(30),
    pais VARCHAR(30),
    codigoPostal VARCHAR(10)
);

CREATE TABLE clientes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombres VARCHAR(50),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50),
    fechaNacimiento DATE,
    idDomicilio INT,
    FOREIGN KEY (idDomicilio) REFERENCES domicilios (id)  
);

CREATE TABLE operaciones(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipoOperacion ENUM("actualizacion","transferencia","retiro"),
    fechaHora DATETIME DEFAULT(CURRENT_TIMESTAMP),
    detalles VARCHAR(250),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES clientes (id)
);

CREATE TABLE cuentasBancarias(
	id INT PRIMARY KEY AUTO_INCREMENT,
    noCuenta VARCHAR(20),
    fechaHora DATETIME DEFAULT(CURRENT_TIMESTAMP),
    saldoMXN DECIMAL(8,4),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES clientes (id)
);

CREATE TABLE transferencias(
	id INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(8,4),
    idCuentaOrigen INT,
    idCuentaDestino INT,
    FOREIGN KEY (idCuentaOrigen) REFERENCES cuentasbancarias (id),
    FOREIGN KEY (idCuentaDestino) REFERENCES cuentasbancarias (id)
);

CREATE TABLE retirosSinCuenta(
	id INT PRIMARY KEY AUTO_INCREMENT,
    password VARCHAR(100),
    monto DECIMAL(8,4),
    folio VARCHAR(50),
    idCuentaBancaria INT,
	FOREIGN KEY (idCuentaBancaria ) REFERENCES cuentasbancarias (id)
);
