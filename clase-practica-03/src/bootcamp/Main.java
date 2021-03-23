package bootcamp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        PasswordFuerte passwordFuerte = new PasswordFuerte();
        PasswordIntermedia passwordIntermedia = new PasswordIntermedia();
        PasswordSimple passwordSimple = new PasswordSimple();

        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;

        while (runProgram) {
            System.out.println("Ingrese una opcion:");
            System.out.println("1) contraseña Simple\n2) Contraseña Intermedia \n3) Contraseña Intermedia");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    try {
                        System.out.println("** Password Simple **");
                        System.out.println("Ingrese una contraseña: ");
                        String passwordSimEntered = scanner.next();
                        passwordSimple.setValue(passwordSimEntered);
                        System.out.println("Password ok!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("** Password Intermedia **");
                        System.out.println("Ingrese una contraseña: ");
                        String passwordIntEntered = scanner.next();
                        passwordIntermedia.setValue(passwordIntEntered);
                        System.out.println("Password ok!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("** Password Fuerte **");
                        System.out.println("Ingrese una contraseña: ");
                        String passwordStrEntered = scanner.next();
                        passwordFuerte.setValue(passwordStrEntered);
                        System.out.println("Password ok!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    runProgram = false;
            }
        }
    }
}
