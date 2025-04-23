package org.example.pages;

import org.example.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage extends BasePage {

    @FindBy(id = "field_name")
    private WebElement name;

    @FindBy(id = "field_balance")
    private WebElement balance;

//    @FindBy(id = "email")
//    private WebElement user;


    @FindBy(xpath = "//button[@id= 'save-entity']")
    private WebElement createButton;

//    @FindBy(css = ".alert-success")
//    private WebElement successMessage;

    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    public void createUser(String username, int userBalance) {
        waitForVisibility(name).sendKeys(username);
        waitForVisibility(balance).sendKeys(String.valueOf(userBalance));
        waitForClickable(createButton).click();
    }

//    public String getSuccessMessage() {
//        return waitForVisibility(successMessage).getText();
//    }
}
