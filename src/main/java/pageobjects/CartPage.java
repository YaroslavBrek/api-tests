package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//td[@class='cart_total']/span")
    private WebElement cartPriceElement;

    @FindBy(xpath = "//td[@class='cart_description']//p//a")
    private WebElement cartNameElement;

    public CartPage checkCartName(String expectedName) {
        assertEquals(expectedName, cartNameElement.getText());
        return this;
    }

    public CartPage checkCartPrice(String expectedName) {
        assertEquals(expectedName, cartPriceElement.getText());
        return this;
    }

}
