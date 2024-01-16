package org.POMwithFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void loginAndVerifyHomepage() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isProductDisplayed());
    }

    @Test(priority = 2)
    public void logoutFromHomepage() {
        homePage.logout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
    @Test(priority = 3)
    public void accessSecondLoginButton() {
        WebElement secondLoginButton = loginPage.getSecondLoginButton();
        Assert.assertNotNull(secondLoginButton);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
