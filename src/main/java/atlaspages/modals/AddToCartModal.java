package atlaspages.modals;

import atlaspages.elements.Header;
import atlaspages.elements.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddToCartModal extends AtlasWebElement<AddToCartModal> {

    @FindBy(".//a[@href='http://automationpractice.com/index.php?controller=order'][@title='Proceed to checkout']")
    HtmlElement navigateToCheckout();

}
