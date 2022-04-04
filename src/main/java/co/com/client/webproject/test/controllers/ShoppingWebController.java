package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ShoppingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void agregarProductosAlCarrito(){
        try {
            ShoppingPage shoppingPage = new ShoppingPage(webAction.getDriver());

            webAction.click(shoppingPage.getWomen(),2,true);
            webAction.moveTo(shoppingPage.getProduct1(),true);
            webAction.clickNotVisible(shoppingPage.getAddtocartproduct1(),2,true);
            webAction.click(shoppingPage.getContinueshoppingbtn(),5,true);
            webAction.clickNotVisible(shoppingPage.getAddtocartproduct2(),2,true);
            webAction.click(shoppingPage.getContinueshoppingbtn(),5,true);
            webAction.moveTo(shoppingPage.getProduct3(),2,true);
            webAction.clickNotVisible(shoppingPage.getAddtocartproduct3(),2,true);
            webAction.click(shoppingPage.getContinueshoppingbtn(),5,true);
            webAction.click(shoppingPage.getCartbtn(),2,true);

        }catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar agregar productos al carrito", e);
        }
    }
}
