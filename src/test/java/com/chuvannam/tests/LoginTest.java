package com.chuvannam.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chuvannam.pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {

        loginPage.enterCredentials(
                "standard_user",
                "secret_sauce"
        );

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login failed!"
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}