package tests.user;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import client.user.UserClient;
import tests.BaseApi;

import static org.hamcrest.Matchers.*;

public class UserFunctionalTests extends BaseApi {

    private UserClient userClient;

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return the list of all users")
    void getAllUsers() {
        userClient = new UserClient();

        userClient.getAllUsers()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(not(isEmptyString()))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return a single users by ID")
    void getUserByID() {
        userClient = new UserClient();

        userClient.getUsersById("1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("id", is(1))
                .body("email", is("john@gmail.com"))
                .body("name.firstname", is("john"))
                .body("name.lastname", is("doe"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using words instead number should return status code 400")
    void requestUsingWordsAsIdShouldReturnAnError() {
        userClient = new UserClient();

        userClient.getUsersById("aaa")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", is("error"))
                .body("message", is("user id should be provided"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using special characters instead number should return status code 400")
    void requestUsingSpecialCharactersAsIdShouldReturnAnError() {
        userClient = new UserClient();

        userClient.getUsersById("@!#")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", is("error"))
                .body("message", is("user id should be provided"))
        ;
    }

    @Test
    @Tag("report")
    @Disabled("Test disabled on purpose")
    @DisplayName("Test disabled for the purpose of displaying its status in the report")
    void onlyToDisplayTheDisabledStatusInTheTestReport() {
        // Disabled test
    }

}
