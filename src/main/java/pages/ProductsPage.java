package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text() = '%s']/ancestor::*[@class='inventory_item']//button";
    public static final By PRODUCT_LABEL = By.xpath("//*[contains(text(),'Product')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage waitForPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL));
        } catch (TimeoutException exception) {
            Assert.fail(String.format("Products page in not loaded! Locator: '%s' was not found!", PRODUCT_LABEL));
        }
        return this;
    }

    public boolean isPageOpened() {
        return driver.findElement(PRODUCT_LABEL).isDisplayed();
    }

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    public ProductsPage openPage() {
        openPage(SAUCE_DEMO_URL + PRODUCTS_URL);
        return this;
    }
}
