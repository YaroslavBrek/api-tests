package atlaspages.pages;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public interface SearchPage extends WebPage {

    @FindBy("//ul[contains(@class, 'product_list')]//div[@class='product-container']")
    List<WebElement> items();

    @FindBy("//option[@value='price:desc']")
    AtlasWebElement selectPriceSoring();

    @FindBy("//form[@id='productsSortForm']")
    AtlasWebElement productSortDropdown();

    @FindBy("//li[contains(@class, 'ajax_block_product')][1]//a[@class='product-name']")
    AtlasWebElement expectedName();

    @FindBy("//li[contains(@class, 'ajax_block_product')][1]//div[@class='right-block']//span[@class='price product-price']")
    AtlasWebElement expectedPrice();

    @FindBy("//li[contains(@class, 'ajax_block_product')][1]//a[contains(@class, 'ajax_add_to_cart_button')]")
    AtlasWebElement addToCart();

    @FindBy("//a[@href='http://automationpractice.com/index.php?controller=order'][@title='Proceed to checkout']")
    AtlasWebElement navigateToCheckout();
}
