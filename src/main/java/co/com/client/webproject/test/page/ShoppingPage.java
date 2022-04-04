package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    @CacheLookup
    @FindBy(xpath = "//*[@title='Women']")
    WebElement women;

    @CacheLookup
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
    WebElement product1;

    @CacheLookup
    @FindBy(xpath = "//*[@id='center_column']/ul/li[2]/div/div[2]/h5/a")
    WebElement product2;

    @CacheLookup
    @FindBy(xpath = "//*[@id='center_column']/ul/li[7]/div/div[2]/h5/a")
    WebElement product3;

    @CacheLookup
    @FindBy(xpath = "(//*[contains(text(), 'Add to cart')]) [1]")
    WebElement addtocartproduct1;

    @CacheLookup
    @FindBy(xpath = "(//*[contains(text(), 'Add to cart')]) [2]")
    WebElement addtocartproduct2;

    @CacheLookup
    @FindBy(xpath = "(//*[contains(text(), 'Add to cart')]) [7]")
    WebElement addtocartproduct3;

    @CacheLookup
    @FindBy(xpath = "//*[@title='Continue shopping']")
    WebElement continueshoppingbtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
    WebElement cartbtn;

    public WebElement getWomen() {
        return women;
    }

    public WebElement getProduct1() {
        return product1;
    }

    public WebElement getProduct2() {
        return product2;
    }

    public WebElement getProduct3() {
        return product3;
    }

    public WebElement getAddtocartproduct1() {
        return addtocartproduct1;
    }

    public WebElement getAddtocartproduct2() {
        return addtocartproduct2;
    }

    public WebElement getAddtocartproduct3() {
        return addtocartproduct3;
    }

    public WebElement getContinueshoppingbtn() {
        return continueshoppingbtn;
    }

    public WebElement getCartbtn() {
        return cartbtn;
    }

    public ShoppingPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    }
}
