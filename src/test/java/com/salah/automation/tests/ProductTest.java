package com.salah.automation.tests;

import com.salah.automation.Base.BaseTest;
import com.salah.automation.pages.LoginPage;
import com.salah.automation.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductTest extends BaseTest {
    
    @Test
    public void addToCartTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(
            productsPage.getPageTitle(), "Products"
        );

        productsPage.addProductToCart();

        Assert.assertEquals(
            productsPage.getCartCount(), "1"
        );
    }
}