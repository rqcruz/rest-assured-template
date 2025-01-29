package factory;

import dto.ProductDTO;
import net.datafaker.Faker;

public class ProductFactory {

    private static Faker faker = new Faker();
    private static final String TITLE = faker.commerce().productName();
    private static final double PRICE = Double.parseDouble(faker.commerce().price());
    private static final String SENTENCE = faker.lorem().sentence(10);
    private static final String URL = faker.internet().url();
    private static final String CATEGORY = faker.commerce().department();


    public static ProductDTO getValidProductValues() {
        return ProductDTO.builder()
                .title(TITLE)
                .price(PRICE)
                .description(SENTENCE)
                .image(URL)
                .category(CATEGORY)
                .build();
    }
}
