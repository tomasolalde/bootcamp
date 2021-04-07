package products.challenge.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import products.challenge.dtos.TicketDTO;

@Data
@AllArgsConstructor
public class ResponsePurchaseDTO {
    public TicketDTO ticket;
    public StatusCodeDTO statusCode;

    public ResponsePurchaseDTO() {

    }
}
