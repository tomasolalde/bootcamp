package products.challenge.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.ProductDTOTest;
import products.challenge.dtos.responses.ResponseGetByFilters;
import products.challenge.repositories.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;

@DisplayName("Integration Tests | Product Controller")
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws IOException {
        objectMapper = new ObjectMapper();
    }

    @DisplayName("[GET] products filtered by category Herramientas")
    @Test
    void getProductsWithFilters_shouldReturnOK() throws Exception {
        // Mockup of the repository
        when(productRepository.getProducts()).thenReturn(ProductDTOTest.getTestProducts());
        when(productRepository.getCategories()).thenReturn(ProductDTOTest.getTestCategories());
        MvcResult result = this.mockMvc.perform(get("/articles?category=Herramientas"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getExpectedProductsCategoryHerramientas();
        assertNotNull(response);
        assertEquals(response.getItems(), expectedProducts);
    }

    @DisplayName("[GET] products filtered by category Herramientas and FreeShipping")
    @Test
    void getProductsWithCategoryFreeShippingFilters_shouldReturnOK() throws Exception {
        // Mockup of the repository
        when(productRepository.getProducts()).thenReturn(ProductDTOTest.getProductsForCategoryAndFreeShipmentFilter());
        when(productRepository.getCategories()).thenReturn(ProductDTOTest.getTestCategories());
        // Get request with filter category and freeShipping
        MvcResult result = this.mockMvc.perform(get("/articles?category=Herramientas&freeShipping=true"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getExpectedProductsForCategoryAndFreeShippingFilter();
        assertNotNull(response);
        assertEquals(response.getItems(), expectedProducts);
    }

    @DisplayName("[GET] products filtered by Ascending order")
    @Test
    void getAllProductsAlphabeticallyOrderedAsc_shouldReturnOK() throws Exception {
        // Mockup of the repository
        when(productRepository.getProducts()).thenReturn(ProductDTOTest.getProductsAlphabeticallyDesordered());
        // Get request to the controller with filter order 0 - A to Z
        MvcResult result = this.mockMvc.perform(get("/articles?order=0"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        // Mockup Products alphabetically ordered asc
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsAlphabeticallyOrderedAsc();
        // Asserts
        assertNotNull(response);
        assertEquals(expectedProducts, response.getItems());
    }

    @DisplayName("[GET] products filtered by Descending order")
    @Test
    void getAllProductsAlphabeticallyOrderedDes_shouldReturnOK() throws Exception {
        // Mockup of the repository
        when(productRepository.getProducts()).thenReturn(ProductDTOTest.getProductsAlphabeticallyDesordered());
        // Get request to the controller with filter order 0 - Z to A
        MvcResult result = this.mockMvc.perform(get("/articles?order=1"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        // Mockup Products alphabetically ordered des
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsAlphabeticallyOrderedDes();
        // Asserts
        assertNotNull(response);
        assertEquals(expectedProducts, response.getItems());
    }

    @DisplayName("[GET] products filtered by price lower to higher")
    @Test
    void getAllProductsOrderedByPriceLowerToHigher_shouldReturnOK() throws Exception {
        // Mockup of the repository
        when(productRepository.getProducts()).thenReturn(ProductDTOTest.getProductsPriceDesordered());
        // Get request to the controller with filter order 2 - price lower to higher
        MvcResult result = this.mockMvc.perform(get("/articles?order=2"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        // Mockup Products ordered by price - lower to higher
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsPriceOrderedLowerToHigher();
        // Asserts
        assertNotNull(response);
        assertEquals(expectedProducts, response.getItems());
    }

    @DisplayName("[GET] products filtered by price higher to lower")
    @Test
    void getAllProductsOrderedByPriceHigherToLower_shouldReturnOK() throws Exception {
        // Mockup of the repository
        when(productRepository.getProducts()).thenReturn(ProductDTOTest.getProductsPriceDesordered());
        // Get request to the controller with filter order 2 - price higher to lower
        MvcResult result = this.mockMvc.perform(get("/articles?order=3"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
        });
        // Mockup Products ordered by price - higher to lower
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsPriceOrderedHigherToLower();
        // Asserts
        assertNotNull(response);
        assertEquals(expectedProducts, response.getItems());
    }
}