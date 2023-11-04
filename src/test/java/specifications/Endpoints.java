package specifications;

import utils.GetProperties;

public class Endpoints {

    private static final String API_PROPERTIES_FILE_PATH = "src/test/resources/properties/api.properties";

    public static String getApiBaseUri() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.base.uri");
    }

    public static String getUserBasePath() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.user.base.path");
    }

    public static String getUserIdPath() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.user.id.path");
    }

    public static String getLoginPath() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.login.path");
    }
}
