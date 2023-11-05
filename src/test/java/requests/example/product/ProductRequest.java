package requests.example.product;

import data.payloads.example.product.ProductPayload;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RestAssuredBase;

public class ProductRequest {

    private RestAssuredBase restAssuredBased;

    public Response requestToUpdateProductUsingPutRequest(String productId, String title, Double price, String description, String image, String category) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .body(new ProductPayload(title, price, description, image, category))
                .setPathParam("id", productId)
                .sendPutRequest(Endpoints.getProductPath());
    }

    public Response requestToUpdateProductUsingPatchRequest(String productId, String title, Double price, String description, String image, String category) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .body(new ProductPayload(title, price, description, image, category))
                .setPathParam("id", productId)
                .sendPatchRequest(Endpoints.getProductPath());
    }

    public Response requestToDeleteProduct(String productId) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .setPathParam("id", productId)
                .sendDeleteRequest(Endpoints.getProductPath());
    }
}
