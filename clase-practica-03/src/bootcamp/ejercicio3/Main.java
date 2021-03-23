package bootcamp.ejercicio3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Persona tomas = new Persona("Tomas", "38696472");
        Persona lisi = new Persona("Lisi", "29873922");
        Persona rochita = new Persona("Rocha", "90382739");

        Persona[] arr = {tomas, lisi, rochita};
        SortUtil.ordenar(arr);
        System.out.println(Arrays.toString(arr));
    }

}
