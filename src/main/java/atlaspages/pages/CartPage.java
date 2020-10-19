package atlaspages.pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartPage extends WebPage {

    @FindBy("//td[@class='cart_total']/span")
    AtlasWebElement cartPriceElement();

    @FindBy("//td[@class='cart_description']//p//a")
    AtlasWebElement cartNameElement();
}
