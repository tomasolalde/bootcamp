package com.calorie.calculator.repositories;

import com.calorie.calculator.dtos.FoodDTO;

import java.util.ArrayList;

public interface CalorieCalculatorRepository {
    ArrayList<FoodDTO> getFood();
}
