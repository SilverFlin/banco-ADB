# Modelo Relacional: BancoTransacciones

- Domicilios (
    - <u>id</u>:entero 
    - Calle: texto
    - Numero: texto
    - Colonia: texto
    - Ciudad: texto
    - Estado: texto
    - CodigoPostal: texto
    - Pais: texto
)

- Clientes (
    - <u>id</u>:entero 
    - Nombres: texto
    - ApellidoPaterno: texto
    - ApellidoMaterno: texto
    - FechaNacimiento:fecha
    - IdDomicilio: entero
)
> IdDomicilio, que viene de Domicilios.
TODO actualizar ER, remover Edad

- Operaciones (
    - <u>id</u>:entero 
    - TipoOperacion: enum("actualizacion","transferencia","retiro")
    - FechaHora: fechaHora
    - Detalles: texto
    - idCliente: entero
)
> FechaHora, que se genera al ingresar el registro.
> IdCliente, que viene de Clientes.
TODO enum en relacional?

- CuentasBancarias (
    - <u>id</u>:entero 
    - NoCuenta: texto
    - FechaApertura: fechaHora
    - SaldoMXN: decimal
    - IdCliente: entero
)
> FechaApertura, que se genera al ingresar el registro
> IdCliente, que viene de Clientes

- Transferencias (
    - <u>id</u>:entero 
    - Monto: decimal
    - IdCuentaOrigen: entero
    - IdCuentaDestino: entero
)
> IdCuentaOrigen, que viene de CuentasBancarias.
> IdCuentaDestino, que viene de CuentasBancarias.

- RetirosSinCuenta (
    - <u>id</u>:entero 
    - Password: texto
    - Monto: decimal
    - Folio: texto
    - IdCuentaBancaria: entero
)
> IdCuentaBancaria, que viene de CuentasBancarias
