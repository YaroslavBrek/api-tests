import atlaspages.pages.CartPage;
import atlaspages.pages.HomePage;
import atlaspages.pages.SearchPage;
import helpers.PriceOrderChecker;
import interfaces.PropertyLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AtlasTest {

    @DataProvider
    public static Object[] searchValues() {
        return new String[] { "Summer", "Dress", "t-shirt" };
    }

    private WebDriver driver;
    private Atlas atlas;

    PropertyLoader config = ru.qatools.properties.PropertyLoader.newInstance()
            .populate(PropertyLoader.class);

    @BeforeClass
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver));
    }

    @Test(dataProvider = "searchValues")
    public void testOne(String query) {
        onHomePage().open(config.getUrl());
        onHomePage().header().searchInput().sendKeys(query);
        onHomePage().header().searchInput().submit();
        onSearchPage().productSortDropdown().click();
        onSearchPage().selectPriceSoring().click();

        assertTrue(PriceOrderChecker.isDescOrdered(onSearchPage().items()));

        String expectedName = onSearchPage().expectedName().getText();
        String expectedPrice = onSearchPage().expectedPrice().getText();

        onSearchPage().addToCart().click();
        onSearchPage().navigateToCheckout().click();

        String cartPrice = onCartPage().cartPriceElement().getText();
        String cartName = onCartPage().cartNameElement().getText();

        assertEquals(cartName, expectedName);
        assertEquals(cartPrice, expectedPrice);

    }

    private HomePage onHomePage() {
        return onPage(HomePage.class);
    }

    private SearchPage onSearchPage() {
        return onPage(SearchPage.class);
    }

    private CartPage onCartPage() {
        return onPage(CartPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    @AfterClass
    public void stopDriver() {
        this.driver.quit();
    }

    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }
}
