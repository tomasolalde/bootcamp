package products.challenge.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.ProductDTOTest;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.exceptions.ApiException;
import products.challenge.repositories.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ProductService.class)
public class ProductServiceImplTest {

    @MockBean
    private ProductServiceImpl service;

    @MockBean
    private ProductRepository repository;

    private ArrayList<ProductDTO> products;

    @BeforeEach
    public void setUp() throws IOException {
        service = new ProductServiceImpl(repository);
        products = ProductDTOTest.getTestProducts();
    }

    @DisplayName("getAllProductsWithoutFilters_shouldReturnOK")
    @Test
    public void getAllProductsWithoutFilters_shouldReturnOK() throws ApiException {
        when(repository.getProducts()).thenReturn(products);
        List<ProductDTO> result = service.getAllByFilters(new ProductFiltersDTO());
        assertNotNull(result, "The list of products is null.");
        assertEquals(products, result);
    }

    @DisplayName("getProductById_shouldReturnOK")
    @Test
    public void getProductById_shouldReturnOK() throws ApiException, IOException {
        when(repository.getProductById(any())).thenReturn(ProductDTOTest.getProductIdOne());
        // Obtain mock product from static method
        ProductDTO expectedProduct = ProductDTOTest.getProductIdOne();
        ProductDTO result = service.getProductById(1);
        assertNotNull(result, "The product is null.");
        assertEquals(expectedProduct, result);
    }

    @DisplayName("getAllProductsWithFiltersCategory_shouldReturnOK")
    @Test
    public void getAllProductsWithFiltersCategory_shouldReturnOK() throws ApiException, IOException {

        // Mockup of categories for the service
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Herramientas");
        when(repository.getCategories()).thenReturn(categories);
        when(repository.getProducts()).thenReturn(products);

        // Mockup of filters with category Herramientas
        ProductFiltersDTO filters = new ProductFiltersDTO();
        filters.setCategory("Herramientas");

        List<ProductDTO> result = service.getAllByFilters(filters);
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getExpectedProductsCategoryHerramientas();
        assertNotNull(result, "The list of products is null.");
        assertEquals(expectedProducts, result, "The expected products are not equals.");
    }

    @DisplayName("getAllProductsWithFiltersCategoryAndFreeShipping_shouldReturnOK")
    @Test
    public void getAllProductsWithFiltersCategoryAndFreeShipping_shouldReturnOK() throws ApiException, IOException {

        // Mockup of categories for the service
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Herramientas");
        when(repository.getCategories()).thenReturn(categories);
        when(repository.getProducts()).thenReturn(ProductDTOTest.getProductsForCategoryAndFreeShipmentFilter());

        // Mockup of filters with category Herramientas and FreeShipping true
        ProductFiltersDTO filters = new ProductFiltersDTO();
        filters.setCategory("Herramientas");
        filters.setFreeShipping(true);

        List<ProductDTO> result = service.getAllByFilters(filters);
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getExpectedProductsForCategoryAndFreeShippingFilter();

        assertNotNull(result, "The list of products is null.");
        assertEquals(expectedProducts, result, "The expected products are not equals.");
    }

    @DisplayName("getAllProductsAlphabeticallyOrderedAsc_shouldReturnOK")
    @Test
    public void getAllProductsAlphabeticallyOrderedAsc_shouldReturnOK() throws ApiException, IOException {

        // Mockup repository
        when(repository.getProducts()).thenReturn(ProductDTOTest.getProductsAlphabeticallyDesordered());

        // Mockup of filters width order 0 - A to Z
        ProductFiltersDTO filters = new ProductFiltersDTO();
        filters.setOrder(0); // A-Z
        List<ProductDTO> result = service.getAllByFilters(filters);
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsAlphabeticallyOrderedAsc();

        assertNotNull(result, "The list of products is null.");
        assertEquals(expectedProducts, result, "The expected products are not equals.");
    }

    @DisplayName("getAllProductsAlphabeticallyOrderedDes_shouldReturnOK")
    @Test
    public void getAllProductsAlphabeticallyOrderedDes_shouldReturnOK() throws ApiException, IOException {

        // Mockup repository
        when(repository.getProducts()).thenReturn(ProductDTOTest.getProductsAlphabeticallyDesordered());

        // Mockup of filters width order 1 - Z to A
        ProductFiltersDTO filters = new ProductFiltersDTO();
        filters.setOrder(1); // A-Z
        List<ProductDTO> result = service.getAllByFilters(filters);
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsAlphabeticallyOrderedDes();

        assertNotNull(result, "The list of products is null.");
        assertEquals(expectedProducts, result, "The expected products are not equals.");
    }

    @DisplayName("getAllProductsOrderedByPriceLowerToHigher_shouldReturnOK")
    @Test
    public void getAllProductsOrderedByPriceLowerToHigher_shouldReturnOK() throws ApiException, IOException {

        // Mockup service - Desordered products
        when(repository.getProducts()).thenReturn(ProductDTOTest.getProductsPriceDesordered());

        // Mockup of filters width order 2 - price lower to higher
        ProductFiltersDTO filters = new ProductFiltersDTO();
        filters.setOrder(2);
        List<ProductDTO> result = service.getAllByFilters(filters);
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsPriceOrderedLowerToHigher();

        assertNotNull(result, "The list of products is null.");
        assertEquals(expectedProducts, result, "The expected products are not equals.");
    }

    @DisplayName("getAllProductsOrderedByPriceHigherToLower_shouldReturnOK")
    @Test
    public void getAllProductsOrderedByPriceHigherToLower_shouldReturnOK() throws ApiException, IOException {

        // Mockup service - Desordered products
        when(repository.getProducts()).thenReturn(ProductDTOTest.getProductsPriceDesordered());

        // Mockup of filters width order 3 - price higher to lower
        ProductFiltersDTO filters = new ProductFiltersDTO();
        filters.setOrder(3);
        List<ProductDTO> result = service.getAllByFilters(filters);
        ArrayList<ProductDTO> expectedProducts = ProductDTOTest.getProductsPriceOrderedHigherToLower();

        assertNotNull(result, "The list of products is null.");
        assertEquals(expectedProducts, result, "The expected products are not equals.");
    }



}
