package atlaspages.pages;

import atlaspages.elements.Header;
import atlaspages.elements.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartPage extends WebPage, Header {

    @FindBy("//td[@class='cart_total']/span")
    HtmlElement cartPriceElement();

    @FindBy("//td[@class='cart_description']//p//a")
    HtmlElement cartNameElement();
}
