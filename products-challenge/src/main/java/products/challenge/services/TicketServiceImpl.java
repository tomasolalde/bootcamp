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
public class TicketServiceImpl implements TicketService {

    TicketRepository repository;
    ProductRepository productRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, ProductRepository productRepository) {
        this.repository = ticketRepository;
        this.productRepository = productRepository;
    }

    /**
     * Crea una nueva compra y valida los datos pasados en cada articulo
     * @param request
     * @return ticket
     */
    @Override
    public TicketDTO createPurchase(RequestPurchaseDTO request) {
        ArrayList<PurchaseArticleDTO> tickerArticles = new ArrayList<>();
        Double totalArticles = 0.0;

        // Valido los distintos filtros
        for (PurchaseArticleDTO article : request.getArticles()) {
            ProductDTO product = this.productRepository.getProductById(article.getProductId());
            if (article.getQuantity() > product.getQuantity())
                throw new ApiException(HttpStatus.BAD_REQUEST, "Cantidad del articulo " + article.getName() + " no disponible");
            if (!article.getName().equals(product.getName()))
                throw new ApiException(HttpStatus.BAD_REQUEST, "Nombre en articulo  " + article.getName() + " inconsistente");
            if (!article.getBrand().equals(product.getBrand()))
                throw new ApiException(HttpStatus.BAD_REQUEST, "Marca en articulo " + article.getName() + " inconsistente");
            tickerArticles.add(article);
            totalArticles += product.getPrice() * article.getQuantity();
        }

        // Cuando todos los articulos fueron aceptados hago un update del stock de cada uno
        for (PurchaseArticleDTO acceptedArticle : tickerArticles) {
            ProductDTO product = this.productRepository.getProductById(acceptedArticle.getProductId());
            product.setQuantity(product.getQuantity() - acceptedArticle.getQuantity());
            this.productRepository.updateProduct(product, product.getId());
        }

        // Creo un nuevo ticket
        TicketDTO ticket = this.repository.createTicket(tickerArticles, totalArticles);
        ticket.setTotal(ticket.getTotal());
        return ticket;
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
