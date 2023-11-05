package tests.examples.product;

import org.junit.jupiter.api.Test;
import requests.example.product.ProductRequest;

import static org.hamcrest.Matchers.is;

public class ProductTest {

    private ProductRequest productRequest;

    @Test
    public void updatingProductWithSuccessUsingPutRequest() {
        productRequest = new ProductRequest();

        productRequest.requestToUpdateProductUsingPutRequest(
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

    @Test
    public void updatingProductWithSuccessUsingPatchRequest() {
        productRequest = new ProductRequest();

        productRequest.requestToUpdateProductUsingPatchRequest(
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

    @Test
    public void deleteProductWithSuccess() {
        productRequest = new ProductRequest();

        productRequest.requestToDeleteProduct("6")
                .then()
                .statusCode(200)
                .body("id", is(6))
                .body("title", is("Solid Gold Petite Micropave "))
                .body("price", is(168))
                .body("category", is("jewelery"))
                .body("description", is("Satisfaction Guaranteed. Return or exchange any order within 30 days.Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days."))
                .body("image", is("https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg"))
                .body("rating.rate", is(3.9F))
                .body("rating.count", is(70))
        ;
    }
}
