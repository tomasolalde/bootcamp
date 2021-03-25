package ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuardaRopa {

    public HashMap<Integer, ArrayList<Prenda>> prendas = new HashMap<Integer, ArrayList<Prenda>>();
    public int contador = 0;

    public Integer guardarPrendas(ArrayList<Prenda> listadePrendas) {
        prendas.put(this.contador, listadePrendas);
        contador++;
        return contador - 1;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, ArrayList<Prenda>> entry : prendas.entrySet()) {
            for (Prenda prenda : entry.getValue()) {
                System.out.println("Id -> " + entry.getKey() + " | " + prenda.toString());
            }
        }
    }

    public ArrayList<Prenda> devolverPrendas(Integer identificadorPrendas) {
        ArrayList<Prenda> list = this.prendas.get(identificadorPrendas);
        this.prendas.remove(identificadorPrendas);
        return list;
    }

}
