package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {

    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @Override
    void waitForPageOpened() {
    }

    public void openPage() {
        openPage();
    }

    public void demoWithoutPageFactoryTest() {
        openPage("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButtonElement = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButtonElement.click();
        WebElement deleteButtonElement = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButtonElement.click();
        addButtonElement.click();
        deleteButtonElement.click();
    }

    public void demoWithPageFactoryTest() {
        openPage("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButtonElement = addButton;
        addButtonElement.click();
        WebElement deleteButtonElement = deleteButton;
        deleteButtonElement.click();
        addButtonElement.click();
        deleteButtonElement.click();
    }

}
