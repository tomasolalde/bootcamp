package products.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PurchaseArticleDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    public Integer productId;
    @NotNull(message = "El nombre no puede ser nulo")
    public String name;
    @NotNull(message = "El nombre no puede ser nulo")
    public String brand;
    @NotNull(message = "El nombre no puede ser nulo")
    public Integer quantity;

    public PurchaseArticleDTO() {
        
    }
}
