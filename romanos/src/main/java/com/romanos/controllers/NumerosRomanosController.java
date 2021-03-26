package com.romanos.controllers;

import com.romanos.utils.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/decimalARomano")
    public String decimalARomano(@RequestParam Integer numero) {
        try {
            return NumeroRomano.convertirANumerosRomanos(numero);
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/ping")
    public String ping() {
        return "PONG";
    }

}
