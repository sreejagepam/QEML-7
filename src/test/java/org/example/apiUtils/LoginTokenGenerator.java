package org.example.apiUtils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginTokenGenerator {
    public static String getTokenOnAuthentication(){
        Response response = given()
                .contentType("application/json")
                .body("{\"username\":\"admin\",\"password\":\"admin\",\"rememberMe\":false}")
                .post("http://localhost:9000/api/authenticate");

        return response.path("id_token");
    }

    public static void main(String[] args) {
        System.out.println(LoginTokenGenerator.getTokenOnAuthentication());
    }
}
