package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationInitialization {

    public RequestSpecBuilder requestSpecBuilder;

    public RequestSpecification setRequestSpecification(){
        requestSpecBuilder = new RequestSpecBuilder();

        requestSpecBuilder
                .setBaseUri(Endpoints.getApiBaseUri())
                .setContentType(ContentType.JSON)
                .addFilter( new ResponseLoggingFilter())
                .addFilter( new RequestLoggingFilter());

        return requestSpecBuilder.build();
    }
}
