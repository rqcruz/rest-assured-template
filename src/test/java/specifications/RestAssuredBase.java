package specifications;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBase {

    private RequestSpecification requestSpecification;

    public RestAssuredBase() {
        requestSpecification = RestAssured.given();
    }

    public RestAssuredBase setDefaultRequestSpecification() {
        requestSpecification.spec(new RequestSpecificationInitialization().setDefautlRequestSpecification());
        return this;
    }

    public RestAssuredBase setPathParam(String pathParam, String value) {
        requestSpecification.pathParam(pathParam, value);
        return this;
    }

    public Response sendGetRequest(String url) {
        return requestSpecification.when().get(url);
    }

    public RestAssuredBase setQueryParam(String queryParam, String value) {
        requestSpecification.queryParam(queryParam, value);
        return this;
    }
}
