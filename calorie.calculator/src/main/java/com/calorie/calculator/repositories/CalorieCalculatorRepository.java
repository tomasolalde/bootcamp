package com.calorie.calculator.repositories;

import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.exceptions.ApiException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface CalorieCalculatorRepository {
    ArrayList<FoodDTO> getFood() throws FileNotFoundException, ApiException;
}
