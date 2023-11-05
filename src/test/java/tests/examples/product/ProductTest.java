package tests.examples.product;

import org.junit.jupiter.api.Test;
import requests.example.login.LoginRequest;
import requests.example.product.ProductRequest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ProductTest {

    private ProductRequest productRequest;

    @Test
    public void updatingProductWithSuccess() {
        productRequest = new ProductRequest();

        productRequest.requestToUpdateProduct(
                "7",
                        "test product",
                        13.5,
                        "'lorem ipsum set",
                        "'https://i.pravatar.cc",
                        "electronic")
                .then()
                .statusCode(200)
                .body("id", is(7))
                .body("title", is("test product"))
                .body("price", is(13.5F))
                .body("description", is("'lorem ipsum set"))
                .body("image", is("'https://i.pravatar.cc"))
                .body("category", is("electronic"))
        ;
    }
}
