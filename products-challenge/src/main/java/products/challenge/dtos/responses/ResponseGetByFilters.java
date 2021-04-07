package products.challenge.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import products.challenge.dtos.ProductDTO;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseGetByFilters {
    Integer total;
    List<ProductDTO> items;
}
