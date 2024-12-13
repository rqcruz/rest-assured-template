package tests.login;

import dto.LoginDTO;
import factory.LoginFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import client.login.LoginClient;
import tests.BaseApi;

import static org.hamcrest.Matchers.*;

public class LoginSecurityTest extends BaseApi {

    LoginClient loginClient = new LoginClient();

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using bad credentials should return status code 401")
    public void postToGetATokenWithBadCredentials() {
        LoginDTO loginDTO = LoginFactory.setCredentials("fake", "fake");

        loginClient
                .getLoginToken(loginDTO)
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("html.body", is("username or password is incorrect"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using invalid username should return status code 401")
    public void postToGetATokenWithInvalidUsername() {
        LoginDTO loginDTO = LoginFactory.setCredentials("fake", "83r5^_");

        loginClient.getLoginToken(loginDTO)
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("html.body", is("username or password is incorrect"))
        ;
    }

    @Test
    @Tag("regression")
    @Tag("negative-scenario")
    @DisplayName("The request using invalid password should return status code 401")
    public void postToGetATokenWithInvalidPassword() {
        LoginDTO loginDTO = LoginFactory.setCredentials("mor_2314", "fake");

        loginClient.getLoginToken(loginDTO)
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("html.body", is("username or password is incorrect"))
        ;
    }

}
