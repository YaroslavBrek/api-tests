package pageobjects;

import helpers.PriceOrderChecker;
import helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SearchResultPage {

    private WebDriver driver;

    @FindBy(xpath = "//form[@id='productsSortForm']")
    private WebElement productSortDropdown;

    @FindBy
    private Select selectPriceSoring;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=order'][@title='Proceed to checkout']")
    private WebElement navigateToCheckout;

    @FindBy(xpath = "//ul[contains(@class, 'product_list')]"
            + "//div[@class='product-container']")
    private static List<WebElement> productsList;

    public SearchResultPage applyDescSorting() {
        Waiter.waitFor(2000);
        productSortDropdown.click();
        Waiter.waitFor(2000);
        selectPriceSoring = new Select(driver.findElement(
                By.xpath("//select[@id='selectProductSort']")));
        selectPriceSoring.selectByVisibleText("Price: Highest first");
        return this;
    }

    public SearchResultPage checkPriceSorting() {
        assertTrue(PriceOrderChecker.isDescOrdered(productsList));
        return this;
    }


    public String storeName() {
        String productNameXpath = ".//a[@class='product-name']";
        return productsList.get(0)
                .findElement(By.xpath(productNameXpath)).getText();
    }

    public static String storePrice() {
        String productPriceXpath = ".//div[./p[@class='product-desc']]"
                + "//span[@class='price product-price']";
        return productsList.get(0)
                .findElement(By.xpath(productPriceXpath)).getText();
    }

    public SearchResultPage clickAddToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(productsList.get(0)).build().perform();
        WebElement element = productsList.get(0).findElement(
                By.xpath(".//a[contains (@class, 'ajax_add_to_cart_button')]"));
        element.click();
        return this;
    }

    public CartPage navigateToCart() {
        Waiter.waitFor(3000);
        navigateToCheckout.click();
        return new CartPage(driver);
    }

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
