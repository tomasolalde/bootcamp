package products.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.challenge.dtos.ClientDTO;
import products.challenge.dtos.filters.ClientFiltersDTO;
import products.challenge.services.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService clientService) {
        this.service = clientService;
    }

    /**
     * Crea un cliente y lo almacena en la BD
     * @param client cliente a crear
     * @return id del cliente
     */
    @PostMapping
    public ResponseEntity<Integer> createClient(@Valid @RequestBody ClientDTO client) {
        return new ResponseEntity<>(this.service.createClient(client), HttpStatus.CREATED);
    }

    /**
     * Retorna los clientes filtrados o todos si no se aplica ningun filtro
     * @param filters filtros de busqueda
     * @return clientes
     */
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClientsByFilter(ClientFiltersDTO filters) {
        List<ClientDTO> clients = this.service.getClientsByFilter(filters);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    /**
     * Retorna un cliente
     * @param id id del cliente a buscar
     * @return cliente
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.getClientById(id), HttpStatus.CREATED);
    }
}
