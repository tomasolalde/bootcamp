package com.calorie.calculator.services;


import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.dtos.PlateOfFoodDTO;
import com.calorie.calculator.dtos.PlateTotalCaloriesResponseDTO;

import java.util.ArrayList;

public interface CalorieCalculatorService {
    ArrayList<FoodDTO> getFood();
    PlateTotalCaloriesResponseDTO calculateTotalCalories(PlateOfFoodDTO plateOfFoodDTO);
    ArrayList<PlateTotalCaloriesResponseDTO> calculateTotalCaloriesForManyPlates(ArrayList<PlateOfFoodDTO> listOfPlates);
}
