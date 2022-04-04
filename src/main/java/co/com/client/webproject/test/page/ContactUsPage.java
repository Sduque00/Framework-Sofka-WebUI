package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(xpath = "//select[@id='id_contact']")
    WebElement heading;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement order;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/p[5]/div/span[1]")
    WebElement fileUpload;

    @CacheLookup
    @FindBy(id = "message"  )
    WebElement message;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submitMessage']/span")
    WebElement submit;

    //For Assertion test case.

    @CacheLookup
    @FindBy(xpath = "//div[@id='center_column']/p")
    WebElement contactUsValidation;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/p")
    WebElement contactUsAlert;

    public WebElement getHeading() {
        return heading;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getOrder() {
        return order;
    }

    public WebElement getFileUpload() {
        return fileUpload;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getContactUsValidation() {
        return contactUsValidation;
    }

    public WebElement getContactUsAlert() {
        return contactUsAlert;
    }

    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
