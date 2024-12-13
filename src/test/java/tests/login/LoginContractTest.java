package tests.login;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import client.login.LoginClient;
import tests.BaseApi;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class LoginContractTest extends BaseApi {

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return a valid token")
    public void postToGetAValidToken() {
        LoginClient loginClient = new LoginClient();

        loginClient.getLoginToken("mor_2314", "83r5^_")
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/login/login-statuscode-200-schema.json"))
        ;
    }

}
