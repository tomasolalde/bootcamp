package com.calculadora.m.cuadrados.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Habitacion {
    public String nombre;
    public double ancho = 0;
    public double largo = 0;

    public double calcularTamaño() {
        return this.largo * this.ancho;
    }
}
