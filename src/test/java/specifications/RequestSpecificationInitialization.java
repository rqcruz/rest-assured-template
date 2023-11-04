package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationInitialization {

    private RequestSpecBuilder requestSpecBuilder;
    private static final boolean IS_ENABLE_REQUEST_LOG = false;
    private static final boolean IS_ENABLE_RESPONSE_LOG = false;

    public RequestSpecification setDefautlRequestSpecification() {
        requestSpecBuilder = new RequestSpecBuilder();

        requestSpecBuilder
                .setBaseUri(Endpoints.getApiBaseUri());

        setContentTypeAsJson();
        enableRequestLog();
        enableResponseLog();

        return requestSpecBuilder.build();
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

    private void setContentTypeAsJson() {
        requestSpecBuilder.setContentType(ContentType.JSON);
    }
}
