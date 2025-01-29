package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.RequestResponseLoggingFilter;

public class RequestSpecificationSetup {

    private RequestSpecBuilder requestSpecBuilder;
    private static final boolean ENABLE_REQUEST_AND_RESPONSE_LOG = true;

    public RequestSpecification setDefautlRequestSpecification() {
        requestSpecBuilder = new RequestSpecBuilder();

        requestAndResposeLog();

        return requestSpecBuilder
                .setBaseUri(Endpoints.getApiBaseUri())
                .setContentType(ContentType.JSON)
                .addFilter(new RequestResponseLoggingFilter())
                .build();
    }

    private void requestAndResposeLog() {
        if (ENABLE_REQUEST_AND_RESPONSE_LOG) {
            requestSpecBuilder
                    .addFilter(new RequestLoggingFilter())
                    .addFilter(new ResponseLoggingFilter());
        }
    }
}
