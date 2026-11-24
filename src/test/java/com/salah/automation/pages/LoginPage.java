package com.salah.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.salah.automation.utils.WaitUtils;

public class LoginPage {

    private WaitUtils waitUtils;

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMessage =
        By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterUsername(String username) {
        waitUtils.type(usernameInput, username);
    }

    public void enterPassword(String password) {
        waitUtils.type(passwordInput, password);
    }

    public void clickLogin() {
        waitUtils.click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return waitUtils.getText(errorMessage);
    }
}