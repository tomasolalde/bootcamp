package products.challenge.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import products.challenge.dtos.ClientDTO;
import products.challenge.dtos.filters.ClientFiltersDTO;
import products.challenge.exceptions.ApiException;
import products.challenge.repositories.ClientRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }

    @Override
    public Integer createClient(ClientDTO client) {
        return this.repository.createClient(client);
    }

    /**
     * Obtiene los clientes por distintos filtros
     * @param filters filtros referidos a los clientes
     * @return clientes
     */
    @Override
    public List<ClientDTO> getClientsByFilter(ClientFiltersDTO filters) {
        // Obtiene los cliente de la base de datos
        List<ClientDTO> clients = this.repository.getAll();
        clients = clients.stream()
                .filter(product -> {
                    boolean matches = true;
                    if (filters.getName() != null) {
                        matches = product.getName().toUpperCase(Locale.ROOT)
                                .equals(filters.getName().toUpperCase(Locale.ROOT));
                    }
                    if (filters.getProvincia() != null) {
                        matches = product.getState().toUpperCase(Locale.ROOT)
                                .equals(filters.getProvincia().toUpperCase(Locale.ROOT));
                    }
                    return matches;
                }).collect(Collectors.toList());

        if (clients.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "No se encontraron clientes");
        return clients;
    }

    /**
     * Obtiene un cliente por id
     * @param id
     * @return
     */
    @Override
    public ClientDTO getClientById(Integer id) {
        return this.repository.getClientById(id);
    }
}
