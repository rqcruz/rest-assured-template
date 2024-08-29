package tests.login;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import requests.login.LoginRequest;
import tests.BaseApi;

import static org.hamcrest.Matchers.*;

public class LoginSecurityTest extends BaseApi {

    private LoginRequest loginRequest;

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using bad credentials should return status code 401")
    public void postToGetATokenWithBadCredentials() {
        loginRequest = new LoginRequest();

        loginRequest.getLoginToken("fake", "fake")
                .then()
                .statusCode(401)
                .body("html.body", is("username or password is incorrect"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using invalid username should return status code 401")
    public void postToGetATokenWithInvalidUsername() {
        loginRequest = new LoginRequest();

        loginRequest.getLoginToken("fake", "83r5^_")
                .then()
                .statusCode(401)
                .body("html.body", is("username or password is incorrect"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using invalid password should return status code 401")
    public void postToGetATokenWithInvalidPassword() {
        loginRequest = new LoginRequest();

        loginRequest.getLoginToken("mor_2314", "fake")
                .then()
                .statusCode(401)
                .body("html.body", is("username or password is incorrect"))
        ;
    }

}
