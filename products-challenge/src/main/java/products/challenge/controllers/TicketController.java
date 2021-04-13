package products.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.challenge.dtos.TicketDTO;
import products.challenge.dtos.requests.RequestPurchaseDTO;
import products.challenge.dtos.responses.ResponsePurchaseDTO;
import products.challenge.dtos.responses.StatusCodeDTO;
import products.challenge.services.TicketService;
import java.util.List;

@RestController
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService ticketService) {
        this.service = ticketService;
    }

    /**
     * Crea una orden de compras
     * @param request orden de compras a crear
     * @return orden de compras con el total del carrito
     */
    @PostMapping(value = "purchase-request")
    public ResponseEntity<ResponsePurchaseDTO> createPurchaseRequest(@RequestBody RequestPurchaseDTO request) {
        ResponsePurchaseDTO response = new ResponsePurchaseDTO();
        response.setTicket(this.service.createPurchase(request));
        response.setStatusCode(new StatusCodeDTO(HttpStatus.CREATED.value(), "Ticket creado correctamente"));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Retorna un ticket filtrado por id
     * @param id id del ticket a filtrar
     * @return ticket
     */
    @GetMapping(value = "ticket/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.getTicketById(id), HttpStatus.CREATED);
    }

    /**
     * Retorna el historial de tickets creados
     * @return tickets
     */
    @GetMapping(value = "ticket")
    public ResponseEntity<List<TicketDTO>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
}
