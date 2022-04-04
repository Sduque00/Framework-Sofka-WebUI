package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.model.ContactUs;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;


import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateContactUs;

public class ContactUsController {
    private WebAction webAction;
    private ContactUs contactUs;

    public ContactUs getContactUs() {
        return contactUs;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void llenarFormularioDeContactUs(){
        try {
            contactUs = generateContactUs(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.selectByText(contactUsPage.getHeading(),"Webmaster",true);
            webAction.sendText(contactUsPage.getEmail(),contactUs.getEmail(),2,true);
            webAction.sendText(contactUsPage.getOrder(),contactUs.getOrderReference(),2,true);
            webAction.sendText(contactUsPage.getMessage(),contactUs.getMessage(),2,true);
            webAction.click(contactUsPage.getSubmit(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar enviar el formulario de contact us", e);

        }
    }

    public void llenarFormularioSinCabecera(){
        try {
            contactUs = generateContactUs(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.sendText(contactUsPage.getEmail(),contactUs.getEmail(),2,true);
            webAction.sendText(contactUsPage.getOrder(),contactUs.getOrderReference(),2,true);
            webAction.sendText(contactUsPage.getMessage(),contactUs.getMessage(),2,true);
            webAction.click(contactUsPage.getSubmit(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar enviar el formulario de contact us sin cabecera", e);
        }
    }

    //For Assert

    public String isContactUsSent(){
        String contactUsSent = EMPTY_STRING;
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            contactUsSent = webAction.getText(contactUsPage.getContactUsValidation(), true).trim();
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar obtener el texto de la alerta de Contact Us"+ e);
        }
        return contactUsSent;
    }

    public String isContactUsSentWithoutHeading(){
        String headingAlert = EMPTY_STRING;
        try {
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            headingAlert = webAction.getText(contactUsPage.getContactUsAlert(), true).trim();
        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar obtener el texto de la alerta de cabecera"+ e);
        }
        return headingAlert;
    }
}
