package com.calculadora.edad.services;

import com.calculadora.edad.dtos.MensajeDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadService {

    public MensajeDto calcularEdad(int dia, int mes, int ano) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.parse(Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(ano), formatter);
        Period p = Period.between(birthday, today);

        String edad = p.getYears() + " años - "
                + p.getMonths() + " meses - "
                + p.getDays() + " dias";

        String mensaje = "";

        if (p.getYears() < 20) mensaje = "Sos tremendo baby";
        if (p.getYears() >= 20 && p.getYears() <= 40) mensaje = "Padre de familia";
        if (p.getYears() > 40) mensaje = "Viejardo mal";

        return new MensajeDto(edad, mensaje);
    }

}
