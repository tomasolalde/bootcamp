package ejercicio3.product;

public class InvitadoNormal implements Invitado{
    @Override
    public void aplaudir() {
        System.out.println("Aplaudir!!");
    }

    @Override
    public String toString() {
        return " - Invidato Normal";
    }
}
