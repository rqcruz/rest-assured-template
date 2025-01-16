package utils;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RequestResponseLoggingFilter implements Filter {
    private static final ThreadLocal<String> REQUEST_BODY = new ThreadLocal<>();
    private static final ThreadLocal<String> RESPONSE_BODY = new ThreadLocal<>();
    private static final ThreadLocal<String> REQUEST_URI = new ThreadLocal<>();
    private static final ThreadLocal<Integer> RESPONSE_STATUS_CODE = new ThreadLocal<>();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        Response response = filterContext.next(requestSpec, responseSpec);
        String requestUri = requestSpec.getURI();
        Integer responseStatusCode = response.getStatusCode();
        String requestBodyContent = formatJson(requestSpec.getBody());
        String responseBodyContent = formatJson(response.getBody().asString());

        REQUEST_URI.set(requestUri);
        RESPONSE_STATUS_CODE.set(responseStatusCode);
        REQUEST_BODY.set(requestBodyContent);
        RESPONSE_BODY.set(responseBodyContent);

        return response;
    }

    private String formatJson(String json) {
        try {
            Object jsonElement = gson.fromJson(json, Object.class);
            return gson.toJson(jsonElement);
        } catch (Exception e) {
            return json;
        }
    }

    public static String getRequestUri() {
        return REQUEST_URI.get();
    }

    public static Integer getResponseStatusCode() {
        return RESPONSE_STATUS_CODE.get();
    }

    public static String getRequestBody() {
        return REQUEST_BODY.get();
    }

    public static String getResponseBody() {
        return RESPONSE_BODY.get();
    }
}
