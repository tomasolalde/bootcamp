package products.challenge.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.TicketDTO;
import products.challenge.dtos.TicketDTOTest;
import products.challenge.repositories.ProductRepository;
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
    private TicketServiceImpl service;

    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() throws IOException {
        service = new TicketServiceImpl(ticketRepository, productRepository);

    }

    @Test
    public void purchaseRequestWithValidProducts_shouldReturnOK() {
        // Mockup of getProucts. This method is used in the logic of the creation ticket service
        when(productRepository.getProducts()).thenReturn(TicketDTOTest.getTestProducts());
        // Mock of getProductById used in the ticketService
        when(productRepository.getProductById(1)).thenReturn(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        when(productRepository.getProductById(2)).thenReturn(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        when(productRepository.getProductById(4)).thenReturn(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        when(productRepository.getProductById(5)).thenReturn(new ProductDTO(5, "Samsung Galaxy s21 +", "Celulares", "Samsung", 130000.0, 7, true, 4));


        // Create the pucharse request with valid parameters
        TicketDTO ticketResult = service.createPurchase(TicketDTOTest.purchaseRequestWithValidProducts());


    }


}
