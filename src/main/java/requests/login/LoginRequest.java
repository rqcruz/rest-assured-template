package requests.login;

import data.payloads.login.LoginPayload;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RequestSpecificationSetup;

public class LoginRequest {

    public Response getLoginToken(String user, String password) {
        return RestAssured
                .given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .body(new LoginPayload(user, password))
                .when()
                .post(Endpoints.getAuthLogin());
    }
}
