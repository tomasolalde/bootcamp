package com.calorie.calculator.repositories;

import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.exceptions.ApiException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class CalorieCalculatorRepositoryImpl implements CalorieCalculatorRepository{

    @Override
    public ArrayList<FoodDTO> getFood() throws ApiException {
        return loadDatabase();
    }

    public ArrayList<FoodDTO> loadDatabase() throws ApiException {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (Exception e) {
            throw new ApiException(HttpStatus.NOT_FOUND.toString(), "Archivo no encontrado", HttpStatus.NOT_FOUND.value());
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ArrayList<FoodDTO>> typeRef = new TypeReference<>() {};
        ArrayList<FoodDTO> listOfFood = null;

        try {
            listOfFood = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfFood;
    }

}
