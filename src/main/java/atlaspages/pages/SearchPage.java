package atlaspages.pages;

import atlaspages.elements.Header;
import atlaspages.elements.ProductItem;
import atlaspages.elements.Select;
import atlaspages.modals.AddToCartModal;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface SearchPage extends WebPage, Header {

    @FindBy("//li[contains(@class, 'ajax_block_product')]")
    ElementsCollection<ProductItem> items();

    @FindBy("//select[@id='selectProductSort']")
    Select priceSortingDropdown();

    @FindBy("//div[@id='layer_cart']")
    AddToCartModal addToCartModal();

}
