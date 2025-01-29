package tests.products;

import client.product.ProductClient;
import dto.ProductDTO;
import factory.ProductFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseApi;

import static org.hamcrest.Matchers.*;

public class ConsultProductsFunctionalTests extends BaseApi {

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should return a product by idProduct")
    void consultSpecificProduct() {
        ProductClient
                .getSingleProduct("1")
                .body(
                        "id", is(1),
                        "title", is("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"),
                        "price", greaterThan(100F),
                        "category", is("men's clothing")
                );
    }

    @Test
    @Tag("regression")
    @Tag("positive-scenario")
    @DisplayName("The request should add a new product")
    void addNewProduct() {
        ProductDTO productDTO = ProductFactory.getValidProductValues();

        ProductClient
                .postNewProduct(productDTO)
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "id", not(nullValue()),
                        "title", is(productDTO.getTitle()),
                        "description", is(productDTO.getDescription())
                );
    }
}
