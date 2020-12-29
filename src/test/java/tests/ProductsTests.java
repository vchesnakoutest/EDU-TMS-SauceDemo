package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPageFactory.openPage();
        loginPageFactory
                .login(USERNAME, PASSWORD)
                .addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .waitForPageOpened();
        Assert.assertTrue(cartPage.isProductAddedToCart("Sauce Labs Fleece Jacket", "1", "49.99"));
    }
}
