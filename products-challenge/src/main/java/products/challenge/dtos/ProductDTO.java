package products.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    public Integer id;
    public String name;
    public String category;
    public String brand;
    public Double price;
    public Integer quantity;
    public Boolean freeShipping;
    public Integer prestige;

    public ProductDTO() {

    }
}
