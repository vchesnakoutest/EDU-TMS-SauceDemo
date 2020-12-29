package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@class = 'btn_action checkout_button']");
    public static final String PRODUCT_NAME_ANCESTOR = "//*[text() = '%s']/ancestor::*[@class='cart_item']";
    public static final String PRODUCT_QUANTITY = PRODUCT_NAME_ANCESTOR + "//*[@class='cart_quantity']";
    public static final String PRODUCT_PRICE = PRODUCT_NAME_ANCESTOR + "//*[@class='inventory_item_price']";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
    }

    public CartPage openPage() {
        openPage(SAUCE_DEMO_URL + CART_URL);
        return this;
    }

    public String getProductQuantity(String productName) {
        String productQuantity = driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
        System.out.println("Product quantity is: " + productQuantity);
        return productQuantity;
    }

    public String getProductPrice(String productName) {
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        System.out.println("Product price is: " + productPrice);
        return productPrice;
    }

    public boolean isProductAddedToCart(String productName, String productQuantity, String productPrice) {
        boolean result = getProductQuantity(productName).equals(productQuantity);
        result &= getProductPrice(productName).equals(productPrice);
        return result;
    }
}
