package com.salah.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.salah.automation.utils.WaitUtils;

public class CartPage {

    private WaitUtils waitUtils;

    private By productName =
        By.className("inventory_item_name");

    private By checkoutButton =
        By.id("checkout");

    public CartPage(WebDriver driver) {
        this.waitUtils = new WaitUtils(driver);
    }

    public String getProductName() {
        return waitUtils.getText(productName);
    }

    public void clickCheckout() {
        waitUtils.click(checkoutButton);
    }
}