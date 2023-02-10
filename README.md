# BancoTransacciones
Pequeño sistema de gestión de transacciones bancarias escrito en Java y utiliza MySQL como base de datos.

## Versiones
- Java 8 o superior
    - Maven
- MySQL 5.7 o superior

## Requisitos actuales

### Entregables obligatorios
- [ ] Protitpos de Interfaz gráfica
    - [ ] Establecer interfaces necesarias
    - [ ] <b style="color:red;">TODO</b>
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






