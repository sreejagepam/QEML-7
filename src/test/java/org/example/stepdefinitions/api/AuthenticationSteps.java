package org.example.stepdefinitions.api;

import org.example.apiUtils.AuthenticationClient;
import org.example.pages.Authentication;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.example.apiUtils.ResponseValidator.validateBasicPostRequest;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotNull;

public class AuthenticationSteps {

    private final AuthenticationClient authenticationClient;
    private Authentication defaultAuthenticationDetails;
    private Response response;
    private ValidatableResponse validatableResponse;

    public AuthenticationSteps() {
        authenticationClient = new AuthenticationClient();
        defaultAuthenticationDetails = Authentication.getDefaultAuthentication();
    }

    @Epic("User Authorization...............")
    @Story("User must be able to authorize with valid credentials")
    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        defaultAuthenticationDetails = Authentication.getDefaultAuthentication();
    }

    @When("the user hits the POST request to the authentication endpoint")
    public void theUserHitsThePOSTRequestToTheAuthenticationEndpoint() {
        System.out.println("When of Authentication........");
        response = authenticationClient.authenticate(defaultAuthenticationDetails);
        assertNotNull(response);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int expectedStatusCode) {
        System.out.println("Response: "+response.prettyPrint());
        validatableResponse = validateBasicPostRequest(response, expectedStatusCode);
    }

    @And("an id token should be generated")
    public void anIdTokenShouldBeGenerated() {
        String token = response.path("id_token");
        assertNotNull(token, "Authorization header is null.");
    }

    @Given("the user enters invalid {string} or {string}")
    public void theUserEntersInvalidOr(String username, String password) {
        defaultAuthenticationDetails.setUsername(username);
        defaultAuthenticationDetails.setPassword(password);
    }

    @And("the user should see {string} message")
    public void theUserShouldSeeMessage(String message) {
        validatableResponse
                .body("title", equalTo(message));
    }
}
