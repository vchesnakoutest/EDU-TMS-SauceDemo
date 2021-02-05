package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import test_data.TestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest implements TestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPageFactory loginPageFactory;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().version("88.0.4324.27").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if (System.getProperty("headless").equals("true")) {
            chromeOptions.addArguments("headless");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}
