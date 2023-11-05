package requests.example.product;

import data.payloads.product.ProductPayload;
import io.restassured.response.Response;
import specifications.Endpoints;
import specifications.RestAssuredBase;

public class ProductRequest {

    RestAssuredBase restAssuredBased;

    public Response requestToUpdateProduct(String productId, String title, Double price, String description, String image, String category) {
        restAssuredBased = new RestAssuredBase();

        return restAssuredBased
                .setDefaultRequestSpecification()
                .body(new ProductPayload(title, price, description, image, category))
                .setPathParam("id", productId)
                .sendPutRequest(Endpoints.getUpdateProductPath());
    }
}
