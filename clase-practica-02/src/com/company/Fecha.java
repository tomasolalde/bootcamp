package com.company;

import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar calendar = new GregorianCalendar();

    public Fecha(int dia, int mes, int ano) {
        new Fecha(ano + "/" + mes + "/" + dia);
    }

    public Fecha(String fecha) {
        String[] values = fecha.split("/");

        System.out.println(values[0] + "/" + values[1] + "/" + values[2]);

        if (values.length != 3)
            System.out.println("La fecha no es valida");
        else
            calendar.set(Integer.parseInt(values[2]), Integer.parseInt(values[1]) - 1, Integer.parseInt(values[0]), 0, 0, 0);
    }

    public static boolean esValida(String fecha) {
        String[] values = fecha.split("/");
        return values.length == 3;
    }

    @Override
    public String toString() {
        return "Fecha: " + calendar.getTime();
    }
}
