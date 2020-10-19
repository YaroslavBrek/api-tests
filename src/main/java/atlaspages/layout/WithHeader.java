package atlaspages.layout;


import atlaspages.elements.Header;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {

    @FindBy("//header[@id='header']")
    Header header();
}
