package products.challenge.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusCodeDTO {
    Integer code;
    String message;

    public StatusCodeDTO() {

    }
}
