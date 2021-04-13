package products.challenge.dtos.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import products.challenge.exceptions.ApiException;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ProductFiltersDTO implements Filtes {
    public String name;
    public String category;
    public String brand;
    public Double price;
    public Integer quantity;
    public Boolean freeShipping;
    public Integer order;
    public Integer prestige;

    public ProductFiltersDTO() {
    }

    @Override
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> listOfValues = new HashMap<>();
        listOfValues.put("name", this.getName());
        listOfValues.put("category", this.getCategory());
        listOfValues.put("brand", this.getBrand());
        listOfValues.put("price", this.getPrice());
        listOfValues.put("freeShipping", this.getFreeShipping());
        listOfValues.put("prestige", this.getPrestige());
        return listOfValues;
    }

    public void validateNumberOfFilters() throws ApiException {
        Integer parameters = 0;
        HashMap<String, Object> listOfValues = getValues();
        for (Map.Entry<String, Object> entry : listOfValues.entrySet()) {
            if (entry.getValue() != null) {
                parameters++;
            }
            if (parameters > 2)
                throw new ApiException(HttpStatus.BAD_REQUEST, "La cantidad de filtros no puede es mayor a 2");
        }
    }


}
