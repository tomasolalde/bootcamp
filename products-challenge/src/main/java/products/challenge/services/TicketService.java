package products.challenge.services;

import products.challenge.dtos.TicketDTO;
import products.challenge.dtos.requests.RequestPurchaseDTO;

import java.util.List;

public interface TicketService {
    TicketDTO createPurchase(RequestPurchaseDTO request);

    TicketDTO getTicketById(Integer id);

    List<TicketDTO> getAll();
}
