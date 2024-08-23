package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationSetup {

    private RequestSpecBuilder requestSpecBuilder;
    private static final boolean IS_ENABLE_REQUEST_LOG = false;
    private static final boolean IS_ENABLE_RESPONSE_LOG = false;

    public RequestSpecification setDefautlRequestSpecification() {
        requestSpecBuilder = new RequestSpecBuilder();

        enableRequestLog();
        enableResponseLog();

        return requestSpecBuilder
                .setBaseUri(Endpoints.getApiBaseUri())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void enableRequestLog() {
        if (IS_ENABLE_REQUEST_LOG) {
            requestSpecBuilder.addFilter(new RequestLoggingFilter());
        }
    }

    private void enableResponseLog() {
        if (IS_ENABLE_RESPONSE_LOG) {
            requestSpecBuilder.addFilter(new ResponseLoggingFilter());
        }
    }
}
