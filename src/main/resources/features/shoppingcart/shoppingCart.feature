# language: es
  @FeatureName:carroDeCompras
  Característica: carro de compras
    Como cliente de la tienda
    necesito agregar productos al carrito de compras
    para poder realizar compras en linea

  Antecedentes:
    Dado que el cliente se encuentra en la tienda virtual

  @ScenarioName:PagoPorTransferenciaClienteNuevo
  Escenario: Pago por transferencia cliente nuevo
    Cuando agrega articulos al carrito y paga la factura
    Entonces el cliente vera en pantalla un mensaje de confirmacion

  @ScenarioName:AceptarTerminosDelServicio
  Escenario: Aceptar los terminos del servicio
    Cuando agrega articulos al carrito
    Y intenta pagar la factura sin aceptar los terminos del servicio
    Entonces el clinte vera en pantalla una alerta
