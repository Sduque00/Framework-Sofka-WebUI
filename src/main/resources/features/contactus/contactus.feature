# language: es
   @FeatureName:contactaConNosotros
   Característica: Contacta con nosotros
       Como cliente de la tienda
       necesito hacer uso del contact us
       para poder hacer una PQRS

   Antecedentes:
     Dado Que el cliente se encuentra en la tienda virtual

   @ScenarioName:SolicitudExitosa
   Escenario: Solicitud exitosa
     Cuando navega hasta el formulario de contact us
     Y ingresa todos los campos del formulario y confirma la accion
     Entonces El usuario vera un mensaje exitoso

   @ScenarioName:AgregarCabeceraAlFormulario
   Escenario: Agregar cabecera al formulario
     Cuando navega hasta el formulario
     Y intenta enviar una solicitud sin agregar cabecera
     Entonces El usuario vera un mensaje de alerta
