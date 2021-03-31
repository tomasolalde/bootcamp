package com.calorie.calculator.services;


import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.dtos.PlateOfFoodDTO;
import com.calorie.calculator.dtos.PlateTotalCaloriesResponseDTO;
import com.calorie.calculator.exceptions.ApiException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface CalorieCalculatorService {
    ArrayList<FoodDTO> getFood() throws FileNotFoundException, ApiException;
    PlateTotalCaloriesResponseDTO calculateTotalCalories(PlateOfFoodDTO plateOfFoodDTO) throws FileNotFoundException, ApiException;
    ArrayList<PlateTotalCaloriesResponseDTO> calculateTotalCaloriesForManyPlates(ArrayList<PlateOfFoodDTO> listOfPlates) throws FileNotFoundException, ApiException;
}
