package products.challenge.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import products.challenge.dtos.TicketDTO;
import products.challenge.dtos.TicketDTOTest;
import products.challenge.repositories.ProductRepository;
import products.challenge.repositories.ProductRepositoryImpl;
import products.challenge.repositories.TicketRepository;
import products.challenge.repositories.TicketRepositoryImpl;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

@DisplayName("Unit Tests | Ticket Service")
@SpringBootTest
public class TicketServiceImplTest {

    @Mock
    private TicketServiceImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() throws IOException {
        productRepository = new ProductRepositoryImpl(TicketDTOTest.getTestProducts());
        ticketRepository = new TicketRepositoryImpl();
        ticketService = new TicketServiceImpl(ticketRepository, productRepository);
    }

    @DisplayName("Create request purcharse")
    @Test
    public void purchaseRequestWithValidProducts_shouldReturnOK() {
        // Create the pucharse request with valid parameters
        TicketDTO ticketResult = ticketService.createPurchase(TicketDTOTest.purchaseRequestWithValidProducts());
        assertNotNull(ticketResult, "The Ticket can't be null.");
        TicketDTO expectedTicket = TicketDTOTest.ticketWithValidProducts();
        assertEquals(expectedTicket, ticketResult);
    }
    
}
