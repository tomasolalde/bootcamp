package com.calorie.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientDTO {
    public String name;
    public double weight;

    public IngredientDTO() {

    }
}
