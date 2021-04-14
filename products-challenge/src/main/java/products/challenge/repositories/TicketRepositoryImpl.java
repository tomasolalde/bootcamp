package products.challenge.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import products.challenge.dtos.PurchaseArticleDTO;
import products.challenge.dtos.TicketDTO;
import products.challenge.exceptions.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private final ArrayList<TicketDTO> tickets = new ArrayList<>();
    private final HashMap<Integer, PurchaseArticleDTO> articles =  new HashMap<>();

    @Override
    public TicketDTO createTicket(ArrayList<PurchaseArticleDTO> ticketArticles, Double ticketArticlesTotal) {
        TicketDTO ticket = new TicketDTO();
        if(articles.isEmpty()) {
            for (PurchaseArticleDTO purchaseArticle : ticketArticles) {
                articles.put(purchaseArticle.getProductId(), purchaseArticle);
            }
        }
        else {
            for (PurchaseArticleDTO purchaseArticle : ticketArticles) {
                PurchaseArticleDTO purchaseArticleInHash = articles.get(purchaseArticle.getProductId());
                if(purchaseArticleInHash != null)
                    purchaseArticleInHash.setQuantity(purchaseArticleInHash.getQuantity() + purchaseArticle.getQuantity());
                else
                    articles.put(purchaseArticle.getProductId(), purchaseArticle);
            }
        }
        ticket.setId(tickets.size() + 1);
        ticket.setTotal(getTotalAmountTickets() + ticketArticlesTotal);
        ticket.setArticles(getArticles());
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

    public Double getTotalAmountTickets() {
        Double total = 0.0;
        if(tickets.isEmpty())
            return total;
        return tickets.get(tickets.size()-1).getTotal();
    }

    public ArrayList<PurchaseArticleDTO> getArticles() {
        ArrayList<PurchaseArticleDTO> list = new ArrayList<>();
        for(Map.Entry<Integer, PurchaseArticleDTO> entry : articles.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
