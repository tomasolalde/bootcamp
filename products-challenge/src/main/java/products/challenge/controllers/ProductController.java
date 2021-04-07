package products.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.responses.ResponseGetByFilters;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "articles")
    public ResponseEntity<ResponseGetByFilters> getAllByCategory(ProductFiltersDTO filters) {
        List<ProductDTO> productos = this.service.getAllByFilters(filters);
        return new ResponseEntity<>(new ResponseGetByFilters(productos.size(), productos), HttpStatus.OK);
    }

    @GetMapping(value = "articles/{id}")
    public ResponseEntity<ProductDTO> getAllByCategory(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.getProductById(id), HttpStatus.OK);
    }

}
