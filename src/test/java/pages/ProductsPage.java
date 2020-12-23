package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    public static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text() = '%s']/ancestor::*[@class='inventory_item']//button";
    public static final By PRODUCT_LABEL = By.xpath("//*[contains(text(),'Product')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL));
    }

    public boolean isPageOpened() {
        return driver.findElement(PRODUCT_LABEL).isDisplayed();
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }
}
