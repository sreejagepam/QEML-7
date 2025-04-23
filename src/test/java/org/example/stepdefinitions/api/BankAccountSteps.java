package org.example.stepdefinitions.api;

import org.example.apiUtils.BankAccountClient;
import org.example.pages.BankAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.example.apiUtils.ResponseValidator.validateBasicPostRequest;
import static org.hamcrest.Matchers.equalTo;

public class BankAccountSteps {

    private final BankAccountClient bankAccountClient;
    private BankAccount defaultBankAccount;
    private Response response;
    private ValidatableResponse validatableResponse;

    public BankAccountSteps(){
        bankAccountClient = new BankAccountClient();
    }

    @Given("the user has authorization access token")
    public void theUserHasAuthorizationAccessToken() {
        //mock for future token generation logic
    }

    @And("the user has valid data for account creation")
    public void theUserHasValidDataForAccountCreation() {
        defaultBankAccount = BankAccount.createDefaultBankAccount();
    }

    @When("the user hits the POST request to the create new account endpoint")
    public void theUserHitsThePOSTRequestToTheCreateNewAccountEndpoint() {
        response = bankAccountClient.createNewBankAccount(defaultBankAccount);
    }

    @Then("the status code should be {int} for creating new account")
    public void theStatusCodeShouldBeForBankAccount(int expectedStatusCode) {
        validatableResponse = validateBasicPostRequest(response, expectedStatusCode);
    }

    @And("the response should have {string} equal to {string}")
    public void theResponseShouldHaveEqualTo(String key, String value) {
        validatableResponse
                .body(key, equalTo(value));
    }
}
