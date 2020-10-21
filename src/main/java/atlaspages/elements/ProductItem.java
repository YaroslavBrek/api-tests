package atlaspages.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductItem extends AtlasWebElement<ProductItem> {

    @FindBy(".//div[@class='right-block']//span[@class='price product-price']")
    HtmlElement expectedPrice();

    @FindBy(".//a[@class='product-name']")
    HtmlElement expectedName();

    @FindBy(".//a[contains(@class, 'ajax_add_to_cart_button')]")
    HtmlElement addToCart();

    @FindBy(".//div[./p[@class='product-desc']]//span[contains(@class, 'old-price')]")
    HtmlElement oldPrice();

    @FindBy(".//div[./p[@class='product-desc']]//span[@class='price product-price']")
    HtmlElement currentPrice();
}
