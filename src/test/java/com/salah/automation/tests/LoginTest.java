// package com.salah.automation.tests;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import java.time.Duration;
// public class LoginTest {

//     public static void main(String[] args) {

//         WebDriver driver = new ChromeDriver();

//         try {
//             driver.manage().window().maximize();

//             driver.get("https://www.saucedemo.com/");

//             WebDriverWait wait =
//                 new WebDriverWait(driver, Duration.ofSeconds(10));

//             WebElement username = wait.until(
//                 ExpectedConditions.visibilityOfElementLocated(
//                     By.id("user-name")
//                 )
//             );
//                 System.out.println("username is"+username);

//             username.sendKeys("standard_user");

//             driver.findElement(By.id("password"))
//                   .sendKeys("secret_sauce");

//             driver.findElement(By.id("login-button"))
//                   .click();

//             WebElement productsTitle = wait.until(
//                 ExpectedConditions.visibilityOfElementLocated(
//                     By.className("title")
//                 )
//             );
//                 System.out.println("productsTitle is"+productsTitle);

//             if (productsTitle.getText().equals("Products")) {
//                 System.out.println("Login Test Passed!");
//             } else {
//                 System.out.println("Login Test Failed!");
//             }

//         } finally {
//             driver.quit();
//         }
//     }
// }



package com.salah.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.salah.automation.pages.LoginPage;
import com.salah.automation.pages.ProductsPage;
import com.salah.automation.Base.BaseTest;
import org.testng.annotations.DataProvider;
import java.time.Duration;

public class LoginTest extends BaseTest  {

    @DataProvider(name = "loginData")
public Object[][] getLoginData() {
    return new Object[][] {
        {"standard_user", "secret_sauce", true,
            "Products"},

        {"wrong_user", "wrong_password", false,
            "Epic sadface: Username and password do not match any user in this service"},

        {"locked_out_user", "secret_sauce", false,
            "Epic sadface: Sorry, this user has been locked out."},

        {"standard_user", "wrong_password", false,
            "Epic sadface: Username and password do not match any user in this service"},

        {"", "secret_sauce", false,
            "Epic sadface: Username is required"},

        {"standard_user", "", false,
            "Epic sadface: Password is required"}
    };
}

    // @Test
    // public void validLoginTest() {

    //     driver.findElement(By.id("user-name"))
    //           .sendKeys("standard_user");

    //     driver.findElement(By.id("password"))
    //           .sendKeys("secret_sauce");

    //     driver.findElement(By.id("login-button"))
    //           .click();

    //     WebDriverWait wait = new WebDriverWait(
    //         driver, Duration.ofSeconds(10)
    //     );

    //     String actualTitle = wait.until(
    //         ExpectedConditions.visibilityOfElementLocated(
    //             By.className("title")
    //         )
    //     ).getText();

    //     Assert.assertEquals(actualTitle, "Products");
    // }

    // @Test
    // public void invalidLoginTest() {

    //     driver.findElement(By.id("user-name"))
    //           .sendKeys("wrong_user");

    //     driver.findElement(By.id("password"))
    //           .sendKeys("wrong_password");

    //     driver.findElement(By.id("login-button"))
    //           .click();

    //     String actualError = driver.findElement(
    //         By.cssSelector("[data-test='error']")
    //     ).getText();

    //     Assert.assertTrue(
    //         actualError.contains("Username and password do not match")
    //     );
    // }
//     @Test(dataProvider = "loginData")
// public void loginDataTest(String username,
//                           String password,
//                           boolean expectedResult, String expectedMessage) {

//     driver.findElement(By.id("user-name"))
//           .sendKeys(username);

//     driver.findElement(By.id("password"))
//           .sendKeys(password);

//     driver.findElement(By.id("login-button"))
//           .click();

//     WebDriverWait wait = new WebDriverWait(
//         driver, Duration.ofSeconds(10)
//     );

//     if (expectedResult) {

//         String actualTitle = wait.until(
//             ExpectedConditions.visibilityOfElementLocated(
//                 By.className("title")
//             )
//         ).getText();

//         Assert.assertEquals(actualTitle, expectedMessage);

//     } else {

//         String actualError = wait.until(
//             ExpectedConditions.visibilityOfElementLocated(
//                 By.cssSelector("[data-test='error']")
//             )
//         ).getText();

//         Assert.assertEquals(actualError, expectedMessage);
//     }
// }

@Test(dataProvider = "loginData")
public void AllLoginTest(
    String username,
    String password,
    Boolean expectedResult,
    String expectedMessage
) {

    LoginPage loginPage = new LoginPage(driver);

    loginPage.login(username, password);

if (expectedResult) {

    ProductsPage productsPage = new ProductsPage(driver);

    Assert.assertEquals(
        productsPage.getPageTitle(),
        expectedMessage
    );

} else {

    Assert.assertEquals(
        loginPage.getErrorMessage(),
        expectedMessage
    );
}
}
}
