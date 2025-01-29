package specifications;

import utils.GetProperties;

public class Endpoints {

    private static final String API_PROPERTIES_FILE_PATH = "src/test/resources/properties/api.properties";
    public static final String SINGLE_PRODUCT_PATH = "/products/{id_product}";
    public static final String POST_PRODUCT_PATH = "/products";

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

    public static String getSingleProductPath(){
        return GetProperties.getValue(API_PROPERTIES_FILE_PATH, "api.single.product.path");
    }
}
