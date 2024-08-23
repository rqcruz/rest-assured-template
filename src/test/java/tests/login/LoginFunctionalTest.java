package tests.login;

import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import requests.login.LoginRequest;
import tests.BaseApi;

public class LoginFunctionalTest extends BaseApi {

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return a valid token")
    public void postToGetAValidToken() {
        LoginRequest loginRequest = new LoginRequest();

        loginRequest.getLoginToken("mor_2314", "83r5^_")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .time(lessThan(2000L))
        ;
    }

}
