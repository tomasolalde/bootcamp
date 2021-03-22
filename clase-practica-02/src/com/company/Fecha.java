package com.company;

import java.util.*;

public class Fecha {
    private final GregorianCalendar calendar = new GregorianCalendar();

    public Fecha() {
        Date date = new Date();
        System.out.println(date);
        this.calendar.setTime(date);
    }

    public Fecha(int day, int month, int year) {
        calendar.set(Calendar.DATE, day);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
    }

    public void agregarDias(int dias) {
        calendar.add(Calendar.DATE, dias);
        boolean isValid = Fecha.validarFecha(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
        if (isValid) {
            calendar.getTime();
        }
    }

    public static boolean validarFecha(int day, int month, int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setLenient(false);
        calendar.set(year, month, day, 0, 0, 0);
        try {
            calendar.getTime();
            return true;
        } catch (Exception e) {
            String error = e.getMessage();
            System.out.println(error);
            switch (error) {
                case "DAY_OF_MONTH":
                    System.out.println("EL dia no es valido");
                    break;
                case "MONTH":
                    System.out.println("EL mes no es valido");
                    break;
                case "YEAR":
                    System.out.println("EL año no es valido");
                    break;
                default:
                    System.out.println("Fecha invalida");
                    break;
            }
            return false;
        }
    }

    public String getFecha() {
        int day = this.calendar.get(Calendar.DATE);
        int month = this.calendar.get(Calendar.MONTH);
        int year = this.calendar.get(Calendar.YEAR);
        return day + "/" + (month > 10 ? month : "0" + month) + "/" + year + "/";
    }

    public void setFecha(Date fecha) {
        this.calendar.setTime(fecha);
    }


}
