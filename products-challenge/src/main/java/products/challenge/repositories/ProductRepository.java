package products.challenge.repositories;

import products.challenge.dtos.ProductDTO;

import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<ProductDTO> getProducts();
    ArrayList<String> getCategories();
    ArrayList<String> getBrands();
    void loadDataBase();
    ProductDTO getProductById(Integer id);
    void updateProduct(ProductDTO productDTO, Integer id);
}
