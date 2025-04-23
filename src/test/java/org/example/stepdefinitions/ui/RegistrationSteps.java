package org.example.stepdefinitions.ui;

import org.example.DriverManager;
import org.example.PageFactoryManager;
import org.example.pages.UserPage;
import org.example.utils.UserBuilder;
import org.example.pages.RegisterPage;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class RegistrationSteps {

    private RegisterPage registerPage;

    @Given("the user is on the registration page")
    public void navigateToRegistrationPage() {
        DriverManager.getDriver().get("http://localhost:9000/account/register");
        registerPage = PageFactoryManager.getRegisterPage(DriverManager.getDriver());
        System.out.println("Arrived at: " + DriverManager.getDriver().getCurrentUrl());
//        registerPage = new RegisterPage(DriverManager.getDriver());
    }

    @When("the user enters valid registration details with username {string}, password {string}, confirm password {string} and email {string}")
    public void enterRegistrationDetails(String username, String password, String confirmPassword, String email) {
        UserPage user = new UserBuilder()
                .withUsername(username)
                .withPassword(password)
                .withConfirmPassword(confirmPassword)
                .withEmail(email)
                .build();
        registerPage.fillRegistrationForm(user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Then("the user account is created successfully")
    public void verifyAccountCreation() {
        String successMessage = registerPage.getSuccessMessage();
        assertEquals(successMessage, "Registration saved! Please check your email for confirmation.", "Account creation failed!");
    }
}
