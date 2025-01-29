package tests.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import client.user.UserClient;
import tests.BaseApi;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserContractTests extends BaseApi {

    private UserClient userClient = new UserClient();

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request to get a valid user by ID should return the correct json schema")
    void getUserByIdShouldReturnTheCorrectJsonSchema() {
        userClient
                .getUsersById("1")
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/users/users-statuscode-200-schema.json"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request to get user by an invalid ID should return the correct json schema")
    void getUserByInvalidIdShouldReturnTheCorrectJsonSchema() {
        userClient
                .getUsersById("abc")
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/users/users-statuscode-400-schema.json"))
        ;
    }

}
