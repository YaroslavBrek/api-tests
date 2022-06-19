//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.*;
//import pageobjects.HomePage;
//import pageobjects.SearchResultPage;
//
//import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
//
//public class PageObjectTest {
//
//    private static final Logger logger = LogManager
//            .getLogger(PageObjectTest.class);
//
//    private ChromeOptions chromeOptions;
//    private WebDriverWait wait;
//    public static WebDriver driver;
//    public static HomePage homePage;
//
//    @DataProvider
//    public static Object[] searchValues() {
//        return new String[] { "Summer", "Dress", "t-shirt" };
//    }
//
//    @BeforeClass
//    public void initialize() {
//        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("disable-gpu");
//        chromeOptions.addArguments("start-maximized");
//        WebDriverManager.getInstance(CHROME).setup();
//        driver = new ChromeDriver(chromeOptions);
//        wait = new WebDriverWait(driver, 15);
//        homePage = new HomePage(driver);
//    }
//
//    @AfterClass
//    public void destroy() {
//        driver.quit();
//    }
//
//    @AfterMethod
//    public void deleteCookies() {
//        driver.manage().deleteAllCookies();
//    }
//
//    @Test(dataProvider = "searchValues")
//    public void testOne(String query) {
//
//        SearchResultPage searchResultPage = homePage.openHomePage()
//                .doSearchByQuery(query);
//
//        String expectedName = searchResultPage
//                .applyDescSorting()
//                .checkPriceSorting()
//                .storeName();
//
//        String expectedPrice = searchResultPage
//                .storePrice();
//
//        searchResultPage.clickAddToCart()
//                .navigateToCart()
//        .checkCartName(expectedName)
//        .checkCartPrice(expectedPrice);
//
//    }
//}
