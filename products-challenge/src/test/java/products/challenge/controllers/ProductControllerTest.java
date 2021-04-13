package products.challenge.controllers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.ProductDTOTest;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.dtos.responses.ResponseGetByFilters;
import products.challenge.repositories.ProductRepositoryImpl;
import products.challenge.services.ProductService;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private ArrayList<ProductDTO> mockProducts;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        mockProducts = ProductDTOTest.getTestProducts();
    }

    @DisplayName("getAllProductsWithoutFilters_shouldReturnOK")
    @Test
    void getAllProductsWithoutFilters_shouldReturnOK() throws Exception {
        // Mock of repository and service methods
        when(productService.getAllByFilters(any())).thenReturn(mockProducts);
        MvcResult result = this.mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertEquals(response.getItems(), mockProducts);
    }

    @DisplayName("getProductById_shouldReturnOK")
    @Test
    void getProductById_shouldReturnOK() throws Exception {
        // Mock of repository and service methods
        ProductDTO expectedProduct = ProductDTOTest.getProductIdOne();
        when(productService.getProductById(1)).thenReturn(expectedProduct);
        MvcResult result = this.mockMvc.perform(get("/articles/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        ProductDTO product = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ProductDTO>() {});
        assertEquals(product, expectedProduct);
    }

}
