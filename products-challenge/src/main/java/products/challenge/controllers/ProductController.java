package products.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.responses.ResponseGetByFilters;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * Retorna los productos filtrados o todos si no se aplica ningun filtro
     * @param filters filtros
     * @return Productos
     */
    @GetMapping(value = "articles")
    public ResponseEntity<ResponseGetByFilters> getAllByCategory(@Valid ProductFiltersDTO filters) {
        List<ProductDTO> productos = this.service.getAllByFilters(filters);
        return new ResponseEntity<>(new ResponseGetByFilters(productos.size(), productos), HttpStatus.OK);
    }

    /**
     * Retorna un producto por id
     * @param id id del producto
     * @return producto
     */
    @GetMapping(value = "articles/{id}")
    public ResponseEntity<ProductDTO> getAllByCategory(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.getProductById(id), HttpStatus.OK);
    }

}
