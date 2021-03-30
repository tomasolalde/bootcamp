package com.calorie.calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDTO {
    public String name;
    public double calories;

    public FoodDTO() {
        
    }
}
