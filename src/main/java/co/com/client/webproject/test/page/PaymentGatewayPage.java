package co.com.client.webproject.test.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentGatewayPage {

    @CacheLookup
    @FindBy(xpath = "(//*[@title='Proceed to checkout'])[2]")
    WebElement processCheckoutbtn;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button")
    WebElement processAddressbtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='uniform-cgv']")
    WebElement termsOfServicecb;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/p/button")
    WebElement processCarrierbtn;

    @CacheLookup
    @FindBy(xpath = "//*[@title='Pay by bank wire']")
    WebElement paymentbtn;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button")
    WebElement confirmOrderbtn;

    //For Assertion test case.

    @CacheLookup
    @FindBy(xpath = "(//*[@class = 'dark'])[6]")
    WebElement orderComplete;

    @CacheLookup
    @FindBy(xpath = "//*[@class='fancybox-error']")
    WebElement termsOfServiceAlert;


    public WebElement getProcessCheckoutbtn() {
        return processCheckoutbtn;
    }

    public WebElement getProcessAddressbtn() {
        return processAddressbtn;
    }

    public WebElement getTermsOfServicecb() {
        return termsOfServicecb;
    }

    public WebElement getProcessCarrierbtn() {
        return processCarrierbtn;
    }

    public WebElement getPaymentbtn() {
        return paymentbtn;
    }

    public WebElement getConfirmOrderbtn() {
        return confirmOrderbtn;
    }

    public WebElement getOrderComplete() {
        return orderComplete;
    }

    public WebElement getTermsOfServiceAlert() {
        return termsOfServiceAlert;
    }

    public PaymentGatewayPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }


}
