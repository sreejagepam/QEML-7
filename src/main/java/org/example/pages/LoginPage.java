package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String username, String password) {
        waitForVisibility(usernameField).sendKeys(username);
        waitForVisibility(passwordField).sendKeys(password);
        waitForClickable(submitButton).click();
    }
}