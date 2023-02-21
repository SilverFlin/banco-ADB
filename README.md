# BancoTransacciones
Pequeño sistema de gestión de transacciones bancarias escrito en Java y utiliza MySQL como base de datos.


<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

- [BancoTransacciones](#-bancotransacciones-)
  - [Versiones](#-versiones-)
  - [Recursos](#-recursos-)
  - [Requisitos actuales](#-requisitos-actuales-)
    - [Entregables obligatorios](#-entregables-obligatorios-)
    - [Requerimientos Funcionales](#-requerimientos-funcionales-)
    - [Requerimientos No Funcionales](#-requerimientos-no-funcionales-)
  - [Estrategia](#-estrategia-)
    - [Triggers](#-triggers-)
    - [Transacciones](#-transacciones-)
    - [Stored Procedures](#-stored-procedures-)
  - [Avances](#-avances-)
    - [Avance 1](#-avance-1-)
    - [Avance 2](#-avance-2-)

<!-- /code_chunk_output -->


## Versiones
- Java 8 o superior
    - Maven
- MySQL 5.7 o superior

## Recursos
[Prototipo de interfaz gráfica](https://www.figma.com/proto/ZyDg6Mm642d4zf3FPzFO1z/frmCuentaBancaria?node-id=1%3A2701&scaling=min-zoom&page-id=0%3A1&starting-point-node-id=1%3A2701)

## Requisitos actuales


### Entregables obligatorios
- [X] Protitpos de Interfaz gráfica
    - [X] Establecer interfaces necesarias
    - [X] ClienteForm
        - [X] Nuevo
        - [X] Editar
    - [X] CuentaBancariaForm
        - [X] Nuevo
        - [X] Cancelar
    - [X] Transferencia
    - [X] Retiro Sin Tarjeta
    - [X] Login
- [X] Modelos
    - [X] Entidad Relacion
    - [X] Relacional
- [X] Scripts
    - [X] init.sql 
        - [X] DB
        - [X] Tablas
        - [X] Triggers
    - [X] dumbdata.sql
- [X] Check transacciones
- [X] Uso de Maven
- [X] JavaDoc

### Requerimientos Funcionales
- [X] Permite Gestionar las transacciones
- [X] Puede tener diferentes cuentas asociadas
- [X] Posibilidad de registro de usuario
- [X] Posibilidad de actualizar datos de usuario
- [X] Posibilidad de cancelar cuenta
- [X] Un usuario puede transferir a otras cuentas (suyas o no)
- [X] Realizar retiros sin ser clientes
- [X] Historial de operaciones con rango de fechas
- [X] Diferentes cuentas por usuario.



### Requerimientos No Funcionales
- [X] Encriptación de contraseñas al almacenarlas
- [X] Retiros sin tarjeta pasan a no cobrado después de 10 min sin retirar dinero.
- [x] Validaciones 
    - [x] Datos de entrada (e.g. formato / campos vacíos)
    - [x] Logicas (e.g. saldo negativo, doble retiro sin cuenta)
    - [x] información repetida
- [x] Fechas y dinero con formato correspondiente

## Estrategia

### Triggers
1. Entradas a la tabla `operaciones`
    1. <s>esta tabla va a guardar diferentes tipos de operaciones, entre estos se encuentran: "actualizacion", "transferencia", y "retiro". 
        a. Las actualizaciones se refiere a cambios en la información del usuario, estos se van a ver efectuadas mediante `UPDATE`'s, un trigger en los updates a la tabla `clientes` podría alimentar esos registros.</s>
        b. <s>Las operacion "transferencia" indica la creación de un registro en la tabla `transferencias`, otro trigger podría estar en todos los `INSERT INTO` de esta tabla.</s>
        c. <s>En la última operación "retiro", un trigger podría ser aplicado al hacer `UPDATE` en la tabla de `CuentasBancarias`, el único campo a actualizar es el saldo.</s>
   
2. <s>Propuesta de alteración a `operaciones`: esta también podría almacenar la creación de cuentas bancarias, agregando un trigger en los `INSERT INTO` de CuentasBancarias, esto podría no ser del todo necesario ya que cada cuenta bancaria tiene una fecha de apertura que contendría esta operación.</s>
3. Para asegurar que no se guarden montos de dinero negativos, se podría aplicar un trigger en todos los cambios que manejen este tipo de atributo, verificando antes de insertar que el valor sea mayor a 0. Esto aplicaría a: Monto de RetiroSinCuenta, SaldoMXN de CuentasBancarias, y Monto de Transferencias.
4. Hay ingresos de fechas que no tendrían sentido, y sería lógico meter algunas validaciones mediante triggers. Esto podría aplicar a la FechaNacimiento de Clientes, que no sea mayor a la fecha actual; que FechaFin no sea menor a FechaInicio en RetirosSinCuenta; FechaApertura de CuentasBancarias tampoco debería ser mayor a la fecha actual.

### Transacciones
1. La transferencia de dinero de una cuenta a otra require el uso de transacciones para asegurar la integridad de la operación.

2. Se podría aplicar transferencia en ambas, retiro y depósito, a cuentas bancarias, siendo este aparentemente no tan necesario podría asegurar que los movimientos se reflejen de manera correcta.

### Stored Procedures
1. Se pueden simplificar operaciones CRUD para realizar conjuntos de consultas en una sola desde el código, por ejemplo, se puede crear un procedimiento almacenado que maneje las transferencias, recibiendo una referencia de cada cuenta con el monto, y que se encargue de crear el registro de la misma transferencia y los cambios en el dinero de ambas cuentas

2. Podría aplicarse un procedimiento almacenado que reciba un tiempo en el cual el retiro pasará a un estado en el que no pueda ser retirado, calculando dentro de aquí la fecha de FechaFin.

## Avances

### Avance 1
- [X] [Modelo entidad-relación de la base de datos.](./modelado/ModeloER.drawio)[^1]
- [X] [Modelo relacional de la base de datos.](./modelado/ModeloRelacional.md)
- [X] [Script SQL de creación de base de datos.](./scripts/init.sql)
- [X] [Diagrama de base de datos generado por el asistente de MySQL Workbench.](./modelado/EERDiagram_MySQL.mwb)
- [X] [Prototipos de interfaz gráfica con información de muestra.](README.md#recursos) 
    - Consideren utilizar el control apropiado según el contenido que deseen mostrar o interactuar.


### Avance 2
- [X] Definir dónde pretenden utilizar el trigger.
- [X] Definir dónde pretenden utilizar la transacción.
- [X] Definir dónde pretenden utilizar el stored procedure.
- [X] Desarrollar completamente un formulario de su elección. Debe incluir conexión con
BD, DAO, Formulario, clases de Dominio, validaciones, etc.
- [X] URL del repositorio público de Github con el código del proyecto actualizado
hasta ese momento.



[^1]: El modelo ER pueden ser abierto mediante [esta página](https://app.diagrams.net/) o usando la [aplicación de escritorio](https://drawio-app.com/)
