package products.challenge.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.TicketDTO;
import products.challenge.dtos.TicketDTOTest;
import products.challenge.exceptions.ApiException;
import products.challenge.repositories.ProductRepository;
import products.challenge.repositories.ProductRepositoryImpl;
import products.challenge.repositories.TicketRepository;
import products.challenge.repositories.TicketRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

@WebMvcTest(TicketServiceImpl.class)
public class TicketServiceImplTest {

    @InjectMocks
    private TicketServiceImpl ticketService;

    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() throws IOException {
        /*
         * Mockup the product repository. We Create a new instance of the product repository with
         * mockup products, the reason of that is we want to use specifics products for the test.
         */
        productRepository = new ProductRepositoryImpl(TicketDTOTest.getTestProducts());
        ticketRepository = new TicketRepositoryImpl();
        ticketService = new TicketServiceImpl(ticketRepository, productRepository);
    }

    @Test
    public void purchaseRequestWithValidProducts_shouldReturnOK() {
        // Create the pucharse request with valid parameters
        TicketDTO ticketResult = ticketService.createPurchase(TicketDTOTest.purchaseRequestWithValidProducts());
        assertNotNull(ticketResult, "The Ticket can't be null.");
        TicketDTO expectedTicket = TicketDTOTest.ticketWithValidProducts();
        assertEquals(expectedTicket, ticketResult);
    }
    
}
