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
    - [ ] dumbdata.sql
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