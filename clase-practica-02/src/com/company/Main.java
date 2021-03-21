package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;
        while (runProgram) {
            System.out.println("\n1) Cuenta corriente");
            System.out.println("2) Libro");
            System.out.println("3) Contador de ejecuciones");
            System.out.println("4) Fecha");

            System.out.print("\n*** Ingrese el Nº del ejercicio a ejecutar: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    Contador.increment();
                    System.out.println("Cuenta Corriente");
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(1000, "Tomas Olalde", "3214567898272831");
                    System.out.println(cuentaCorriente.toString());
                    cuentaCorriente.egreso(100);
                    cuentaCorriente.ingreso(350);
                    System.out.println(cuentaCorriente.toString());
                    break;
                case 2:
                    Contador.increment();
                    Libro libro = new Libro("La vuelta al mundo en 80 dias", "Julio Verne", "Pierre-Jules Hetzel");
                    System.out.println(libro.toString());
                    break;
                case 3:
                    System.out.println("El programa se ejecuto: " + Contador.getValue() + " veces.");
                    break;
                case 4:
                    Contador.increment();
                    Fecha fecha = new Fecha();
                    System.out.println(fecha.getFecha());
                    break;
                default:
                    runProgram = false;
                    break;
            }
            System.out.println("\n* FIN *");
        }


    }
}
