package products.challenge.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.PurchaseArticleDTO;
import products.challenge.dtos.TicketDTO;
import products.challenge.dtos.requests.RequestPurchaseDTO;
import products.challenge.exceptions.ApiException;
import products.challenge.repositories.ProductRepository;
import products.challenge.repositories.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImple implements TicketService {

    TicketRepository repository;
    ProductRepository productRepository;

    public TicketServiceImple(TicketRepository ticketRepository, ProductRepository productRepository) {
        this.repository = ticketRepository;
        this.productRepository = productRepository;
    }

    @Override
    public TicketDTO createPurchase(RequestPurchaseDTO request) {
        ArrayList<PurchaseArticleDTO> tickerArticles = new ArrayList<>();
        Double total = 0.0;
        for (PurchaseArticleDTO article : request.getArticles()) {
            ProductDTO product = this.productRepository.getProductById(article.getProductId());
            if (article.getQuantity() > product.getQuantity())
                throw new ApiException(HttpStatus.BAD_REQUEST, "Cantidad en articulo Id[" + article.getProductId() + "] solicitada no disponible");
            if (!article.getName().equals(product.getName()))
                throw new ApiException(HttpStatus.BAD_REQUEST, "Nombre en articulo Id[" + article.getProductId() + "] inconsistente");
            if (!article.getBrand().equals(product.getBrand()))
                throw new ApiException(HttpStatus.BAD_REQUEST, "Marca en articulo Id[" + article.getProductId() + "] inconsistente");
            tickerArticles.add(article);
            total += product.getPrice() * product.getQuantity();
        }

        // Cuando todos los articulos fueron aceptados hago un update del stock de cada uno
        for (PurchaseArticleDTO acceptedArticle : tickerArticles) {
            ProductDTO product = this.productRepository.getProductById(acceptedArticle.getProductId());
            product.setQuantity(product.getQuantity() - acceptedArticle.getQuantity());
            this.productRepository.updateProduct(product, product.getId());
        }

        /*
        Existen tickets por lo que no genero uno si no que
        agrego los articulos al anterior y modifico el total
         */
        List<TicketDTO> tickets = this.repository.getAll();
        if (!tickets.isEmpty()) {
            for (TicketDTO t : tickets) {
                tickerArticles.addAll(t.getArticles());
                total += t.getTotal();
            }
        }

        TicketDTO ticket = new TicketDTO();
        ticket.setArticles(tickerArticles);
        ticket.setTotal(total);
        return this.repository.createTicket(ticket);
    }

    @Override
    public TicketDTO getTicketById(Integer id) {
        return this.repository.getTicketById(id);
    }

    @Override
    public List<TicketDTO> getAll() {
        List<TicketDTO> tickets = this.repository.getAll();
        if (tickets.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "No se encontraron tickers");
        return tickets;
    }
}
