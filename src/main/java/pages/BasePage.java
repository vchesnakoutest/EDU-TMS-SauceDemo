package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage implements Constants {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    abstract BasePage waitForPageOpened();

    public void openPage(String url) {
        driver.get(url);
    }
}
