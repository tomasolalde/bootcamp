package products.challenge.dtos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProductDTOTest {

    public static ArrayList<ProductDTO> getTestProducts() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/resources/testProducts.json"), new TypeReference<ArrayList<ProductDTO>>() {
        });
    }

    public static ProductDTO getProductIdOne() throws IOException {
        return new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4);
    }

    public static ArrayList<ProductDTO> getExpectedProductsCategoryHerramientas() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsForCategoryAndFreeShipmentFilter() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 9600.0, 5, false, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        list.add(new ProductDTO(5, "Samsung Galaxy s21 +", "Celulares", "Samsung", 130000.0, 7, true, 4));
        list.add(new ProductDTO(6, "Samsung Galaxy s21", "Celulares", "Samsung", 100000.0, 7, true, 4));
        list.add(new ProductDTO(7, "Short", "Indumentaria", "Lacoste", 2400.0, 10, true, 4));
        list.add(new ProductDTO(8, "Remerita", "Indumentaria", "Bensimon", 1500.0, 20, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getExpectedProductsForCategoryAndFreeShippingFilter() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsAlphabeticallyDesordered() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 9600.0, 5, false, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsAlphabeticallyOrderedDes() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 9600.0, 5, false, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsAlphabeticallyOrderedAsc() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 9600.0, 5, false, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsPriceDesordered() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 100.0, 5, false, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsPriceOrderedLowerToHigher() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 100.0, 5, false, 4));
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        return list;
    }

    public static ArrayList<ProductDTO> getProductsPriceOrderedHigherToLower() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 100.0, 5, false, 4));
        return list;
    }

    /**
     * Return and ArrayList with te category Herramientas.
     * @return
     */
    public static ArrayList<String> getTestCategories() {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Herramientas");
        return categories;
    }
}
