package client.login;

import dto.LoginDTO;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import specifications.Endpoints;
import specifications.RequestSpecificationSetup;

public class LoginClient {

    public ValidatableResponse getLoginToken(LoginDTO loginDTO) {
        return RestAssured
                .given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .body(loginDTO)
                .when()
                .post(Endpoints.getAuthLogin())
                .then();
    }
}
