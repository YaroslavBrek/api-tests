package pageobjects;

import interfaces.PropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    PropertyLoader config = ru.qatools.properties.PropertyLoader.newInstance()
            .populate(PropertyLoader.class);

    private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(xpath = "//button[@name='submit_search']")
    private WebElement searchButton;

    public SearchResultPage doSearchByQuery(String query) {
        searchField.sendKeys(query);
        searchButton.click();
        return new SearchResultPage(this.driver);
    }

    public HomePage openHomePage() {
        driver.get(config.getUrl());
        return this;
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
