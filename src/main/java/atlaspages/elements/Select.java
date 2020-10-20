package atlaspages.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Select extends AtlasWebElement {

    @FindBy("//option[text()='{{ optionText }}']")
    AtlasWebElement optionByName(@Param("optionText") String optionText);
}
