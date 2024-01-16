package org.POMwithFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;



public class LoginPage {

    private final WebDriver driver;


    @FindBy(id = "user-name")
    @CacheLookup
    private WebElement usernameInput;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindAll({
            @FindBy(id = "login-button"),
            @FindBy(css = "#login-button"),
            @FindBy(xpath = "//input[@id='login-button']")
    })
    @CacheLookup
    private List<WebElement> loginButtons;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginPageDisplayed() {
        return loginButton.isDisplayed();
    }

    public WebElement getSecondLoginButton() {
        return loginButtons.size() >= 2 ? loginButtons.get(1) : null;
    }
}
