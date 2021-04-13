package products.challenge.services;

import products.challenge.dtos.ClientDTO;
import products.challenge.dtos.filters.ClientFiltersDTO;

import java.util.List;

public interface ClientService {
    Integer createClient(ClientDTO client);
    List<ClientDTO> getClientsByFilter(ClientFiltersDTO filters);
    ClientDTO getClientById(Integer id);
}
