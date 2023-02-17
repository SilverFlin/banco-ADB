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
    - Correo: texto(100),
    - password: texto(50)
    - IdDomicilio: entero
)
> IdDomicilio, que viene de Domicilios.

- CuentasBancarias (
    - <u>id</u>:entero 
    - NoCuenta: texto(20) unico
    - FechaApertura: fechaHora
    - SaldoMXN: decimal
    - IdCliente: entero
)
> FechaApertura, que se genera al ingresar el registro
> IdCliente, que viene de Clientes

- Operaciones (
    - <u>id</u>:entero 
    - FechaHora: fechaHora
    - Detalles: texto(250)
    - idCuentaBancaria: entero
)
> FechaHora, que se genera al ingresar el registro.
> idCuentaBancaria, que viene de CuentasBancarias.

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
    - FechaInicio: fechaHora
    - FechaFin: fechaHora
    - Cobrado: texto("Cobrado","Pendiente")
    - IdCuentaBancaria: entero
)
> IdCuentaBancaria, que viene de CuentasBancarias
