package data.payloads.example.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPayload {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("price")
    private final Double price;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("image")
    private final String image;

    @JsonProperty("category")
    private final String category;

    public ProductPayload(String title, Double price, String description, String image, String category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
