package atlaspages.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Select extends AtlasWebElement<Select> {

    @FindBy(".//option[text()='{{ optionText }}']")
    HtmlElement optionByName(@Param("optionText") String optionText);
}
