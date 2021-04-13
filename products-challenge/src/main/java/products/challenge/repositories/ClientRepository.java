package products.challenge.repositories;

import products.challenge.dtos.ClientDTO;

import java.util.List;

public interface ClientRepository {
    Integer createClient(ClientDTO client);
    List<ClientDTO> getAll();
    ClientDTO getClientById(Integer id);
}
