package org.POMwithFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private final WebDriver driver;


    @FindBy(className = "inventory_item_name")
    @CacheLookup
    private WebElement productLabel;

    @FindBy(id = "react-burger-menu-btn")
    @CacheLookup
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    @CacheLookup
    private WebElement logoutButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    @CacheLookup
    private WebElement errorLabel;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDisplayed() {
        try {
            return productLabel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        menuButton.click();
        logoutButton.click();
    }
}
