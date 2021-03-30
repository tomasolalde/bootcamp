package com.calorie.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class PlateOfFoodDTO {
    public String name;
    public ArrayList<IngredientDTO> ingredients;

    public PlateOfFoodDTO() {

    }
}
