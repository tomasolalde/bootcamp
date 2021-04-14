package products.challenge.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.ProductDTOTest;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.dtos.responses.ResponseGetByFilters;
import products.challenge.repositories.ProductRepository;
import products.challenge.services.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerUnitTest {

    @InjectMocks
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws IOException {
        objectMapper = new ObjectMapper();
    }

    @DisplayName("getAllProductsWithoutFilters_shouldReturnOK")
    @Test
    void getAllProductsWithoutFilters_shouldReturnOK() throws Exception {
        ArrayList<ProductDTO> mockedProducts = ProductDTOTest.getTestProducts();
        // Mock of repository and service methods
//        when(productRepository.getProducts()).thenReturn(mockedProducts);
        when(productService.getAllByFilters(new ProductFiltersDTO())).thenReturn(mockedProducts);

        MvcResult result = this.mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andReturn();
        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
        assertEquals(response.getItems(), mockedProducts);
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

//    @DisplayName("get products filtered by category Herramientas")
//    @Test
//    void getProductsWithFilter_shouldReturnOK() throws Exception {
//        ArrayList<ProductDTO> mockedProducts = ProductDTOTest.getTestProducts();
//        when(productRepository.getProducts()).thenReturn(mockedProducts);
//        // Mockup of categories for the validation in the service
//        ArrayList<String> categories = new ArrayList<>();
//        categories.add("Herramientas");
//
//        MvcResult result = this.mockMvc.perform(get("/articles?category=Herramientas"))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        ResponseGetByFilters response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//
//        assertNotNull(response);
//    }


}
