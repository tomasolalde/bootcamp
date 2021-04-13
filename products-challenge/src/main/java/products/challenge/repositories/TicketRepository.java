package products.challenge.repositories;

import products.challenge.dtos.PurchaseArticleDTO;
import products.challenge.dtos.TicketDTO;
import products.challenge.exceptions.ApiException;

import java.util.ArrayList;
import java.util.List;

public interface TicketRepository {
    TicketDTO createTicket(ArrayList<PurchaseArticleDTO> articles, Double ticketArticlesTotal) throws ApiException;

    TicketDTO getTicketById(Integer id) throws ApiException;

    List<TicketDTO> getAll() throws ApiException;
}
