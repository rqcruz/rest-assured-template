package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties
public class ProductDTO {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
