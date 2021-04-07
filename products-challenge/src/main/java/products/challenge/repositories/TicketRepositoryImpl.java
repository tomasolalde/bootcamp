package products.challenge.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import products.challenge.dtos.TicketDTO;
import products.challenge.exceptions.ApiException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private final ArrayList<TicketDTO> tickets = new ArrayList<>();

    @Override
    public TicketDTO createTicket(TicketDTO ticket) {
        ticket.setId(tickets.size() + 1);
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public TicketDTO getTicketById(Integer id) {
        for (TicketDTO ticket : tickets) {
            if (ticket.getId().equals(id)) return ticket;
        }
        throw new ApiException(HttpStatus.NOT_FOUND, "No se encontro el ticket con id " + id);
    }

    @Override
    public List<TicketDTO> getAll() {
        return this.tickets;
    }
}
