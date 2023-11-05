package requests.example.login;

import data.payloads.example.login.LoginPayload;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RestAssuredBase;

public class LoginRequest {

    public Response requestToLogin(String user, String password) {
        RestAssuredBase restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .body(new LoginPayload(user, password))
                .sendPostRequest(Endpoints.getLoginPath());
    }
}
