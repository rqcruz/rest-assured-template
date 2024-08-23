package requests.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RequestSpecificationSetup;

public class UserRequest {

    public Response getAllUsers() {
        return RestAssured
                .given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .when()
                .get(Endpoints.getAllUsers());
    }

    public Response getUsersById(String userId) {
        return RestAssured
                .given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .pathParam("id", userId)
                .when()
                .get(Endpoints.getUserById());
    }

}
