package com.calculadora.m.cuadrados.services;

import com.calculadora.m.cuadrados.dtos.HabitacionDTO;
import com.calculadora.m.cuadrados.entities.Casa;
import com.calculadora.m.cuadrados.entities.Habitacion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalculadoraService {

    public Double calcularMetrosCuadradosTotales(Casa casa) {
        double metrosCuadradosTotales = 0;
        for (Habitacion habitacion : casa.habitaciones) {
            metrosCuadradosTotales += habitacion.largo * habitacion.ancho;
        }
        return metrosCuadradosTotales;
    }

    public Habitacion calcularHabitacionMasGrande(Casa casa) {
        Habitacion habitacionMasGrande = null;
        for (Habitacion habitacion : casa.habitaciones) {
            if (habitacionMasGrande == null) {
                habitacionMasGrande = habitacion;
            } else {
                if (habitacion.calcularTamaño() > habitacionMasGrande.calcularTamaño()) {
                    habitacionMasGrande = habitacion;
                }
            }
        }
        return habitacionMasGrande;
    }

    public ArrayList<HabitacionDTO> calcularTamañoHabitaciones(Casa casa) {
        ArrayList<HabitacionDTO> habitacionDTOArrayList = new ArrayList<>();
        for (Habitacion habitacion : casa.habitaciones) {
            habitacionDTOArrayList.add(new HabitacionDTO(habitacion.nombre, habitacion.calcularTamaño()));
        }
        return habitacionDTOArrayList;
    }

    public Double calcularValor(Casa casa) {
        return 800 * calcularMetrosCuadradosTotales(casa);
    }
}
