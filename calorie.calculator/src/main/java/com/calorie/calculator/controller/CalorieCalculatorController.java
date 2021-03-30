package com.calorie.calculator.controller;


import com.calorie.calculator.dtos.FoodDTO;
import com.calorie.calculator.dtos.PlateOfFoodDTO;
import com.calorie.calculator.dtos.PlateTotalCaloriesResponseDTO;
import com.calorie.calculator.services.CalorieCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "calories")
public class CalorieCalculatorController {

    private final CalorieCalculatorService service;

    public CalorieCalculatorController(CalorieCalculatorService calorieCalculatorService) {
        this.service = calorieCalculatorService;
    }

    @GetMapping(value = "/calories")
    public ResponseEntity<ArrayList<FoodDTO>> getListOfFood() {
        return new ResponseEntity<>(service.getFood(), HttpStatus.OK);
    }

    @GetMapping(value = "/calculate-calories")
    public ResponseEntity<PlateTotalCaloriesResponseDTO> calculateTotalCalories(@RequestBody PlateOfFoodDTO plate) {
        return new ResponseEntity<>(this.service.calculateTotalCalories(plate), HttpStatus.OK);
    }

    @GetMapping(value = "/calculate-calories-list")
    public ResponseEntity<ArrayList<PlateTotalCaloriesResponseDTO>> calculateTotalCaloriesPlates(@RequestBody ArrayList<PlateOfFoodDTO> plates) {
        return new ResponseEntity<>(this.service.calculateTotalCaloriesForManyPlates(plates), HttpStatus.OK);
    }
}
