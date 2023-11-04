package requests.example.login;

import data.payloads.login.LoginPayload;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RestAssuredBase;

public class LoginRequest {
    RestAssuredBase restAssuredBased;

    public Response requestToLogin(String user, String password) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .body(new LoginPayload(user, password))
                .sendPostRequest(Endpoints.getLoginPath());
    }
}
