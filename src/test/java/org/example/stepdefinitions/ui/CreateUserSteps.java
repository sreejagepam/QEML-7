package org.example.stepdefinitions.ui;

import io.cucumber.java.en.*;
import org.example.DriverManager;
import org.example.PageFactoryManager;
import org.example.pages.CreateUserPage;
import org.example.pages.LoginPage;


import static org.testng.Assert.assertEquals;
import static org.example.utils.NavigateToBankAccount.goToCreateNewBankAccount;
public class CreateUserSteps {

    private CreateUserPage createUserPage;
    @Given("the user is logged in")
    public void loginAdmin() {
        DriverManager.getDriver().get("http://localhost:9000/login"); // or whatever your login URL is
        LoginPage loginPage = PageFactoryManager.getLoginPage(DriverManager.getDriver());
        loginPage.login("admin", "admin"); // or use secure credentials
        System.out.println("I logged in");
//        DriverManager.getDriver().wait();
    }

    @Given("navigates to the create user page")
    public void theAdminIsOnTheCreateUserPage() {
        System.out.println("running....");
        goToCreateNewBankAccount(DriverManager.getDriver());
        createUserPage = PageFactoryManager.getCreateUserPage(DriverManager.getDriver());
    }

    @When("the admin enters username {string} and balance {int}")
    public void theAdminEntersUsernameAndBalance(String username, int balance) {
        createUserPage.createUser(username, balance);
    }

    @Then("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        assertEquals(currentUrl, "http://localhost:9000/bank-account/new", "Redirection to Bank Account page failed");
    }
}
