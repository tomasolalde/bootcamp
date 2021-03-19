package com.company;

import java.util.Scanner;

public class EjercicioGrupal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n** Ingrese el número del ejercicio a ejecutar: ");
        int e = scanner.nextInt();

        switch (e) {
            case 1:
                System.out.println("EJERCICIO Nº" + e);
                ejercicio1(scanner);
                break;
            case 2:
                System.out.println("EJERCICIO Nº" + e);
                ejercicio2(scanner);
                break;
            case 3:
                System.out.println("EJERCICIO Nº" + e);
                ejercicio3(scanner);
                break;
            case 4:
                System.out.println("EJERCICIO Nº" + e);
                ejercicio4(scanner);
                break;
            case 5:
                System.out.println("EJERCICIO Nº" + e);
                ejercicio5(scanner);
                break;
        }

        scanner.close();
    }

    public static void ejercicio1(Scanner scanner) {
        System.out.println("Ingrese un entero n: ");
        int n = scanner.nextInt();
        for(int i = 0; i <= n; i++){
            if(i%2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void ejercicio2(Scanner scanner) {
        System.out.println("Ingrese un entero n: ");
        int n = scanner.nextInt();
        System.out.println("Ingrese un entero m: ");
        int m = scanner.nextInt();

        for(int i = 0; i <= n; i++){
            if(i%m == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void ejercicio3(Scanner scanner) {
        System.out.println("Ingrese un entero n: ");
        int n = scanner.nextInt();

        boolean resultado = esPrimo(n);

        if(resultado) {
            System.out.println("El número " + n + " es primo.");
        } else {
            System.out.println("El número " + n + " no es primo.");
        }
    }


    public static void ejercicio4(Scanner scanner) {
        System.out.println("Ingrese un entero n: ");
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            if(esPrimo(i)) {
                System.out.println(i);
            }
        }
    }

    public static void ejercicio5(Scanner scanner) {
        int num = 0;

        System.out.println("Ingrese un entero n: ");
        int n = scanner.nextInt();

        System.out.println("Ingrese un entero d: ");
        int d = scanner.nextInt();

        System.out.println("Ingrese un entero m: ");
        int m = scanner.nextInt();

        while (n > 0) {
            int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();
            int digitCount = 0;
            for(int digit : digits) {
                if(digit == m) {
                    digitCount ++;
                }
            }
            if(digitCount == d) {
                n--;
                System.out.println(num);
            }
            digitCount = 0;
            num++;
        }
    }


    public static boolean esPrimo(int n) {
        if (n == 0 || n == 1 || n == 4) {
            return false;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

