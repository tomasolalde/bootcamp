package com.calculadora.edad.controllers;

import com.calculadora.edad.dtos.MensajeDto;
import com.calculadora.edad.services.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EdadController {

    @Autowired
    private EdadService edadService;

    @GetMapping(value = "/{dia}/{mes}/{ano}")
    public ResponseEntity<MensajeDto> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {
        MensajeDto mensaje = edadService.calcularEdad(dia, mes, ano);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }


}
