package com.calorie.calculator.repositories;

import com.calorie.calculator.dtos.FoodDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class CalorieCalculatorRepositoryImpl implements CalorieCalculatorRepository {

    @Override
    public ArrayList<FoodDTO> getFood() {
        return loadDatabase();
    }

    public ArrayList<FoodDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ArrayList<FoodDTO>> typeRef = new TypeReference<>() {
        };
        ArrayList<FoodDTO> listOfFood = null;

        try {
            listOfFood = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfFood;
    }

}
