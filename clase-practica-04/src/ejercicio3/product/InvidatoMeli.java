package ejercicio3.product;

public class InvidatoMeli implements Invitado {
    @Override
    public void aplaudir() {
        System.out.println("Daaaaale chiquiii!!!");
    }

    @Override
    public String toString() {
        return " * Invidato Meli";
    }
}
