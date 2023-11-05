package data.payloads.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPayload {

    @JsonProperty("title")
    private String title;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String image;

    @JsonProperty("category")
    private String category;

    public ProductPayload(String title, Double price, String description, String image, String category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
