package atlaspages.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement<Header> {

    @FindBy("//input[@id='search_query_top']")
    HtmlElement searchInput();
}
