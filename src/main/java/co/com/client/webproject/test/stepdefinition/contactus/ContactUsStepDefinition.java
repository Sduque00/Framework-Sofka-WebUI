package co.com.client.webproject.test.stepdefinition.contactus;

import co.com.client.webproject.test.controllers.ContactUsController;
import co.com.client.webproject.test.controllers.LoginPageController;
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

import static co.com.client.webproject.test.helpers.Dictionary.CONTACT_US_SENT;
import static co.com.client.webproject.test.helpers.Dictionary.HEADING_ALERT;

public class ContactUsStepDefinition extends Setup {

    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("Que el cliente se encuentra en la tienda virtual")
    public void queElClienteSeEncuentraEnLaTiendaVirtual() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

    }
    @Cuando("navega hasta el formulario de contact us")
    public void navegaHastaElFormularioDeContactUs() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaContactUsPage();

    }
    @Cuando("ingresa todos los campos del formulario y confirma la accion")
    public void ingresaTodosLosCamposDelFormularioYConfirmaLaAccion() {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.llenarFormularioDeContactUs();
    }
    @Entonces("El usuario vera un mensaje exitoso")
    public void elUsuarioVeraUnMensajeExitoso() {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        String contactUsSent = contactUsController.isContactUsSent();

        Assert
                .Hard
                .thatString(contactUsSent)
                .isEqualTo(CONTACT_US_SENT);

    }

//Agregar cabecera al formulario

    @Cuando("navega hasta el formulario")
    public void navegaHastaElFormulario() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaContactUsPage();
    }
    @Cuando("intenta enviar una solicitud sin agregar cabecera")
    public void intentaEnviarUnaSolicitudSinAgregarCabecera() {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.llenarFormularioSinCabecera();
    }
    @Entonces("El usuario vera un mensaje de alerta")
    public void elUsuarioVeraUnMensajeDeAlerta() {
        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        String headingAlert = contactUsController.isContactUsSentWithoutHeading();

        Assert
                .Hard
                .thatString(headingAlert)
                .isEqualTo(HEADING_ALERT);
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
