package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage (WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
}
