package com.company;

public class Contador {

    public static int value;

    public Contador() {
    }

    public Contador(int value) {
        setValue(value);
    }

    public static int getValue() {
        return value;
    }

    public static void setValue(int value) {
        Contador.value = value;
    }

    public static void decrement() {
        if (value > 0) value -= 1;
    }

    public static void increment() {
        value += 1;
    }


}
