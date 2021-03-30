package com.calorie.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class PlateTotalCaloriesDTO {
    public String name;
    public double totalCalories;
    public ArrayList<FoodDTO> listOfingredients = new ArrayList<>();
    public FoodDTO maxIngredient;

    public PlateTotalCaloriesDTO() {}

    public PlateTotalCaloriesDTO(String name) {
        this.name = name;
    }

}
