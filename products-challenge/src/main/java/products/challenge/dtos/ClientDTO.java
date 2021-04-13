package products.challenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    public Integer id;
    @NotBlank(message = "EL nombre es requerido")
    public String name;
    @NotBlank(message = "La provincia es requerida")
    public String state;
}
