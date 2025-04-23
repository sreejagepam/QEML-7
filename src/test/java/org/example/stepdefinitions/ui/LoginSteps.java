package org.example.stepdefinitions.ui;

import org.example.DriverManager;
import org.example.PageFactoryManager;
import io.cucumber.java.en.*;
import org.example.pages.UserPage;
import org.example.utils.UserBuilder;

import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps {

    @Given("the user is on the login page")
    public void navigateToAuthenticationPage() {
        DriverManager.getDriver().get("http://localhost:9000/login");
    }

    @When("the user enters username {string} and password {string}")
    public void enterAuthenticationCredentials(String username, String password) {
        UserPage user = new UserBuilder()
                .withUsername(username)
                .withPassword(password)
                .build();

        PageFactoryManager.getLoginPage(DriverManager.getDriver())
                .login(user.getUsername(), user.getPassword());
    }

    @Then("the user successfully logs in")
    public void verifyAuthenticationSuccess() {
        // Add verification logic
//        WebElement successMsg = DriverManager.getDriver().findElement(By.id("home-logged-message"));
//        String actualText = successMsg.getText();
//        assertEquals(actualText, "You are logged in as user \"admin\".",
//                "Authentication success message does not match!");
    }
}
