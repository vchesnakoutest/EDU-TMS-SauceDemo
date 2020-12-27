package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public static final String PRODUCT_NAME = "//*[@class = 'inventory_item_name' and contains(text(), '%s')]";
    public static final String ANCESTOR_CART_ITEM = "/ancestor::*[@class='cart_item']";
    public static final String PRODUCT_QUANTITY = PRODUCT_NAME + ANCESTOR_CART_ITEM + "//*[@class = 'cart_quantity']";
    public static final String PRODUCT_PRICE = PRODUCT_NAME + ANCESTOR_CART_ITEM + "//*[@class = 'inventory_item_price']";

    public CartPage (WebDriver driver) {
        super(driver);
    }

    @Override
    void waitForPageOpened() {

    }

    public void openPage() {
        driver.get(SAUCE_DEMO_URL + CART_URL);
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductQuantity(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
    }

    public boolean isProductAddedToCart(String productName, String productQuantity, String productPrice) {
        boolean result = getProductQuantity(productName).equals(productQuantity);
        result &= getProductPrice(productName).equals(productPrice);
        return result;
    }
}
