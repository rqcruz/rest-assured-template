package requests.example.user;

import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RestAssuredBase;

public class UserRequest {

    private RestAssuredBase restAssuredBased;

    public Response requestByUserId(String userId) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .setPathParam("id", userId)
                .sendGetRequest(Endpoints.getUserIdPath());
    }

    public Response requestLimitingQuantityOfUsers(String limitOfUsers) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .setQueryParam("limit", limitOfUsers)
                .sendGetRequest(Endpoints.getUserBasePath());
    }
}
