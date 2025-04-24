package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(name = "login")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".alert-success")  // Locator for registration success message
    private WebElement successMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(String username, String password, String email) {
        waitForVisibility(usernameField).sendKeys(username);
        waitForVisibility(passwordField).sendKeys(password);
        waitForVisibility(confirmPasswordField).sendKeys(password);
        waitForVisibility(emailField).sendKeys(email);
        System.out.println("Current page: " + driver.getCurrentUrl());
        waitForClickable(submitButton).click();
    }

    public String getSuccessMessage() {
        return waitForVisibility(successMessage).getText();
    }
}