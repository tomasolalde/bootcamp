package products.challenge.services;

import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.filters.Filtes;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.exceptions.ApiException;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllByFilters(ProductFiltersDTO filters) throws ApiException;

    void validateFilters(Filtes filtes) throws ApiException;

    ProductDTO getProductById(Integer id);
}
