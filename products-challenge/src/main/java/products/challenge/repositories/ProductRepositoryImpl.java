package products.challenge.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import products.challenge.dtos.ProductDTO;
import products.challenge.exceptions.ApiException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    public ArrayList<ProductDTO> products = new ArrayList<>();

    public ProductRepositoryImpl() {
        loadDataBase();
    }

    public ProductRepositoryImpl(ArrayList<ProductDTO> productDTOArrayList) {
        products = productDTOArrayList;
    }

    @Override
    public ArrayList<ProductDTO> getProducts() {
        return this.products;
    }

    @Override
    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<ProductDTO> products = getProducts();
        for (ProductDTO p : products) {
            if (!categories.contains(p.getCategory())) categories.add(p.getCategory());
        }
        return categories;
    }

    @Override
    public ArrayList<String> getBrands() {
        ArrayList<String> brands = new ArrayList<>();
        ArrayList<ProductDTO> products = getProducts();
        for (ProductDTO p : products) {
            if (!brands.contains(p.getBrand())) brands.add(p.getBrand());
        }
        return brands;
    }

    @Override
    public void loadDataBase() {
        String COMMA_DELIMITER = ",";
        List<List<String>> result = null;
        try {
            result = Files.readAllLines(Paths.get(loadFile("dbProductos.csv").getAbsolutePath()))
                    .stream()
                    .map(line -> Arrays.asList(line.split(COMMA_DELIMITER)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 1; i < Objects.requireNonNull(result).size(); i++) {
            List<String> parameters = result.get(i);
            ProductDTO productDTO = new ProductDTO();
            productDTO.id = i;
            productDTO.name = parameters.get(0);
            productDTO.category = parameters.get(1);
            productDTO.brand = parameters.get(2);
            productDTO.price = Double.parseDouble(parameters.get(3).replace("$", "").replace(".", ""));
            productDTO.quantity = Integer.parseInt(parameters.get(4));
            productDTO.freeShipping = parameters.get(5).toUpperCase(Locale.ROOT).equals("SI");
            productDTO.prestige = parameters.get(6).split("").length;
            productDTOS.add(productDTO);
        }
        products = productDTOS;
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        for (ProductDTO p : this.getProducts()) {
            if (p.getId().equals(id)) return p;
        }
        throw new ApiException(HttpStatus.NOT_FOUND, "No se encontro el producto con id " + id);
    }

    @Override
    public void updateProduct(ProductDTO productDTO, Integer id) {
        for (ProductDTO p : getProducts()) {
            if (p.getId().equals(id)) {
                p = productDTO;
                return;
            }
        }
        throw new ApiException(HttpStatus.NOT_FOUND, "No se encontro el producto con id " + id);
    }

    /**
     * Retorna un archivo dado el nombre
     * @param fileName nombre del archivo
     */
    public File loadFile(String fileName) {
        File file = new File("");
        try {
            file = ResourceUtils.getFile(file.getAbsolutePath()+ "/src/main/resources/" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

}
