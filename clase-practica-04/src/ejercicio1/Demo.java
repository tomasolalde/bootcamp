package ejercicio1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Demo {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda p1 = new Prenda("Bensimon", "M1");
        Prenda p2 = new Prenda("Legacy", "M3");
        Prenda p3 = new Prenda("Bensimon", "M2");

        ArrayList<Prenda> prendasTomi = new ArrayList<Prenda>();
        ArrayList<Prenda> prendasRocha = new ArrayList<Prenda>();
        prendasTomi.add(p1);
        prendasTomi.add(p2);
        prendasRocha.add(p3);
        guardaRopa.guardarPrendas(prendasTomi);
        guardaRopa.guardarPrendas(prendasRocha);
        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(0);
        guardaRopa.mostrarPrendas();
    }
}
