package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void demoTest() {
        loginPageFactory.openPage();
        loginPageFactory.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isPageOpened());
    }
}
