package com.calorie.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class PlateTotalCaloriesResponseDTO {
    public String name;
    public double totalCalories;
    public ArrayList<FoodDTO> listOfingredients = new ArrayList<>();
    public FoodDTO maxIngredient;

    public PlateTotalCaloriesResponseDTO() {}

    public PlateTotalCaloriesResponseDTO(String name) {
        this.name = name;
    }

}
