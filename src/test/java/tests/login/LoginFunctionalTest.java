package tests.login;

import static org.hamcrest.Matchers.*;

import dto.LoginDTO;
import factory.LoginFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import client.login.LoginClient;
import tests.BaseApi;

public class LoginFunctionalTest extends BaseApi {

    LoginClient loginClient = new LoginClient();

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return a valid token")
    public void postToGetAValidTokenDTO() {
        LoginDTO loginDTO = LoginFactory.getValidCredentials();

        loginClient
                .getLoginToken(loginDTO)
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("token", notNullValue())
        ;
    }

}
