package factory;

import dto.ProductDTO;

public class ProductFactory {

    public static ProductDTO getValidProductValues() {
        return ProductDTO.builder()
                .title("Brazilian Macaw Smartwatch")
                .price(14.0)
                .description("A smartwatch designed in honor of the Brazilian macaw")
                .image("https://fakestoreapi.com/img/br_macaw_IMG123.jpg")
                .category("gadget")
                .build();
    }
}
