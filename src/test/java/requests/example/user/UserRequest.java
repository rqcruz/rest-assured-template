package requests.example.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RequestSpecificationInitialization;

public class UserRequest {

    public Response requestByUserId(String userId){
       return RestAssured
                .given()
                .spec(new RequestSpecificationInitialization().setRequestSpecification())
                .pathParam("id", userId)
                .when()
                .get(Endpoints.getUserIdPath());
    }

    public Response requestLimitingQuantityOfUsers(Integer limitOfUsers){
        return RestAssured
                .given()
                .spec(new RequestSpecificationInitialization().setRequestSpecification())
                .queryParam("limit", limitOfUsers)
                .when()
                .get(Endpoints.getUserBasePath());
    }
}
