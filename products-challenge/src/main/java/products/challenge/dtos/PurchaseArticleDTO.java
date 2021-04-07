package products.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseArticleDTO {
    public Integer productId;
    public String name;
    public String brand;
    public Integer quantity;

    public PurchaseArticleDTO() {
        
    }
}
