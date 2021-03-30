package com.calorie.calculator.services;


import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.dtos.PlateOfFoodDTO;
import com.calorie.calculator.dtos.PlateTotalCaloriesDTO;

import java.util.ArrayList;

public interface CalorieCalculatorService {
    ArrayList<FoodDTO> getFood();
    PlateTotalCaloriesDTO calculateTotalCalories(PlateOfFoodDTO plateOfFoodDTO);
    ArrayList<PlateTotalCaloriesDTO> calculateTotalCaloriesForManyPlates(ArrayList<PlateOfFoodDTO> listOfPlates);
}
