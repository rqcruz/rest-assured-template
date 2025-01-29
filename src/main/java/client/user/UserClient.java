package client.user;

import io.restassured.response.ValidatableResponse;
import specifications.Endpoints;
import specifications.RequestSpecificationSetup;

import static io.restassured.RestAssured.given;

public class UserClient {

    public ValidatableResponse getAllUsers() {
        return given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .when()
                .get(Endpoints.getAllUsers())
                .then();
    }

    public ValidatableResponse getUsersById(String userId) {
        return given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .pathParam("id", userId)
                .when()
                .get(Endpoints.getUserById())
                .then();
    }

}
