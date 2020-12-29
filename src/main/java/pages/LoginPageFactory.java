package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;
    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @Override
    LoginPageFactory waitForPageOpened() {
        return this;
    }

    /**
     * Login to the site
     *  @param username
     * @param password
     * @return
     */
    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public LoginPageFactory loginWithIncorrectData(String username, String password) {
        login(username, password);
        return this;
    }

    /**
     * Open login page
     */
    public void openPage() {
        driver.get(SAUCE_DEMO_URL);
    }
}
