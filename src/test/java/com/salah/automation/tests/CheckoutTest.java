package com.salah.automation.tests;

import com.salah.automation.Base.BaseTest;
import com.salah.automation.pages.LoginPage;
import com.salah.automation.pages.ProductsPage;
import com.salah.automation.pages.CartPage;
import com.salah.automation.pages.CheckoutPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void completeCheckoutTest() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Add product
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(
            productsPage.getPageTitle(), "Products"
        );

        productsPage.addProductToCart();

        Assert.assertEquals(
            productsPage.getCartCount(), "1"
        );

        productsPage.openCart();

        // Step 3: Verify cart
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(
            cartPage.getProductName(),
            "Sauce Labs Backpack"
        );

        cartPage.clickCheckout();

        // Step 4: Enter customer details
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterCustomerDetails(
            "Test", "User", "411001"
        );

        checkoutPage.clickContinue();

        // Step 5: Verify checkout overview
        Assert.assertEquals(
            checkoutPage.getPageTitle(),
            "Checkout: Overview"
        );

        checkoutPage.clickFinish();

        // Step 6: Verify confirmation
        Assert.assertEquals(
            checkoutPage.getConfirmationMessage(),
            "Thank you for your order!"
        );

        System.out.println("Checkout Test Passed");
    }
}