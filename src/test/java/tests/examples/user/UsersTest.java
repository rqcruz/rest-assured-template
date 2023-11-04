package tests.examples.user;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import requests.example.user.UserRequest;

public class UsersTest {

    private UserRequest userRequest;

    @Test
    public void requestShouldReturnClientData() {
        userRequest = new UserRequest();

        userRequest.requestByUserId("1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("email", is("john@gmail.com"))
                .body("name.firstname", is("john"))
                .body("name.lastname", is("doe"))
        ;
    }

    @Test
    public void requestLimitingTheQuantityOfUsers() {
        userRequest = new UserRequest();

        userRequest.requestLimitingQuantityOfUsers("2")
                .then()
                .statusCode(200)
                .body("id", hasSize(2))
        ;
    }

    @Test
    public void requestUsingWordsAsIdShouldReturnAnError() {
        userRequest = new UserRequest();

        userRequest.requestByUserId("aaa")
                .then()
                .statusCode(400)
                .body("status", is("error"))
                .body("message", is("user id should be provided"))
        ;
    }
}
