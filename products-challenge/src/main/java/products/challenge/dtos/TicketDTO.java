package products.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class TicketDTO {
    Integer id;
    ArrayList<PurchaseArticleDTO> articles;
    Double total;

    public TicketDTO() {
    }
}
