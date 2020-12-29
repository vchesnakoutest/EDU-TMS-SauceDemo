package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    @Override
    LoginPage waitForPageOpened() {
        return this;
    }

    /**
     * Login to the site
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    /**
     * Open login page
     */
    public void openPage() {
        driver.get(SAUCE_DEMO_URL);
    }
}
