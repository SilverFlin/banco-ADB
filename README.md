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
    - [ ] ClienteForm
        - [ ] Nuevo
        - [ ] Editar
    - [X] CuentaBancariaForm
        - [X] Nuevo
        - [X] Cancelar
    - [X] Transferencia
    - [X] Retiro Sin Tarjeta
    - [X] Login
- [ ] Modelos
    - [ ] Entidad Relacion
    - [ ] Relacional
- [ ] Scripts
    - [ ] init.sql (db + tablas + triggers)
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
- [ ] Un ususario puede transferir a otras cuentas (suyas o no)
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






