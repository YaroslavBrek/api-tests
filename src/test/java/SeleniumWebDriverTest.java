//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
//
//public class SeleniumWebDriverTest extends Assert {
//
//    private static final Logger logger = LogManager
//            .getLogger(SeleniumWebDriverTest.class);
//
//    private ChromeOptions chromeOptions;
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//
//    @BeforeMethod
//    public void initialize() {
//        WebDriverManager.getInstance(CHROME).setup();
//        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("disable-gpu");
//        chromeOptions.addArguments("start-maximized");
//        //        chromeOptions.addArguments("headless");
//        driver = new ChromeDriver(chromeOptions);
//        wait = new WebDriverWait(driver, 15);
//        driver.get("http://automationpractice.com/");
//    }
//
//    @DataProvider
//    public static Object[] searchValues() {
//        return new String[] { "Summer", "Dress", "t-shirt" };
//    }
//
//    @Test(dataProvider = "searchValues")
//    public void testTest(String searchData) {
//
//        // Get the search input field and search by "Summer"
//        WebElement searchField = driver.findElement(By.id("search_query_top"));
//        searchField.sendKeys(searchData);
//
//        WebElement searchButton = driver
//                .findElement(By.xpath("//button[@name='submit_search']"));
//        searchButton.click();
//
//        // Sorting by highest price
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//form[@id='productsSortForm']")));
//
//        Select priceSorting = new Select(driver.findElement(
//                By.xpath("//select[@id='selectProductSort']")));
//        priceSorting.selectByVisibleText("Price: Highest first");
//
//        // Get all products as list of elements
//        List<WebElement> productsList = driver.findElements(By.xpath(
//                "//ul[contains(@class, 'product_list')]"
//                        + "//div[@class='product-container']"));
//
//        // Get all product prices as list
//        String oldPriceXpath = ".//div[./p[@class='product-desc']]"
//                + "//span[contains(@class, 'old-price')]";
//        String currentPriceXpath = ".//div[./p[@class='product-desc']]"
//                + "//span[@class='price product-price']";
//        List<String> prices = new ArrayList<String>();
//
//        //Store all ordered prices
//        for (WebElement ele : productsList) {
//            try {
//                prices.add(ele.findElement(By.xpath(oldPriceXpath)).getText());
//            } catch (org.openqa.selenium.NoSuchElementException e) {
//                prices.add(
//                        ele.findElement(By.xpath(currentPriceXpath)).getText());
//            }
//        }
//        for (int i = 0; i < prices.size(); i++) {
//            prices.set(i, prices.get(i).replace("$", ""));
//        }
//        boolean isSorted = true;
//        for (int i = 1; i < prices.size(); i++) {
//            if (prices.get(i).compareTo(prices.get(i - 1)) > 0) {
//                isSorted = false;
//                break;
//            }
//        }
//        System.out.println(prices.toString());
//
//        //Verify, prices are actually desc
//        assertTrue(isSorted);
//
//        WebElement firstProductInTheList = productsList.get(0);
//        String productNameXpath = ".//a[@class='product-name']";
//        String productPriceXpath = ".//div[./p[@class='product-desc']]"
//                + "//span[@class='price product-price']";
//
//        String name = firstProductInTheList
//                .findElement(By.xpath(productNameXpath)).getText();
//        String price = firstProductInTheList
//                .findElement(By.xpath(productPriceXpath)).getText()
//                .replace("$", "");
//
//        //Add to cart the first product item
//        Actions action = new Actions(driver);
//        action.moveToElement(firstProductInTheList).build().perform();
//        WebElement firstItemLink = firstProductInTheList.findElement(By.xpath(
//                ".//a[contains (@class, 'ajax_add_to_cart_button')]"));
//        firstItemLink.click();
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//a[@class='btn btn-default button button-medium']")))
//                .click();
//
//        // Get the product's name and price in the cart
//        String cartPrice = driver
//                .findElement(By.xpath("//td[@class='cart_total']/span"))
//                .getText().replace("$", "");
//        String cartName = driver
//                .findElement(By.xpath("//td[@class='cart_description']//p//a"))
//                .getText();
//
//        //Verify, the price and name are the same
//        assertEquals(name, cartName);
//        assertEquals(price, cartPrice);
//    }
//}