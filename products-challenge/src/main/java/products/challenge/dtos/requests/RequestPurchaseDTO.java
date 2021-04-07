package products.challenge.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import products.challenge.dtos.PurchaseArticleDTO;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class RequestPurchaseDTO {
    public ArrayList<PurchaseArticleDTO> articles;

    public RequestPurchaseDTO() {

    }
}
