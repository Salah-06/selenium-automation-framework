package com.salah.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.salah.automation.utils.WaitUtils;

public class CheckoutPage {

    private WaitUtils waitUtils;

    private By firstName = By.id("first-name");

    private By lastName = By.id("last-name");

    private By postalCode = By.id("postal-code");

    private By continueButton = By.id("continue");

    private By finishButton = By.id("finish");

    private By pageTitle = By.className("title");

    private By confirmationMessage =
        By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterCustomerDetails(
        String fname,
        String lname,
        String zipcode
    ) {
        waitUtils.type(firstName, fname);
        waitUtils.type(lastName, lname);
        waitUtils.type(postalCode, zipcode);
    }

    public void clickContinue() {
        waitUtils.click(continueButton);
    }

    public String getPageTitle() {
        return waitUtils.getText(pageTitle);
    }

    public void clickFinish() {
        waitUtils.click(finishButton);
    }

    public String getConfirmationMessage() {
        return waitUtils.getText(confirmationMessage);
    }
}