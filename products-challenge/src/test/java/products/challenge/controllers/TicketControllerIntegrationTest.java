package products.challenge.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.TicketDTOTest;
import products.challenge.dtos.responses.ResponseGetByFilters;
import products.challenge.repositories.ProductRepository;
import products.challenge.repositories.TicketRepository;
import products.challenge.repositories.TicketRepositoryImpl;
import products.challenge.services.TicketServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("Integration Tests | Ticket Controller")
@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TicketServiceImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private ProductRepository productRepository;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        ticketRepository = new TicketRepositoryImpl();
        ticketService = new TicketServiceImpl(ticketRepository, productRepository);
    }

    @DisplayName("[POST] create new request purchase")
    @Test
    void purchaseRequestWithValidProducts_shouldReturnOK() throws Exception {

        when(productRepository.getProductById(1)).thenReturn(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        when(productRepository.getProductById(2)).thenReturn(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        when(productRepository.getProductById(4)).thenReturn(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        when(productRepository.getProductById(5)).thenReturn(new ProductDTO(5, "Samsung Galaxy s21 +", "Celulares", "Samsung", 130000.0, 7, true, 4));

        MvcResult result = this.mockMvc.perform(post("/purchase-request")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(TicketDTOTest.purchaseRequestWithValidProducts())))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(
                result.getResponse().getContentAsString(), new TypeReference<>() {
        });
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
