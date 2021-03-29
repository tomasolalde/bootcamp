package com.diploma.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Certificate {
    private String message;
    private double average;
    private Student student;
}
