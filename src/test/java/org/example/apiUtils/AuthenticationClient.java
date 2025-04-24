package org.example.apiUtils;

import org.example.config.APIConfigReader;
import org.example.pages.Authentication;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AuthenticationClient {
    private static final String authenticationUrl = APIConfigReader.getProperty("authentication_url");

    RequestSpecification requestSpecification = given()
            .baseUri(authenticationUrl)
            .contentType(ContentType.JSON);

    public Response authenticate(Authentication authentication) {
        return requestSpecification
                .body(authentication)
                .when()
                .post();
    }

}
