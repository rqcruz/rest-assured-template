package specifications;

import utils.GetProperties;

public class Endpoints {

    private static final String API_PROPERTIES_FILE_PATH = "src/test/resources/properties/api.properties";

    public static String getApiBaseUri() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.base.uri");
    }

    public static String getAllUsers() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.users.path");
    }

    public static String getUserById() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.id.users.path");
    }

    public static String getAuthLogin() {
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.auth.login.path");
    }
}
