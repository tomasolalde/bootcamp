package products.challenge.dtos.filters;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class ClientFiltersDTO implements Filtes {
    public String name;
    public String provincia;

    public ClientFiltersDTO() {
    }

    @Override
    public HashMap<String, Object> getValues() {
        HashMap<String, Object> listOfValues = new HashMap<>();
        listOfValues.put("name", this.getName());
        listOfValues.put("provincia", this.getProvincia());
        return listOfValues;
    }
}
