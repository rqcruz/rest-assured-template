package tests.login;

import dto.LoginDTO;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import client.login.LoginClient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseApi;

import static org.hamcrest.Matchers.is;

public class LoginSecurityTest extends BaseApi {

    LoginClient loginClient = new LoginClient();

    @Tag("regression")
    @Tag("negative-scenario")
    @ParameterizedTest
    @MethodSource("dataprovider.LoginProvider#provideInvalidCredentials")
    @DisplayName("The request using invalid credentials should return status code 401")
    public void postToGetATokenWithBadCredentials(LoginDTO loginDTO, String errorMsg) {
        loginClient
                .getLoginToken(loginDTO)
                .assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("html.body", is(errorMsg))
        ;
    }

}
