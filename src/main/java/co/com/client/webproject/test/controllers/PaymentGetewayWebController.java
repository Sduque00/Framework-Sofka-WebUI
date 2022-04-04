package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.PaymentGatewayPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.EMPTY_STRING;

public class PaymentGetewayWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void pagarCarritoDeCompras(){
        try {
            PaymentGatewayPage paymentGatewayPage = new PaymentGatewayPage(webAction.getDriver());
            CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
            createAnAccountWebController.setWebAction(webAction);

            webAction.click(paymentGatewayPage.getProcessCheckoutbtn(),2,true);
            createAnAccountWebController.crearUnaCuenta();
            webAction.click(paymentGatewayPage.getProcessAddressbtn(),2,true);
            webAction.click(paymentGatewayPage.getTermsOfServicecb(),2,true);
            webAction.click(paymentGatewayPage.getProcessCarrierbtn(),2,true);
            webAction.click(paymentGatewayPage.getPaymentbtn(),2,true);
            webAction.click(paymentGatewayPage.getConfirmOrderbtn(),2,true);


        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar hacer el pago del carrito de compras", e);
        }
    }

    public void procederAlCheckoutSinAceptarTerminos(){
        try {
            PaymentGatewayPage paymentGatewayPage = new PaymentGatewayPage(webAction.getDriver());
            CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
            createAnAccountWebController.setWebAction(webAction);

            webAction.click(paymentGatewayPage.getProcessCheckoutbtn(),2,true);
            createAnAccountWebController.crearUnaCuenta();
            webAction.click(paymentGatewayPage.getProcessAddressbtn(),2,true);
            webAction.click(paymentGatewayPage.getProcessCarrierbtn(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar proceder al pago sin los terminos", e);
        }

    }

    //For Assert

    public String isOrderComplete(){
        String orderComplete = EMPTY_STRING;
        try {
            PaymentGatewayPage paymentGatewayPage = new PaymentGatewayPage(webAction.getDriver());
            orderComplete = webAction.getText(paymentGatewayPage.getOrderComplete(),true).trim();
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar obtener el texto de la orden completada"+ e);
        }
        return orderComplete;
    }

    public String proceedWithoutAcceptingTerms(){
        String alertTermsOfService = EMPTY_STRING;
        try {
            PaymentGatewayPage paymentGatewayPage = new PaymentGatewayPage(webAction.getDriver());
            alertTermsOfService = webAction.getText(paymentGatewayPage.getTermsOfServiceAlert(),true).trim();
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar obtener el texto de la alerta de terminos del servicio"+ e);
        }
        return alertTermsOfService;
    }
}
