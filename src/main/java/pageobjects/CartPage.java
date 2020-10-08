package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private static String cartPrice;
    private static String cartName;
    private WebDriver driver;

    public static String getCartPrice() {
        return cartPrice;
    }

    public static String getCartName() {
        return cartName;
    }

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//td[@class='cart_total']/span")
    private WebElement cartPriceElement;

    @FindBy(xpath = "//td[@class='cart_description']//p//a")
    private WebElement cartNameElement;

    public void getCartPriceAndName(){
        cartName = cartNameElement.getText();
        cartPrice = cartPriceElement.getText();
    }

}
