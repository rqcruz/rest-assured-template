package specifications;

import data.payloads.login.LoginPayload;
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

    public RestAssuredBase setQueryParam(String queryParam, String value) {
        requestSpecification.queryParam(queryParam, value);
        return this;
    }

    public RestAssuredBase body(Object payload) {
        requestSpecification.body(payload);
        return this;
    }

    public Response sendGetRequest(String url) {
        return requestSpecification.when().get(url);
    }

    public Response sendPostRequest(String url) {
        return requestSpecification.when().post(url);
    }

    public Response sendPutRequest(String url) {
        return requestSpecification.when().put(url);
    }

    public Response sendPatchRequest(String url) { return requestSpecification.when().patch(url);
    }

    public Response sendDeleteRequest(String url) { return requestSpecification.when().delete(url);
    }
}
