# BancoTransacciones
Pequeño sistema de gestión de transacciones bancarias escrito en Java y utiliza MySQL como base de datos.

## Versiones
- Java 8 o superior
    - Maven
- MySQL 5.7 o superior

## Recursos
[Prototipo de interfaz gráfica](https://www.figma.com/proto/ZyDg6Mm642d4zf3FPzFO1z/frmCuentaBancaria?node-id=1%3A2701&scaling=min-zoom&page-id=0%3A1&starting-point-node-id=1%3A2701)

## Requisitos actuales


### Entregables obligatorios
- [ ] Protitpos de Interfaz gráfica
    - [ ] Establecer interfaces necesarias
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
- [ ] Scripts
    - [ ] init.sql 
        - [X] DB
        - [X] Tablas
        - [ ] Triggers
        - [ ] Views
    - [X] dumbdata.sql
- [ ] Check transacciones
- [ ] Uso de Maven
- [ ] JavaDoc

### Requerimientos Funcionales
- [ ] Permite Gestionar las transacciones
- [ ] Puede tener diferentes cuentas asociadas
- [ ] Posibilidad de registro de usuario
- [ ] Posibilidad de actualizar datos de usuario
- [ ] Posibilidad de cancelar cuenta
- [ ] Un usuario puede transferir a otras cuentas (suyas o no)
- [ ] Realizar retiros sin ser clientes
- [ ] Historial de operaciones con rango de fechas
- [ ] Diferentes cuentas por usuario.



### Requerimientos No Funcionales
- [ ] Encriptación de contraseças al almacenarlas
- [ ] Retiros sin tarjeta pasan a no cobrado depsués de 10 min sin retirar dinero.
- [ ] Validaciones 
    - [ ] Datos de entrada (e.g. formato / campos vacíos)
    - [ ] Logicas (e.g. saldo negativo, doble retiro sin cuenta)
    - [ ] información repetida
- [ ] Fechas y dinero con formato correspondiente

## Estrategia

### Triggers
1. Entradas a la tabla `operaciones`
    1. Rationale: esta tabla va a guardar diferentes tipos de operaciones, entre estos se encuentran: "actualizacion", "transferencia", y "retiro". 
        a. Las actualizaciones se refiere a cambios en la información del usuario, estos se van a ver efectuadas mediante `UPDATE`'s, un trigger en los updates a la tabla `clientes` podría alimentar esos registros.
        b. Las operacion "transferencia" indica la creación de un registro en la tabla `transferencias`, otro trigger podría estar en todos los `INSERT INTO` de esta tabla.
        c. En la última operación "retiro", un trigger podría ser aplicado al hacer `UPDATE` en la tabla de `CuentasBancarias`, el único campo a actualizar es el saldo.
    <p style="color:red;"> TODO Agregar depósito o englobar en un solo tipo de operación el retiro y depósito a la cuenta</p>
2. Propuesta de alteración a `operaciones`: esta también podría almacenar la creación de cuentas bancarias, agregando un trigger en los `INSERT INTO` de CuentasBancarias, esto podría no ser del todo necesario ya que cada cuenta bancaria tiene una fecha de apertura que contendría esta operación.

### Transacciones
1. La transferencia de dinero de una cuenta a otra require el uso de transacciones para asegurar la integridad de la operación.
2. Se podría aplicar transferencia en ambas, retiro y depósito, a cuentas bancarias, siendo este aparentemente no tan necesario podría asegurar que los movimientos se reflejen de manera correcta.


### Stored Procedures

## Avances

### Avance 1
- [X] [Modelo entidad-relación de la base de datos.](./modelado/ModeloER.drawio)[^1]
- [X] [Modelo relacional de la base de datos.](./modelado/ModeloRelacional.md)
- [X] [Script SQL de creación de base de datos.](./scripts/init.sql)
- [X] [Diagrama de base de datos generado por el asistente de MySQL Workbench.](./modelado/EERDiagram_MySQL.mwb)
- [X] [Prototipos de interfaz gráfica con información de muestra.](README.md#recursos) 
    - Consideren utilizar el control apropiado según el contenido que deseen mostrar o interactuar.


### Avance 2
- [ ] Definir dónde pretenden utilizar el trigger.
- [ ] Definir dónde pretenden utilizar la transacción.
- [ ] Definir dónde pretenden utilizar el stored procedure.
- [ ] Desarrollar completamente un formulario de su elección. Debe incluir conexión con
BD, DAO, Formulario, clases de Dominio, validaciones, etc.
- [X] URL del repositorio público de Github con el código del proyecto actualizado
hasta ese momento.



[^1]: El modelo ER pueden ser abierto mediante [esta página](https://app.diagrams.net/) o usando la [aplicación de escritorio](https://drawio-app.com/)