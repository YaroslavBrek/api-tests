package atlaspages.helpers;

import atlaspages.elements.ProductItem;
import io.qameta.atlas.webdriver.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

public class PriceChecker {

    public static boolean isDescOrdered(
            ElementsCollection<ProductItem> productsList){

        List<String> prices = new ArrayList<>();

        for (ProductItem ele : productsList) {
            try {
                prices.add(ele.oldPrice().getText());
            } catch (org.openqa.selenium.NoSuchElementException e) {
                prices.add(
                        ele.currentPrice().getText());
            }
        }

        boolean isSorted = true;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i).compareTo(prices.get(i - 1)) > 0) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
