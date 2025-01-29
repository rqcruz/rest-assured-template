package client.product;

import dto.ProductDTO;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import specifications.Endpoints;
import specifications.RequestSpecificationSetup;

public class ProductClient {

    public static ValidatableResponse getSingleProduct(String idProduct) {
        return RestAssured
                .given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .pathParam("id_product", idProduct)
                .when()
                .get(Endpoints.SINGLE_PRODUCT_PATH)
                .then();
    }

    public static ValidatableResponse postNewProduct(ProductDTO productDTO) {
        return RestAssured
                .given()
                .spec(new RequestSpecificationSetup().setDefautlRequestSpecification())
                .body(productDTO)
                .when()
                .post(Endpoints.POST_PRODUCT_PATH)
                .then();
    }
}
