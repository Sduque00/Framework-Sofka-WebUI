package co.com.client.webproject.test.stepdefinition.shoppingcart;


import co.com.client.webproject.test.controllers.PaymentGetewayWebController;
import co.com.client.webproject.test.controllers.ShoppingWebController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.client.webproject.test.helpers.Dictionary.PAYMENT_CONFIRMATION;
import static co.com.client.webproject.test.helpers.Dictionary.TERM_OF_SERVICE_ALERT;


public class ShoppingCartStepDefinition extends Setup {

    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente se encuentra en la tienda virtual")
    public void queElClienteSeEncuentraEnLaTiendaVirtual() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Cuando("agrega articulos al carrito y paga la factura")
    public void agregaArticulosAlCarritoYPagaLaFactura() {
        ShoppingWebController shoppingWebController = new ShoppingWebController();
        shoppingWebController.setWebAction(webAction);
        shoppingWebController.agregarProductosAlCarrito();

        PaymentGetewayWebController paymentGetewayWebController = new PaymentGetewayWebController();
        paymentGetewayWebController.setWebAction(webAction);
        paymentGetewayWebController.pagarCarritoDeCompras();

    }

    @Entonces("el cliente vera en pantalla un mensaje de confirmacion")
    public void elClienteVeraEnPantallaUnMensajeDeConfirmacion() {
        PaymentGetewayWebController paymentGetewayWebController = new PaymentGetewayWebController();
        paymentGetewayWebController.setWebAction(webAction);
        String oderComplete = paymentGetewayWebController.isOrderComplete();

        Assert
                .Hard
                .thatString(oderComplete)
                .isEqualTo(PAYMENT_CONFIRMATION);
    }

   //Aceptar los terminos del servicio.

    @Cuando("agrega articulos al carrito")
    public void agregaArticulosAlCarrito() {
        ShoppingWebController shoppingWebController = new ShoppingWebController();
        shoppingWebController.setWebAction(webAction);
        shoppingWebController.agregarProductosAlCarrito();

    }
    @Cuando("intenta pagar la factura sin aceptar los terminos del servicio")
    public void intentaPagarLaFacturaSinAceptarLosTerminosDelServicio() {
        PaymentGetewayWebController paymentGetewayWebController = new PaymentGetewayWebController();
        paymentGetewayWebController.setWebAction(webAction);
        paymentGetewayWebController.procederAlCheckoutSinAceptarTerminos();

    }
    @Entonces("el clinte vera en pantalla una alerta")
    public void elClinteVeraEnPantallaUnaAlerta() {
        PaymentGetewayWebController paymentGetewayWebController = new PaymentGetewayWebController();
        paymentGetewayWebController.setWebAction(webAction);
        String termsOfServiceAlert = paymentGetewayWebController.proceedWithoutAcceptingTerms();

        Assert
                .Hard
                .thatString(termsOfServiceAlert)
                .isEqualTo(TERM_OF_SERVICE_ALERT);
    }


    @After
    public void cerrarDriver() throws InterruptedException {

        Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
