/*
Script que crea la base de datos, tablas, vistas, y triggers del sistema.
TODO: Vistas, Triggers
TODO: domicilios NOT NULL
TODO: password
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
    nombres VARCHAR(50) NOT NULL,
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50),
    fechaNacimiento DATE NOT NULL,
    idDomicilio INT NOT NULL,
    FOREIGN KEY (idDomicilio) REFERENCES domicilios (id)  
);

CREATE TABLE operaciones(
	id INT PRIMARY KEY AUTO_INCREMENT,
    tipoOperacion ENUM("actualizacion","transferencia","retiro") NOT NULL,
    fechaHora DATETIME DEFAULT(CURRENT_TIMESTAMP),
    detalles VARCHAR(250),
    idCliente INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES clientes (id)
);

CREATE TABLE cuentasBancarias(
	id INT PRIMARY KEY AUTO_INCREMENT,
    noCuenta VARCHAR(20) NOT NULL,
    fechaApertura DATETIME DEFAULT(CURRENT_TIMESTAMP) NOT NULL,
    saldoMXN DECIMAL(8,4) NOT NULL,
    idCliente INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES clientes (id)
);

CREATE TABLE transferencias(
	id INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(8,4) NOT NULL,
    idCuentaOrigen INT NOT NULL,
    idCuentaDestino INT NOT NULL,
    FOREIGN KEY (idCuentaOrigen) REFERENCES cuentasBancarias (id),
    FOREIGN KEY (idCuentaDestino) REFERENCES cuentasBancarias (id)
);

CREATE TABLE retirosSinCuenta(
	id INT PRIMARY KEY AUTO_INCREMENT,
    password VARCHAR(100) NOT NULL,
    monto DECIMAL(8,4) NOT NULL,
    folio VARCHAR(50) NOT NULL,
    idCuentaBancaria INT NOT NULL,
	FOREIGN KEY (idCuentaBancaria ) REFERENCES cuentasBancarias (id)
);
