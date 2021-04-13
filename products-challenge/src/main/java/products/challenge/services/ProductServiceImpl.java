package products.challenge.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import products.challenge.dtos.ProductDTO;
import products.challenge.dtos.filters.Filtes;
import products.challenge.dtos.filters.ProductFiltersDTO;
import products.challenge.exceptions.ApiException;
import products.challenge.repositories.ProductRepository;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todos los productos por distintos filtros
     * @param filters
     * @return
     */
    @Override
    public List<ProductDTO> getAllByFilters(ProductFiltersDTO filters) {
        // Valido el numero de filtros
        filters.validateNumberOfFilters();
        // Valido la consistencia de los filtros
        validateFilters(filters);
        List<ProductDTO> products = this.repository.getProducts();

        // Aplico los filtros
        products = products.stream()
                .filter(product -> {
                    boolean matches = true;
                    // Filtro por nombre
                    if (filters.getName() != null) {
                        matches = product.getName().equals(filters.getName());
                    }
                    // Filtro por marca
                    if (filters.getBrand() != null) {
                        matches = matches && product.getBrand().equals(filters.getBrand());
                    }
                    // Filtro por categoria
                    if (filters.getCategory() != null) {
                        matches = matches && product.getCategory().equals(filters.getCategory());
                    }
                    // Filtro por envio gratis
                    if (filters.getFreeShipping() != null) {
                        matches = matches && product.freeShipping.equals(filters.getFreeShipping());
                    }
                    // Filtro por prestigio
                    if (filters.getPrestige() != null) {
                        matches = matches && product.getPrestige().equals(filters.getPrestige());
                    }
                    return matches;
                }).collect(Collectors.toList());

        // Filtro por orden
        if (filters.getOrder() != null) {
            int opt = filters.getOrder();
            switch (opt) {
                case 0:
                    products.sort(Comparator.comparing(ProductDTO::getName));
                    break;
                case 1:
                    products.sort(Comparator.comparing(ProductDTO::getName).reversed());
                    break;
                case 2:
                    products.sort(Comparator.comparing(ProductDTO::getPrice));
                    break;
                case 3:
                    products.sort(Comparator.comparing(ProductDTO::getPrice).reversed());
                    break;
                default:
                    throw new ApiException(HttpStatus.BAD_REQUEST, "El orden tiene que estar entre 0 y 3");
            }
        }
        if (products.isEmpty()) throw new ApiException(HttpStatus.NOT_FOUND, "No se encontraros productos");
        return products;
    }


    /**
     * Valida los distintos parametros.
     * Compara los parametros enviados con los parametros almacenados en la base de datos a fin de
     * no permitir que se ingresen datos incorrectos o inconsistentes
     * @param filtes
     * @throws ApiException
     */
    public void validateFilters(Filtes filtes) throws ApiException {
        HashMap<String, Object> listOfFilters = filtes.getValues();
        for (Map.Entry<String, Object> entry : listOfFilters.entrySet()) {
            if (entry.getValue() != null) {
                if (entry.getKey().equals("category")) {
                    ArrayList<String> categories = this.repository.getCategories();
                    if (!categories.contains(entry.getValue().toString())) {
                        throw new ApiException(HttpStatus.BAD_REQUEST,
                                "La categoria " + entry.getValue() + " no es valida");
                    }
                }
                if (entry.getKey().equals("brand")) {
                    ArrayList<String> brands = this.repository.getBrands();
                    if (!brands.contains(entry.getValue().toString())) {
                        throw new ApiException(HttpStatus.BAD_REQUEST,
                                "La marca " + entry.getValue() + " no es valida");
                    }
                }
                if (entry.getKey().equals("price")) {
                    double order = Double.parseDouble(entry.getValue().toString());
                    if (order < 0) throw new ApiException(HttpStatus.BAD_REQUEST,
                            "El precio no puede ser menor que 0");
                }
                if (entry.getKey().equals("prestige")) {
                    int prestige = Integer.parseInt(entry.getValue().toString());
                    if (prestige > 5 || prestige < 0)
                        throw new ApiException(HttpStatus.BAD_REQUEST,
                                "El prestigio tiene que estar entre 0 y 5");
                }
            }
        }
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        return repository.getProductById(id);
    }


}
