package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PriceOrderChecker {

    public static boolean isDescOrdered(List<WebElement> productsList){

        String oldPriceXpath = ".//div[./p[@class='product-desc']]"
                + "//span[contains(@class, 'old-price')]";
        String currentPriceXpath = ".//div[./p[@class='product-desc']]"
                + "//span[@class='price product-price']";

        List<String> prices = new ArrayList<String>();

        for (WebElement ele : productsList) {
            try {
                prices.add(ele.findElement(By.xpath(oldPriceXpath)).getText());
            } catch (org.openqa.selenium.NoSuchElementException e) {
                prices.add(
                        ele.findElement(By.xpath(currentPriceXpath)).getText());
            }
        }

        for (int i = 0; i < prices.size(); i++) {
            prices.set(i, prices.get(i).replace("$", ""));
        }
        boolean isSorted = true;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i).compareTo(prices.get(i - 1)) > 0) {
                isSorted = false;
                break;
            }
        }
        System.out.println(isSorted);
        return isSorted;
    }
}
