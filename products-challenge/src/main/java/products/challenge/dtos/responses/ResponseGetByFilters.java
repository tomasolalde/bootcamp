package products.challenge.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import products.challenge.dtos.ProductDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGetByFilters {
    Integer total;
    List<ProductDTO> items;
}
