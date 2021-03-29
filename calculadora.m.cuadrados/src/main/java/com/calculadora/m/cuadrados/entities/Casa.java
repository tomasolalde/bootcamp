package com.calculadora.m.cuadrados.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Casa {
    @NonNull
    public String nombre;
    @NonNull
    public String direccion;
    @NonNull
    public ArrayList<Habitacion> habitaciones;
}
