package tests.examples.login;

import org.junit.jupiter.api.Test;
import requests.example.login.LoginRequest;
import requests.example.user.UserRequest;

import static org.hamcrest.Matchers.*;

public class LoginTest {

    private LoginRequest loginRequest;

    @Test
    public void requestToLoginWithSuccess() {
        loginRequest = new LoginRequest();

        loginRequest.requestToLogin("mor_2314", "83r5^_")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
        ;
    }

    @Test
    public void requestToLoginWithBadCredentials() {
        loginRequest = new LoginRequest();

        loginRequest.requestToLogin("fake", "fake")
                .then()
                .statusCode(401)
                .body("html.body", is("username or password is incorrect"))
        ;
    }
}
