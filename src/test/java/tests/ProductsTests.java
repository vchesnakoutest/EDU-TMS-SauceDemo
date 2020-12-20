package tests;

import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.openPage();
        loginPage.login(loginPage.USERNAME, loginPage.PASSWORD);
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
    }
}
