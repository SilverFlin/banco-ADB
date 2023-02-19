/*
Script que crea la base de datos, tablas, vistas, y triggers del sistema.
TODO: Vistas, Triggers
TODO: domicilios NOT NULL
*/

DROP DATABASE IF EXISTS banco_transacciones;
CREATE DATABASE banco_transacciones;
USE banco_transacciones;

--  TABLAS --

CREATE TABLE domicilios(
	id INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(50),
    numero VARCHAR(50),
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
    correo VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    idDomicilio INT NOT NULL,
    FOREIGN KEY (idDomicilio) REFERENCES domicilios (id)  
);

CREATE TABLE cuentasBancarias(
	id INT PRIMARY KEY AUTO_INCREMENT,
    noCuenta VARCHAR(20) NOT NULL UNIQUE,
    fechaApertura DATETIME DEFAULT(CURRENT_TIMESTAMP) NOT NULL,
    saldoMXN DECIMAL(8,4) NOT NULL DEFAULT 0,
    idCliente INT NOT NULL,
    estadoCuenta ENUM("Activa","Inactiva") DEFAULT ("Activa") NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES clientes (id)
);

CREATE TABLE operaciones(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fechaHora DATETIME DEFAULT(CURRENT_TIMESTAMP),
    detalles VARCHAR(250),
    idCuentaBancaria INT NOT NULL,
    FOREIGN KEY (idCuentaBancaria) REFERENCES cuentasBancarias (id)
);

CREATE TABLE transferencias(
	id INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(8,4) NOT NULL,
    fechaHora DATETIME NOT NULL DEFAULT(CURRENT_TIMESTAMP) NOT NULL,
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
    estado ENUM("Cobrado","Pendiente","Expirado") DEFAULT("Pendiente"),
    fechaInicio DATETIME DEFAULT(CURRENT_TIMESTAMP) NOT NULL,
    fechaFin DATETIME NOT NULL,
    idCuentaBancaria INT NOT NULL,
	FOREIGN KEY (idCuentaBancaria ) REFERENCES cuentasBancarias (id)
);

--  TRIGGERS --


DELIMITER $$

CREATE TRIGGER RetiroPositivo
     BEFORE INSERT ON RetirosSinCuenta FOR EACH ROW
     BEGIN
          IF NEW.monto <= 0
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Monto debe ser mayor a cero.';
          END IF;
     END;
$$

DELIMITER ;

###

DELIMITER $$

CREATE TRIGGER SaldoPositivo
     BEFORE INSERT ON CuentasBancarias FOR EACH ROW
     BEGIN
          IF NEW.saldoMXN < 0
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Saldo debe ser mayor o igual a cero.';
          END IF;
     END;
$$

DELIMITER ;

### 

DELIMITER $$

CREATE TRIGGER MontoTransferenciaPositiva
     BEFORE INSERT ON Transferencias FOR EACH ROW
     BEGIN
          IF NEW.monto <= 0
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Monto debe ser mayor a cero.';
          END IF;
     END;
$$

DELIMITER ;

### 

DELIMITER $$

CREATE TRIGGER FechaNacimientoValida
     BEFORE INSERT ON Clientes FOR EACH ROW
     BEGIN
          IF NEW.fechaNacimiento > now()
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Fecha Nacimiento no puede ser mayor a la actual.';
          END IF;
     END;
$$

DELIMITER ;

###

DELIMITER $$

CREATE TRIGGER FechaAperturaValida
     BEFORE INSERT ON CuentasBancarias FOR EACH ROW
     BEGIN
          IF NEW.fechaApertura > now()
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Fecha apertura no puede ser mayor a la actual.';
          END IF;
     END;
$$

DELIMITER ;

###

DELIMITER $$

CREATE TRIGGER FechaFinMayorAInicio
     BEFORE INSERT ON RetirosSinCuenta FOR EACH ROW
     BEGIN
          IF NEW.fechaInicio < new.fechaInicio
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'fechaFin no puede ser menor a fechaInicio..';
          END IF;
     END;
$$

DELIMITER ;
