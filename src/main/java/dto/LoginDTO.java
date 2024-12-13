package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties
public class LoginDTO {
    private String username;
    private String password;
}
