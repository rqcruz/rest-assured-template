package tests.user;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import requests.user.UserRequest;
import tests.BaseApi;

import static org.hamcrest.Matchers.*;

public class UserFunctionalTests extends BaseApi {

    private UserRequest userRequest;

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return the list of all users")
    void getAllUsers() {
        userRequest = new UserRequest();

        userRequest.getAllUsers()
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
        userRequest = new UserRequest();

        userRequest.getUsersById("1")
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
        userRequest = new UserRequest();

        userRequest.getUsersById("aaa")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("status", is("error"))
                .body("message", is("user id should be provided"))
        ;
    }
}
