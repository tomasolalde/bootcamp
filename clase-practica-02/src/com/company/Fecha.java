package com.company;

import java.util.*;

public class Fecha {
    private final GregorianCalendar calendar = new GregorianCalendar();
    private Date fecha;

    public Fecha() {
        Date date = new Date();
        System.out.println(date);
        this.calendar.setTime(date);
    }

    public String getFecha() {
        int day = this.calendar.get(Calendar.DATE);
        int month = this.calendar.get(Calendar.MONTH);
        int year = this.calendar.get(Calendar.YEAR);
        return day + "/" + (month > 10 ? month : "0" + month)  + "/" + year + "/";
    }

    public void setFecha(Date fecha) {
        this.calendar.setTime(fecha);
    }
}
