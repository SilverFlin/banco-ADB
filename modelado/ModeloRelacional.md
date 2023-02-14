    # Modelo Relacional: BancoTransacciones

- Domicilios (
    - <u>id</u>:entero 
    - Calle: texto(50)
    - Numero: texto(50)
    - Colonia: texto(50)
    - Ciudad: texto(30)
    - Estado: texto(30)
    - Pais: texto(30)
    - CodigoPostal: texto(30)
)

- Clientes (
    - <u>id</u>:entero 
    - Nombres: texto(50)
    - ApellidoPaterno: texto(50)
    - ApellidoMaterno: texto(50) opcional
    - FechaNacimiento:fecha
    - Correo: texto(100)
    - IdDomicilio: entero
)
> IdDomicilio, que viene de Domicilios.

- Operaciones (
    - <u>id</u>:entero 
    - FechaHora: fechaHora
    - Detalles: texto(250)
    - idCliente: entero
)
> FechaHora, que se genera al ingresar el registro.
> IdCliente, que viene de Clientes.

- CuentasBancarias (
    - <u>id</u>:entero 
    - NoCuenta: texto(20) unico
    - FechaApertura: fechaHora
    - SaldoMXN: decimal
    - IdCliente: entero
)
> FechaApertura, que se genera al ingresar el registro
> IdCliente, que viene de Clientes

- Transferencias (
    - <u>id</u>:entero 
    - Monto: decimal
    - FechaHora: fechaHora
    - IdCuentaOrigen: entero
    - IdCuentaDestino: entero
)
> IdCuentaOrigen, que viene de CuentasBancarias.
> IdCuentaDestino, que viene de CuentasBancarias.

- RetirosSinCuenta (
    - <u>id</u>:entero 
    - Password: texto(100)
    - Monto: decimal
    - Folio: texto(50)
    - IdCuentaBancaria: entero
    - Cobrado: texto("Cobrado","Pendiente")
)
> IdCuentaBancaria, que viene de CuentasBancarias
