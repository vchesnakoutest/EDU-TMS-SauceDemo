package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropReader;

public class ProductsTests extends BaseTest {

    @Test
    public void addProductToCartChainTest() {
        loginPage
                .openPage()
                .login(System.getenv().getOrDefault("username", PropReader.getProperty("username")), System.getenv().getOrDefault("password", PropReader.getProperty("password")))
                .addProductToCart("Sauce Labs Fleece Jacket");
        productsPage.openPage();
        productsPage.waitForPageOpened();
        Assert.assertTrue(productsPage.isPageOpened());
    }

    @Test
    public void addProductToCartTest() {
        productsPage.openPage();
        productsPage.waitForPageOpened();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        Assert.assertTrue(cartPage.isProductAddedToCart("Sauce Labs Fleece Jacket", "1", "49.99"));
    }
}
