package com.diploma.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private ArrayList<Subject> subjects;
}
