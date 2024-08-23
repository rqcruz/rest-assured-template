package tests.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import requests.user.UserRequest;
import tests.BaseApi;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class UserContractTests extends BaseApi {

    private UserRequest userRequest;

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request to get a valid user by ID should return the correct json schema")
    void getUserByIdShouldReturnTheCorrectJsonSchema() {
        userRequest = new UserRequest();

        userRequest.getUsersById("1")
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/users/users-statuscode-200-schema.json"))
                .time(lessThan(2000L))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request to get user by an invalid ID should return the correct json schema")
    void getUserByInvalidIdShouldReturnTheCorrectJsonSchema() {
        userRequest = new UserRequest();

        userRequest.getUsersById("abc")
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/users/users-statuscode-400-schema.json"))
                .time(lessThan(2000L))
        ;
    }

}
