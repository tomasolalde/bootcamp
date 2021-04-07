package products.challenge.dtos.filters;

import products.challenge.exceptions.ApiException;

import java.util.HashMap;

public interface Filtes {
    HashMap<String, Object> getValues();
    void validateNumberOfFilters() throws ApiException;
}
