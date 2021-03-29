package com.calculadora.m.cuadrados.controllers;

import com.calculadora.m.cuadrados.dtos.HabitacionDTO;
import com.calculadora.m.cuadrados.entities.Casa;
import com.calculadora.m.cuadrados.entities.Habitacion;
import com.calculadora.m.cuadrados.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping(value = "/metros-cuadrados-totales")
    public ResponseEntity<Double> calcularMetrosCuadradosTotales(@RequestBody Casa casa) {
        return new ResponseEntity<>(calculadoraService.calcularMetrosCuadradosTotales(casa), HttpStatus.OK);
    }

    @PostMapping(value = "/habitacion-mas-grande")
    public ResponseEntity<Habitacion> habitacionMasGrande(@RequestBody Casa casa) {
        return new ResponseEntity<>(calculadoraService.calcularHabitacionMasGrande(casa), HttpStatus.OK);
    }

    @PostMapping(value = "/tamaño-habitaciones")
    public ResponseEntity<ArrayList<HabitacionDTO>> metrosCuadradosPorHAbitacion(@RequestBody Casa casa) {
        return new ResponseEntity<>(calculadoraService.calcularTamañoHabitaciones(casa), HttpStatus.OK);
    }

    @GetMapping(value = "/valor")
    public ResponseEntity<Double> calcularValor(@RequestBody Casa casa) {
        return new ResponseEntity<>(calculadoraService.calcularValor(casa), HttpStatus.OK);
    }
}
