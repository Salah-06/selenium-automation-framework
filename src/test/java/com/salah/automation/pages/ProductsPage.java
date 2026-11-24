package com.salah.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.salah.automation.utils.WaitUtils;

public class ProductsPage {

    private WaitUtils waitUtils;

    private By pageTitle = By.className("title");

    private By addToCartButton =
        By.id("add-to-cart-sauce-labs-backpack");

    private By cartBadge =
        By.className("shopping_cart_badge");

    private By cartIcon =
        By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.waitUtils = new WaitUtils(driver);
    }

    public String getPageTitle() {
        return waitUtils.getText(pageTitle);
    }

    public void addProductToCart() {
        waitUtils.click(addToCartButton);
    }

    public String getCartCount() {
        return waitUtils.getText(cartBadge);
    }

    public void openCart() {
        waitUtils.click(cartIcon);
    }
}