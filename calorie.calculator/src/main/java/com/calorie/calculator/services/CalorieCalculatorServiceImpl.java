package com.calorie.calculator.services;

import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.dtos.IngredientDTO;
import com.calorie.calculator.dtos.PlateOfFoodDTO;
import com.calorie.calculator.dtos.PlateTotalCaloriesResponseDTO;
import com.calorie.calculator.exceptions.ApiException;
import com.calorie.calculator.repositories.CalorieCalculatorRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CalorieCalculatorServiceImpl implements CalorieCalculatorService {

    private final CalorieCalculatorRepository repository;

    public CalorieCalculatorServiceImpl(CalorieCalculatorRepository calorieCalculatorRepository) {
        this.repository = calorieCalculatorRepository;
    }

    @Override
    public ArrayList<FoodDTO> getFood() throws FileNotFoundException, ApiException {
        return this.repository.getFood();
    }

    @Override
    public PlateTotalCaloriesResponseDTO calculateTotalCalories(PlateOfFoodDTO plateOfFoodDTO) throws FileNotFoundException, ApiException {
        PlateTotalCaloriesResponseDTO plateTotalCaloriesDTO = new PlateTotalCaloriesResponseDTO(plateOfFoodDTO.name);
        HashMap<String, Double> foodHashMap = foodListToHashMap(this.repository.getFood());
        for (IngredientDTO ingredient : plateOfFoodDTO.ingredients) {
            Double caloriesOfIngredient = foodHashMap.get(ingredient.name);
            if (caloriesOfIngredient != null) {
                plateTotalCaloriesDTO.listOfingredients.add(new FoodDTO(ingredient.name, caloriesOfIngredient));
                plateTotalCaloriesDTO.totalCalories += caloriesOfIngredient * ingredient.weight;
            }
        }
        plateTotalCaloriesDTO.maxIngredient = getMaxIngredient(plateTotalCaloriesDTO.listOfingredients);
        return plateTotalCaloriesDTO;
    }

    @Override
    public ArrayList<PlateTotalCaloriesResponseDTO> calculateTotalCaloriesForManyPlates(ArrayList<PlateOfFoodDTO> listOfPlates) throws FileNotFoundException, ApiException {
        ArrayList<PlateTotalCaloriesResponseDTO> processedPlates = new ArrayList<>();
        for(PlateOfFoodDTO plate : listOfPlates) {
            processedPlates.add(calculateTotalCalories(plate));
        }
        return processedPlates;
    }

    private HashMap<String, Double> foodListToHashMap(ArrayList<FoodDTO> foodList) {
        HashMap<String, Double> foodHashMap = new HashMap<>();
        for (FoodDTO food : foodList) {
            foodHashMap.put(food.name, food.calories);
        }
        return foodHashMap;
    }

    private FoodDTO getMaxIngredient(ArrayList<FoodDTO> listOfIngredients) {
        FoodDTO foodDTO = null;
        double maxCaloriesIngredient = 0.0;
        for (FoodDTO food : listOfIngredients) {
            if (food.calories > maxCaloriesIngredient) {
                foodDTO = food;
                maxCaloriesIngredient = food.calories;
            }
        }
        return foodDTO;
    }

}
